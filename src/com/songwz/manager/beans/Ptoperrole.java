package com.songwz.manager.beans;

import org.nutz.dao.entity.annotation.*;

import lombok.Data;

/**
* 
*/
@Data
@Table("ptoperrole")
@PK({
"roleid" ,
"operid" 
})
public class Ptoperrole {

	/**
	 * 
	 */
	@Column("roleid")
	private String roleid;
	/**
	 * 
	 */
	@Column("operid")
	private String operid;
}