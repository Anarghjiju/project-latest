package com.demo.user_service.service;

import com.demo.user_service.entity.UserEntity;
import com.demo.user_service.pojo.UserPojo;
import com.demo.user_service.repo.UserRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo ur;

    public List<UserPojo> getAllUsers(){
        List<UserEntity> allUserEntity = ur.findAll();
        List<UserPojo> allUserPojo = new ArrayList<>();
        allUserEntity.stream().forEach((eachUserEntity) -> {
            UserPojo userPojo = new UserPojo();
            BeanUtils.copyProperties(eachUserEntity, userPojo);
            allUserPojo.add(userPojo);
        });
        return allUserPojo;
    }

    public UserPojo getAUser(Long userId){
        Optional<UserEntity> fetchedDeptEntity = ur.findById(userId);
        UserPojo deptPojo = null;
        if(fetchedDeptEntity.isPresent()) {
            deptPojo = new UserPojo();
            BeanUtils.copyProperties(fetchedDeptEntity.get(), deptPojo);
        }
        return deptPojo;
    }

    public UserPojo addAUser(UserPojo newUserPojo){
        UserEntity deptEntity = new UserEntity();
        BeanUtils.copyProperties(newUserPojo, deptEntity);
        ur.saveAndFlush(deptEntity);
        return newUserPojo;
    }



}
