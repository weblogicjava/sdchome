package com.songwz.sdchome.beans;

import org.nutz.dao.entity.annotation.*;

import lombok.Data;

/**
* 
*/
@Data
@Table("user_friends_info")
@PK({"uid" ,"fid" })
public class UserFriendsInfo {

	/**
	 * 
	 */
	@Column("uid")
	private String uid;
	/**
	 * 
	 */
	@Column("fid")
	private String fid;
	/**
	 * 状态；1：正常；0：待确认
	 */
	@Column("state")
	private String state;
	/**
	 * 
	 */
	@Column("fdate")
	private java.util.Date fdate;
}