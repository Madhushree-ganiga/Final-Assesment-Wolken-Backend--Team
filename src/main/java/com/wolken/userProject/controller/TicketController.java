package com.wolken.userProject.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wolken.userProject.service.TicketService;
import com.wolken.userProject.dto.TicketDTO;

@RestController
public class TicketController {
	@Autowired
	TicketService service;
	private Logger logger = LoggerFactory.getLogger( TicketController.class);
	@PostMapping("addNewTicket")
	String save(@RequestBody TicketDTO dto) {
		String msg = null;
		try {
			logger.info("" + dto);
			msg = service.validateAndAddTicket(dto);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return msg;
	}

	@GetMapping("getTicketByName")
	TicketDTO getTicketByName(@Param(value="ticketName")String ticketName )
		{
		TicketDTO dto = null;

			try {
				logger.info(ticketName);
				dto = service.validateAndFindTicketByName(ticketName);
			} catch (Exception e) {
				logger.error("========you have an exception in UserController.getByEmail() ===");
				logger.error(e.getMessage(), e.getClass());

			}
			return dto;
		}
	@PostMapping("updateTickets")
	String updateTickets(@RequestBody TicketDTO dto) {
		String msg=null;
		try {
			logger.info(""+dto);
			msg=service.validateAndUpdateTickets(dto);
		}
		catch(Exception e) {
			logger.error(e.getMessage());
			}
		
		return msg;
		
	}
	@GetMapping("GetAllTickets")
	List<TicketDTO> GetAll() {
		List<TicketDTO> dto = null;
		try {
		
			dto=service.validateAndGetAll();
		} catch (Exception e) {
			logger.error("=============== you have an exception in EmployeeController.getByName() =====");
			logger.error(e.getMessage(), e.getClass());
		}
		
		return dto;
	}
}




