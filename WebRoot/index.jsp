<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.getRequestDispatcher("/SDCHOME/index.jsp").forward(request, response);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>SDCHOME</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
    This is my JSP page. <br>
    <div style="margin-top:30px;line-height:24px">
    	<a href="${AppBase}/SDCHOME/register.jsp">用户注册页面</a>
    	<a href="${AppBase}/SDCHOME/login.jsp">用户登陆页面</a>
    	<a href="${AppBase}/SDCHOME/userlist.jsp">用户列表页面</a>
    	<br/>
    	<a href="${AppBase}/SDCHOME/bbs/SubjectAdd.jsp">添加日志记录</a>
    	<a href="${AppBase}/SDCHOME/bbs/SubjectList.jsp">日志信息列表</a>
    	<hr>
    	<a href="${AppBase}/ADMIN/login.jsp">管理员登陆页面</a>
    </div>
  </body>
</html>
