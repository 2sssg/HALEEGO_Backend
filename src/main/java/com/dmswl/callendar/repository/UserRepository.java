package com.dmswl.callendar.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dmswl.callendar.model.Friend;
import com.dmswl.callendar.model.User;

//DAO
//자동으로 bean등록이된다.
//@Repository 생략가능하다.
public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByUserID(String user_ID);
}


