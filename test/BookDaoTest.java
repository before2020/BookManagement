import com.books.dao.BookDao;
import com.books.domain.Book;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class BookDaoTest
{
    private BookDao bookDao = new BookDao();

    @Test
    public void testGetBookList() throws SQLException
    {
        List<Book> bookList =  bookDao.getBookList();
        System.out.println(bookList);
    }

    @Test
    public void testAddBook() throws SQLException
    {
        Book book = new Book();
        book.setTitle("艺术的故事");
        book.setAuthor("[英] 贡布里希");
        book.setPress("广西美术出版社 ");
        book.setCategory("艺术");
        book.setDate("2008-04");
        book.setPrice(280.0);
        bookDao.addBook(book);
    }

    @Test
    public void testDeleteBook() throws SQLException
    {
        bookDao.deleteBook(3);
    }

    @Test
    public void testUpdateBook() throws SQLException
    {
        Book book = new Book();
        book.setTitle("艺术的故事");
        book.setAuthor("[英] 贡布里希");
        book.setPress("广西美术出版社 ");
        book.setCategory("艺术");
        book.setDate("2008-04");
        book.setPrice(280.0);
        bookDao.updateBook(book, 2);
    }

    @Test
    public void testSearch() throws SQLException
    {
        BookDao bookDao = new BookDao();
        List<Book> result = bookDao.search("press", "人民");
        System.out.println(result);
    }
}
