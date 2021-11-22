package com.wolken.userProject.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wolken.userProject.dto.UserDTO;
import com.wolken.userProject.service.UserService;



@RestController
public class UserController {
	@Autowired
	UserService service;
	private Logger logger = LoggerFactory.getLogger( UserController.class);
	
	@PostMapping("addUser")
	String save(@RequestBody UserDTO dto) {
		String msg = null;
		try {
			logger.info("" + dto);
			msg = service.validateAndAddUser(dto);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return msg;
	}
	@GetMapping("GetAllUser")
	List<UserDTO> GetAll() {
		List<UserDTO> dto = null;
		try {
		
			dto=service.validateAndGetAll();
		} catch (Exception e) {
			logger.error("=============== you have an exception in EmployeeController.getByName() =====");
			logger.error(e.getMessage(), e.getClass());
		}
		
		return dto;
	}

	@GetMapping("getUserByEmail")
	UserDTO getUserByEmail(@Param(value="email")String email )
		{
		UserDTO dto = null;

			try {
				logger.info(email);
				dto = service.validateAndFindByEmail(email);
			} catch (Exception e) {
				logger.error("========you have an exception in UserController.getByEmail() ===");
				logger.error(e.getMessage(), e.getClass());

			}
			return dto;
		}
	
	@PostMapping("updateUser")
	String updateUser(@RequestBody UserDTO dto) {
		String msg=null;
		try {
			logger.info(""+dto);
			msg=service.validateAndUpdate(dto);
		}
		catch(Exception e) {
			logger.error(e.getMessage());
			}
		
		return msg;
		
	}
}
