<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
	<head>
    	<%@include file="/common/resourse.jsp"%>
    	<script src="${webRoot}/static/js/edit-common.js"></script>
    	<style type="text/css">
    		.delUrl{
    			cursor: pointer;
    			color: #ff5454;
    		}
    		.delUrl:HOVER {
				color: #4c4f53;
			}
    	</style>
	</head>
</head>

<body style="background: #ffffff;">
	<div class="modal-body">
     	<form id="data_form" method="post" enctype="multipart/form-data" class="form-horizontal " url="${webRoot}/sysUser/doEdit.do">
     		<input type="hidden" name="id" value="${sysUser.id}">
     		<input id="client_token" name="client_token" type="hidden" value="${client_token }">
			<div class="form-group">
                <label class="col-md-3 control-label" for="status">是否启用</label>
                <div class="col-md-9">
					<label class="switch switch-success">
				      <input id="status" name="status" type="checkbox" class="switch-input" value="" ${sysUser.status=='1'?'checked':''}>
				      <span class="switch-label" data-on="是" data-off="否"></span>
				      <span class="switch-handle"></span>
				    </label>
				</div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label" for="loginName"><span class="requiredField">&nbsp;*</span>用户名</label>
                <div class="col-md-9">
                    <input type="text" id="loginName" name="loginName" class="form-control" placeholder="用户名" value="${sysUser.loginName}">
                    <span class="help-block" atr="info"></span>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label" for="name"><span class="requiredField">&nbsp;*</span>姓名</label>
                <div class="col-md-9">
                    <input type="text" id="name" name="name" class="form-control" placeholder="姓名" value="${sysUser.name}">
                    <span class="help-block" atr="info"></span>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label" for="phone"><span class="requiredField">&nbsp;*</span>手机号码</label>
                <div class="col-md-9">
                    <input type="text" id="phone" name="phone" class="form-control" placeholder="手机号码" value="${sysUser.phone}">
                    <span class="help-block" atr="info"></span>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label" for="email"><span class="requiredField">&nbsp;*</span>电子邮箱</label>
                <div class="col-md-9">
                    <input type="text" id="email" name="email" class="form-control" placeholder="电子邮箱" value="${sysUser.email}">
                    <span class="help-block" atr="info"></span>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label" for="roleId">角色</label>
                <div class="col-md-9">
                	<c:forEach items="${sysRoles }" var="sysRole">
				    <label class="checkbox-inline" for="inline-checkbox1">
                    	<input type="checkbox" id="roleId" name="roleId" value="${sysRole.id }" ${userRoleMap.containsKey(sysRole.id)?'checked':''}> ${sysRole.name }
                    </label>
                	</c:forEach>
				</div>
            </div>						
			<br>
          </form>
	</div>
	<div class="clearfix"></div>
	<script type="text/javascript">
		$(function(){
		});
	</script>
</body>
</html>