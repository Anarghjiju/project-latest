package com.demo.book_service.service;

import com.demo.book_service.pojo.BookPojo;
import com.demo.book_service.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepo br;

    public List<BookPojo> getAllBooks() {
        List<BookPojo> allBooks = br.findAll();
        return allBooks;
    }

    public BookPojo getABooks(Long bookId) {
        BookPojo fetchedBook = br.findById(bookId).get();
        return fetchedBook;
    }

    public BookPojo addABook(BookPojo newBook) {
        return br.saveAndFlush(newBook);
    }
}