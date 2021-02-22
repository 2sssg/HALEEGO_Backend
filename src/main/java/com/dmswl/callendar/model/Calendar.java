package com.dmswl.callendar.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Calendar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int calendarNUM;
	
	@Column(nullable = false, length = 50)
	private String scheduleTYPE;
	
	@Column(nullable = true, length = 100)
	private String scheduleDETAIL;
	
	@Column(nullable = false, length = 50)
	private String scheduleDATE;
	
	@Column(nullable = true,length = 50)
	private String startTIME;
	
	@Column(nullable = true, length = 50)
	private String finishTIME;
	
	@Column(nullable = false, length = 50)
	private String scheduleLOCATION;
	
	@Column(nullable = false,length = 50)
	private int hostNUM;
	
	
    @OneToMany(mappedBy = "calendar", cascade = CascadeType.REMOVE)
    private List<Calendar_has_User> Calendar_has_User1 = new ArrayList<>();
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Calendar_has_User> Calendar_has_User2 = new ArrayList<>();
	
}
