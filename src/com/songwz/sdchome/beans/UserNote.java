package com.songwz.sdchome.beans;

import org.nutz.dao.entity.annotation.*;

import lombok.Data;

/**
* 
*/
@Data
@Table("user_note")
@PK({"noteid" ,"uid" })
public class UserNote {

	/**
	 * 
	 */
	@Column("noteid")
	private String noteid;
	/**
	 * 
	 */
	@Column("uid")
	private String uid;
	/**
	 * 
	 */
	@Column("content")
	private String content;
	/**
	 * 
	 */
	@Column("writeDate")
	private java.util.Date writeDate;
}