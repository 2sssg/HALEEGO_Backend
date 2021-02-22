package com.dmswl.callendar.model;





import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity	
public class User {
	@Id //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB넘버링 전략을 따라간다.
	private int userIDK; //oracleDB : 시퀀스    mysql : auto-increment
	
	
	@Column(nullable=false, length=30, unique = true)
//	@ManyToMany
	private String userID;
	
	@Column(nullable=false, length=100)
	private String userPW;
	
	@Column(nullable = true, length = 30)
	private String userNAME;
	
	@Enumerated(EnumType.STRING)
	private RoleType userROLE;
	
    @OneToMany(mappedBy = "userME", cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    private List<Friend> friends = new ArrayList<>();
    
    @OneToMany(mappedBy = "userFRIEND", cascade = CascadeType.REMOVE)
    private List<Friend> friendss = new ArrayList<>();

    @OneToMany(mappedBy = "calendar", cascade = CascadeType.REMOVE)
    private List<Calendar_has_User> Calendar_has_User = new ArrayList<>();
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Calendar_has_User> Calendar_has_Userr = new ArrayList<>();
}
