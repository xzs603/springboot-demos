package com.mttsui.multids.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: zsxu2
 * @Date 2018/2/1 20:28
 */
public class DataSourceContextHolder {

    public static final Logger log = LoggerFactory.getLogger(DataSourceContextHolder.class);

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    /**
     * @param dbType
     */
    public static void setDB(String dbType) {
        log.debug("切换到{}数据源", dbType);
        contextHolder.set(dbType);
    }

    /**
     * 获取数据源名称
     * @return
     */
    public static String getDB() {
        return (contextHolder.get());
    }

    /**
     * 清除数据源名称
     */
    public static void clearDB() {
        contextHolder.remove();
    }
}
