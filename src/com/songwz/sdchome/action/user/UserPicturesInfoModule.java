package com.songwz.sdchome.action.user;

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
import org.nutz.mvc.annotation.Param;
import org.nutz.service.EntityService;

import com.songwz.sdchome.SDC;
import com.songwz.sdchome.beans.UserPicturesInfo;

@At("/"+SDC.APPNAME+"/UserPicturesInfo")
@IocBean(fields={"dao"})
public class UserPicturesInfoModule extends EntityService<UserPicturesInfo>{

    private static final Log log = Logs.get();
	
	@At
	public Object list(@Param("page") int page ,@Param("rows") int rows){
		if (rows < 1)
			rows = 10;
		Pager pager = dao().createPager(page, rows);
		List<UserPicturesInfo> list = dao().query(UserPicturesInfo.class, null, pager);
		Map<String, Object> map = new HashMap<String, Object>();
		if (pager != null) {
			pager.setRecordCount(dao().count(UserPicturesInfo.class));
			map.put("pager", pager);
		}
		map.put("list", list);
		return map;
	}
	
	@At
	public boolean add(@Param("..") UserPicturesInfo obj){
		try{
			dao().insert(obj);
			return true;
		}catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!",e);
			return false;
		}
	}
	
	@At
	public boolean delete(@Param("..") UserPicturesInfo obj){
		try{
			dao().delete(obj);
			return true;
		}catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!",e);
			return false;
		}
	}
	
	@At
	public boolean update(@Param("..") UserPicturesInfo obj){
		try{
			dao().update(obj);
			return true;
		}catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!",e);
			return false;
		}
	}
	
	@At
	public String img(@Param("uid")String userid){
		String contextPath = Mvcs.getServletContext().getContextPath() ;
		UserPicturesInfo picInfo = dao().fetch(UserPicturesInfo.class, Cnd.wrap("UID='"+userid+"' AND GID='DEFAULT' AND TYPE='A' "));
		if(picInfo==null){
			return contextPath + "/ace/assets/avatars/profile-pic.jpg" ;
		}else{
			return contextPath + "/attached/"+userid+"/headers/"+picInfo.getPicname() ;
		}
	}
	
}