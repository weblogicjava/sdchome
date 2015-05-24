package com.songwz.sdchome.beans;

import org.nutz.dao.entity.annotation.*;

import lombok.Data;

/**
* 
*/
@Data
@Table("user_pictures_group")
@PK({"gid" ,"uid" })
public class UserPicturesGroup {

	/**
	 * 
	 */
	@Column("gid")
	private String gid;
	/**
	 * 
	 */
	@Column("uid")
	private String uid;
	/**
	 * 文件路径
	 */
	@Column("groupName")
	private String groupName;
	/**
	 * 文件描述
	 */
	@Column("groupDesc")
	private String groupDesc;
	/**
	 * 
	 */
	@Column("createTime")
	private java.util.Date createTime;
}