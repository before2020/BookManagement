package com.books.web;

import com.books.domain.Book;
import com.books.service.BookService;
import org.apache.catalina.Session;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Enumeration;
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
        clearSession(request);
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
        return getDest(request);
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
        return getDest(request);
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

    public String search(HttpServletRequest request, HttpServletResponse response)
    {
        String searchType = request.getParameter("searchType");
        String searchContent = request.getParameter("searchContent");

        //没有搜索任何内容则返回首页
        if(searchContent == null) { return "admin/main.jsp"; }

        BookService bookService = new BookService();
        try {
            List<Book> result = bookService.search(searchType, searchContent);
            if(result != null)
            {
                // 为了update或delete之后返回result.jsp
                HttpSession session = request.getSession();
                session.setAttribute("searchType", searchType);
                session.setAttribute("searchContent", searchContent);

                request.setAttribute("result", result);
                request.setAttribute("count", result.size());
            }
            else {
                request.setAttribute("count", "0");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "admin/result.jsp";
    }

    public String addPage(HttpServletRequest request, HttpServletResponse response)
    {
        return "admin/add.jsp";
    }

    private String getDest(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        if(session.getAttribute("searchType") != null)
        {
            return "BookServlet?action=search&searchType=" +
                    session.getAttribute("searchType") +
                    "&searchContent=" + session.getAttribute("searchContent");
        }
        else
        {
            return "BookServlet?action=getBookList";
        }
    }

    private void clearSession(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        session.removeAttribute("searchType");
        session.removeAttribute("searchContent");
    }
}
