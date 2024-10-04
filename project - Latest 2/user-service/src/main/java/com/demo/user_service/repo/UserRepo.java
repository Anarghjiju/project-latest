package com.demo.user_service.repo;

import com.demo.user_service.entity.UserEntity;
import com.demo.user_service.pojo.UserPojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity,Long> {
}
