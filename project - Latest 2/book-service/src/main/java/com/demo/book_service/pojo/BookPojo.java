package com.demo.book_service.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class BookPojo {
    @Id

    private long bookId;
    private String bookName;
    private Long bookUserId;

}