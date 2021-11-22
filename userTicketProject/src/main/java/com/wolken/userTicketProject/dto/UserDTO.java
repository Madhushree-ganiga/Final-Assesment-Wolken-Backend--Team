package com.wolken.userTicketProject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDTO {

	
	private String firstName;
	private String MiddleName;
	private String lasttName;
	private String password;
	private long contactNumber;
	private String email;
	private String residentialAddress;
	private String country;
	private String state;
	private long pincode;
	private int age;
	private String gender;
	private String dob;

}
