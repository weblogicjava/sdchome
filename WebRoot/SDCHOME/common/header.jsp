<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.songwz.sdchome.beans.UserInfo"%>
<%@ page import="com.songwz.sdchome.SDC" %>
<%
UserInfo userBaseInfo = (UserInfo)session.getAttribute(SDC.SESSION_USER);
%>

<div id="top_cont">
	<div style="width:80%;margin-left:auto;margin-right:auto">
		
		<%
			if(userBaseInfo==null){
				%>
				<div style="text-align:left;float:left">
					亲，欢迎来SDCHOME！
					&nbsp;&nbsp;
					[<a href="front/login/login.jsp"  target="_top">登录</a>]
					&nbsp;&nbsp;
					[<a href="front/login/regist.jsp"  target="_top">快速注册</a>]
				</div>
				<div style="text-align:right;float:right">帮助&nbsp;&nbsp;|&nbsp;&nbsp;设为首页&nbsp;&nbsp;|&nbsp;&nbsp;返回首页&nbsp;&nbsp;|&nbsp;&nbsp;安全退出</div>
				<%
			}else{
				%>
				<div style="text-align:left;float:left">
					<%=userBaseInfo.getUsername() %>，欢迎来SDCHOME！
					&nbsp;&nbsp;&nbsp;&nbsp;积分[10000]
					&nbsp;&nbsp;&nbsp;&nbsp;等级[<img alt="" style="vertical-align:middle" src="${AppBase}/SDCHOME/style/imgs/level/b_blue_5.gif">]
				</div>
				<div style="text-align:right;float:right">
					&nbsp;&nbsp;我的地盘&nbsp;&nbsp;|
					&nbsp;&nbsp;消息&nbsp;&nbsp;|
					&nbsp;&nbsp;帮助&nbsp;&nbsp;|
					&nbsp;&nbsp;设为首页&nbsp;&nbsp;|
					&nbsp;&nbsp;返回首页&nbsp;&nbsp;|
					&nbsp;&nbsp;安全退出
				</div>
				<%
			}
			%>
	</div>
</div>
