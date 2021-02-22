package com.dmswl.callendar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dmswl.callendar.model.Friend;
import com.dmswl.callendar.model.User;

public interface FriendRepository extends JpaRepository<Friend, Integer>{

//	Friend findByuser_IDAndrecipient(String user_ID, String reci);
	
//	Friend findByRecipientAndUser(int reci, User id);
	
	Friend findByUserMEAndUserFRIEND(User userme, User userfriend);
	
	List<Friend> findByUserME(User userme);
	
	int countByUserME(User userme);
	
	List<Friend> findByUserFRIEND(User userfriend);
	
}
