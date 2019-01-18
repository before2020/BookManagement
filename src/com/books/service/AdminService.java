package com.books.service;

import com.books.dao.AdminDao;
import com.books.domain.Admin;

public class AdminService
{
    public Admin getAdmin(String username, String password) throws Exception
    {
        AdminDao adminDao = new AdminDao();
        Admin admin = adminDao.getAdmin(username, password);
        if(admin == null) {
            throw new Exception("管理员不存在");
        }
        return admin;
    }
}
