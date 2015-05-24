package com.songwz.probase.service;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.songwz.manager.Manager;
import com.songwz.sdchome.SDC;

public class WorkListener  implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("##########################初始化应用信息################################");
		String contextPathString = event.getServletContext().getContextPath() ;
		event.getServletContext().setAttribute("AppAction", contextPathString+"/"+SDC.APPNAME);
		event.getServletContext().setAttribute("AppBase", contextPathString);
		event.getServletContext().setAttribute("AdminAction", contextPathString+"/"+Manager.APPNAME);
		event.getServletContext().setAttribute("AdminBase", contextPathString);
		
		System.out.println("##########################初始化资源信息################################");
		//PropertiesRes.load(); 
		
	}

}
