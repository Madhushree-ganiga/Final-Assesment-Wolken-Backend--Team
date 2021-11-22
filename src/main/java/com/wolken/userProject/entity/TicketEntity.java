package com.wolken.userProject.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
public class TicketEntity {
	@Id
	@GenericGenerator(name = "Madhushree", strategy = "increment")
	@GeneratedValue(generator = "Madhushree")
	
	private int t_id;
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
