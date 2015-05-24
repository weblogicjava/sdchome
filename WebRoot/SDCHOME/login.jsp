<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>LOGIN-SDCHOME</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="用户登陆页面">
		<script type="text/javascript" src="${AppBase}/CONTENTS/jquery-1.6.2.js"></script>
		<script type="text/javascript" src="${AppBase}/CONTENTS/json.js"></script>
		<script type="text/javascript" src="${AppBase}/SDCHOME/js/login.js"></script>
		<script type="text/javascript">
		$(function() {
			$("#loginForm").submit(function() {
				$.ajax({
					url : "${AppAction}/Security/login",
					data : $("#loginForm").serialize(),
					success : function(res) {
						res = JSON.parse(res);
						if (res.errorCode == "SUCCESS") {
							if(res.nextMove!=null){
								window.location = res.nextMove ;
							}else{
								window.location = "${AppBase}/SDCHOME/userlist.jsp";
							}
						} else {
							$("#loginRet").html(res.errorMsg);
						}
					},
					fail : function(res) {
						alert("系统错误?!");
					}
				});
				return false;
			});
		});
		</script>
	</head>
	
	<body>
		用户登录&nbsp;<span id="loginRet" style="color:blue">${loginmsg }</span><hr/>
		<form id='loginForm' name='loginForm' action="" method='POST'>
			<input type="hidden" id="targetURL" name="targetURL" value="${targetURL }"/>
			用户名：<input type="text" name="username" id="username"/>
			密码：<input type="text" name="password" id="password"/>
			<input type="submit" value="登陆">
		</form>
		
	</body>
</html>
