package com.songwz.manager.beans;

import org.nutz.dao.entity.annotation.*;

import lombok.Data;

/**
* 
*/
@Data
@Table("ptenudetail")
public class Ptenudetail {

	/**
	 * 
	 */
	@Column("enumtype")
	private String enumtype;
	/**
	 * 
	 */
	@Column("itemvalue")
	private String itemvalue;
	/**
	 * 
	 */
	@Column("itemlable")
	private String itemlable;
	/**
	 * 
	 */
	@Column("dispno")
	private Integer dispno;
	/**
	 * 
	 */
	@Column("itemexpand")
	private String itemexpand;
	/**
	 * 
	 */
	@Column("itemspell")
	private String itemspell;
	/**
	 * 
	 */
	@Column("itemdesc")
	private String itemdesc;
}