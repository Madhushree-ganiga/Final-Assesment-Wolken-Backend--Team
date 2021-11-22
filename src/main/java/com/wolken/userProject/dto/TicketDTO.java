package com.wolken.userProject.dto;




import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class TicketDTO {
	private int t_id;
	private String ticketName;
	private String shortDesc;
	private String ticketStartDate;
	private String ticketCloseDate;
	private String ticketCategory;
	private String ticketType;
	private String ticketRaisedBy;
    private boolean status;
	private int priority;
}
