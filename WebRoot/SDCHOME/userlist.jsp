<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/SDCHOME/logincheck.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>用户信息列表</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="">
		<script type="text/javascript" src="${AppBase}/CONTENTS/jquery-1.6.2.js"></script>
		<script type="text/javascript" src="${AppBase}/CONTENTS/json.js"></script>
	</head>
	<body>
		用户信息列表&nbsp;&nbsp;<span id="userlistInfo" style="color:blue">&nbsp;</span><hr/>
		<div id="tablePanel">&nbsp;</div>
	</body>
<script type="text/javascript">

	function createTable(tableObj) {
		var listInfo = tableObj.list;
		var pagerInfo = tableObj.pager;

		var tableHtml = "<table>";
		for (var i = 0; i < listInfo.length; i++) {
			var infoTmp = listInfo[i] ;
			tableHtml += "<tr>";
			tableHtml += "<td>"+infoTmp.uid+"</td>" ;
			tableHtml += "<td>"+infoTmp.username+"</td>" ;
			tableHtml += "<td>"+infoTmp.password+"</td>" ;
			tableHtml += "<td>"+infoTmp.email+"</td>" ;
			tableHtml += "<td>"+infoTmp.score+"</td>" ;
			tableHtml += "<td>"+infoTmp.level+"</td>" ;
			tableHtml += "<td>"+infoTmp.isvip+"</td>" ;
			tableHtml += "<td>"+infoTmp.state+"</td>" ;
			tableHtml += "<td>"+infoTmp.registdate+"</td>" ;
			tableHtml += "<td>"+infoTmp.memo+"</td>" ;
			tableHtml += "</tr>";
		}
		tableHtml += "<tr>";
		var pageStr = "<a href='javascript:void(0);return;' onclick='getTable(1)'>首页</a>" ;
		pageStr += "<a href='javascript:void(0);return;' onclick='getTable("+((pagerInfo.pageNumber-1)>0?(pagerInfo.pageNumber-1):1)+")'>上一页</a> " ;
		pageStr += "<a href='javascript:void(0);return;' onclick='getTable("+((pagerInfo.pageNumber+1)>pagerInfo.pageCount?pagerInfo.pageNumber:(pagerInfo.pageNumber+1))+")'>下一页</a> " ;
		pageStr += "<a href='javascript:void(0);return;' onclick='getTable("+pagerInfo.pageCount+")'>尾页</a> " ;
		tableHtml += "<td colspan='10'>共"+pagerInfo.recordCount+"条数据&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;第"+pagerInfo.pageNumber+"页/共"+pagerInfo.pageCount+"页&nbsp;&nbsp;&nbsp;&nbsp;"+pageStr+"</td>" ;
		tableHtml += "</tr>";

		tableHtml += "</table>";
		$("#tablePanel").html(tableHtml);
	}

	function getTable(pageNum) {
		$.ajax({
			type : "POST",
			url : "${AppAction}/UserInfo/list",
			data : {
				page : pageNum,
				rows : 10
			},
			success : function(res) {
				$("#userlistInfo").html(res);
				createTable(JSON.parse(res));
			},
			fail : function(res) {
				alert("系统错误?!");
			}
		});
	}
	$(function() {
		getTable(1);
	});
</script>
</html>
