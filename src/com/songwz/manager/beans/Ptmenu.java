package com.songwz.manager.beans;

import org.nutz.dao.entity.annotation.*;

import lombok.Data;

/**
* 
*/
@Data
@Table("ptmenu")
public class Ptmenu {

	/**
	 * 
	 */
	@Name
	@Column("menuid")
	private String menuid;
	/**
	 * 
	 */
	@Column("parentmenuid")
	private String parentmenuid;
	/**
	 * 
	 */
	@Column("menulevel")
	private Integer menulevel;
	/**
	 * 
	 */
	@Column("isleaf")
	private Integer isleaf;
	/**
	 * 
	 */
	@Column("menudesc")
	private String menudesc;
	/**
	 * 
	 */
	@Column("menulabel")
	private String menulabel;
	/**
	 * 
	 */
	@Column("menuicon")
	private String menuicon;
	/**
	 * 
	 */
	@Column("openicon")
	private String openicon;
	/**
	 * 
	 */
	@Column("targetmachine")
	private String targetmachine;
	/**
	 * 
	 */
	@Column("menusrc")
	private String menusrc;
	/**
	 * 
	 */
	@Column("openwindow")
	private String openwindow;
	/**
	 * 
	 */
	@Column("windowwidth")
	private Integer windowwidth;
	/**
	 * 
	 */
	@Column("windowheight")
	private Integer windowheight;
	/**
	 * 
	 */
	@Column("levelidx")
	private Integer levelidx;
	/**
	 * 
	 */
	@Column("isexpand")
	private String isexpand;
	/**
	 * 
	 */
	@Column("menuclick")
	private String menuclick;
	/**
	 * 
	 */
	@Column("fillstr50")
	private String fillstr50;
	/**
	 * 
	 */
	@Column("fillstr100")
	private String fillstr100;
	/**
	 * 
	 */
	@Column("fillint1")
	private Integer fillint1;
	/**
	 * 
	 */
	@Column("filldbl2")
	private Integer filldbl2;
	public String getMenuid() {
		return menuid;
	}
	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}
	public String getParentmenuid() {
		return parentmenuid;
	}
	public void setParentmenuid(String parentmenuid) {
		this.parentmenuid = parentmenuid;
	}
	public Integer getMenulevel() {
		return menulevel;
	}
	public void setMenulevel(Integer menulevel) {
		this.menulevel = menulevel;
	}
	public Integer getIsleaf() {
		return isleaf;
	}
	public void setIsleaf(Integer isleaf) {
		this.isleaf = isleaf;
	}
	public String getMenudesc() {
		return menudesc;
	}
	public void setMenudesc(String menudesc) {
		this.menudesc = menudesc;
	}
	public String getMenulabel() {
		return menulabel;
	}
	public void setMenulabel(String menulabel) {
		this.menulabel = menulabel;
	}
	public String getMenuicon() {
		return menuicon;
	}
	public void setMenuicon(String menuicon) {
		this.menuicon = menuicon;
	}
	public String getOpenicon() {
		return openicon;
	}
	public void setOpenicon(String openicon) {
		this.openicon = openicon;
	}
	public String getTargetmachine() {
		return targetmachine;
	}
	public void setTargetmachine(String targetmachine) {
		this.targetmachine = targetmachine;
	}
	public String getMenusrc() {
		return menusrc;
	}
	public void setMenusrc(String menusrc) {
		this.menusrc = menusrc;
	}
	public String getOpenwindow() {
		return openwindow;
	}
	public void setOpenwindow(String openwindow) {
		this.openwindow = openwindow;
	}
	public Integer getWindowwidth() {
		return windowwidth;
	}
	public void setWindowwidth(Integer windowwidth) {
		this.windowwidth = windowwidth;
	}
	public Integer getWindowheight() {
		return windowheight;
	}
	public void setWindowheight(Integer windowheight) {
		this.windowheight = windowheight;
	}
	public Integer getLevelidx() {
		return levelidx;
	}
	public void setLevelidx(Integer levelidx) {
		this.levelidx = levelidx;
	}
	public String getIsexpand() {
		return isexpand;
	}
	public void setIsexpand(String isexpand) {
		this.isexpand = isexpand;
	}
	public String getMenuclick() {
		return menuclick;
	}
	public void setMenuclick(String menuclick) {
		this.menuclick = menuclick;
	}
	public String getFillstr50() {
		return fillstr50;
	}
	public void setFillstr50(String fillstr50) {
		this.fillstr50 = fillstr50;
	}
	public String getFillstr100() {
		return fillstr100;
	}
	public void setFillstr100(String fillstr100) {
		this.fillstr100 = fillstr100;
	}
	public Integer getFillint1() {
		return fillint1;
	}
	public void setFillint1(Integer fillint1) {
		this.fillint1 = fillint1;
	}
	public Integer getFilldbl2() {
		return filldbl2;
	}
	public void setFilldbl2(Integer filldbl2) {
		this.filldbl2 = filldbl2;
	}
	
	
}