package com.books.service;

import com.books.dao.BookDao;
import com.books.domain.Book;

import java.sql.SQLException;
import java.util.List;

public class BookService
{
    public List<Book> getBookList() throws SQLException
    {
        BookDao bookDao = new BookDao();
        return bookDao.getBookList();
    }
}
