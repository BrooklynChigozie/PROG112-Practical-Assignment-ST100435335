/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.librarymanagementlibrary;

/**
 *
 * @author brook
 */
import java.util.Scanner;
import java.util.ArrayList;

public class Book {
    private final String title;
    private final String author;
    private final int id;

    public Book(String title, String author, int id) {
        this.title = title;
        this.author = author;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }

    public void displayInfo() {
        System.out.println("ID: " + id + ", Title: " + title + ", Author: " + author);
    }
}

public class EBook extends Book {
    private final double fileSize;

    public EBook(String title, String author, int id, double fileSize) {
        super(title, author, id);
        this.fileSize = fileSize;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("File Size: " + fileSize + " MB");
    }
}


public class LibraryManagement {
    private final ArrayList<Book> books;

    public LibraryManagement() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayAllBooks() {
        for (Book book : books) {
            book.displayInfo();
        }
    }
}



public class Main {
    public static void main(String[] args) {
        LibraryManagement libMgmt = new LibraryManagement();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Book");
            System.out.println("2. Add EBook");
            System.out.println("3. Display All Books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.next();
                    System.out.print("Enter author: ");
                    String author = scanner.next();
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    libMgmt.addBook(new Book(title, author, id));
                    break;
                case 2:
                    System.out.print("Enter title: ");
                    title = scanner.next();
                    System.out.print("Enter author: ");
                    author = scanner.next();
                    System.out.print("Enter ID: ");
                    id = scanner.nextInt();
                    System.out.print("Enter file size (MB): ");
                    double fileSize = scanner.nextDouble();
                    libMgmt.addBook(new EBook(title, author, id, fileSize));
                    break;
                case 3:
                    libMgmt.displayAllBooks();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

