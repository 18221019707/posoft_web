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
     	<form id="data_form" method="post" enctype="multipart/form-data" class="form-horizontal " url="${webRoot}/sysRole/doAuth.do">
     		<input type="hidden" name="id" value="${sysRole.id}">
            <div class="panel-body">
				<table class="table table-bordered">
				  <thead>
					  <tr>
						  <th>资源名称</th>
                          <th width="20%">操作</th>
					  </tr>
				  </thead>   
				  <tbody  id="tablelist">
				  	<c:forEach items="${sysResources }" var="sr" varStatus="i">
	          			<c:if test="${fn:length(sr.sons)>0 }">
		          		<tr tag="p" sid="${sr.id }">
						    <td>${sr.name }</td>
							<td>
								<div class="col-md-1 col-sm-2 col-xs-3">
									<label class="switch switch-success">
								      <input type="checkbox" class="switch-input">
								      <span class="switch-label" data-on="全选" data-off="取消"></span>
								      <span class="switch-handle"></span>
								    </label>
								</div>
							</td>
						</tr>
          				<c:forEach items="${sr.sons }" var="son">
          				<tr tag="c" sid="${son.id }" parentId="${sr.id }" style="background-color: #fdfdfd;">
						    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${son.name }(${son.url })</td>
							<td>
								<div class="col-md-1 col-sm-2 col-xs-3">
									<label class="switch switch-info">
								      <input type="checkbox" class="switch-input"  name="res" value="${son.id }" ${roleResourceMap.containsKey(son.id)?'checked':''}>
								      <span class="switch-label" data-on="选择" data-off="取消"></span>
								      <span class="switch-handle"></span>
								    </label>
								</div>
							</td>
						</tr>
          				</c:forEach>
	          			</c:if>
	          		</c:forEach>
				  </tbody>
			  </table>        
			</div>
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
			$("#tablelist").find("tr[tag='p']").each(function(){
				var sid = $(this).attr("sid");
				$(this).attr("showhide",false);
				var bol = true;
				$("#tablelist").find("tr[parentId='"+sid+"']").each(function(){
					$(this).hide();
					bol = $(this).find(".switch-input").is(':checked')&&bol;
				});
				if(bol){
					$(this).find(".switch-input").attr("checked",true);
				}else{
					$(this).find(".switch-input").attr("checked",false);
				}
			});
			$("#tablelist").find("tr[tag='p']").click(function(){
				var sid = $(this).attr("sid");
				var child = $("#tablelist").find("tr[parentId='"+sid+"']");
				if($(this).attr('showhide')=='false'){
					child.show(); 
					$(this).attr('showhide',true);
				}else{
					child.hide();
					$(this).attr('showhide',false);
				}
			});
			$("#tablelist").find("tr[tag='p']").find(".switch").click(function(){
				var tr = $(this).parent().parent().parent();
				var sid = tr.attr("sid");
				$("#tablelist").find("tr[parentId='"+sid+"']").find(".switch-input")
						.attr("checked",$(this).find(".switch-input").is(':checked'));
			});
			
			$("#tablelist").find("tr[tag='c']").find(".switch").click(function(){
				var tr = $(this).parent().parent().parent();
				var parentid = tr.attr("parentid");
				var childNum = $("#tablelist").find("tr[parentId='"+parentid+"']").find(".switch-input").length;
				var checkChildNum = $("#tablelist").find("tr[parentId='"+parentid+"']").find(".switch-input:checked").length;
				var parentTr = $("#tablelist").find("tr[sid='"+parentid+"']");
				if(childNum==checkChildNum){
					parentTr.find(".switch-input").attr("checked",true);
				}else{
					parentTr.find(".switch-input").attr("checked",false);
				}
			});
		});
	</script>
</body>
</html>