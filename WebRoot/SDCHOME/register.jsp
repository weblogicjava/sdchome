<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>用户信息注册-SDCHOME</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="用户登陆页面">
		<script type="text/javascript" src="${AppBase}/CONTENTS/jquery-1.6.2.js"></script>
		<script type="text/javascript" src="${AppBase}/CONTENTS/json.js"></script>
		<script type="text/javascript">
	        $(function () {
	            $("#registerForm").submit(function () {
	                $.ajax({
	                    url : "${AppAction}/UserInfo/add", 
	                    data : $("#registerForm").serialize(),
	                    success : function (res) {
	                    	res = JSON.parse(res);
	                    	if(res.errorCode=="SUCCESS"){
	                    		window.location = "${AppBase}/SDCHOME/login.jsp" ;
	                    	}else{
	                    		$("#registRet").html(res.errorMsg);
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
		用户注册&nbsp;<span id="registRet" style="color:blue">&nbsp;</span><hr/>
		<form id='registerForm' name='registerForm' action="" method='POST'>
			用户名：<input type="text" name="username" id="username"/>
			密码：<input type="password" name="password" id="password"/>
			邮箱：<input type="text" name="email" id="email"/>
			备注：<input type="text" name="memo" id="memo"/>
			<input type="submit" value="注册">
		</form>
	</body>
</html>
