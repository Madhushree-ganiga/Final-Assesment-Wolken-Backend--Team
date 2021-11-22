package com.wolken.userTicketProject.service;




import java.util.List;

import com.wolken.userTicketProject.dto.UserDTO;

public interface UserService {

	String validateAndAddUser(UserDTO dto);

	UserDTO validateAndFindByEmail(String email);

	String validateAndUpdate(UserDTO dto);

	List<UserDTO> validateAndGetAll();

	
	

	

}
