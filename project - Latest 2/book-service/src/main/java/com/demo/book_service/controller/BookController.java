package com.demo.book_service.controller;

import com.demo.book_service.pojo.BookPojo;
import com.demo.book_service.repo.BookRepo;
import com.demo.book_service.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    BookService bs;

    @Autowired
    BookRepo br;

    @GetMapping("/books")
    public List<BookPojo> getAllBooks(){
        return bs.getAllBooks();
    }

    @PostMapping("/books")
    public BookPojo addBooks(@RequestBody BookPojo newBook) {
        return bs.addABook(newBook);
    }

    @GetMapping("/books/users/{uid}")
    public List<BookPojo> getAllBooksByUsers(@PathVariable long uid){
        return br.findByBookUserId(uid);
    }

}
