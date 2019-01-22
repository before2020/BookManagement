package com.books.dao;

import com.books.domain.Book;
import com.books.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class BookDao
{
    private QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());

    public List<Book> getBookList() throws SQLException
    {
        String sql = "select * from book";
        return qr.query(sql, new BeanListHandler<Book>(Book.class));
    }

    public Book getBookById(int bid) throws SQLException
    {
        String sql = "select * from book where bid=?";
        return qr.query(sql, new BeanHandler<>(Book.class), bid);
    }

    public void addBook(Book book) throws SQLException
    {
        String sql = "insert into book values (null,?,?,?,?,?,?)";
        qr.update(sql, book.getTitle(), book.getAuthor(), book.getPress(),
                book.getCategory(), book.getDate(), book.getPrice());
    }

    public void deleteBook(int bid) throws SQLException
    {
        String sql = "delete from book where bid = ?";
        qr.update(sql, bid);
    }

    public void updateBook(Book book, int bid) throws SQLException
    {
        String sql = "update book set title = ?, author = ?, press = ?, " +
                "category = ?, date = ?, price = ? where bid = ?";

        qr.update(sql, book.getTitle(), book.getAuthor(), book.getPress(),
                book.getCategory(), book.getDate(), book.getPrice(), bid);
    }
}
