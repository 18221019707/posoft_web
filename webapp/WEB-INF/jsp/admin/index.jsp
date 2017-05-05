<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
	<head>
    	<%@include file="/common/resourse.jsp"%>
	</head>
</head>

<body>
	
	<%@include file="/common/header.jsp"%>
	
	<div class="container-fluid content">
	
		<div class="row">
			
			<%@include file="/common/menu.jsp"%>	
			
			<!-- start: Content -->
			<div class="main sidebar-minified">
				
				<%@include file="/common/page-header.jsp"%>
				
				<div class="row">		
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h2><i class="fa fa-table red"></i><span class="break"></span><strong>Members</strong></h2>
								<div class="panel-actions">
									<a href="table.html#" class="btn-setting"><i class="fa fa-rotate-right"></i></a>
									<a href="table.html#" class="btn-minimize"><i class="fa fa-chevron-up"></i></a>
									<a href="table.html#" class="btn-close"><i class="fa fa-times"></i></a>
								</div>
							</div>
							<div class="panel-body">
								<table class="table table-striped table-bordered bootstrap-datatable datatable">
								  <thead>
									  <tr>
										  <th>Employe</th>
	                                      <th>Position</th>
	                                      <th>Salary</th>
										  <th>Status</th>
										  <th>Actions</th>
									  </tr>
								  </thead>   
								  <tbody>								
									<tr>
										<td>Willson</td>
	                                    <td>Developer</td>
	                                    <td>2563$</td>
										<td>
											<span class="label label-warning">Pending</span>
										</td>
										<td>
											<a class="btn btn-success" href="table.html#">
												<i class="fa fa-search-plus "></i>                                            
											</a>
											<a class="btn btn-info" href="table.html#">
												<i class="fa fa-edit "></i>                                            
											</a>
											<a class="btn btn-danger" href="table.html#">
												<i class="fa fa-trash-o "></i> 
	
											</a>
										</td>
									</tr>
									<tr>
										<td>James</td>
	                                    <td>SEO</td>
	                                    <td>5000$</td>
										<td>
											<span class="label label-warning">Pending</span>
										</td>
										<td>
											<a class="btn btn-success" href="table.html#">
												<i class="fa fa-search-plus "></i>                                            
											</a>
											<a class="btn btn-info" href="table.html#">
												<i class="fa fa-edit "></i>                                            
											</a>
											<a class="btn btn-danger" href="table.html#">
												<i class="fa fa-trash-o "></i> 
	
											</a>
										</td>
									</tr>
									<tr>
										<td>Steven</td>
	                                    <td>Photographer</td>
	                                    <td>1269$</td>
										<td>
											<span class="label label-warning">Pending</span>
										</td>
										<td>
											<a class="btn btn-success" href="table.html#">
												<i class="fa fa-search-plus "></i>                                            
											</a>
											<a class="btn btn-info" href="table.html#">
												<i class="fa fa-edit "></i>                                            
											</a>
											<a class="btn btn-danger" href="table.html#">
												<i class="fa fa-trash-o "></i> 
	
											</a>
										</td>
									</tr>
									<tr>
										<td>Aselay</td>
	                                    <td>Project manger</td>
	                                    <td>6253$</td>
										<td>
											<span class="label label-warning">Pending</span>
										</td>
										<td>
											<a class="btn btn-success" href="table.html#">
												<i class="fa fa-search-plus "></i>                                            
											</a>
											<a class="btn btn-info" href="table.html#">
												<i class="fa fa-edit "></i>                                            
											</a>
											<a class="btn btn-danger" href="table.html#">
												<i class="fa fa-trash-o "></i> 
	
											</a>
										</td>
									</tr>
								  </tbody>
							  </table>            
							</div>
						</div>
					</div><!--/col-->
				
				</div><!--/row-->
				
			</div>
			<!-- end: Content -->
			<br><br><br>		
		</div>
	</div><!--/container-->
	
	<%@include file="/common/addModel.jsp"%>
	<%@include file="/common/editModel.jsp"%>
	
	<div class="clearfix"></div>
</body>
</html>