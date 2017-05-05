<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
	<head>
    	<%@include file="/common/resourse.jsp"%>
    	<script src="${webRoot}/static/js/add-common.js"></script>
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
     	<form id="data_form" method="post" enctype="multipart/form-data" class="form-horizontal " url="${webRoot}/sysLeftMenu/doEdit.do">
     		<input type="hidden" name="id" value="${sysLeftMenu.id}">
     		<input id="client_token" name="client_token" type="hidden" value="${client_token }">
     		<div class="form-group">
				<label class="col-md-3 control-label" for="select"><span class="requiredField">&nbsp;*</span>上级资源</label>
				<div class="col-md-9">
					<input type="hidden" name="parentId" value="${parent==null?'888888888888888888':parent.id}"/>
					<select id="disabledSelect" class="form-control" disabled>
			        	<option value="${parent==null?'888888888888888888':parent.id}">${parent==null?'无父级资源':parent.name}</option>
			      	</select>
			      	<span class="help-block" atr="info"></span>
			    </div>
			</div>
            <div class="form-group">
                <label class="col-md-3 control-label" for="idx"><span class="requiredField">&nbsp;*</span>排序</label>
                <div class="col-md-9">
                    <input type="text" id="idx" name="idx" class="form-control" placeholder="数字，越小越靠前" value="${sysLeftMenu.idx }">
                    <span class="help-block" atr="info"></span>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label" for="name"><span class="requiredField">&nbsp;*</span>菜单名称</label>
                <div class="col-md-9">
                    <input type="text" id="name" name="name" class="form-control" placeholder="菜单名称" value="${sysLeftMenu.name }">
                    <span class="help-block" atr="info"></span>
                </div>
            </div>
            <div class="form-group">
            	<label class="col-md-3 control-label" for="type">菜单类型</label>
	            <div class="col-md-9">
	            	<input type="hidden" id="type" name="type"  value="${sysLeftMenu.type }">
					<button type="button" class="btn ${sysLeftMenu.type==1?'btn-info':'btn-default'} option" value="1">有子菜单</button>
					<button type="button" class="btn ${sysLeftMenu.type==2?'btn-info':'btn-default'} option" value="2">菜单链接</button>
				</div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label" for="url">导航资源</label>
                <div class="col-md-9">
                    <select name="resourceId" id="resourceId" class="js-example-basic-single form-control">
		          		<option value="">--请选择--</option>
		          		<c:forEach items="${sysResources }" var="sr" varStatus="i">
		          			<c:if test="${fn:length(sr.sons)>0 }">
			          			<option value="${sr.id }" ${sysLeftMenu.resourceId==sr.id?'selected':'' }>${sr.name }</option>
		          				<c:if test="${i.index==0 }">
		          				${sr.name}-->
		          				</c:if>
		          				<c:forEach items="${sr.sons }" var="son">
		          					<option value="${son.id }" ${sysLeftMenu.resourceId==son.id?'selected':'' }>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${son.name }(${son.url })</option>
		          				</c:forEach>
		          			</c:if>
		          		</c:forEach>
					</select>
                    <span class="help-block" atr="info"></span>
                </div>
            </div>					
			<br>
          </form>
	</div>
	<div class="clearfix"></div>
	<script type="text/javascript">
		$(function(){
			$(".btn.option").click(function(){
				$(".btn.option").removeClass("btn-info");
				$(".btn.option").addClass("btn-default");
				$(this).removeClass("btn-default");
				$(this).addClass("btn-info");
				if($(this).val()=='1'){
					$("#resourceId").parent().parent().hide();
					$("#url").parent().parent().hide();
					$("#type").val("1");
				}else{
					$("#resourceId").parent().parent().show();
					$("#url").parent().parent().show();
					$("#type").val("2");
				}
			});
			$(".btn.btn-info.option").click();
		});
	</script>
</body>
</html>