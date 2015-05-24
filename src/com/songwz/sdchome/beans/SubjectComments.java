package com.songwz.sdchome.beans;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.PK;
import org.nutz.dao.entity.annotation.Table;

/**
* 
*/
@ToString
@EqualsAndHashCode
@Table("subject_comments")
@PK({ "commentid" })
public class SubjectComments {

	/**
	 * 
	 */
	@Name
	@Column("commentid")
	private String commentid;
	/**
	 * 
	 */
	@Column("subjectid")
	private String subjectid;
	/**
	 * 
	 */
	@Column("authorid")
	private String authorid;
	/**
	 * 
	 */
	@Column("content")
	private String content;
	/**
	 * 
	 */
	@Column("writeDate")
	private java.util.Date writeDate;
	
	/**
	 * 作者是否已读，0未读；1已读
	 */
	@Column("readState")
	private String readState ;
	
	public String getReadState() {
		return readState;
	}

	public void setReadState(String readState) {
		this.readState = readState;
	}

	public String getCommentid() {
		return commentid;
	}

	public void setCommentid(String commentid) {
		this.commentid = commentid;
	}

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public java.util.Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(java.util.Date writeDate) {
		this.writeDate = writeDate;
	}

}