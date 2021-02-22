package com.dmswl.callendar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dmswl.callendar.model.Calendar;
import com.dmswl.callendar.model.Calendar_has_User;
import com.dmswl.callendar.model.User;

public interface Calendar_has_UserRepository extends JpaRepository<Calendar_has_User, Integer>{
	List<Calendar_has_User> findByUser(User user);
	
	List<Calendar_has_User> findByCalendar(Calendar calendar);
	
	
	
}
