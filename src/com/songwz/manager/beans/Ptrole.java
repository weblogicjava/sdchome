package com.songwz.manager.beans;

import org.nutz.dao.entity.annotation.*;

import lombok.Data;

/**
* 
*/
@Data
@Table("ptrole")
public class Ptrole {

	/**
	 * 
	 */
	@Name
	@Column("roleid")
	private String roleid;
	/**
	 * 
	 */
	@Column("roledesc")
	private String roledesc;
	/**
	 * 
	 */
	@Column("status")
	private String status;
	/**
	 * 
	 */
	@Column("parroleid")
	private String parroleid;
	/**
	 * 
	 */
	@Column("isleaf")
	private String isleaf;
}