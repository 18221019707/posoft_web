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
     	<form id="data_form" method="post" enctype="multipart/form-data" class="form-horizontal " url="${webRoot}/sysRole/doAdd.do">
     		<input id="client_token" name="client_token" type="hidden" value="${client_token }">
            <div class="form-group">
                <label class="col-md-3 control-label" for="name"><span class="requiredField">&nbsp;*</span>角色名称</label>
                <div class="col-md-9">
                    <input type="text" id="name" name="name" class="form-control" placeholder="角色名称">
                    <span class="help-block" atr="info"></span>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label" for="code"><span class="requiredField">&nbsp;*</span>角色代码</label>
                <div class="col-md-9">
                    <input type="text" id="code" name="code" class="form-control" placeholder="角色代码">
                    <span class="help-block" atr="info"></span>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-3 control-label" for="memo">角色说明</label>
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
			
		});
	</script>
</body>
</html>