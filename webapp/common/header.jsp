<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- start: Header -->
<div class="navbar" role="navigation">
	<div class="container-fluid">		
		<ul class="nav navbar-nav navbar-actions navbar-left">
			<li class="visible-md visible-lg"><a href="#" id="main-menu-toggle"><i class="fa fa-th-large"></i></a></li>
			<li class="visible-xs visible-sm"><a href="#" id="sidebar-menu"><i class="fa fa-navicon"></i></a></li>			
		</ul>
        <ul class="nav navbar-nav navbar-right">
			<li class="dropdown visible-md visible-lg">
        		<a href="#" class="dropdown-toggle" data-toggle="dropdown"><img class="user-avatar" src="${webRoot}/static/img/avatar.jpg" alt="user-mail">galen@163.com</a>
        		<ul class="dropdown-menu">
					<li class="dropdown-menu-header">
						<strong>用户</strong>
					</li>						
					<li><a href="page-profile.html"><i class="fa fa-user"></i> 用户信息</a></li>
					<li><a href="page-login.html"><i class="fa fa-wrench"></i> 修改密码</a></li>
					<li class="divider"></li>						
					<li><a href="index.html"><i class="fa fa-sign-out"></i> 退出</a></li>	
        		</ul>
      		</li>
			<li><a href="index.html"><i class="fa fa-power-off"></i></a></li>
		</ul>
	</div>
</div>
<!-- end: Header -->