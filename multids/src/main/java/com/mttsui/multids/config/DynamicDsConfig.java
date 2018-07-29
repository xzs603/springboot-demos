package com.mttsui.multids.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.mttsui.multids.dao.JoinOrgDao;
import com.mttsui.multids.model.JoinOrg;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: zsxu2
 * @Date 2018/7/9 19:13
 */
public class DynamicDsConfig {

    /**
     * 默认数据源
     */
    public static final String DEFAULT_DS = "ds1";

    private Map<Object, Object> dataSourceMap = new ConcurrentHashMap<>();

    private String dbDriverClass = "oracle.jdbc.OracleDriver";

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUser;

    @Value("${spring.datasource.password}")
    private String dbPass;

    private List<JoinOrg> orgs;

    @Autowired
    private JoinOrgDao joinOrgDao;

    @PostConstruct
    @DependsOn("joinOrgDao")
    private void init() {
        orgs = joinOrgDao.findAll();
    }

    class JoinOrgRowMapper implements RowMapper<JoinOrg> {
        @Override
        public JoinOrg mapRow(ResultSet rs, int rowNum) throws SQLException {
            JoinOrg joinOrg = new JoinOrg();
            joinOrg.setId(rs.getString("id"));
            joinOrg.setDomainCode(rs.getString("domain_code"));
            joinOrg.setBsDbIp(rs.getString("bs_db_ip"));
            joinOrg.setBsDbPort(rs.getString("bs_db_port"));
            joinOrg.setBsDbSid(rs.getString("bs_db_sid"));
            joinOrg.setBsDbUser(rs.getString("bs_db_user"));
            joinOrg.setBsDbPass(rs.getString("bs_db_pass"));
            return joinOrg;
        }
    }

    @Bean
    public DataSource dynamicDataSource() {
        RoutingDataSource dynamicRoutingDataSource = new RoutingDataSource();
        DruidDataSource primaryDs = new DruidDataSource();
        primaryDs.setDriverClassName(dbDriverClass);
        primaryDs.setUrl(dbUrl);
        primaryDs.setUsername(dbUser);
        primaryDs.setPassword(dbPass);
        dataSourceMap.put("primary", primaryDs);

        fillDataSource();

        // 将 master 数据源作为默认指定的数据源
        dynamicRoutingDataSource.setDefaultTargetDataSource(primaryDs);
        // 将 master 和 slave 数据源作为指定的数据源
        dynamicRoutingDataSource.setTargetDataSources(dataSourceMap);

        return dynamicRoutingDataSource;
    }

    /**
     * 根据配置的前置机，初始化数据源
     */
    private void fillDataSource() {

        for (JoinOrg joinOrg : orgs) {
            String url = "jdbc:oracle:thin:@" + joinOrg.getBsDbIp() + ":" + joinOrg.getBsDbPort()
                    + ":" + joinOrg.getBsDbSid();
            DruidDataSource ds = new DruidDataSource();
            ds.setDriverClassName("oracle.jdbc.OracleDriver");
            ds.setUrl(url);
            ds.setUsername(joinOrg.getBsDbUser());
            ds.setPassword(joinOrg.getBsDbPass());
            dataSourceMap.put(joinOrg.getDomainCode(), ds);
        }
    }


    @Bean
    @ConfigurationProperties(prefix = "mybatis")
    public SqlSessionFactoryBean sqlSessionFactoryBean() {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dynamicDataSource());
        return sqlSessionFactoryBean;
    }

    /**
     * 注入 DataSourceTransactionManager 用于事务管理
     *
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }
}
