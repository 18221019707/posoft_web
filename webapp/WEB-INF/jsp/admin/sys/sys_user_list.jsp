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
				<td>{{row.loginName}}</td>
				<td>{{row.name}}</td>
				<td>{{each row.sysRoles as value}}
						{{value.name}},
					{{/each}}</td>
				<td>{{row.email}}</td>
				<td>{{row.phone}}</td>
				<td>{{row.status}}</td>
				<td>
					<a class="btn btn-info" href="javascript:Public.goEdit('${webRoot}/sysUser/goEdit.do?id={{row.id}}')">
						<i class="fa fa-edit "></i>                                            
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
					<h2><i class="fa fa-table red"></i><span class="break"></span><strong>用户管理</strong></h2>
					<div class="panel-actions">
						<a href="javascript:Public.goAdd('${webRoot}/sysUser/goAdd.do')" class="btn-setting" ><i class="fa fa-plus"></i></a>
						<a href="#" class="btn-minimize"><i class="fa fa-chevron-up"></i></a>
						<a href="#" class="btn-close"><i class="fa fa-times"></i></a>
					</div>
				</div>
				<div class="panel-body">
					<div class="searchbar">
			          <div class="searchForm">
			          	<form id="search_form" method="post" enctype="multipart/form-data" class="form-horizontal ">
			          	<div class="form-group">
		                    <label class="col-sm-4 control-label" for="loginName">用户名:</label>
		                    <div class="col-sm-8">
		                        <input type="text" id="loginName" name="loginName" class="form-control" placeholder="用户名">
		                    </div>
		                </div>
		                <div class="form-group">
		                    <label class="col-sm-4 control-label" for="name">姓名:</label>
		                    <div class="col-sm-8">
		                        <input type="text" id="name" name="name" class="form-control" placeholder="姓名">
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
					<table class="table table-striped table-bordered bootstrap-datatable datatable ltable" url="${webRoot}/sysUser/datagrid.do" sort="name" order="desc">
					  <thead>
						  <tr>
							  <th sort="login_name">用户名</th>
                                    <th sort="url">姓名</th>
                                    <th sort="name">角色</th>
                                    <th sort="email">邮箱</th>
                                    <th sort="phone">手机号码</th>
                                    <th sort="status">状态</th>
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
</html>