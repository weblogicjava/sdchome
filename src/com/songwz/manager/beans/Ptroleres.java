package com.songwz.manager.beans;

import org.nutz.dao.entity.annotation.*;

import lombok.Data;

/**
* 
*/
@Data
@Table("ptroleres")
@PK({
"roleid" ,
"resid" 
})
public class Ptroleres {

	/**
	 * 
	 */
	@Column("roleid")
	private String roleid;
	/**
	 * 
	 */
	@Column("resid")
	private String resid;
}