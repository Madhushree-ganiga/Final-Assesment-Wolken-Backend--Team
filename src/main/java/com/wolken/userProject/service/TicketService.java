package com.wolken.userProject.service;

import java.util.List;

import com.wolken.userProject.dto.TicketDTO;

public interface TicketService {

	List<TicketDTO> validateAndGetAll();

	String validateAndUpdateTickets(TicketDTO dto);

	TicketDTO validateAndFindTicketByName(String ticketName);

	String validateAndAddTicket(TicketDTO dto);

}
