package com.wolken.userProject.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.TypeMismatchException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolken.userProject.dto.TicketDTO;
import com.wolken.userProject.entity.TicketEntity;
import com.wolken.userProject.repository.TicketRepo;



@Service
public class TicketServiceImpl implements TicketService {
	@Autowired
	TicketRepo repo;
	private Logger logger=LoggerFactory.getLogger(TicketServiceImpl.class);
	

	@Override
	public List<TicketDTO> validateAndGetAll() {
		// TODO Auto-generated method stub
try {
			
			List<TicketDTO> dtos=new ArrayList<>();
			List<TicketEntity> entity;
			entity=repo.findAll();
			for(TicketEntity Ticketentity:entity ) {
				TicketDTO dto=new TicketDTO();
				BeanUtils.copyProperties(Ticketentity, dto);
				dtos.add(dto);
				
			}
			
			
			return dtos;
		}
			
		
catch(Exception e) {
		logger.error("========you have an exception in EmployeeController.getByName() ===");
		logger.error(e.getMessage(),e.getClass());

	}
		
		return null;
	}


	@Override
	public String validateAndUpdateTickets(TicketDTO dto) {
	
		TicketEntity entity = new TicketEntity();
		entity = repo.getByTicketName(dto.getTicketName());
		logger.info("entity"+entity);
		if (dto != null) {
			if (dto.getTicketName() != null) {

				entity.setTicketName(dto.getTicketName());
			}
			if (dto.getShortDesc() != null) {

				entity.setShortDesc(dto.getShortDesc());
			}
			if (dto.getTicketStartDate() != null) {
				entity.setTicketStartDate(dto.getTicketStartDate());
			}
			
			if (dto.getTicketCloseDate() != null) {
				entity.setTicketCloseDate(dto.getTicketCloseDate());
			}
			if (dto.getTicketCategory() != null) {
				entity.setTicketCategory(dto.getTicketCategory());
			}
			if (dto.getTicketType() != null) {
				entity.setTicketType(dto.getTicketType());
			}

			if (dto.getTicketRaisedBy() != null) {
				entity.setTicketRaisedBy(dto.getTicketRaisedBy());
			}

			if (dto.isStatus() != true | false) {
				entity.setStatus(dto.isStatus());
			}
			if (dto.getPriority() != 0) {
				entity.setPriority(dto.getPriority());
			}
			
			repo.save(entity);
			return "Ticket Details Updated Sucessfully";
		}
		return null;
	}


	@Override
	public TicketDTO validateAndFindTicketByName(String ticketName) {
		// TODO Auto-generated method stub
		try {
			if(ticketName!=null) {
				logger.info(ticketName);
				TicketEntity entity=repo.getByTicketName(ticketName);
				logger.info(""+entity);
				if(entity!=null) {
					TicketDTO dto=new TicketDTO();
					BeanUtils.copyProperties(entity,dto);
					return dto;
				}
			}
			else {
				logger.info("invalid name");
				return null;
			}
		}
		catch(Exception e) {
			logger.error("========you have an exception in EmployeeController.getByName() ===");
			logger.error(e.getMessage(),e.getClass());

		}
		
		
		return null;
	}


	@Override
	public String validateAndAddTicket(TicketDTO dto) {
		// TODO Auto-generated method stub
		try {
			if(dto!=null) {
				logger.info(""+dto);
				TicketEntity entity=new com.wolken.userProject.entity.TicketEntity();
				BeanUtils.copyProperties(dto, entity);
				logger.info(""+entity);
				repo.save(entity);
			
				logger.info(" Added New Ticket ");
				return " New ticket Added";
			}
			else
			{
				logger.info("Object Is Null");
	return "Ticket Not Added";
	}
		
		}
		catch( NullPointerException | TypeMismatchException e)
		{logger.error(e.getMessage(),e.getClass().getSimpleName());
		
		}
		
		return null;
	}
}
