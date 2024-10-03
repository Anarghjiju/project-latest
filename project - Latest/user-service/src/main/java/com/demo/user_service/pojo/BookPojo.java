package com.demo.user_service.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne
    @JoinColumn(name = "user_id") // Foreign key in the Book table
    private UserPojo user;

}
