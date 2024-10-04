package com.demo.user_service.controller;
import com.demo.user_service.pojo.BookPojo;
import com.demo.user_service.pojo.UserPojo;
import com.demo.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService us;

    @GetMapping("/users")
    public List<UserPojo> getAllUsers(){
        return us.getAllUsers();
    }

    @GetMapping("/users/{uid}")
    public UserPojo getAUser(@PathVariable("uid") long userId) {
        UserPojo fetchedUser = us.getAUser(userId);
        List<BookPojo> books = WebClient.builder().build()
                .get()
                .uri("http://localhost:8082/api/books/users/" + userId)
                .retrieve()
                .bodyToFlux(BookPojo.class)
                .collectList()
                .block();
        fetchedUser.setAllBooks(books);
        return fetchedUser;
    }

    @PostMapping("/users")
    public UserPojo addUser(@RequestBody UserPojo newUser) {
        return us.addAUser(newUser);
    }

}
