package com.songwz.manager.beans;

import org.nutz.dao.entity.annotation.*;

import lombok.Data;

/**
* 
*/
@Data
@Table("ptdept")
public class Ptdept {

	/**
	 * 
	 */
	@Name
	@Column("deptid")
	private String deptid;
	/**
	 * 
	 */
	@Column("deptname")
	private String deptname;
	/**
	 * 
	 */
	@Column("deptdesc")
	private String deptdesc;
	/**
	 * 
	 */
	@Column("parentdeptid")
	private String parentdeptid;
	/**
	 * 
	 */
	@Column("deptleaf")
	private String deptleaf;
	/**
	 * 
	 */
	@Column("deptlevel")
	private Integer deptlevel;
	/**
	 * 
	 */
	@Column("depttype")
	private String depttype;
	/**
	 * 
	 */
	@Column("dqdm")
	private String dqdm;
	/**
	 * 
	 */
	@Column("mkdm")
	private String mkdm;
	/**
	 * 
	 */
	@Column("deptindex")
	private Integer deptindex;
	/**
	 * 
	 */
	@Column("deptphone")
	private String deptphone;
	/**
	 * 
	 */
	@Column("deptguid")
	private String deptguid;
	/**
	 * 
	 */
	@Column("operid")
	private String operid;
	/**
	 * 
	 */
	@Column("opertime")
	private java.util.Date opertime;
}