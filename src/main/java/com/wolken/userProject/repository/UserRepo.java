package com.wolken.userProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wolken.userProject.entity.UserEntity;

public interface UserRepo extends JpaRepository <UserEntity,Integer> {

	UserEntity getUserByEmail(String email);

}
