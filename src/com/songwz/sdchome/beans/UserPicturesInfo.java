package com.songwz.sdchome.beans;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.PK;
import org.nutz.dao.entity.annotation.Table;

/**
* 
*/
@ToString
@EqualsAndHashCode
@Table("user_pictures_info")
@PK({ "pid", "gid", "uid" })
public class UserPicturesInfo {

	/**
	 * 
	 */
	@Column("pid")
	private String pid;
	/**
	 * 
	 */
	@Column("gid")
	private String gid;
	/**
	 * 
	 */
	@Column("uid")
	private String uid;
	/**
	 * 类型：待确定
	 */
	@Column("type")
	private String type;
	/**
	 * 文件路径
	 */
	@Column("picname")
	private String picname;
	/**
	 * 文件描述
	 */
	@Column("picdesc")
	private String picdesc;
	/**
	 * 
	 */
	@Column("uptime")
	private java.util.Date uptime;

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPicname() {
		return picname;
	}

	public void setPicname(String picname) {
		this.picname = picname;
	}

	public String getPicdesc() {
		return picdesc;
	}

	public void setPicdesc(String picdesc) {
		this.picdesc = picdesc;
	}

	public java.util.Date getUptime() {
		return uptime;
	}

	public void setUptime(java.util.Date uptime) {
		this.uptime = uptime;
	}

}