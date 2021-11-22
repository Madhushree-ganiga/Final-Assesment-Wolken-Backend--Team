package com.wolken.userProject.service;

import java.util.List;

import com.wolken.userProject.dto.UserDTO;

public interface UserService {

	String validateAndAddUser(UserDTO dto);

	List<UserDTO> validateAndGetAll();

	UserDTO validateAndFindByEmail(String email);

	String validateAndUpdate(UserDTO dto);

}
