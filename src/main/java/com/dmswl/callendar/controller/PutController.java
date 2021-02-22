package com.dmswl.callendar.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dmswl.callendar.model.Calendar;
import com.dmswl.callendar.model.User;
import com.dmswl.callendar.repository.CalendarRepository;
import com.dmswl.callendar.repository.Calendar_has_UserRepository;
import com.dmswl.callendar.repository.FriendRepository;
import com.dmswl.callendar.repository.UserRepository;


@RestController
public class PutController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private Calendar_has_UserRepository calendar_has_UserRepository;
	@Autowired
	private CalendarRepository calendarRepository;
	@Autowired
	private FriendRepository friendRepository;
	
	@Transactional //더티 체킹 : 함수 종료시에 자동 commit 
	@PutMapping("/put/user/{userid}")
	public String updateUser(@PathVariable String userid,@RequestBody User requestUser) {// 유저정보변경
		//비번,이름만 바꿀수있음
		User user = userRepository.findByUserID(userid);
		
		
		
		User user1 = userRepository.findById(user.getUserIDK()).orElseThrow(()->{
			return new IllegalArgumentException("수정에 실패하였습니다.");
		});
		if(requestUser.getUserPW() != null) user1.setUserPW(requestUser.getUserPW());
		
		if(requestUser.getUserNAME() !=null) user1.setUserNAME(requestUser.getUserNAME());
		
		
		return "ok"; //-> commit
	}
	
	@Transactional //더티 체킹 : 함수 종료시에 자동 commit 
	@PutMapping("/put/calendar/{calendarnum}")
	public String updatecalendar(@PathVariable int calendarnum,@RequestBody Calendar requestCalendar) {//일정변경
		//이름,설명,날짜,시작시간,끝나는시간,위치 변경가능
		Calendar calendar = calendarRepository.findById(calendarnum).orElseThrow(()->{
			return new IllegalArgumentException("수정에 실패하였습니다.");
		});
		if(requestCalendar.getScheduleTYPE() != null) calendar.setScheduleTYPE(requestCalendar.getScheduleTYPE());
		if(requestCalendar.getScheduleDETAIL() != null) calendar.setScheduleDETAIL(requestCalendar.getScheduleDETAIL());
		if(requestCalendar.getScheduleDATE() != null) calendar.setScheduleDATE(requestCalendar.getScheduleDATE());
		if(requestCalendar.getScheduleLOCATION() != null) calendar.setScheduleLOCATION(requestCalendar.getScheduleLOCATION());
		if(requestCalendar.getStartTIME() != null) calendar.setStartTIME(requestCalendar.getStartTIME());
		if(requestCalendar.getFinishTIME() != null) calendar.setFinishTIME(requestCalendar.getFinishTIME());
		
		
		return "ok"; //-> commit
	}
	
	
	
	
}
