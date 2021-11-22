package com.wolken.userTicketProject.repository;


import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.wolken.userTicketProject.entity.UserandTicketEntity;

public interface UserandTicketRepository extends JpaRepositoryImplementation<UserandTicketEntity, Integer> {

	UserandTicketEntity findByUserId(int userId);

	

	
}
