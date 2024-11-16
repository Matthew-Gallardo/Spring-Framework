package org.acumen.training.codes.controller;

import java.util.InputMismatchException;
import java.util.List;

import org.acumen.training.codes.exception.ISBNLimitException;
import org.acumen.training.codes.model.data.Book;
import org.acumen.training.codes.model.form.BookForm;
import org.acumen.training.codes.services.BookService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/book")
public class BookFormController {
	private static final Logger LOGGER = LogManager.getLogger(BookFormController.class);

    @Autowired
    private BookService bookService;
    

    
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String initMain(Model model) {
        LOGGER.info("Main Application");
        return "main";
    }

    @RequestMapping(value = "/entry", method = RequestMethod.GET)
    public String initAddBookForm(Model model) {
        model.addAttribute("bookForm", new BookForm());
        LOGGER.info("Entry GET success");
        return "add_book";
    }

    @RequestMapping(value = "/entry", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("bookForm") BookForm form, Model model) {
  
        validateBookForm(form); 
        bookService.addBook(form);
        LOGGER.info("Entry POST success");
        return "redirect:/app1/book/list";
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listBooks(Model model) {
        List<Book> books = bookService.listAllBooks();
        model.addAttribute("bookList", books);
        LOGGER.info("List Book GET success");
        return "list_books";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String initDeleteForm(Model model) {
        model.addAttribute("bookForm", new BookForm());
        model.addAttribute("recs", bookService.listAllBooks());
        LOGGER.info("Delete GET success");
        return "delete_book";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteBook(@ModelAttribute("bookForm") BookForm form, Model model) {
        bookService.deleteBookByTitle(form.getTitle());
        LOGGER.info("Delete POST success");
        return "redirect:/app1/book/list";
    }

    private void validateBookForm(BookForm form) {
    	
    	//ISBN Validation
        if (form.getIsbn() == null || form.getIsbn().isEmpty()) {
            LOGGER.warn("ISBN empty error");
            throw new NullPointerException("ISBN cannot be empty");
        }
        if (form.getIsbn().length() > 20) {
            LOGGER.warn("ISBN over 20 character error");
            throw new ISBNLimitException("ISBN cannot be more than 20 characters");
        }
        
        // Title Validation
        if (form.getTitle() == null || form.getTitle().isEmpty()) {
            LOGGER.warn("Title empty error");
            throw new NullPointerException("Title cannot be empty");
        }
        
        // Author Validation
        if (form.getAuthor() == null || form.getAuthor().isEmpty()) {
            LOGGER.warn("Author empty error");
            throw new NullPointerException("Author cannot be empty");
        }
        
        // Price Validation
        try {
            Double price = form.getPrice();
            if (price == null || price <= 0) {
                LOGGER.warn("Price must be a positive double");
                throw new InputMismatchException("Price must be a positive double");
            }
        } catch (Exception e) {
            LOGGER.warn("Price is not a valid double");
            throw new InputMismatchException("Price must be a valid double");
        }
        
       
        try {
            Integer quantity = form.getQuantity();
            if (quantity== null || quantity < 0) {
                LOGGER.warn("Quantity must be a non-negative integer");
                throw new InputMismatchException("Quantity must be a non-negative integer");
            }
        } catch (Exception e) {
            LOGGER.warn("Quantity is not a valid integer");
            throw new InputMismatchException("Quantity must be a valid integer");
        }
    }
}
