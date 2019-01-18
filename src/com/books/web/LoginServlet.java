package com.books.web;

import com.books.domain.Admin;
import com.books.service.AdminService;
import com.books.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            Admin admin = new AdminService().getAdmin(username, password);

            /*把admin的用户名写入会话*/
            HttpSession session = request.getSession();
            session.setAttribute("username", admin.getUsername());

            /*去书籍列表页*/
            request.getRequestDispatcher("admin/index.jsp").forward(request, response);

        } catch (Exception e) {
            /*登录失败，返回登录页*/
            if(e.getMessage().equals("管理员不存在")) {
                request.setAttribute("loginState", "fail");
                request.getRequestDispatcher("admin/login.jsp").forward(request, response);
            }
            e.printStackTrace();
        }
    }
}
