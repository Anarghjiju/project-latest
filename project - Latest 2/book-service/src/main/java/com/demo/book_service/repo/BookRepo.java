package com.demo.book_service.repo;

import com.demo.book_service.pojo.BookPojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookRepo extends JpaRepository<com.demo.book_service.pojo.BookPojo,Long> {

    List<BookPojo> findByBookUserId(long bookId);

}
