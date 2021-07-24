package com.dmswl.callendar.DTO;

import com.dmswl.callendar.constant.RoleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

	private int userIDK; //oracleDB : 시퀀스    mysql : auto-increment
	
	private String userID;
	
	private String userPW;
	
	private String userNAME;
	
	private RoleType userROLE;
	
}
