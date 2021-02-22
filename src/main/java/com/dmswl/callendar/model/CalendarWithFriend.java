package com.dmswl.callendar.model;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CalendarWithFriend {
	
	private int hostNUM;

	private String scheduleTYPE;
	
	private String scheduleDETAIL;
	
	private String scheduleDATE;
	
	private String startTIME;
	
	private String finishTIME;
	
	private String scheduleLOCATION;
	
	private List<String> friendLIST;
	
}
