<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>用户登录</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="${webRoot}/static/assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="${webRoot}/static/assets/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="${webRoot}/static/assets/css/form-elements.css">
        <link rel="stylesheet" href="${webRoot}/static/assets/css/style.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="${webRoot}/static/assets/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${webRoot}/static/assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${webRoot}/static/assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${webRoot}/static/assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="${webRoot}/static/assets/ico/apple-touch-icon-57-precomposed.png">

    </head>

    <body>

        <!-- Top content -->
        <div class="top-content">
        	
            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <h1>用户登录</h1>
                            <div class="description">
                            	<p></p>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                        	<div class="form-top">
                        		<div class="form-top-left">
                        			<h3>登录我们的网站</h3>
                            		<p class="msg">请输入用户名密码登录:</p>
                        		</div>
                        		<div class="form-top-right">
                        			<i class="fa fa-lock"></i>
                        		</div>
                            </div>
                            <div class="form-bottom">
			                    <form role="form" action="${webRoot }/admin/login.do" method="post" class="login-form" >
			                    	<div class="form-group">
			                    		<label class="sr-only" for="loginName">用户名</label>
			                        	<input type="text" name="loginName" placeholder="用户名..." class="form-username form-control" id="loginName">
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="pwd">密码</label>
			                        	<input type="password" name="pwd" placeholder="密码..." class="form-password form-control" id="pwd">
			                        </div>
			                        <button id="submit" type="button" class="btn">登 录</button>
			                    </form>
		                    </div>
                        </div>
                    </div>
                </div>
            </div>
            
        </div>


        <!-- Javascript -->
        <script src="${webRoot}/static/assets/js/jquery-1.11.1.min.js"></script>
        <script src="${webRoot}/static/assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="${webRoot}/static/assets/js/jquery.backstretch.min.js"></script>
        <script src="${webRoot}/static/assets/js/scripts.js"></script>
        <script type="text/javascript">
        jQuery(document).ready(function() {
        	$.backstretch("${webRoot}/static/assets/img/backgrounds/1.jpg");
        });
        </script>
        
        <!--[if lt IE 10]>
            <script src="${webRoot}/static/assets/js/placeholder.js"></script>
        <![endif]-->

    </body>

</html>