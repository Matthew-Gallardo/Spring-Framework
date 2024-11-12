package org.acumen.training.codes.services;

import java.util.List;
import org.acumen.training.codes.dao.BookDao;
import org.acumen.training.codes.model.data.Book;
import org.acumen.training.codes.model.form.BookForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    @Transactional
    public boolean addBook(BookForm form) {
        Book book = new Book();
        book.setIsbn(form.getIsbn());
        book.setTitle(form.getTitle());
        book.setAuthor(form.getAuthor());
        book.setPrice(form.getPrice());
        book.setQuantity(form.getQuantity());
        return bookDao.insertBook(book);
    }

    @Transactional
    public List<Book> listAllBooks() {
        return bookDao.selectAllBooks();
    }

    @Transactional
    public boolean deleteBookByTitle(String title) {
        return bookDao.deleteByTitle(title);
    }
}
