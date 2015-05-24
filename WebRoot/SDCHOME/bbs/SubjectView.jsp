<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/SDCHOME/logincheck.jsp" %>
<%
String subjectid = request.getParameter("subjectid") ;
%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<title>日志信息查看</title>
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
		<link rel="stylesheet" type="text/css" href="${AppBase}/SDCHOME/bbs/css/SubjectView.css"/>
		
		<script type="text/javascript" src="${AppBase}/CONTENTS/json.js"></script>
		<script type="text/javascript" src="${AppBase}/ace/assets/js/jquery.min.js"></script>
				
		<!-- KINDEDITOR -->
		<link rel="stylesheet" href="${AppBase}/plugins/kindeditor/themes/default/default.css" />
		<link rel="stylesheet" href="${AppBase}/plugins/kindeditor/plugins/code/prettify.css" />
		<script charset="utf-8" src="${AppBase}/plugins/kindeditor/kindeditor-all.js"></script>
		<script charset="utf-8" src="${AppBase}/plugins/kindeditor/lang/zh_CN.js"></script>
		<script charset="utf-8" src="${AppBase}/plugins/kindeditor/plugins/code/prettify.js"></script>
		<script type="text/javascript">
			var ls_subjectid = "<%=subjectid%>" ;
			var _SDCACTION_ = "${AppAction}" ;
			var _SDCBASE_ = "${AppBase}" ;
		</script>
	</head>
	
	<body>
		<%@ include file="/SDCHOME/common/header.jsp" %>
		<div class='clear'></div>
		<!--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-->
		
		<div class="mainContent">
			<div class="page-content">
				<div class="page-header">
					<h1>
						<div id="v_title">&nbsp;</div>
					</h1>
				</div><!-- /.page-header -->
				<div class="row">
					<div class="col-xs-12">
						<div id="v_content">&nbsp;</div>
						<div class="hr hr-12 dotted"></div>
						
						<div class="page-header">
							<h5>
								评论信息：
							</h5>
						</div>
						<div id="tablePanel">暂无评论信息</div>
						
						<form id='CommentForm' name='CommentForm' action="" method='POST'>
							<input type='hidden' name='subjectid' id='subjectid' value='<%=subjectid%>'/>
							<textarea name="content" id="content" style="width:100%;height:200px;visibility:hidden;"></textarea>
							<br>
							<button class="btn btn-xs btn-info">
								<i class="ace-icon fa fa-floppy-o bigger-110"></i>
								我要点评
								<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
							</button>
						</form>
					</div>
				</div>
				
				<div id="modal-form" class="modal" tabindex="-1">
					<div class="modal-dialog" style="width: 980px;">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="blue bigger">评论信息修改</h4>
							</div>
	
							<div class="modal-body">
								<div class="row">
									<div class="col-xs-12">
										<div class="form-group">
											<div>
												<textarea name="commentEdit" id="commentEdit" style="width:100%;height:200px;visibility:hidden;"></textarea>
											</div>
										</div>
										<div class="space-4"></div>
									</div>
								</div>
							</div>
	
							<div class="modal-footer">
								<button class="btn btn-sm" data-dismiss="modal">
									<i class="ace-icon fa fa-times"></i>
									取消
								</button>
	
								<button id="ModelSaveBtn" class="btn btn-sm btn-primary">
									<i class="ace-icon fa fa-check"></i>
									保存
								</button>
							</div>
						</div>
					</div>
				</div>
				
				<div class='clear'></div>
			</div>
		</div>
		
		<script src="${AppBase}/ace/assets/js/ace-extra.min.js"></script>
		<!-- basic scripts -->
		<script src="${AppBase}/ace/assets/js/bootstrap.min.js"></script>
		<script src="${AppBase}/ace/assets/js/bootstrap-tag.min.js"></script>
		<script src="${AppBase}/ace/assets/js/bootstrap-wysiwyg.min.js"></script>
		<!-- ace scripts -->
		<script src="${AppBase}/ace/assets/js/ace-elements.min.js"></script>
		<script src="${AppBase}/ace/assets/js/ace/ace.js"></script>
		<script src="${AppBase}/ace/assets/js/bootbox.min.js"></script>
		
		<script src="${AppBase}/SDCHOME/js/SDCHOME.js"></script>
		<script src="${AppBase}/SDCHOME/bbs/js/SubjectView.js"></script>
		
		<!--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-->
		<div class='clear'></div>
		<%@ include file="/SDCHOME/common/footer.jsp" %>
	</body>
		
</html>
