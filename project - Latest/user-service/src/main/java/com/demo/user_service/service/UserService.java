package com.demo.user_service.service;

import com.demo.user_service.pojo.UserPojo;
import com.demo.user_service.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo ur;

    public List<UserPojo> getAllUsers(){
        List<UserPojo> allUsers = ur.findAll();
        return allUsers;
    }

    public UserPojo getAUser(Long userId){
        UserPojo fetchedUser = ur.findById(userId).get();
        return fetchedUser;
    }

    public UserPojo addAUser(UserPojo newUser){
        return ur.saveAndFlush(newUser);
    }



}
