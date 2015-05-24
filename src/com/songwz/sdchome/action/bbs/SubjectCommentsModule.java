package com.songwz.sdchome.action.bbs;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nutz.dao.Cnd;
import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.Mvcs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.filter.CheckSession;
import org.nutz.service.EntityService;

import com.songwz.probase.lang.BusinessDate;
import com.songwz.sdchome.SDC;
import com.songwz.sdchome.beans.SubjectBase;
import com.songwz.sdchome.beans.SubjectCommentItem;
import com.songwz.sdchome.beans.SubjectComments;
import com.songwz.sdchome.beans.UserInfo;
import com.songwz.sdchome.beans.UserPicturesInfo;

@At("/"+SDC.APPNAME+"/SubjectComments")
@IocBean(fields={"dao"})
public class SubjectCommentsModule extends EntityService<SubjectComments>{

    private static final Log log = Logs.get();
	
	@At
	public Object list(@Param("page") int page ,@Param("rows") int rows , @Param("subjectid") String subjectid){
		if (rows < 1)
			rows = 10;
		Pager pager = dao().createPager(page, rows);
		List<SubjectComments> list = dao().query(SubjectComments.class, Cnd.where("subjectid", "=", subjectid).desc("writeDate"), pager);
		Map<String, Object> map = new HashMap<String, Object>();
		if (pager != null) {
			pager.setRecordCount(dao().count(SubjectComments.class,Cnd.where("subjectid", "=", subjectid)));
			map.put("pager", pager);
		}
		
		SubjectBase subjectBase = dao().fetch(SubjectBase.class, Cnd.where("subjectid", "=", subjectid));
		String subjectAuthorID = "" ;
		if(subjectBase!=null){
			subjectAuthorID = subjectBase.getAuthorid() ;
		}else{
			SubjectComments itemComments = dao().fetch(SubjectComments.class, Cnd.where("commentid", "=", subjectid));
			if(itemComments!=null){
				subjectAuthorID = itemComments.getAuthorid() ;
			}
		}
		
		String contextPath = Mvcs.getServletContext().getContextPath() ;
		List<SubjectCommentItem> items = new ArrayList<SubjectCommentItem>() ; 
		for(SubjectComments comment : list){
			SubjectCommentItem item = new SubjectCommentItem() ;
			item.setCommentVO(comment);
			
			UserPicturesInfo picInfo = dao().fetch(UserPicturesInfo.class, Cnd.wrap("UID='"+comment.getAuthorid()+"' AND GID='DEFAULT' AND TYPE='A' "));
			if(picInfo==null){
				item.setAuthorpic(contextPath + "/ace/assets/avatars/profile-pic.jpg");
			}else{
				item.setAuthorpic(contextPath + "/attached/"+comment.getAuthorid()+"/headers/"+picInfo.getPicname());
			}
			
			UserInfo userInfo = dao().fetch(UserInfo.class, Cnd.wrap("UID='"+comment.getAuthorid()+"'")) ;
			if (userInfo != null) {
				item.setAuthorname(userInfo.getUsername());
			}
			
			UserInfo sessionUserInfo = (UserInfo) Mvcs.getHttpSession().getAttribute(SDC.SESSION_USER) ;
			if (sessionUserInfo != null) {
				if (sessionUserInfo.getUid().equals(comment.getAuthorid())) {
					item.setIsCurrentUser("1");
				}
				if (sessionUserInfo.getUid().equals(subjectAuthorID)) {
					item.setIsViewerIsAuthor("1");
				}
			}
			
			items.add(item);
		}
		
		map.put("list", items);
		return map;
	}
	
	@At
	@Filters(@By(type=CheckSession.class, args={SDC.SESSION_USER, "/SDCHOME/login.jsp"}))
	public boolean add(@Param("..") SubjectComments comment) {
		try {
			UserInfo userInfo = (UserInfo) Mvcs.getHttpSession().getAttribute(SDC.SESSION_USER);
			
			comment.setCommentid(BusinessDate.getSerialNumFromDate());
			comment.setAuthorid(userInfo.getUid());
			comment.setWriteDate(new Date());
			comment.setReadState("0");
			dao().insert(comment);

			return true;
		} catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return false;
		}
	}
	
	@At
	public boolean delete(@Param("..") SubjectComments obj) {
		try {
			List<SubjectComments> list = dao().query(SubjectComments.class, Cnd.where("subjectid", "=", obj.getCommentid())) ;
			if(list!=null && list.size()>0){
				dao().clear(SubjectComments.class, Cnd.where("subjectid", "=", obj.getCommentid())) ;
			}
			dao().delete(obj);
			return true;
		} catch (Throwable e) {
			if (log.isDebugEnabled()) {
				log.debug("E!!", e);
			}
			return false;
		}
	}
	
	@At
	public boolean update(@Param("..") SubjectComments obj) {
		try {
			obj.setWriteDate(new Date());
			dao().updateIgnoreNull(obj);
			return true;
		} catch (Throwable e) {
			if (log.isDebugEnabled()) {
				log.debug("E!!", e);
			}
			return false;
		}
	}
	
}