package com.dmswl.callendar.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Calendar2 {
	
	private int calendarNUM;
	
	private String scheduleTYPE;
	
	private String scheduleDETAIL;
	
	private String scheduleDATE;
	
	private String startTIME;
	
	private String finishTIME;
	
	private String scheduleLOCATION;
	
	private int hostNUM;
	

}
