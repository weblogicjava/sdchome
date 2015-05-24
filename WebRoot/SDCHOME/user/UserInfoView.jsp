<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>用户信息查看</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="">
		
		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="${AppBase}/ace/assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${AppBase}/ace/assets/css/font-awesome.min.css" />
		<!-- ace styles -->
		<link rel="stylesheet" href="${AppBase}/ace/assets/css/ace.min.css" />
		
		<link rel="stylesheet" type="text/css" href="${AppBase}/SDCHOME/style/app_base.css"/>
		
		<script type="text/javascript" src="${AppBase}/CONTENTS/jquery-1.6.2.js"></script>
		<script type="text/javascript" src="${AppBase}/CONTENTS/json.js"></script>
		<script type="text/javascript">
	        $(function () {
	        	
	        });
		</script>
		<style type="text/css">
		</style>
	</head>
	
	<body>
		<%@ include file="/SDCHOME/common/header.jsp" %>
		<div class='clear'></div>
		<!--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-->
		
		<div class="mainContent" style='align:Center'>

			<div class="page-header">
				<h1>
					基本信息查看
					<small>
						<i class="ace-icon fa fa-angle-double-right"></i>
						关于用户基本情况的说明
					</small>
				</h1>
			</div><!-- /.page-header -->
			<div class="hr hr-12 dotted"></div>
			<div id="home" class="tab-pane in active">
				<div class="row">
					<div class="col-xs-12 col-sm-3 center">
						<span class="profile-picture">
							<img class="editable img-responsive" alt="Alex's Avatar" id="avatar2" src="${AppBase}/ace/assets/avatars/profile-pic.jpg" />
						</span>

						<div class="space space-4"></div>

						<a href="#" class="btn btn-sm btn-block btn-success">
							<i class="ace-icon fa fa-plus-circle bigger-120"></i>
							<span class="bigger-110">加为好友</span>
						</a>

						<a href="#" class="btn btn-sm btn-block btn-primary">
							<i class="ace-icon fa fa-envelope-o bigger-110"></i>
							<span class="bigger-110">发送信息</span>
						</a>
					</div><!-- /.col -->

					<div class="col-xs-12 col-sm-9">
						<h4 class="blue">
							<span class="middle">宋卫中</span>

							<span class="label label-purple arrowed-in-right">
								<i class="ace-icon fa fa-circle smaller-80 align-middle"></i>
								在线
							</span>
						</h4>

						<div class="profile-user-info">
							<div class="profile-info-row">
								<div class="profile-info-name"> 用户名 </div>

								<div class="profile-info-value">
									<span>CA090407</span>
								</div>
							</div>

							<div class="profile-info-row">
								<div class="profile-info-name"> 地址 </div>

								<div class="profile-info-value">
									<i class="fa fa-map-marker light-orange bigger-110"></i>
									<span>Netherlands</span>
									<span>Amsterdam</span>
								</div>
							</div>

							<div class="profile-info-row">
								<div class="profile-info-name"> 年龄 </div>

								<div class="profile-info-value">
									<span>38</span>
								</div>
							</div>

							<div class="profile-info-row">
								<div class="profile-info-name"> 注册时间 </div>

								<div class="profile-info-value">
									<span>2010/06/20</span>
								</div>
							</div>

							<div class="profile-info-row">
								<div class="profile-info-name"> 最后在线 </div>

								<div class="profile-info-value">
									<span>3 hours ago</span>
								</div>
							</div>
						</div>

						<div class="hr hr-8 dotted"></div>

						<div class="profile-user-info">
							<div class="profile-info-row">
								<div class="profile-info-name"> 联系方式 </div>

								<div class="profile-info-value">
									<a href="#" target="_blank">www.alexdoe.com</a>
								</div>
							</div>
							
							<div class="profile-info-row">
								<div class="profile-info-name">
									<i class="middle ace-icon fa fa-facebook-square bigger-150 blue"></i>
								</div>

								<div class="profile-info-value">
									<a href="#">718258907</a>
								</div>
							</div>

							<div class="profile-info-row">
								<div class="profile-info-name">
									<i class="middle ace-icon fa fa-facebook-square bigger-150 blue"></i>
								</div>

								<div class="profile-info-value">
									<a href="#">Find me on Facebook</a>
								</div>
							</div>
							
						</div>
					</div><!-- /.col -->
										
				</div><!-- /.row -->

			</div><!-- /#home -->
			<div class='clear'></div>
		</div>
		<!--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-->
		<div class='clear'></div>
		<%@ include file="/SDCHOME/common/footer.jsp" %>
	</body>
</html>
