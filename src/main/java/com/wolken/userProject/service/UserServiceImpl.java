package com.wolken.userProject.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.TypeMismatchException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolken.userProject.dto.UserDTO;
import com.wolken.userProject.entity.UserEntity;
import com.wolken.userProject.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepo repo;

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public String validateAndAddUser(UserDTO dto) {
		// TODO Auto-generated method stub
		UserEntity entity = new UserEntity();
		try {
			if (dto != null) {
				BeanUtils.copyProperties(dto, entity);
				logger.info("" + entity);
				entity = repo.save(entity);

				logger.info(" Added New User ");
				return "Added  User";
			} else {
				logger.info("Object Is Null");
				return "User Not Added";
			}
		} catch (NullPointerException | TypeMismatchException e) {
			logger.error(e.getMessage(), e.getClass().getSimpleName());

		}

		return null;
	}

	@Override
	public List<UserDTO> validateAndGetAll() {
		// TODO Auto-generated method stub

		try {

			List<UserDTO> dtos = new ArrayList<>();
			List<UserEntity> entity;
			entity = repo.findAll();
			for (UserEntity Userentity : entity) {
				UserDTO dto = new UserDTO();
				BeanUtils.copyProperties(Userentity, dto);
				dtos.add(dto);

			}

			return dtos;
		}

		catch (Exception e) {
			logger.error("========you have an exception in EmployeeController.getByName() ===");
			logger.error(e.getMessage(), e.getClass());

		}
		return null;

	}

	@Override
	public UserDTO validateAndFindByEmail(String email) {
		// TODO Auto-generated method stub
		try {
			if(email!=null) {
				logger.info(email);
				UserEntity entity=repo.getUserByEmail(email);
				logger.info(""+entity);
				if(entity!=null) {
					UserDTO dto=new UserDTO();
					BeanUtils.copyProperties(entity,dto);
					return dto;
				}
			}
			else {
				logger.info("invalid email");
				return null;
			}
		}
		catch(Exception e) {
			logger.error("========you have an exception in UserController.getByEmail() ===");
			logger.error(e.getMessage(),e.getClass());

		}
		return null;
	}

	@Override
	public String validateAndUpdate(UserDTO dto) {
		// TODO Auto-generated method stub
		
		UserEntity entity = new UserEntity();
		entity = repo.getUserByEmail(dto.getEmail());
		logger.info("entity"+entity);
		if (dto != null) {
			if (dto.getFirstName() != null) {

				entity.setFirstName(dto.getFirstName());
			}
			if (dto.getMiddleName() != null) {

				entity.setMiddleName(dto.getMiddleName());
			}
			if (dto.getLasttName() != null) {
				entity.setLasttName(dto.getLasttName());
			}
			
			if (dto.getPassword() != null) {
				entity.setPassword(dto.getPassword());
			}
			
			if (dto.getContactNumber() != 0) {
				entity.setContactNumber(dto.getContactNumber());
			}

			if (dto.getEmail() != null) {
				entity.setEmail(dto.getEmail());
			}
			if (dto.getResidentialAddress() != null) {
				entity.setResidentialAddress(dto.getResidentialAddress());
			}
			
			
			if (dto.getCountry() != null) {
				entity.setCountry(dto.getCountry());
			}
			if (dto.getState() != null) {
				entity.setState(dto.getState());
			}
			if (dto.getPincode() != 0) {
				entity.setPincode(dto.getPincode());
			}
			if (dto.getAge() != 0) {
				entity.setAge(dto.getAge());
			}
			if (dto.getGender() != null) {
				entity.setGender(dto.getGender());
				
			}
			if (dto.getDob() != null) {
				entity.setDob(dto.getDob());
				
			}
			repo.save(entity);
			return "User Updated Sucessfully";
		}
		return null;
	}
}