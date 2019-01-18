package com.books.dao;

import com.books.domain.Admin;
import com.books.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class AdminDao
{
    private QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());

    public Admin getAdmin(String username, String password) throws SQLException
    {
        String sql = "select * from admin where username = ? and password = ?";
        return qr.query(sql, new BeanHandler<>(Admin.class), username, password);

    }
}
