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
							<a href="#">Home</a>
						</li>
						<li class="active">Dashboard</li>
					</ul><!-- /.breadcrumb -->

					<!-- #section:basics/content.searchbox -->
					<%@ include file="/ADMIN/pages/searchbox.jsp" %>
					<!-- /section:basics/content.searchbox -->
				</div>

				<!-- /section:basics/content.breadcrumbs -->
				<div class="page-content">
					<div class="page-header">
						<h1>
							Dashboard
							<small>
								<i class="ace-icon fa fa-angle-double-right"></i>
								overview &amp; stats
							</small>
						</h1>
					</div><!-- /.page-header -->

					<div class="row">
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->
							
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
		
		<script type="text/javascript">
			jQuery(function($) {
				
			})
		</script>
	</body>
</html>
		