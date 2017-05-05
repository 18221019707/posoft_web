<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
		<meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <title>后台管理系统</title>
		<!-- Favicon and touch icons -->
		<link rel="shortcut icon" href="${webRoot}/static/ico/favicon.ico" type="image/x-icon" />
	    <!-- Css files -->
	    <link href="${webRoot}/static/css/bootstrap.min.css" rel="stylesheet">		
		<link href="${webRoot}/static/css/jquery.mmenu.css" rel="stylesheet">		
		<link href="${webRoot}/static/css/font-awesome.min.css" rel="stylesheet">
		<link href="${webRoot}/static/plugins/jquery-ui/css/jquery-ui-1.10.4.min.css" rel="stylesheet">
	    <link href="${webRoot}/static/css/style.min.css" rel="stylesheet">
		<link href="${webRoot}/static/css/add-ons.min.css" rel="stylesheet">
		<link href="${webRoot}/static/plugins/select2/css/select2.css" rel="stylesheet" />
		<!-- start: JavaScript-->
	    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	    <!--[if lt IE 9]>
			<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
			<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	    <![endif]-->
		<script src="${webRoot}/static/js/jquery-2.1.1.min.js"></script>
		<script src="${webRoot}/static/js/jquery-migrate-1.2.1.min.js"></script>
		<script src="${webRoot}/static/js/bootstrap.min.js"></script>
		<!-- page scripts -->
		<script src="${webRoot}/static/plugins/jquery-ui/js/jquery-ui-1.10.4.min.js"></script>
		<script src="${webRoot}/static/plugins/datatables/js/jquery.dataTables.min.js"></script>
		<script src="${webRoot}/static/plugins/datatables/js/dataTables.bootstrap.min.js"></script>
		<!-- theme scripts -->
		<script src="${webRoot}/static/js/SmoothScroll.js"></script>
		<script src="${webRoot}/static/js/jquery.mmenu.min.js"></script>
		<script src="${webRoot}/static/js/core.min.js"></script>
		
		<script src="${webRoot}/static/plugins/arttemplate/template.js"></script>
		<script src="${webRoot}/static/js/ajaxpage.js"></script>
		<script src="${webRoot}/static/js/data.js"></script>
		<script src="${webRoot}/static/js/common.js"></script>
		<script src="${webRoot}/static/plugins/select2/js/select2.min.js"></script>
		<!-- inline scripts related to this page -->
		<%-- <script src="${webRoot}/static/js/pages/table.js"></script> --%>
		<!-- end: JavaScript-->
<script>
$(function(){
	$.ajaxSetup({
		complete:function(XMLHttpRequest){
	        var server_token=XMLHttpRequest.getResponseHeader("server_token");
	        if(server_token){
	        	var ret = JSON.parse(XMLHttpRequest.responseText);
	        	if(ret.code!='0000'&&ret.code!="403"){
		        	$("#client_token").val(server_token);
	        	}
	        }
	    },
	    beforeSend:function(XMLHttpRequest){
			XMLHttpRequest.setRequestHeader('ClientToken',$("#client_token").val());
	    }
	});
});
</script>
