<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<title>平台开发-后台管理系统</title>
		<meta name="description" content="overview &amp; stats" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		<%@ include file="/ADMIN/pages/basic-head-elem.jsp" %>
		<link rel="stylesheet" type="text/css" href="${AppBase}/ADMIN/style/table/content.css">
		<script src="${AppBase}/ADMIN/style/table/consoleUtil.js" type="text/javascript"></script>
		<script src="${AppBase}/ADMIN/style/table/table.js" type="text/javascript"></script>
	</head>

	<body class="no-skin">
		<!-- #section:basics/navbar.layout -->
		<%@ include file="/ADMIN/pages/navbar.jsp" %>
		<!-- /section:basics/navbar.layout -->
		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<!-- #section:basics/sidebar -->
			<%@ include file="/ADMIN/pages/sidebar.jsp" %>
			<!-- /section:basics/sidebar -->
			
			<div class="main-content">
				<!-- #section:basics/content.breadcrumbs -->
				<div class="breadcrumbs" id="breadcrumbs">
					<script type="text/javascript">
						try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
					</script>

					<ul class="breadcrumb">
						<li>
							<i class="ace-icon fa fa-home home-icon"></i>
							<a href="#"> 系统管理 </a>
						</li>
						<li class="active">菜单管理</li>
					</ul><!-- /.breadcrumb -->

					<!-- #section:basics/content.searchbox -->
					<%@ include file="/ADMIN/pages/searchbox.jsp" %>
					<!-- /section:basics/content.searchbox -->
				</div>

				<!-- /section:basics/content.breadcrumbs -->
				<div class="page-content">
					<div class="page-header">
						<h1>
							菜单管理
							<small>
								<i class="ace-icon fa fa-angle-double-right"></i>
								添加、修改、删除系统支持的菜单功能
							</small>
						</h1>
					</div><!-- /.page-header -->

					<div class="row">
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->
							
								<div class="col-xs-6 col-sm-2">
									<div class="widget-box widget-color-blue2">
										<div class="widget-header">
											<h4 class="widget-title lighter smaller">菜单信息维护</h4>
										</div>
	
										<div class="widget-body">
											<div class="widget-main padding-1">
												<button class="btn btn-xs btn-danger">
													<i class="ace-icon fa fa-bolt bigger-110"></i>
													添加
													<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
												</button>
												<div id="tree2" class="tree"></div>
											</div>
										</div>
									</div>
								</div>
							
								<div class="col-xs-6 col-sm-10">
									<div class="widget-box widget-color-blue2">
										<div class="widget-header">
											<h4 class="widget-title lighter smaller">菜单信息维护</h4>
										</div>
	
										<div class="widget-body">
											<div class="widget-main padding-1">
												
												<div class="contenttable">
													<form id="genericTableForm" name="genericTableForm" action="#"
														method="POST">
														<table class="tablebuttonbar" summary="">
															<tbody>
																<tr>
																	<td class="tablecontrols"><div class="buttonBar">
																			<button type="button" onclick="" name="安装" class="formButton">安装</button>
																			&nbsp;
																		</div></td>
																	<td class="tablenavigation">显示 1 到 2 个, 共 2
																		个&nbsp;&nbsp;&nbsp;上一个&nbsp;下一个</td>
																</tr>
															</tbody>
														</table>
														
														<table class="datatable" id="genericTableFormtable" summary="部署">
															<colgroup>
																<col class="checkboxColumn">
															</colgroup>
															<tbody id="TBODY">
																<tr>
																	<th scope="col">&nbsp;</th>
																	<th scope="col" title="名称">菜单名称</th>
																	<th scope="col" title="状态">菜单路径</th>
																	<th scope="col" title="健康状况">显示顺序</th>
																	<th scope="col" title="类型">功能说明</th>
																	<th scope="col" title="部署顺序">允许操作</th>
																</tr>
															</tbody>
														</table>
														
													</form>
												</div>
												
											</div>
										</div>
									</div>
								</div>
							
							<!-- PAGE CONTENT ENDS -->
						</div><!-- /.col -->
					</div><!-- /.row -->
				</div><!-- /.page-content -->
			</div><!-- /.main-content -->

			<div class="footer">
				<div class="footer-inner">
					<!-- #section:basics/footer -->
					<%@ include file="/ADMIN/pages/footer.jsp" %>
					<!-- /section:basics/footer -->
				</div>
			</div>

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->

		<!-- basic scripts -->
		<%@ include file="/ADMIN/pages/basic-script.jsp" %>
		<!-- inline scripts related to this page -->
		<script src="${AdminBase}/ace/assets/js/bootstrap.min.js"></script>

		<!-- page specific plugin scripts -->
		<script src="${AdminBase}/ace/assets/js/fuelux/data/fuelux.tree-sample-demo-data.js"></script>
		<script src="${AdminBase}/ace/assets/js/fuelux/fuelux.tree.min.js"></script>
		<script type="text/javascript">
			jQuery(function($) {
				
				
				
			});
			
		</script>
		<script src="${AdminBase}/ADMIN/js/MenuList2.js" type="text/javascript"></script>
	</body>
</html>
		