package com.demo.user_service.pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserPojo {
    private long userId;
    private String userName;
    private List<BookPojo> allBooks;

}
