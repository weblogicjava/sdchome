package com.songwz.sdchome.action.security;

import javax.servlet.http.HttpSession;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.Mvcs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;

import com.songwz.probase.resp.SwapArea;
import com.songwz.sdchome.SDC;
import com.songwz.sdchome.beans.UserInfo;

@IocBean
@At("/"+SDC.APPNAME+"/Security")
public class SecurityModule {

    private static final Log log = Logs.get() ;

    @Inject
    private Dao dao ;
    
    @At
    public SwapArea login(@Param("..")UserInfo userInfo,@Param("targetURL")String targetUrl) {
    	UserInfo tmpUser = dao.fetch(UserInfo.class,Cnd.wrap(" username='"+userInfo.getUsername()+"' ")) ;
		if(tmpUser==null){
			return SwapArea.createSwapArea().setFailCode().setErrorMsg("用户信息未找到") ;
		}
		String logpwd = com.songwz.probase.lang.MD5.encode(userInfo.getPassword()) ; 
		if(!logpwd.equals(tmpUser.getPassword())){
			return SwapArea.createSwapArea().setFailCode().setErrorMsg("密码不正确") ;
		}
		
		tmpUser.setPassword("");
		
		Mvcs.getHttpSession().setAttribute(SDC.SESSION_USER, tmpUser);
		
		SwapArea swapArea = SwapArea.createSwapArea().setSuccessCode() ;
		if(targetUrl!=null && !"".equals(targetUrl)){
			swapArea.setNextMove(targetUrl) ;
		}
		
    	return swapArea ;
	}
    
    @At
    public Object me(HttpSession session){
        return session.getAttribute("user");
    }

    @At
    public Object ping(){
        log.debug("date:"+new java.util.Date()) ;
        return new java.util.Date();
    }

}
