<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--[if !IE]> -->
<script type="text/javascript">
	window.jQuery || document.write("<script src='${AppBase}/ace/assets/js/jquery.min.js'>"+"<"+"/script>");
</script>

<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='${AppBase}/ace/assets/js/jquery1x.min.js'>"+"<"+"/script>");
</script>
<![endif]-->
<script type="text/javascript">
	if('ontouchstart' in document.documentElement) document.write("<script src='${AppBase}/ace/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>
<script src="${AppBase}/ace/assets/js/bootstrap.min.js"></script>

<!-- page specific plugin scripts -->

<!--[if lte IE 8]>
  <script src="${AppBase}/ace/assets/js/excanvas.min.js"></script>
<![endif]-->
<script src="${AppBase}/ace/assets/js/jquery-ui.custom.min.js"></script>
<script src="${AppBase}/ace/assets/js/jquery.ui.touch-punch.min.js"></script>

<!-- ace scripts -->
<script src="${AppBase}/ace/assets/js/ace-elements.min.js"></script>
<script src="${AppBase}/ace/assets/js/ace.min.js"></script>

<script type="text/javascript"> ace.vars['base'] = '..'; </script>