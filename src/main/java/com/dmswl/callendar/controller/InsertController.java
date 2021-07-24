package com.dmswl.callendar.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dmswl.callendar.model.Calendar;
import com.dmswl.callendar.model.CalendarWithFriend;
import com.dmswl.callendar.model.Calendar_has_User;
import com.dmswl.callendar.model.Friend;
import com.dmswl.callendar.constant.RoleType;
import com.dmswl.callendar.model.User;
import com.dmswl.callendar.repository.CalendarRepository;
import com.dmswl.callendar.repository.Calendar_has_UserRepository;
import com.dmswl.callendar.repository.FriendRepository;
import com.dmswl.callendar.repository.UserRepository;

@RestController
public class InsertController {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private Calendar_has_UserRepository calendar_has_UserRepository;
	@Autowired
	private CalendarRepository calendarRepository;
	@Autowired
	private FriendRepository friendRepository;
	
	ReadController r = new ReadController();
	
	@PostMapping("/insert/user") //회원가입
	public String join(@RequestBody User user) {
		
		System.out.println("userID : " + user.getUserID());
		System.out.println("userPW : " + user.getUserPW());
		System.out.println("userNAME : " + user.getUserNAME());
		user.setUserROLE(RoleType.ADMIN);
		System.out.println("userROLE : " + user.getUserROLE());
		
		try {
			userRepository.save(user);
			return "ok";
		} catch (Exception e) {
			return "fail";
		}
	}
	
	@PostMapping("/insert/calendar")//일정추가
	public String join(@RequestBody CalendarWithFriend calendarWithFriend) {
		

				
		try {
			System.out.println("scheduleTYPE : " + calendarWithFriend.getScheduleTYPE());
			System.out.println("scheduleDETAIL : " + calendarWithFriend.getScheduleDETAIL());
			System.out.println("scheduleDATE : " + calendarWithFriend.getScheduleDATE());
			System.out.println("startTIME : " + calendarWithFriend.getStartTIME());
			System.out.println("finishTIME : " + calendarWithFriend.getFinishTIME());
			System.out.println("scheduleLOCATION : " + calendarWithFriend.getScheduleLOCATION());
			System.out.println("friendLIST : " + calendarWithFriend.getFriendLIST().toString());
			System.out.println("hostNUM : "+ calendarWithFriend.getHostNUM() );
			
			Calendar calendar = new Calendar();
			System.out.println(calendar.getCalendarNUM());
			calendar.setScheduleTYPE(calendarWithFriend.getScheduleTYPE());
			calendar.setScheduleDETAIL(calendarWithFriend.getScheduleDETAIL());
			calendar.setScheduleDATE(calendarWithFriend.getScheduleDATE());
			calendar.setStartTIME(calendarWithFriend.getStartTIME());
			calendar.setFinishTIME(calendarWithFriend.getFinishTIME());
			calendar.setScheduleLOCATION( calendarWithFriend.getScheduleLOCATION());
			calendar.setHostNUM(calendarWithFriend.getHostNUM());
			calendarRepository.save(calendar);
			

			for(String userid : calendarWithFriend.getFriendLIST()) {
				Calendar_has_User calendarhasuser = new Calendar_has_User();
				calendarhasuser.setUser(userRepository.findByUserID(userid));
				calendarhasuser.setCalendar(calendar);
				calendar_has_UserRepository.save(calendarhasuser);
			}


			return "ok";
		} catch (Exception e) {
			return "fail";
		}
	}
	
	
	@PostMapping("/insert/friend/{userMEuserID}/{userYOUuserID}")//친구추가
	public String join(@PathVariable String userMEuserID, @PathVariable String userYOUuserID ) {
		
		
		try {
			User userME = userRepository.findByUserID(userMEuserID);
			User userYOU = userRepository.findByUserID(userYOUuserID);
//			friend.(userME);
			Friend friend = new Friend();
			friend.setUserME(userME);
			friend.setUserFRIEND(userYOU);
			friendRepository.save(friend);
			return "ok";
		} catch (Exception e) {
			return "fail";
		}
	}
}
