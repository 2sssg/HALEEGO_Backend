package com.dmswl.callendar.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dmswl.callendar.model.Friend;
import com.dmswl.callendar.model.User;
import com.dmswl.callendar.repository.CalendarRepository;
import com.dmswl.callendar.repository.Calendar_has_UserRepository;
import com.dmswl.callendar.repository.FriendRepository;
import com.dmswl.callendar.repository.UserRepository;

@RestController
public class DeleteController {

	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private Calendar_has_UserRepository calendar_has_UserRepository;
	@Autowired
	private CalendarRepository calendarRepository;
	@Autowired
	private FriendRepository friendRepository;

	
	
	
	@DeleteMapping("/delete/user/{userid}")
	public String delete(@PathVariable String userid) {
		try {
			userRepository.deleteById(userRepository.findByUserID(userid).getUserIDK()); 
		} catch (Exception e) {
			return "fail";
		}
		
		return "ok";
	}

	
	
	@DeleteMapping("/delete/friend/{userME}/{userFRIEND}")
	public String deletefriend(@PathVariable String userME, @PathVariable String userFRIEND) {
		User userme = userRepository.findByUserID(userME);
		User userfriend = userRepository.findByUserID(userFRIEND);
		
		try {
			friendRepository.deleteById(friendRepository.findByUserMEAndUserFRIEND(userme, userfriend).getId());
		} catch (Exception e) {
			return "fail";
		}
		
		return "ok";
	}

	@DeleteMapping("/delete/calendar/{calendarnum}")
	public String deletecalendar(@PathVariable int calendarnum) {
		try {
			calendarRepository.deleteById(calendarnum);
		} catch (Exception e) {
			return "fail";
		}
		
		return "ok";
	}

}

