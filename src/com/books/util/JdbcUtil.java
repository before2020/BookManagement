package com.books.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.util.Properties;

public class JdbcUtil
{
    private static DataSource ds = null;

    static {
        try {
            Properties p = new Properties();
            String path = JdbcUtil.class.getClassLoader().getResource("db.properties").getPath();
            FileInputStream in = new FileInputStream(path);
            p.load(in);
            ds = DruidDataSourceFactory.createDataSource(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource()
    {
        return ds;
    }
}
