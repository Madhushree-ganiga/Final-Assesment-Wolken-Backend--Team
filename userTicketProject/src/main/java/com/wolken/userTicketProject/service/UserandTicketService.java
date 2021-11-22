package com.wolken.userTicketProject.service;

import java.util.List;

import com.wolken.userTicketProject.dto.TicketDTO;
import com.wolken.userTicketProject.dto.UserDTO;
import com.wolken.userTicketProject.dto.UserandTicketDTO;
import com.wolken.userTicketProject.entity.TicketEntity;
import com.wolken.userTicketProject.entity.UserEntity;
import com.wolken.userTicketProject.entity.UserandTicketEntity;

public interface UserandTicketService {

	

	public  List<UserandTicketDTO> getAllTicket() ;

	public UserandTicketEntity addToMap(UserDTO dto);

	void addTicketToMap(TicketEntity entity);



}




