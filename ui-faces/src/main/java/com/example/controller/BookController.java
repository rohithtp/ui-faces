package com.example.controller;

import com.example.model.Book;
import com.example.dao.BookDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean
@RequestScoped
public class BookController {
    private Book book = new Book();
    private BookDAO bookDAO = new BookDAO();

    public String createBook() {
        bookDAO.addBook(book);
        return "books"; // Navigate to books page after creation
    }

    // Always return the current book instance for form binding
    public Book getBook() {
        if (book == null) {
            book = new Book();
        }
        return book;
    }

    public String updateBook() {
        bookDAO.updateBook(book);
        return "books"; // Navigate to books page after update
    }

    public String deleteBook() {
        bookDAO.deleteBook(book.getId());
        return "books"; // Navigate to books page after deletion
    }

    public void setBook(Book book) {
        this.book = book;
    }

    // Return the list of books from the DAO
    public List<Book> getBooks() {
        return bookDAO.getAllBooks();
    }
}