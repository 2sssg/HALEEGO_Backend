package com.dmswl.callendar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dmswl.callendar.model.Friend;
import com.dmswl.callendar.model.User;

public interface FriendRepository extends JpaRepository<Friend, Integer>{

	Friend findByUserMEAndUserFRIEND(User userme, User userfriend);
	
	List<Friend> findByUserME(User userme);

	List<Friend> findByUserFRIEND(User userfriend);
	
}
