package com.songwz.sdchome.beans;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

/**
* 
*/
@ToString
@EqualsAndHashCode
@Table("user_info")
public class UserInfo {

	/**
	 * 
	 */
	@Name
	@Column("uid")
	private String uid;
	/**
	 * 
	 */
	@Column("username")
	private String username;
	/**
	 * 
	 */
	@Column("password")
	private String password;
	/**
	 * 
	 */
	@Column("email")
	private String email;
	/**
	 * 
	 */
	@Column("telphone")
	private String telphone;
	/**
	 * 用户积分
	 */
	@Column("score")
	private Integer score;
	/**
	 * 
	 */
	@Column("address")
	private String address;
	/**
	 * 等级
	 */
	@Column("level")
	private String level;
	/**
	 * 是否是VIP用户；1是；0否
	 */
	@Column("isvip")
	private String isvip;
	/**
	 * 用户状态；1正常；0未激活；2禁止
	 */
	@Column("state")
	private String state;
	/**
	 * 注册时间
	 */
	@Column("registdate")
	private java.util.Date registdate;
	/**
	 * 
	 */
	@Column("memo")
	private String memo;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
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

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getIsvip() {
		return isvip;
	}

	public void setIsvip(String isvip) {
		this.isvip = isvip;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public java.util.Date getRegistdate() {
		return registdate;
	}

	public void setRegistdate(java.util.Date registdate) {
		this.registdate = registdate;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}