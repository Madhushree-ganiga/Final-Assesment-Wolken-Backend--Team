package com.wolken.userTicketProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.wolken.userTicketProject.entity.UserEntity;

public interface UserRepo extends JpaRepository <UserEntity,Integer> {

	UserEntity getUserByEmail(String email);

}
