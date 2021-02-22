package com.dmswl.callendar.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User2 {

	private int userIDK; //oracleDB : 시퀀스    mysql : auto-increment
	
	private String userID;
	
	private String userPW;
	
	private String userNAME;
	
	private RoleType userROLE;
	
//	public List<String> userIDKLIST = new ArrayList<>();
	
//	public void addList(String tmp) {
//		userIDKLIST.add(tmp);
//	}
}
