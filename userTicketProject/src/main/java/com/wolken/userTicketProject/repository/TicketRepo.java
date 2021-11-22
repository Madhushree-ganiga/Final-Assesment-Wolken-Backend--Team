package com.wolken.userTicketProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wolken.userTicketProject.entity.TicketEntity;

public interface TicketRepo extends JpaRepository <TicketEntity,Integer> {

	TicketEntity getByTicketName(String ticketName);

	

}
