package com.wolken.userTicketProject.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import com.wolken.userTicketProject.dto.UserandTicketDTO;
import com.wolken.userTicketProject.service.UserandTicketService;



@RestController
public class UserandTicketController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	UserandTicketService service;
	
	@GetMapping("alltickets")
	List<UserandTicketDTO> alltickets(){
		List<UserandTicketDTO> dto=null;
		try {
			dto = service.getAllTicket();
		} catch (Exception e) {
			logger.error(e.getMessage(),e.getClass().getSimpleName());
		}
		return dto;
	}
	
	
	
}

