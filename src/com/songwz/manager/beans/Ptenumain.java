package com.songwz.manager.beans;

import org.nutz.dao.entity.annotation.*;

import lombok.Data;

/**
* 
*/
@Data
@Table("ptenumain")
public class Ptenumain {

	/**
	 * 
	 */
	@Column("parentid")
	private String parentid;
	/**
	 * 
	 */
	@Name
	@Column("enumtype")
	private String enumtype;
	/**
	 * 
	 */
	@Column("enumlable")
	private String enumlable;
	/**
	 * 
	 */
	@Column("enumisleaf")
	private String enumisleaf;
	/**
	 * 
	 */
	@Column("isload")
	private String isload;
}