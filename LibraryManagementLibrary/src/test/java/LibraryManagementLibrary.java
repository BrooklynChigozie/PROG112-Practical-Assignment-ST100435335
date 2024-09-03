/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author brook
 */


public class BookTest {

    @Test
    public void testBookCreation() {
        Book book = new Book("Effective Java", "Joshua Bloch", 1);
        assertEquals("Effective Java", book.getTitle());
        assertEquals("Joshua Bloch", book.getAuthor());
        assertEquals(1, book.getId());
    }

    @Test
    public void testDisplayInfo() {
        Book book = new Book("Effective Java", "Joshua Bloch", 1);
        book.displayInfo();

    }
}


public class EBookTest {

    @Test
    public void testEBookCreation() {
        EBook ebook = new EBook("Clean Code", "Robert C. Martin", 2, 1.5);
        assertEquals("Clean Code", ebook.getTitle());
        assertEquals("Robert C. Martin", ebook.getAuthor());
        assertEquals(2, ebook.getId());
        assertEquals(1.5, ebook.getFileSize());
    }
    //tests for adding a new ebook to the digital library
    
    @Test
    public void testDisplayInfo() {
        EBook ebook = new EBook("Clean Code", "Robert C. Martin", 2, 1.5);
        ebook.displayInfo();

    }
}
  // test to display infomation

public class LibraryManagementTest {
    private LibraryManagement libMgmt;

    @BeforeEach
    public void setUp() {
        libMgmt = new LibraryManagement();
    }

    @Test
    public void testAddBook() {
        Book book = new Book("Effective Java", "Joshua Bloch", 1);
        libMgmt.addBook(book);
        assertEquals(1, libMgmt.getBooks().size());
        assertEquals(book, libMgmt.getBooks().get(0));
    }
 // method to add book
    @Test
    public void testDisplayAllBooks() {
        Book book1 = new Book("Effective Java", "Joshua Bloch", 1);
        EBook ebook1 = new EBook("Clean Code", "Robert C. Martin", 2, 1.5);
        libMgmt.addBook(book1);
        libMgmt.addBook(ebook1);
        libMgmt.displayAllBooks();
     
    }
}
