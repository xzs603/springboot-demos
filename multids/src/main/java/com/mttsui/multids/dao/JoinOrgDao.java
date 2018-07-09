package com.mttsui.multids.dao;

import com.alibaba.druid.pool.DruidDataSource;
import com.mttsui.multids.model.JoinOrg;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: zsxu2
 * @Date 2018/7/9 19:14
 */
@Repository
public class JoinOrgDao {

    private JdbcTemplate jdbcTemplate;

    private String dbDriverClass = "oracle.jdbc.OracleDriver";

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUser;

    @Value("${spring.datasource.password}")
    private String dbPass;

    @PostConstruct
    private void init() {
        jdbcTemplate = new JdbcTemplate();
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(dbDriverClass);
        ds.setUrl(dbUrl);
        ds.setUsername(dbUser);
        ds.setPassword(dbPass);
        jdbcTemplate.setDataSource(ds);
    }

    public List<JoinOrg> findAll() {
        return jdbcTemplate.query("select * from data_qc.t_join_org", new JoinOrgRowMapper());
    }

    class JoinOrgRowMapper implements RowMapper<JoinOrg> {

        @Override
        public JoinOrg mapRow(ResultSet rs, int rowNum) throws SQLException {
            JoinOrg org = new JoinOrg();
            org.setId(rs.getString("id"));
            org.setDomainCode(rs.getString("domain_code"));
            org.setBsDbName(rs.getString("bs_db_name"));
            org.setBsDbIp(rs.getString("bs_db_ip"));
            org.setBsDbPort(rs.getString("bs_db_port"));
            org.setBsDbSid(rs.getString("bs_db_sid"));
            org.setBsDbUser(rs.getString("bs_db_user"));
            org.setBsDbPass(rs.getString("bs_db_pass"));
            org.setDomainName(rs.getString("domain_name"));
            org.setOrgCode(rs.getString("org_code"));
            org.setOrgName(rs.getString("org_name"));
            org.setOrgType(rs.getString("org_type"));
            org.setRegionIden(rs.getString("region_iden"));
            org.setComments(rs.getString("comments"));
            return org;
        }
    }
}
