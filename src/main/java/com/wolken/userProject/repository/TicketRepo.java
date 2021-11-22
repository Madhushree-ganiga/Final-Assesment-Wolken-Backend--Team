package com.wolken.userProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wolken.userProject.entity.TicketEntity;


public interface TicketRepo extends JpaRepository <TicketEntity,Integer> {

	TicketEntity getByTicketName(String ticketName);

}
