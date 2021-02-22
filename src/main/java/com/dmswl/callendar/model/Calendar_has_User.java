package com.dmswl.callendar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Calendar_has_User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto-increment
	private int id;
	
	@ManyToOne
	@JoinColumn(name="calendar_calendarNUM")
	private Calendar calendar;
	
	@ManyToOne
	@JoinColumn(name="user_userIDK")
	private User user;
	
}
