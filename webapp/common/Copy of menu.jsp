<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- start: Main Menu -->
<div class="sidebar ">
					
	<div class="sidebar-collapse">
		<div class="sidebar-header t-center">
                     <span><img class="text-logo" src="${webRoot}/static/img/logo1.png"><i class="fa fa-space-shuttle fa-3x blue"></i></span>
                 </div>										
		<div class="sidebar-menu">						
			<ul class="nav nav-sidebar">
				<li><a href="index.html"><i class="fa fa-laptop"></i><span class="text">首页</span></a></li>
				<li>
					<a href="#">
						<i class="fa fa-file-text"></i>
						<span class="text">系统管理</span>
						<span class="fa fa-angle-down pull-right"></span>
					</a>
					<ul class="nav sub">
						<li>
							<a href="${webRoot}/sysResource/toIndex.do">
							<i class="fa fa-car"></i><span class="text">资源管理</span>
							</a>
						</li>
						<li>
							<a href="${webRoot}/sysLeftMenu/toIndex.do">
							<i class="fa fa-car"></i><span class="text">菜单管理</span>
							</a>
						</li>
						<li>
							<a href="${webRoot}/sysRole/toIndex.do">
							<i class="fa fa-car"></i><span class="text">角色管理</span>
							</a>
						</li>
						<li>
							<a href="${webRoot}/sysUser/toIndex.do">
							<i class="fa fa-car"></i><span class="text">用户管理</span>
							</a>
						</li>
					</ul>
				</li>
				<li><a href="table.html"><i class="fa fa-table"></i><span class="text">Tables</span></a></li>
			</ul>
		</div>					
	</div>
	<div class="sidebar-footer">					
		
		<div class="sidebar-brand">
			Proton
		</div>
		
		<ul class="sidebar-terms">
			<li><a href="index.html#">Terms</a></li>
			<li><a href="index.html#">Privacy</a></li>
			<li><a href="index.html#">Help</a></li>
			<li><a href="index.html#">About</a></li>
		</ul>
		
		<div class="copyright text-center">
			<small>Proton <i class="fa fa-coffee"></i> from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></small>
		</div>					
	</div>	
	
</div>
<!-- end: Main Menu -->