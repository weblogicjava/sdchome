<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/SDCHOME/logincheck.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>用户信息编辑</title>
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
		
		<script type="text/javascript" src="${AppBase}/ace/assets/js/jquery.min.js"></script>
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
					<form id='UserInfoForm' class="form-horizontal">
						<div class="tabbable">
							<ul class="nav nav-tabs padding-16">
								<li class="active">
									<a data-toggle="tab" href="#edit-basic">
										<i class="green ace-icon fa fa-pencil-square-o bigger-125"></i>
										个人信息
									</a>
								</li>

								<li>
									<a data-toggle="tab" href="#edit-settings">
										<i class="purple ace-icon fa fa-cog bigger-125"></i>
										保密设置
									</a>
								</li>

								<li>
									<a data-toggle="tab" href="#edit-password">
										<i class="blue ace-icon fa fa-key bigger-125"></i>
										重置密码
									</a>
								</li>
							</ul>

							<div class="tab-content profile-edit-tab-content">
								<div id="edit-basic" class="tab-pane in active">
									<h4 class="header blue bolder smaller">基本信息</h4>

									<div class="row">
										<div class="col-xs-12" style='text-align:center'>
											<span class="profile-picture" style="margin-left:auto;margin-right:auto">
												<img class="editable img-responsive" alt="Alex's Avatar" id="avatar2" src="${AppBase}/ace/assets/avatars/profile-pic.jpg" />
											</span>
										</div>
									</div>
									
									<hr />
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-date">用户名</label>
										<div class="col-sm-8">
											<input class="col-xs-12 col-sm-10" type="text" id="form-field-username" placeholder="用户名" value="" />
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-date">出生日期</label>

										<div class="col-sm-9">
											<div class="input-medium">
												<div class="input-group">
													<input class="input-medium date-picker" id="form-field-date" type="text" data-date-format="yyyy-mm-dd" placeholder="yyyy-mm-dd" />
													<span class="input-group-addon">
														<i class="ace-icon fa fa-calendar"></i>
													</span>
												</div>
											</div>
										</div>
									</div>

									<div class="space-4"></div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right">性别</label>

										<div class="col-sm-9">
											<label class="inline">
												<input name="form-field-radio" type="radio" class="ace" />
												<span class="lbl middle"> 男</span>
											</label>

											&nbsp; &nbsp; &nbsp;
											<label class="inline">
												<input name="form-field-radio" type="radio" class="ace" />
												<span class="lbl middle"> 女</span>
											</label>
										</div>
									</div>

									<div class="space-4"></div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-comment">我的签名</label>

										<div class="col-sm-9">
											<textarea id="form-field-comment" style="width:60%"></textarea>
										</div>
									</div>

									<div class="space"></div>
									<h4 class="header blue bolder smaller">联系方式</h4>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-email">电子信箱</label>

										<div class="col-sm-9">
											<span class="input-icon input-icon-right">
												<input type="email" id="form-field-email" value="" />
												<i class="ace-icon fa fa-envelope"></i>
											</span>
										</div>
									</div>

									<div class="space-4"></div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-website">个人网页</label>

										<div class="col-sm-9">
											<span class="input-icon input-icon-right">
												<input type="url" id="form-field-website" value="" />
												<i class="ace-icon fa fa-globe"></i>
											</span>
										</div>
									</div>

									<div class="space-4"></div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-phone">联系电话</label>

										<div class="col-sm-9">
											<span class="input-icon input-icon-right">
												<input class="input-medium input-mask-phone" type="text" id="form-field-phone" />
												<i class="ace-icon fa fa-phone fa-flip-horizontal"></i>
											</span>
										</div>
									</div>

									<div class="space"></div>
									<h4 class="header blue bolder smaller">社交信息</h4>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-facebook">Facebook</label>

										<div class="col-sm-9">
											<span class="input-icon">
												<input type="text" value="facebook_alexdoe" id="form-field-facebook" />
												<i class="ace-icon fa fa-facebook blue"></i>
											</span>
										</div>
									</div>

									<div class="space-4"></div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-twitter">Twitter</label>

										<div class="col-sm-9">
											<span class="input-icon">
												<input type="text" value="twitter_alexdoe" id="form-field-twitter" />
												<i class="ace-icon fa fa-twitter light-blue"></i>
											</span>
										</div>
									</div>

									<div class="space-4"></div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-gplus">Google+</label>

										<div class="col-sm-9">
											<span class="input-icon">
												<input type="text" value="google_alexdoe" id="form-field-gplus" />
												<i class="ace-icon fa fa-google-plus red"></i>
											</span>
										</div>
									</div>
								</div>

								<div id="edit-settings" class="tab-pane">
									<div class="space-10"></div>

									<div>
										<label class="inline">
											<input type="checkbox" name="form-field-checkbox" class="ace" />
											<span class="lbl"> 公开我的注册信息</span>
										</label>
									</div>

									<div class="space-8"></div>

									<div>
										<label class="inline">
											<input type="checkbox" name="form-field-checkbox" class="ace" />
											<span class="lbl"> 更新时短信通知我</span>
										</label>
									</div>

									<div class="space-8"></div>

									<div>
										<label class="inline">
											<input type="checkbox" name="form-field-checkbox" class="ace" />
											<span class="lbl"> 保存我的访问历史</span>
										</label>

										<label class="inline">
											<span class="space-2 block"></span>
											<input type="text" class="input-mini" maxlength="3" />
											天内
										</label>
									</div>
								</div>

								<div id="edit-password" class="tab-pane">
									<div class="space-10"></div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-pass1">新密码</label>

										<div class="col-sm-9">
											<input type="password" id="form-field-pass1" />
										</div>
									</div>

									<div class="space-4"></div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-pass2">确认密码</label>

										<div class="col-sm-9">
											<input type="password" id="form-field-pass2" />
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="clearfix form-actions">
							<div class="col-md-offset-3 col-md-9">
								<button class="btn btn-info" type="button">
									<i class="ace-icon fa fa-check bigger-110"></i>
									保存提交
								</button>

								&nbsp; &nbsp;
								<button class="btn" type="reset">
									<i class="ace-icon fa fa-undo bigger-110"></i>
									重置
								</button>
							</div>
						</div>
					</form>
				</div><!-- /.row -->
			</div><!-- /#home -->
			<div class='clear'></div>
		</div>
		<script src="${AppBase}/ace/assets/js/ace-extra.min.js"></script>
		<!-- basic scripts -->
		<script src="${AppBase}/ace/assets/js/bootstrap.min.js"></script>
		<script src="${AppBase}/ace/assets/js/bootstrap-tag.min.js"></script>
		<!-- ace scripts -->
		<script src="${AppBase}/ace/assets/js/ace-elements.min.js"></script>
		<script src="${AppBase}/ace/assets/js/ace/ace.js"></script>
		<script type="text/javascript">
		var form = $("#UserInfoForm");
				
		//another option is using modals
		$('#avatar2').on('click', function(){
			var modal = 
			'<div class="modal fade">\
			  <div class="modal-dialog">\
			   <div class="modal-content">\
				<div class="modal-header">\
					<button type="button" class="close" data-dismiss="modal">&times;</button>\
					<h4 class="blue">更换头像</h4>\
				</div>\
				\
				<form class="no-margin" action="${AppAction}/UserInfo/upload" id="fileTrans_form" method="POST" enctype="multipart/form-data">\
				 <div class="modal-body">\
				 	<input type="hidden" name="targetReturn" id="targetReturn" value="${AppBase}/SDCHOME/user/UserInfoEdit.jsp"/>\
					<div class="space-4"></div>\
					<div style="width:75%;margin-left:12%;"><input type="file" id="file-input" name="file-input" /></div>\
				 </div>\
				\
				 <div class="modal-footer center">\
					<button type="submit" class="btn btn-sm btn-success"><i class="ace-icon fa fa-check"></i> 保存提交</button>\
					<button type="button" class="btn btn-sm" data-dismiss="modal"><i class="ace-icon fa fa-times"></i> 取消</button>\
				 </div>\
				</form>\
			  </div>\
			 </div>\
			</div>';
			
			
			var modal = $(modal);
			modal.modal("show").on("hidden", function(){
				modal.remove();
			});
	
			var working = false;
			
			var form = modal.find('form:eq(0)');
			var file = form.find('input[type=file]').eq(0);
			file.ace_file_input({
				style:'well',
				btn_choose:'点击此处选择新头像图片',
				btn_change:null,
				no_icon:'ace-icon fa fa-picture-o',
				thumbnail:'small',
				before_remove: function() {
					//don't remove/reset files while being uploaded
					return !working;
				},
				allowExt: ['jpg', 'jpeg', 'png', 'gif'],
				allowMime: ['image/jpg', 'image/jpeg', 'image/png', 'image/gif']
			});
	
			form.on('submit', function(){
				//$("#fileTrans_form").submit();
			});
					
		});
		</script>
		<!--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-->
		<div class='clear'></div>
		<%@ include file="/SDCHOME/common/footer.jsp" %>
	</body>
</html>
