package com.example.dao;

import com.example.model.Book;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    
    // Method to add a new book
    public void addBook(Book book) {
        // Implementation for adding a book to the database
    }

    // Method to retrieve a book by its ID
    public Book getBook(int id) {
        // Implementation for retrieving a book from the database
        return null; // Placeholder return
    }

    // Method to update an existing book
    public void updateBook(Book book) {
        // Implementation for updating a book in the database
    }

    // Method to delete a book by its ID
    public void deleteBook(int id) {
        // Implementation for deleting a book from the database
    }

    // Method to get all books from the SQLite database
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String url = "jdbc:sqlite:ui_faces_db.sqlite";
        String sql = "SELECT id, title, author, isbn FROM Book";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setIsbn(rs.getString("isbn"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
}