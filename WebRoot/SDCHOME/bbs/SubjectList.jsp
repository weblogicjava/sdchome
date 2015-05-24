<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/SDCHOME/logincheck.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<title>用户信息列表</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="">
		
		<link rel="stylesheet" type="text/css" href="${AppBase}/SDCHOME/style/app_base.css"/>
		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="${AppBase}/ace/assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${AppBase}/ace/assets/css/font-awesome.min.css" />
		<!-- ace styles -->
		<link rel="stylesheet" href="${AppBase}/ace/assets/css/ace.min.css" />
		
		<script type="text/javascript" src="${AppBase}/ace/assets/js/jquery.min.js"></script>
		<script type="text/javascript" src="${AppBase}/CONTENTS/json.js"></script>
		<script type="text/javascript">
			var _SDCACTION_ = "${AppAction}" ;
			var _SDCBASE_ = "${AppBase}" ; 
		</script>
	</head>
	<body>
		<%@ include file="/SDCHOME/common/header.jsp" %>
		<div class='clear'></div>
		<!--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-->
		
		<div class="mainContent" style='align:Center'>
			<div class="page-content">
				用户信息列表&nbsp;&nbsp;<span id="subjectListInfo" style="color:blue">&nbsp;</span><hr/>
				<div id="tablePanel">&nbsp;</div>
				<div id="SubjectsListPanel">
					<div class="hr hr-12 dotted"></div>
					<div class="feed">
						<div class="feedAuthorTime">songweizhong &nbsp;&nbsp; 2014-12-12 23:!2:23</div>
						<div class="feedTitle">
							<h4 class="red smaller lighter">
								<i class="ace-icon fa fa-star orange"></i>
								关于达尔文进化论问题的一点儿想法，仅供娱乐~~
							</h4>
						</div>
						<div>
							<div class="feedRemarks">
								<span class="label label-sm label-success arrowed">阅读数[10000]</span>
								<span class="label label-sm label-success arrowed">推荐数[1000]</span>
								<span class="label label-sm label-success arrowed">不推荐[100]</span>
								<span class="label label-sm label-success arrowed">喜欢数[10]</span>
								|
								<span class="label label-sm label-primary arrowed arrowed-right">标签1</span>
								<span class="label label-sm label-primary arrowed arrowed-right">标签2</span>
								<span class="label label-sm label-primary arrowed arrowed-right">标签3</span>
								<span class="label label-sm label-primary arrowed arrowed-right">标签4</span>
								<span class="label label-sm label-primary arrowed arrowed-right">标签5</span>
								<span class="label label-sm label-primary arrowed arrowed-right">标签6</span>
								<span class="label label-sm label-primary arrowed arrowed-right">标签7</span>
								<span class="label label-sm label-primary arrowed arrowed-right">标签8</span>
							</div>
						</div>
					</div>
					<div class="clear"></div>
					<hr/>
					
					<div class="feed">
						<div class="feedAuthorTime">songweizhong &nbsp;&nbsp; 2014-12-12 23:!2:23</div>
						<div class="feedTitle">
							<h4 class="black smaller lighter">
								<i class="ace-icon fa fa-star orange"></i>
								关于达尔文进化论问题的一点儿想法，仅供娱乐~~
							</h4>
						</div>
						<div>
							<div class="feedRemarks">
								<span class="label label-sm label-success arrowed">阅读数</span>
								<span class="label label-sm label-success arrowed">推荐数</span>
								<span class="label label-sm label-success arrowed">不推荐</span>
								<span class="label label-sm label-success arrowed">喜欢数</span>
								|
								<span class="label label-sm label-primary arrowed arrowed-right">标签1</span>
								<span class="label label-sm label-primary arrowed arrowed-right">标签2</span>
								<span class="label label-sm label-primary arrowed arrowed-right">标签3</span>
								<span class="label label-sm label-primary arrowed arrowed-right">标签4</span>
								<span class="label label-sm label-primary arrowed arrowed-right">标签5</span>
								<span class="label label-sm label-primary arrowed arrowed-right">标签6</span>
								<span class="label label-sm label-primary arrowed arrowed-right">标签7</span>
								<span class="label label-sm label-primary arrowed arrowed-right">标签8</span>
								<span class="label label-sm label-primary arrowed arrowed-right">标签8</span>
							</div>
						</div>
					</div>
					<div class="clear"></div>
					<hr/>
					
				</div>
			</div>
		</div>
		<link rel="stylesheet" href="${AppBase}/SDCHOME/bbs/css/SubjectList.css" />
		<script type="text/javascript" src="${AppBase}/SDCHOME/bbs/js/SubjectList.js"></script>		
		<!--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-->
		<div class='clear'></div>
		<%@ include file="/SDCHOME/common/footer.jsp" %>
	</body>
</html>
