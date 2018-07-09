package com.mttsui.multids.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Author: zsxu2
 * @Date 2018/2/1 19:54
 */
public class RoutingDataSource extends AbstractRoutingDataSource {

    private static final Logger log = LoggerFactory.getLogger(RoutingDataSource.class);

    @Override
    protected Object determineCurrentLookupKey() {
        String db = DataSourceContextHolder.getDB();
        log.debug("数据源为{}", db);
        System.out.println("数据源为{}" + db);
        return db;
    }

}
