package com.books.web;

import com.books.domain.Book;
import com.books.service.BookService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet
{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException
    {
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");

        try {
            /* reflect */
            Class clazz = this.getClass();
            Method method = clazz.getMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            if (method != null) {
                String desPath = (String) method.invoke(this, request, response);
                if (desPath != null) {
                    request.getRequestDispatcher(desPath).forward(request, response);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getBookList(HttpServletRequest request, HttpServletResponse response)
    {
        BookService bookService = new BookService();
        try {
            List<Book> bookList = bookService.getBookList();
            request.setAttribute("bookList", bookList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "admin/main.jsp";
    }

    public String updatePage(HttpServletRequest request, HttpServletResponse response)
    {
        String bid = request.getParameter("bid");
        BookService bookService = new BookService();
        try {
            Book book = bookService.getBookById(bid);
            request.setAttribute("book", book);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "admin/edit.jsp";
    }

    public String update(HttpServletRequest request, HttpServletResponse response)
    {
        Map<String, String[]> parameterMap = request.getParameterMap();
        BookService bookService = new BookService();
        try {
            bookService.update(parameterMap);
        } catch (InvocationTargetException | IllegalAccessException | SQLException e) {
            e.printStackTrace();
        }
        return "BookServlet?action=getBookList";
    }

    public String delete(HttpServletRequest request, HttpServletResponse response)
    {
        BookService bookService = new BookService();
        String bid = request.getParameter("bid");
        try {
            bookService.delete(bid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "BookServlet?action=getBookList";
    }

    public String addPage(HttpServletRequest request, HttpServletResponse response)
    {
        return "admin/add.jsp";
    }

    public String addBook(HttpServletRequest request, HttpServletResponse response)
    {
        Book book = new Book();
        try {
            BeanUtils.populate(book, request.getParameterMap());
            BookService bookService = new BookService();
            bookService.addBook(book);
        } catch (IllegalAccessException | InvocationTargetException | SQLException e) {
            e.printStackTrace();
        }

        return "BookServlet?action=getBookList";
    }
}
