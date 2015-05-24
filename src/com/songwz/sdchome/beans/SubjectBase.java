package com.songwz.sdchome.beans;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

/**
* 
*/
@ToString
@EqualsAndHashCode
@Table("subject_base")
public class SubjectBase {

	/**
	 * 
	 */
	@Column("subjectid")
	@Name
	private String subjectid;
	/**
	 * 
	 */
	@Column("authorid")
	private String authorid;
	/**
	 * 
	 */
	@Column("title")
	private String title;
	/**
	 * 
	 */
	@Column("content")
	private String content;
	/**
	 * 
	 */
	@Column("keywords")
	private String keywords;
	/**
	 * 完成时间
	 */
	@Column("writeDate")
	private java.util.Date writeDate;
	/**
	 * 
	 */
	@Column("lastMDate")
	private java.util.Date lastMdate;
	/**
	 * 文章类型
	 */
	@Column("type")
	private String type;
	/**
	 * 文件级别；0普通；1精华；2推荐；
	 */
	@Column("level")
	private String level;
	/**
	 * 
	 */
	@Column("state")
	private String state;
	/**
	 * 点击数
	 */
	@Column("clickcount")
	private Integer clickcount;
	/**
	 * 推荐数
	 */
	@Column("recommcount")
	private Integer recommcount;
	/**
	 * 喜欢数
	 */
	@Column("lovecount")
	private Integer lovecount;

	public String getSubjectid() {
		return subjectid;
	}

	public void setSubjectid(String subjectid) {
		this.subjectid = subjectid;
	}

	public String getAuthorid() {
		return authorid;
	}

	public void setAuthorid(String authorid) {
		this.authorid = authorid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public java.util.Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(java.util.Date writeDate) {
		this.writeDate = writeDate;
	}

	public java.util.Date getLastMdate() {
		return lastMdate;
	}

	public void setLastMdate(java.util.Date lastMdate) {
		this.lastMdate = lastMdate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getClickcount() {
		return clickcount;
	}

	public void setClickcount(Integer clickcount) {
		this.clickcount = clickcount;
	}

	public Integer getRecommcount() {
		return recommcount;
	}

	public void setRecommcount(Integer recommcount) {
		this.recommcount = recommcount;
	}

	public Integer getLovecount() {
		return lovecount;
	}

	public void setLovecount(Integer lovecount) {
		this.lovecount = lovecount;
	}

}