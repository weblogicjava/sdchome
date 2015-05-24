package com.songwz.sdchome.beans;

import org.nutz.dao.entity.annotation.*;

import lombok.Data;

/**
* 
*/
@Data
@Table("subject_bcount")
public class SubjectBcount {

	/**
	 * 
	 */
	@Name
	@Column("subjectid")
	private String subjectid;
	/**
	 * 
	 */
	@Column("type")
	private String type;
	/**
	 * 
	 */
	@Column("ipaddress")
	private String ipaddress;
	/**
	 * 时间字符串，可按照不同的类型确定计算方法；yyyy-MM-dd
	 */
	@Column("timestr")
	private String timestr;
}