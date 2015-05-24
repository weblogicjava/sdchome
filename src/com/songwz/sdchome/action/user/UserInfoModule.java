package com.songwz.sdchome.action.user;

import java.io.File;
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
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.filter.CheckSession;
import org.nutz.mvc.upload.UploadAdaptor;
import org.nutz.service.EntityService;

import com.songwz.probase.lang.BusinessDate;
import com.songwz.probase.lang.LocalMessage;
import com.songwz.probase.lang.MD5;
import com.songwz.probase.resp.SwapArea;
import com.songwz.sdchome.SDC;
import com.songwz.sdchome.beans.UserInfo;
import com.songwz.sdchome.beans.UserPicturesInfo;

@At("/" + SDC.APPNAME + "/UserInfo")
@IocBean(fields = { "dao" })
public class UserInfoModule extends EntityService<UserInfo> {

	private static final Log log = Logs.get();

	@At
	@Filters(@By(type=CheckSession.class, args={SDC.SESSION_USER, "/SDCHOME/login.jsp"}))
	public Object list(@Param("page") int page, @Param("rows") int rows) {
		if (rows < 1)
			rows = 10;
		Pager pager = dao().createPager(page, rows);
		List<UserInfo> list = dao().query(UserInfo.class, null, pager);
		Map<String, Object> map = new HashMap<String, Object>();
		if (pager != null) {
			pager.setRecordCount(dao().count(UserInfo.class));
			map.put("pager", pager);
		}
		map.put("list", list);
		return map;
	}

	@At
	public SwapArea add(@Param("..") UserInfo user) {
		try {
			
			UserInfo tmpUserInfo = dao().fetch(UserInfo.class, Cnd.where("username","=",user.getUsername())) ;
			if(tmpUserInfo!=null){
				return SwapArea.createSwapArea().setFailCode().setErrorMsg("用户名已存在") ;
			}
			tmpUserInfo = dao().fetch(UserInfo.class, Cnd.where("email","=",user.getEmail())) ;
			if(tmpUserInfo!=null){
				return SwapArea.createSwapArea().setFailCode().setErrorMsg("邮箱信息已存在") ;
			}
			
			String uid = BusinessDate.getSerialNumFromDate(); 
			user.setPassword(MD5.encode(user.getPassword()));
			user.setUid(uid);
			user.setIsvip("0");
			user.setLevel("1");
			user.setRegistdate(new Date());
			user.setScore(100);
			user.setState("0");
			dao().insert(user);
			return SwapArea.createSwapArea().setSuccessCode();
		} catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return SwapArea.createSwapArea().setFailCode().setErrorMsg(e.getMessage()) ;
		}
	}

	@At
	public boolean delete(@Param("..") UserInfo obj) {
		try {
			dao().delete(obj);
			return true;
		} catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return false;
		}
	}

	@At
	public boolean update(@Param("..") UserInfo obj) {
		try {
			dao().update(obj);
			return true;
		} catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return false;
		}
	}
	
    @At
    @Filters(@By(type=CheckSession.class, args={SDC.SESSION_USER, "/SDCHOME/login.jsp"}))
	@AdaptBy(type = UploadAdaptor.class, args = { "ioc:myPicUpload" })
	public void upload(@Param("file-input") File file,@Param("targetReturn")String targetReturn) {
		try {
			String localPath = LocalMessage.getAppPath()+"" ;
			if(!localPath.endsWith(java.io.File.separator)){
				localPath += java.io.File.separator ;
			}
			
			UserInfo userinfo = (UserInfo)Mvcs.getHttpSession().getAttribute(SDC.SESSION_USER);
			localPath += "attached" + File.separator +userinfo.getUid() + File.separator + "headers" + File.separator ;
			
			if (!new File(localPath).exists()) {
				new File(localPath).mkdirs();
			}

			localPath += file.getName();
			File destFile = new File(localPath);
			file.renameTo(destFile);
			
			UserPicturesInfo picInfo = dao().fetch(UserPicturesInfo.class, Cnd.wrap("UID='"+userinfo.getUid()+"' AND GID='DEFAULT' AND TYPE='A' "));
			if (picInfo == null) {
				UserPicturesInfo headerPicInfo = new UserPicturesInfo();
				headerPicInfo.setGid("DEFAULT");
				headerPicInfo.setPid(BusinessDate.getSerialNumFromDate());
				headerPicInfo.setPicname(file.getName());
				headerPicInfo.setUptime(new Date());
				headerPicInfo.setPicdesc("HEADER_PIC");
				headerPicInfo.setType("A");
				headerPicInfo.setUid(userinfo.getUid());
				
				dao().insert(headerPicInfo);
			} else {
				picInfo.setPicname(file.getName());
				picInfo.setUptime(new Date());
				
				dao().update(picInfo);
			}
			
			Mvcs.getResp().sendRedirect(targetReturn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
	@At
	@Filters(@By(type=CheckSession.class, args={SDC.SESSION_USER, "/SDCHOME/login.jsp"}))
	@Ok("jsp:/SDCHOME/user/UserInfoEdit.jsp")
	public void get2edit(@Param("userid") String userid) {
		try {
			UserInfo userInfo = dao().fetch(UserInfo.class, userid);
			Mvcs.getReq().setAttribute("userInfo", userInfo);
		} catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
		}
	}
    
}