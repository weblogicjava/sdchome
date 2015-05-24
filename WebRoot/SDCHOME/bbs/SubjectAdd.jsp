<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/SDCHOME/logincheck.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>添加日志信息</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		<link rel="stylesheet" type="text/css" href="${AppBase}/SDCHOME/style/app_base.css"/>
		
		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="${AppBase}/ace/assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${AppBase}/ace/assets/css/font-awesome.min.css" />
		<!-- ace styles -->
		<link rel="stylesheet" href="${AppBase}/ace/assets/css/ace-fonts.css" />
		<link rel="stylesheet" href="${AppBase}/ace/assets/css/ace.min.css" />
		<link rel="stylesheet" href="${AppBase}/ace/assets/css/ace-skins.min.css" />
		<link rel="stylesheet" href="${AppBase}/ace/assets/css/ace-rtl.min.css" />
		
		<script type="text/javascript" src="${AppBase}/ace/assets/js/jquery.min.js"></script>
		<script type="text/javascript" src="${AppBase}/CONTENTS/json.js"></script>
		
		<!-- KINDEDITOR -->
		<link rel="stylesheet" href="${AppBase}/plugins/kindeditor/themes/default/default.css" />
		<link rel="stylesheet" href="${AppBase}/plugins/kindeditor/plugins/code/prettify.css" />
		<script charset="utf-8" src="${AppBase}/plugins/kindeditor/kindeditor-all.js"></script>
		<script charset="utf-8" src="${AppBase}/plugins/kindeditor/lang/zh_CN.js"></script>
		<script charset="utf-8" src="${AppBase}/plugins/kindeditor/plugins/code/prettify.js"></script>

		<script type="text/javascript">
			var editor ;
			$(function() {
				
				KindEditor.ready(function(K) {
					editor = K.create('textarea[name="content"]', {
						cssPath : '${AppBase}/plugins/kindeditor/plugins/code/prettify.css',
						uploadJson : '${AppBase}/plugins/kindeditor/jsp/upload_json.jsp',
						fileManagerJson : '${AppBase}/plugins/kindeditor/jsp/file_manager_json.jsp',
						allowFileManager : true
					});
				});
				
			});
			
			function submitSubject(){
				$("#content").val(editor.html());
				$.ajax({
					url : "${AppAction}/SubjectBase/add",
					data : $("#PublishForm").serialize(),
					type:"POST",
					success : function(res) {
						res = JSON.parse(res);
						if (res.errorCode == "SUCCESS") {
							window.top.location = "${AppBase}/SDCHOME/bbs/SubjectList.jsp";
						} else {
							//$("#subjectRet").html(res.errorMsg);
						}
					},
					fail : function(res) {
						alert("系统错误?!");
					}
				});
								
			}
		</script>
	</head>
	
	<body>
		<%@ include file="/SDCHOME/common/header.jsp" %>
		<div class='clear'></div>
		<!--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-->

	<div class="mainContent" style='align:Center'>
		<div class="row">
			<div class="page-header" style="border-bottom: #E5E5E5 1px solid;">
				<h1>
					日志信息记录Form
					<small>
						<i class="ace-icon fa fa-angle-double-right"></i>
						添加日志信息
					</small>
				</h1>
			</div>
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<form class="form-horizontal" role="form" id='PublishForm'
					name='PublishForm' action="" method='POST'>
					<div class="form-group">
						<input type="text" id="title" name='title' placeholder="添加文章标题" class="col-xs-10 col-sm-8" />
					</div>
					<div class="form-group">
						<textarea name="content" id="content" style="width:100%;min-height:600px;visibility:hidden;"></textarea>
					</div>
					<div class="form-group">
						<input type="text" name="keywords" id="keywords" style="width:100%;" value="" placeholder="输入关键字方便查找......" />
					</div>
					<button id="submitBtn" class="btn btn-info" type="button">
						<i class="ace-icon fa fa-check bigger-110"></i>
						保存提交
					</button>
					&nbsp; &nbsp; &nbsp;
					<button class="btn" type="reset">
						<i class="ace-icon fa fa-undo bigger-110"></i>
						重新填写
					</button>
				</form>
			</div>
		</div>
		<div class='clear'></div>
				
		<script src="${AppBase}/ace/assets/js/ace-extra.min.js"></script>
		<!-- basic scripts -->
		<script src="${AppBase}/ace/assets/js/bootstrap.min.js"></script>
		<script src="${AppBase}/ace/assets/js/bootstrap-tag.min.js"></script>
		<script src="${AppBase}/ace/assets/js/bootstrap-wysiwyg.min.js"></script>
		<!-- ace scripts -->
		<script src="${AppBase}/ace/assets/js/ace-elements.min.js"></script>
		<script src="${AppBase}/ace/assets/js/ace/ace.js"></script>
		<script src="${AppBase}/ace/assets/js/bootbox.min.js"></script>
		<!-- inline scripts related to this page -->
		<script type="text/javascript">
			jQuery(function($) {
				var tag_input = $('#keywords');
				try{
					tag_input.tag({
						placeholder:tag_input.attr('placeholder')
					});
				} catch(e) {
					tag_input.after('<textarea id="'+tag_input.attr('id')+'" name="'+tag_input.attr('name')+'" rows="3">'+tag_input.val()+'</textarea>').remove();
				}
								
				$("#submitBtn").on(ace.click_event, function() {
					bootbox.dialog({
						message: "<span class='bigger-110'>是否确认保存到服务器</span>",
						buttons: {
							"success" :
							 {
								"label" : "<i class='ace-icon fa fa-check'></i> 提交保存",
								"className" : "btn-sm btn-success",
								"callback": function() {
									submitSubject();
								}
							},
							"button" :
							{
								"label" : "取消保存",
								"className" : "btn-sm"
							}
						}
					});
				});
				
			});
		</script>
	</div>
	<!--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-->
		<div class='clear'></div>
		<%@ include file="/SDCHOME/common/footer.jsp" %>
	</body>
</html>
