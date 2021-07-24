package com.dmswl.callendar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dmswl.callendar.model.Calendar;
import com.dmswl.callendar.DTO.CalendarDTO;
import com.dmswl.callendar.model.Calendar_has_User;
import com.dmswl.callendar.model.Friend;
import com.dmswl.callendar.model.User;
import com.dmswl.callendar.DTO.UserDTO;
import com.dmswl.callendar.repository.CalendarRepository;
import com.dmswl.callendar.repository.Calendar_has_UserRepository;
import com.dmswl.callendar.repository.FriendRepository;
import com.dmswl.callendar.repository.UserRepository;

@RestController
public class ReadController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private Calendar_has_UserRepository calendar_has_UserRepository;
	@Autowired
	private CalendarRepository calendarRepository;
	@Autowired
	private FriendRepository friendRepository;

	
	//{id}주소로 파라미터를 전달받을수 있다
	//http://localhost:8000/calendar/read/user/{유저의 아이디}
	@GetMapping("/read/user/{userid}")
	public UserDTO finduser(@PathVariable String userid) {		// 유저정보 검색
		System.out.println("이거실행");
		try {
			System.out.println("here!");
			int user_idk = userRepository.findByUserID(userid).getUserIDK();
			User user = userRepository.findById(user_idk).orElseThrow(new Supplier<IllegalStateException>() {

				
				@Override
				public IllegalStateException get() {
					// TODO Auto-generated method stub
					return new IllegalStateException("해당 유저는 없습니다. id : " + userid);
				}
				
			}); 
			UserDTO userDTO = new UserDTO(user.getUserIDK(),user.getUserID(),user.getUserPW(),user.getUserNAME()
					,user.getUserROLE());
			return userDTO;
		} catch (Exception e) {
			return new UserDTO();
		}
	}
	
	@GetMapping("/read/userfriend/{userid}")
	public List<UserDTO> finduserfriend(@PathVariable String userid) {		// 유저가 가진 친구목록
		int user_idk = userRepository.findByUserID(userid).getUserIDK();
		User user = userRepository.findById(user_idk).orElseThrow(new Supplier<IllegalStateException>() {

			
			@Override
			public IllegalStateException get() {
				// TODO Auto-generated method stub
				return new IllegalStateException("해당 유저는 없습니다. id : " + userid);
			}
			
		});	

		List<Friend> user_idk_List = friendRepository.findByUserME(user);
		List<UserDTO> userDTOList = new ArrayList<>();
		for(Friend friend : user_idk_List) {
			UserDTO userDTO = new UserDTO(friend.getUserFRIEND().getUserIDK(),friend.getUserFRIEND().getUserID(),
					friend.getUserFRIEND().getUserPW(),friend.getUserFRIEND().getUserNAME(),
					friend.getUserFRIEND().getUserROLE());
			userDTOList.add(userDTO);
		}
		return userDTOList;
		
	}
	
	@GetMapping("/read/frienduser/{userid}")
	public List<UserDTO> findfrienduser(@PathVariable String userid) {		// 유저를 팔로우하는 친구
		int user_idk = userRepository.findByUserID(userid).getUserIDK();
		User user = userRepository.findById(user_idk).orElseThrow(new Supplier<IllegalStateException>() {

			
			@Override
			public IllegalStateException get() {
				// TODO Auto-generated method stub
				return new IllegalStateException("해당 유저는 없습니다. id : " + userid);
			}
			
		});	

		List<Friend> user_idk_List = friendRepository.findByUserFRIEND(user);
		List<UserDTO> userDTOList = new ArrayList<>();
		for(Friend friend : user_idk_List) {
			UserDTO userDTO = new UserDTO(friend.getUserME().getUserIDK(),friend.getUserME().getUserID(),
					friend.getUserME().getUserPW(),friend.getUserME().getUserNAME(),
					friend.getUserME().getUserROLE());
			userDTOList.add(userDTO);
		}
		return userDTOList;
		
	}
	
	
	
	@GetMapping("/read/calendar/{calendarid}")
	public CalendarDTO findcalendar(@PathVariable int calendarid) {		// 일정검색
		try {
			Calendar calendar = calendarRepository.getOne(calendarid);
			CalendarDTO calendarDTO = new CalendarDTO(calendar.getCalendarNUM(),calendar.getScheduleTYPE(),calendar.getScheduleDETAIL(),calendar.getScheduleDATE(),calendar.getStartTIME(),calendar.getFinishTIME(),calendar.getScheduleLOCATION(),calendar.getHostNUM());
			return calendarDTO;  //성공했을때
		} catch (Exception e) {
			CalendarDTO calendarDTO = new CalendarDTO();
			return calendarDTO;   // 일정이 없으면 빈 캘린더 객체 리턴
			//calendarNUM이 0이면 해당 일정 없는것으로 간주하면됨
		}
		
	}
	
	
	
	@GetMapping("/read/usercalendar/{userid}") 
	public List<CalendarDTO> findcalendar(@PathVariable String userid) {		// 유저가 가지고있는 일정
		User user = userRepository.findByUserID(userid);
		List<Calendar_has_User> calendarList = calendar_has_UserRepository.findByUser(user);
		List<Calendar> calendarUserList = new ArrayList<>();
		for(int i=0; i<calendarList.size(); i++) {
			calendarUserList.add(calendarList.get(i).getCalendar());
		}
		List<CalendarDTO> cal = new ArrayList<>();;
		for(Calendar c : calendarUserList) {
			CalendarDTO calendarDTO = new CalendarDTO(c.getCalendarNUM(),c.getScheduleTYPE(),c.getScheduleDETAIL(),c.getScheduleDATE(),c.getStartTIME(),c.getFinishTIME(),c.getScheduleLOCATION(),c.getHostNUM());
			cal.add(calendarDTO);
		}
		
		return cal;
		
	}
	@GetMapping("/read/usercalendardate/{userid}/{date}") 
	public List<CalendarDTO> findusercalendardate(@PathVariable String userid, @PathVariable String date) {		// 유저가 가지고있는 일정중 날짜
		User user = userRepository.findByUserID(userid);
		List<Calendar_has_User> calendarList = calendar_has_UserRepository.findByUser(user);
		List<Calendar> calendarUserList = new ArrayList<>();
		for(int i=0; i<calendarList.size(); i++) {
			calendarUserList.add(calendarList.get(i).getCalendar());
		}
		List<CalendarDTO> cal = new ArrayList<>();;
		for(Calendar c : calendarUserList) {
			System.out.println(c.getScheduleDATE());
			if(c.getScheduleDATE().equals(date)) {
				CalendarDTO calendarDTO = new CalendarDTO(c.getCalendarNUM(),c.getScheduleTYPE(),c.getScheduleDETAIL(),c.getScheduleDATE(),c.getStartTIME(),c.getFinishTIME(),c.getScheduleLOCATION(),c.getHostNUM());
				cal.add(calendarDTO);
			}
		}
		
		return cal;
		
	}
	
	@GetMapping("/read/calendaruser/{calendarnum}")  // calendar객체 받아야됨
	public List<UserDTO> finduser(@PathVariable int calendarnum) {		//일정이 가지고있는 유저
		Calendar calendar = calendarRepository.getOne(calendarnum);
		System.out.println("1111111111111");
		List<Calendar_has_User> userList = calendar_has_UserRepository.findByCalendar(calendar);
		List<User> userCalendarList = new ArrayList<>();
		for(int i=0; i<userList.size(); i++) {
			userCalendarList.add(userList.get(i).getUser());
		}
		List<UserDTO> us = new ArrayList<>();;
		for(User u : userCalendarList) {
			UserDTO userDTO = new UserDTO(u.getUserIDK(),u.getUserID(),u.getUserPW(),u.getUserNAME(),u.getUserROLE());
			us.add(userDTO);
		}
		
		return us;
		
	}
	
}
