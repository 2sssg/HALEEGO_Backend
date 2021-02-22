package com.dmswl.callendar.model;

import javax.persistence.Column;
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
public class Friend {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto-increment
	private int id;
	
	
	@ManyToOne
	@JoinColumn(name = "userME" , nullable = false)
	private User userME;
//	
//	@Column(nullable = false)
//	private int recipient;
	
	@ManyToOne
	@JoinColumn(name = "userFRIEND", nullable = false)
	private User userFRIEND;
}
