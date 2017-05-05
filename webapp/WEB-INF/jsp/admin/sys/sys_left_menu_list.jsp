<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
	<head>
    	<%@include file="/common/resourse.jsp"%>
    	<script id="tableContent" type="text/html">
		{{each dataList as row}}
			<tr>
				<td onclick="child(this,'{{row.id}}')">{{row.name}}</td>
				<td>{{row.url}}</td>
				<td>{{row.idx}}</td>
				<td>
					<a class="btn btn-success" href="javascript:Public.goAdd('${webRoot}/sysLeftMenu/goAdd.do?pid={{row.id}}')">
						<i class="fa fa-search-plus "></i>                                            
					</a>
					<a class="btn btn-info" href="javascript:Public.goEdit('${webRoot}/sysLeftMenu/goEdit.do?id={{row.id}}')">
						<i class="fa fa-edit "></i>                                            
					</a>
					<a class="btn btn-danger" href="javascript:Public.ajaxDel('${webRoot}/sysLeftMenu/delete.do?id={{row.id}}')">
						<i class="fa fa-trash-o "></i> 
					</a>
				</td>
         	</tr>
		{{/each}}
		</script>
		<script id="tableContentChild" type="text/html">
		{{each dataList as row}}
			<tr class="trChild">
				<td onclick="child2(this,'{{row.id}}')">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<i class="fa  fa-terminal"></i>&nbsp;{{row.name}}
				</td>
				<td>{{row.url}}</td>
				<td>{{row.idx}}</td>
				<td>
					<a class="btn btn-success" href="javascript:Public.goAdd('${webRoot}/sysLeftMenu/goAdd.do?pid={{row.id}}')">
						<i class="fa fa-search-plus "></i>                                            
					</a>
					<a class="btn btn-info" href="javascript:Public.goEdit('${webRoot}/sysLeftMenu/goEdit.do?id={{row.id}}')">
						<i class="fa fa-edit "></i>                                            
					</a>
					<a class="btn btn-danger" href="javascript:Public.ajaxDel('${webRoot}/sysLeftMenu/delete.do?id={{row.id}}')">
						<i class="fa fa-trash-o "></i> 
					</a>
				</td>
         	</tr>
		{{/each}}
		</script>
		<script id="tableContentChild2" type="text/html">
		{{each dataList as row}}
			<tr class="trChild2">
				<td>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<i class="fa  fa-terminal"></i>&nbsp;{{row.name}}
				</td>
				<td>{{row.url}}</td>
				<td>{{row.idx}}</td>
				<td>
					<a class="btn btn-info" href="javascript:Public.goEdit('${webRoot}/sysLeftMenu/goEdit.do?id={{row.id}}')">
						<i class="fa fa-edit "></i>                                            
					</a>
					<a class="btn btn-danger" href="javascript:Public.ajaxDel('${webRoot}/sysLeftMenu/delete.do?id={{row.id}}')">
						<i class="fa fa-trash-o "></i> 
					</a>
				</td>
         	</tr>
		{{/each}}
		</script>
	</head>
</head>

<body>
	
	<%@include file="/common/page-header.jsp"%>
				
	<div class="row">		
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div id="panel-heading" class="panel-heading">
					<h2><i class="fa fa-table red"></i><span class="break"></span><strong>资源管理</strong></h2>
					<div class="panel-actions">
						<a href="javascript:Public.goAdd('${webRoot}/sysLeftMenu/goAdd.do')" class="btn-setting" ><i class="fa fa-plus"></i></a>
						<a href="#" class="btn-minimize"><i class="fa fa-chevron-up"></i></a>
						<a href="#" class="btn-close"><i class="fa fa-times"></i></a>
					</div>
				</div>
				<div class="panel-body">
					<div class="searchbar">
			          <div class="searchForm">
			          	<form id="search_form" method="post" enctype="multipart/form-data" class="form-horizontal ">
			          	<div class="form-group">
		                    <label class="col-sm-4 control-label" for="name">菜单名称:</label>
		                    <div class="col-sm-8">
		                        <input type="text" id="name" name="name" class="form-control" placeholder="菜单名称">
		                    </div>
		                </div>
		                <div class="form-group">
		                    <label class="col-sm-4 control-label" for="url">Url地址:</label>
		                    <div class="col-sm-8">
		                        <input type="text" id="url" name="url" class="form-control" placeholder="Url地址">
		                    </div>
		                </div>
		                </form>
			          </div>
			          <div class="searchButton">
			            <a id="searchBtn" class="btn btn-info" href="#">
							<i class="fa">搜索</i>                                            
						</a>
						<a id="clearBtn" class="btn btn-warning" href="#">
							<i class="fa">重置</i>                                            
						</a>
			   		  </div>
					</div>
					<table class="table table-striped table-bordered bootstrap-datatable datatable ltable" url="${webRoot}/sysLeftMenu/datagrid.do" sort="name" order="desc">
					  <thead>
						  <tr>
							  <th sort="name">菜单名称</th>
                                    <th sort="url">URL地址</th>
                                    <th sort="idx">排序</th>
                                    <th width="20%">操作</th>
						  </tr>
					  </thead>   
					  <tbody  id="tablelist">
					  </tbody>
				  </table>  
				  <div class="pagelist"></div>         
				</div>
			</div>
		</div><!--/col-->
	
	</div><!--/row-->
</body>
<script type="text/javascript">
	function child(that,id){
		var order = $(".ltable").attr('order');
		var sort = $(".ltable").attr('sort');
		jQuery.ajax({
			url : "${webRoot}/sysLeftMenu/datagridChild.do",
			data : '&parentId='+id+'&page=1&rows=99&sort='+(sort||'')+'&order='+(order||''),
			type : "POST",
			beforeSend: function(){
				
			},
			success : function(ret) {
				var tr = $(that).parent();
				if(tr.next().attr("class")=="trChild"){
					$(" #tablelist .trChild").remove();
					$(" #tablelist .trChild2").remove();
					return ;
				}
				 if(ret.code=='0000'){
					 var result = ret.pageRecord;
					 if(result.totalCount>0){
						 var child = template("tableContentChild",result);
						 $(that).parent().after(child);
					 }else{
						 $(that).parent().after("<tr class='trChild'><td height='40px;' colspan='100' align='center'><span>抱歉！无子栏目</span></td></tr>");
					 }
				 }else if(ret.code=='403'){
					 alert("无权访问当前数据");
				 }else{
					 alert("查询错误");
				 }
			}
		});
	}
	function child2(that,id){
		var order = $(".ltable").attr('order');
		var sort = $(".ltable").attr('sort');
		jQuery.ajax({
			url : "${webRoot}/sysLeftMenu/datagridChild.do",
			data : '&parentId='+id+'&page=1&rows=99&sort='+(sort||'')+'&order='+(order||''),
			type : "POST",
			beforeSend: function(){
				
			},
			success : function(ret) {
				var tr = $(that).parent();
				if(tr.next().attr("class")=="trChild2"){
					$("#tablelist .trChild2").remove();
					return ;
				}
				 if(ret.code=='0000'){
					 var result = ret.pageRecord;
					 if(result.totalCount>0){
						 var child = template("tableContentChild2",result);
						 $(that).parent().after(child);
					 }else{
						 $(that).parent().after("<tr class='trChild2'><td height='40px;' colspan='100' align='center'><span>抱歉！无子栏目</span></td></tr>");
					 }
				 }else if(ret.code=='403'){
					 alert("无权访问当前数据");
				 }else{
					 alert("查询错误");
				 }
			}
		});
	}
</script>
</html>