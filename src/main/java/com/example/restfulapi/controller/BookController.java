package com.example.restfulapi.controller;

import com.example.restfulapi.entity.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    private final List<Book> books = new ArrayList<>();

    public BookController() {
        books.add(new Book(1, "Spring Boot Basic", "abc"));
        books.add(new Book(2, "REST API", "abc"));
        books.add(new Book(3, "Java Core", "xyz"));
    }

    @GetMapping("/books/search")
    public List<Book> search(@RequestParam String author) {
        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }

        return result;
    }
}
