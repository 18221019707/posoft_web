<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/context/tags.jsp" %>
<!-- start: Main Menu interate -->
<ul class="nav sub">
	<c:forEach var="sysLeftMenuSon" items="${sysLeftMenuSons }" varStatus="vs">
	<li>
		<a href="javascript:loadPage('${sysLeftMenuSon.sysResource==null?'':webRoot }${sysLeftMenuSon.sysResource==null?'#':sysLeftMenuSon.sysResource.url }')" url="${sysLeftMenuSon.sysResource==null?'':webRoot }${sysLeftMenuSon.sysResource==null?'#':sysLeftMenuSon.sysResource.url }">
		<i class="fa fa-car"></i>
		<span class="text">${sysLeftMenuSon.name }</span>
		<c:if test="${sysLeftMenuSon.sons!=null&&fn:length(sysLeftMenuSon.sons) > 0 }">
		<span class="fa fa-angle-down pull-right"></span>
		</c:if>
		</a>
		<c:if test="${sysLeftMenuSon.sons!=null&&fn:length(sysLeftMenuSon.sons) > 0 }">
		<c:set var="sysLeftMenuSons" value="${sysLeftMenuSon.sons }" scope="request"/>
		<c:import url="/common/menu_interate.jsp"/>
		</c:if>
	</li>
	</c:forEach>
</ul>
<!-- end: Main Menu interate-->