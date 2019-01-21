package com.books.service;

import com.books.dao.BookDao;
import com.books.domain.Book;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class BookService
{
    public List<Book> getBookList() throws SQLException
    {
        BookDao bookDao = new BookDao();
        return bookDao.getBookList();
    }

    public Book getBookById(String bid) throws SQLException
    {
        BookDao bookDao = new BookDao();
        return bookDao.getBookById(Integer.parseInt(bid));
    }

    public void update(Map<String, String[]> parameterMap) throws InvocationTargetException, IllegalAccessException, SQLException
    {
        BookDao bookDao = new BookDao();
        Book book = new Book();
        BeanUtils.populate(book, parameterMap);
        bookDao.updateBook(book, book.getBid());
    }

    public void delete(String bid) throws SQLException
    {
        BookDao bookDao = new BookDao();
        bookDao.deleteBook(Integer.parseInt(bid));
    }
}
