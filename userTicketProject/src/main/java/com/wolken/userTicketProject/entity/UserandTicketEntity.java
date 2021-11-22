package com.wolken.userTicketProject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table
@NoArgsConstructor
@ToString

public class UserandTicketEntity {
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
	private int ticketId;
	private String ticketName;
	private String shortDesc;
	private String ticketStartDate;
	private String ticketCloseDate;
	private String ticketCategory;
	private String ticketType;
	private String ticketRaisedBy;
    private boolean status;
    private int priority;


}
