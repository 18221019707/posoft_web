<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/context/tags.jsp" %>
<!-- start: Main Menu -->
<div class="sidebar ">
					
	<div class="sidebar-collapse">
		<div class="sidebar-header t-center">
                     <span><img class="text-logo" src="${webRoot}/static/img/logo1.png"><i class="fa fa-space-shuttle fa-3x blue"></i></span>
                 </div>										
		<div class="sidebar-menu">		
			<input type="hidden" name="curUrl" id="curUrl" value="${webRoot}/admin/console.do">				
			<ul class="nav nav-sidebar">
				<li><a href="${webRoot}/admin/console.do" url="${webRoot}/admin/console.do"><i class="fa fa-laptop"></i><span class="text">首页</span></a></li>
				<c:forEach items="${sysLeftMenus }" var="sysLeftMenu">
				<li>
					<a href="${sysLeftMenu.sysResource==null?'':webRoot }${sysLeftMenu.sysResource==null?'#':sysLeftMenu.sysResource.url }" url="${sysLeftMenu.sysResource==null?'':webRoot }${sysLeftMenu.sysResource==null?'#':sysLeftMenu.sysResource.url }">
						<i class="fa fa-file-text"></i>
						<span class="text">${sysLeftMenu.name }</span>
						<c:if test="${sysLeftMenu.sons!=null&&fn:length(sysLeftMenu.sons) > 0 }">
						<span class="fa fa-angle-down pull-right"></span>
						</c:if>
					</a>
					<c:if test="${sysLeftMenu.sons!=null&&fn:length(sysLeftMenu.sons) > 0 }">
					<c:set var="webRoot" value="${webRoot }" scope="request"/>
					<c:set var="sysLeftMenuSons" value="${sysLeftMenu.sons }" scope="request"/>
					<c:import url="/common/menu_interate.jsp"/>
					</c:if>
				</li>
				</c:forEach>
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