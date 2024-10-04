package com.demo.user_service.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="user_details")
public class UserEntity {

    @Id
    @Column(name="user_id")
    private Long userid;

    @Column(name="user_name")
    private String userName;

}
