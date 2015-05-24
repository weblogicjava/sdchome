<%@page import="com.songwz.sdchome.beans.UserInfo"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.songwz.sdchome.SDC" %>
<%
	UserInfo userinfo = (UserInfo) session.getAttribute(SDC.SESSION_USER);
	if (userinfo == null) {
		request.setAttribute("loginmsg", "用户尚未登录");
		String queryString = request.getQueryString();
		if (queryString != null) {
			queryString = "?" + queryString;
		} else {
			queryString = "";
		}
		request.setAttribute("targetURL", request.getRequestURI() + queryString);
		request.getRequestDispatcher("/SDCHOME/index.jsp").forward(request, response);
	}
%>
