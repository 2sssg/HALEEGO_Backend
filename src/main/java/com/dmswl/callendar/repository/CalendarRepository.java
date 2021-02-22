package com.dmswl.callendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dmswl.callendar.model.Calendar;

public interface CalendarRepository extends JpaRepository<Calendar, Integer>{
	
}
