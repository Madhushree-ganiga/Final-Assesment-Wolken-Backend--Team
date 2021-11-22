package com.wolken.userTicketProject.service;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.TypeMismatchException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolken.userTicketProject.dto.TicketDTO;
import com.wolken.userTicketProject.dto.UserDTO;
import com.wolken.userTicketProject.dto.UserandTicketDTO;
import com.wolken.userTicketProject.entity.TicketEntity;
import com.wolken.userTicketProject.entity.UserEntity;
import com.wolken.userTicketProject.entity.UserandTicketEntity;
import com.wolken.userTicketProject.repository.UserandTicketRepository;


@Service
public class UserandTicketServiceImpl implements UserandTicketService {
	@Autowired
	UserandTicketRepository Repo;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public List<UserandTicketDTO> getAllTicket() {
		
       List<UserandTicketDTO> mappingDTOs = new ArrayList<>();
		
		try {
			List<UserandTicketEntity> MappingEntities = Repo.findAll();
			logger.info("Find ALL"+Repo.findAll());
			
			for (UserandTicketEntity UserandTicketEntity : MappingEntities) {
				UserandTicketDTO UserandTicketDto = new UserandTicketDTO();
				BeanUtils.copyProperties(UserandTicketEntity, UserandTicketDto);
				
				logger.info(""+ mappingDTOs);
				 mappingDTOs.add(UserandTicketDto);
				logger.info("Mapping"+ mappingDTOs);
				
			}
		} catch (NullPointerException | TypeMismatchException e) {
			logger.error(e.getMessage(),e.getClass().getName());
		}
		return  mappingDTOs;
	}

	@Override
	public UserandTicketEntity addToMap(UserDTO dto) {
		// TODO Auto-generated method stub
		UserandTicketEntity entity=new UserandTicketEntity();
		UserEntity uEntity=new UserEntity();
		BeanUtils.copyProperties(dto, entity);
		logger.info("user id"+entity);
		
		Repo.save(entity);
		return null;
	}

	@Override
	public void addTicketToMap(TicketEntity entity) {
		// TODO Auto-generated method stub
		
		UserandTicketEntity mentity=new UserandTicketEntity();
		
		mentity=Repo.findByUserId(entity.getUser_id());
	
		mentity.setTicketId(entity.getT_id());
		mentity.setShortDesc(entity.getShortDesc());
		mentity.setTicketName(entity.getTicketName());
		mentity.setTicketStartDate(entity.getTicketStartDate());
		mentity.setTicketCloseDate(entity.getTicketCloseDate());
		mentity.setTicketCategory(entity.getTicketCategory());
		mentity.setTicketType(entity.getTicketType());
		mentity.setTicketRaisedBy(entity.getTicketRaisedBy());
		mentity.setStatus(entity.isStatus());
		mentity.setPriority(entity.getPriority());
		Repo.save(mentity);
		
		
	}
	

	

}