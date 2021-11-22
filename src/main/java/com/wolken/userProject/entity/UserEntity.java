package com.wolken.userProject.entity;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class UserEntity {

	@Id
	@GenericGenerator(name = "Madhushree", strategy = "increment")
	@GeneratedValue(generator = "Madhushree")
	private int userId;
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
	
	@OneToMany(targetEntity=TicketEntity.class,cascade=CascadeType.ALL)
	@JoinColumn(name="user_id",referencedColumnName="userId")
	private List<TicketEntity> ticket;
	
	
	
}
