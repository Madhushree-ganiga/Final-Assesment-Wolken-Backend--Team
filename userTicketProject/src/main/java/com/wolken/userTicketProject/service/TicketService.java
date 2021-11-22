package com.wolken.userTicketProject.service;

import java.util.List;

import com.wolken.userTicketProject.dto.TicketDTO;


public interface TicketService {

	String validateAndAddTicket(TicketDTO dto);

	TicketDTO validateAndFindTicketByName(String ticketName);

	String validateAndUpdateTickets(TicketDTO dto);

	List<TicketDTO> validateAndGetAll();

	
}
