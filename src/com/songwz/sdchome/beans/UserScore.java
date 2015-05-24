package com.songwz.sdchome.beans;

import org.nutz.dao.entity.annotation.*;

import lombok.Data;

/**
* 
*/
@Data
@Table("user_score")
@PK({ "uid" ,"scoreid" })
public class UserScore {

	/**
	 * 
	 */
	@Column("uid")
	private String uid;
	/**
	 * 
	 */
	@Column("scoreid")
	private String scoreid;
	/**
	 * 
	 */
	@Column("type")
	private String type;
	/**
	 * 用户积分
	 */
	@Column("score")
	private Integer score;
	/**
	 * 注册时间
	 */
	@Column("giveDate")
	private java.util.Date giveDate;
}