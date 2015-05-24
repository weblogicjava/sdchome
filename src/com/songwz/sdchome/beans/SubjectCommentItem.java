package com.songwz.sdchome.beans;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class SubjectCommentItem {

	public SubjectCommentItem() {
		super();
	}

	private String subjectid;

	private String commentid;

	private String authorid;
	
	private String authorname;
	
	private String authorpic;

	private String content;

	private java.util.Date writeDate;
	
	private String isCurrentUser = "0" ;
	
	private String isViewerIsAuthor = "0" ;
	
	public String getIsViewerIsAuthor() {
		return isViewerIsAuthor;
	}

	public void setIsViewerIsAuthor(String isViewerIsAuthor) {
		this.isViewerIsAuthor = isViewerIsAuthor;
	}

	public String getIsCurrentUser() {
		return isCurrentUser;
	}

	public void setIsCurrentUser(String isCurrentUser) {
		this.isCurrentUser = isCurrentUser;
	}

	public String getSubjectid() {
		return subjectid;
	}

	public void setSubjectid(String subjectid) {
		this.subjectid = subjectid;
	}

	public String getCommentid() {
		return commentid;
	}

	public void setCommentid(String commentid) {
		this.commentid = commentid;
	}

	public String getAuthorid() {
		return authorid;
	}

	public void setAuthorid(String authorid) {
		this.authorid = authorid;
	}

	public String getAuthorname() {
		return authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}

	public String getAuthorpic() {
		return authorpic;
	}

	public void setAuthorpic(String authorpic) {
		this.authorpic = authorpic;
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

	public void setCommentVO(SubjectComments comment) {
		this.subjectid = comment.getSubjectid() ;
		this.commentid = comment.getCommentid() ; 
		this.authorid = comment.getAuthorid() ; 
		this.content = comment.getContent() ;
		this.writeDate = comment.getWriteDate() ;
	}

}
