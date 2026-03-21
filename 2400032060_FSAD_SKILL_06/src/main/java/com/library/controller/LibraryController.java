package com.library.controller;

import java.util.*;
import org.springframework.web.bind.annotation.*;
import com.library.model.Book;

@RestController
public class LibraryController {

    List<Book> bookList = new ArrayList<>();

    // 1. Welcome
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Library System";
    }

    // 2. Count
    @GetMapping("/count")
    public int count() {
        return 100;
    }

    // 3. Price
    @GetMapping("/price")
    public double price() {
        return 499.99;
    }

    // 4. Books list
    @GetMapping("/books")
    public List<String> getBooks() {
        return Arrays.asList("Java", "Spring", "Hibernate");
    }

    // 5. Book by ID
    @GetMapping("/books/{id}")
    public String getBookById(@PathVariable int id) {
        return "Book ID: " + id;
    }

    // 6. Search
    @GetMapping("/search")
    public String search(@RequestParam String title) {
        return "Searching for book: " + title;
    }

    // 7. Author
    @GetMapping("/author/{name}")
    public String author(@PathVariable String name) {
        return "Books by author: " + name;
    }

    // 8. Add book (POST)
    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        bookList.add(book);
        return "Book added successfully";
    }

    // 9. View books
    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return bookList;
    }
}