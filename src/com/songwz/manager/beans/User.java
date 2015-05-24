package com.songwz.manager.beans;

import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import com.songwz.manager.Manager;

@Table(value=Manager.DB_M_PRIFIX+"USER")
public class User {

	@Id
	private int id;
	private String userid ;
	private String username;
	private String password;
	private String email;
	private String memo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}
