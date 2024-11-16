package org.acumen.training.codes.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.acumen.training.codes.model.data.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class BookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final Logger LOGGER = LogManager.getLogger(BookDao.class);

    @Transactional
    public boolean insertBook(Book book) {
        LOGGER.info("Attempting to insert book with ISBN: {}", book.getIsbn());
        try {
            jdbcTemplate.update("insert into book (isbn, title, author, price, quantity) values (?, ?, ?, ?, ?)",
                    book.getIsbn(), book.getTitle(), book.getAuthor(), book.getPrice(), book.getQuantity());
            LOGGER.info("Book inserted successfully with ISBN: {}", book.getIsbn());
            return true;
        } catch (Exception e) {
            LOGGER.error("Failed to insert book with ISBN: {}", book.getIsbn(), e);
            return false;
        }
    }

    @Transactional
    public List<Book> selectAllBooks() {
        LOGGER.info("Fetching all books from the database.");
        try {
            return jdbcTemplate.query("select * from book", new RowMapper<Book>() {
                @Override
                public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Book book = new Book();
                    book.setId(rs.getInt("id"));
                    book.setIsbn(rs.getString("isbn"));
                    book.setTitle(rs.getString("title"));
                    book.setAuthor(rs.getString("author"));
                    book.setPrice(rs.getDouble("price"));
                    book.setQuantity(rs.getInt("quantity"));
                    return book;
                }
            });
        } catch (Exception e) {
            LOGGER.error("Error fetching books from the database", e);
            return null;
        }
    }

    @Transactional
    public boolean deleteByTitle(String title) {
        LOGGER.info("Attempting to delete book with title: {}", title);
        try {
            int rowsAffected = jdbcTemplate.update("delete from book where title = ?", title);
            if (rowsAffected > 0) {
                LOGGER.info("Book with title '{}' deleted successfully.", title);
                return true;
            } else {
                LOGGER.warn("No book found with title '{}'. No records deleted.", title);
                return false;
            }
        } catch (Exception e) {
            LOGGER.error("Failed to delete book with title: {}", title, e);
            return false;
        }
    }
}
