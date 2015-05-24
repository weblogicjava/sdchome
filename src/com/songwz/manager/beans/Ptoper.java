package com.songwz.manager.beans;

import org.nutz.dao.entity.annotation.*;

import lombok.Data;

/**
* 
*/
@Data
@Table("ptoper")
public class Ptoper {

	/**
	 * 
	 */
	@Column("deptid")
	private String deptid;
	/**
	 * 
	 */
	@Column("opertype")
	private String opertype;
	/**
	 * 
	 */
	@Name
	@Column("operno")
	private String operno;
	/**
	 * 
	 */
	@Column("opername")
	private String opername;
	/**
	 * 
	 */
	@Column("operorder")
	private Integer operorder;
	/**
	 * 
	 */
	@Column("operpasswd")
	private String operpasswd;
	/**
	 * 
	 */
	@Column("issuper")
	private String issuper;
	/**
	 * 
	 */
	@Column("sex")
	private String sex;
	/**
	 * 
	 */
	@Column("email")
	private String email;
	/**
	 * 
	 */
	@Column("mobilephone")
	private String mobilephone;
	/**
	 * 
	 */
	@Column("operphone")
	private String operphone;
	/**
	 * 
	 */
	@Column("otherphone")
	private String otherphone;
	/**
	 * 
	 */
	@Column("operenabled")
	private String operenabled;
	/**
	 * 
	 */
	@Column("welcomidx")
	private String welcomidx;
}