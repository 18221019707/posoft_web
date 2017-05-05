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
     	<form id="data_form" method="post" enctype="multipart/form-data" class="form-horizontal " url="${webRoot}/sysResource/doAdd.do">
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
                <label class="col-md-3 control-label" for="name"><span class="requiredField">&nbsp;*</span>资源名称</label>
                <div class="col-md-9">
                    <input type="text" id="name" name="name" class="form-control" placeholder="资源名称">
                    <span class="help-block" atr="info"></span>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label" for="url">URL地址</label>
                <div class="col-md-9">
                    <input type="text" id="url" name="url" class="form-control" placeholder="URL地址">
                    <span class="help-block" atr="info"></span>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-9">
                    <button id="addUrl" type="button" class="btn btn-primary btn-sm"><i class="fa fa-plus"></i>&nbsp;依赖URL</button>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label" for="memo">备注</label>
                <div class="col-md-9">
                    <textarea id="memo" name="memo" rows="9" class="form-control" placeholder="Content.."></textarea>
                    <span class="help-block" atr="info"></span>
                </div>
            </div>						
			<br>
          </form>
	</div>
	<div class="clearfix"></div>
	<script type="text/javascript">
		$(function(){
			$("#addUrl").click(function(){
				$(this).parent().parent().after('<div class="form-group">'+
		                '<label class="col-md-3 control-label" for="dep_urls">URL<span class="delUrl">&nbsp;&nbsp;<i class="fa fa-trash-o"></i></span></label>'+
		                '<div class="col-md-9">'+
		                    '<input type="text" id="dep_urls" name="dep_urls" class="form-control" placeholder="URL">'+
		                '</div>'+
		            '</div>');
				$(".delUrl").click(function(){
					$(this).parent().parent().remove();
				});
			});
		});
	</script>
</body>
</html>