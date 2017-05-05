var sort;
var order;

function pagination(page){
	if(!page){
		page = $(".pagination li.active a").attr("page");
		if(!page){
			page = 1;
		}
	}
	var url =$(".ltable").attr("url");
	if(!url){
		return false;
	}
	jQuery.ajax({
		url : url,
		data : $('#search_form').serialize()+'&page='+page+'&rows='+getCookie('rows')+'&sort='+(sort||'')+'&order='+(order||''),
		type : "POST",
		beforeSend: function(){
			$('#tablelist').html('');
			$(".pagelist").html('');
		},
		success : function(ret) {
			 if(ret.code=='0000'){
				 var result = ret.pageRecord;
				 if(result.totalCount>0){
					 $(".pagelist").getLinkStr({totalPage:result.totalPage,totalCount:result.totalCount,page:result.page,pageSize:result.pageSize});
					 $('#tablelist').html(template('tableContent', result));
				 }else{
					 norecord();
				 }
			 }else if(ret.code=='403'){
				 alert("无权访问当前数据"); 
			 }else{
				 alert("查询错误");
			 }
		}
	});
}
function norecord(){
	$("#tablelist").html("<tr><td height='40px;' colspan='100' align='center'><span>抱歉！没有记录 。。。</span></td></tr>");
}
$(function(){
	order = $(".ltable").attr('order');
	sort = $(".ltable").attr('sort');
	pagination();
	$("#searchBtn").click(function(){
		pagination();
	});
	$("#clearBtn").click(function(){
		window.location.reload(true);
	});
	$(".ltable").find('th').each(function(){
		var tSort = $(this).attr('sort');
		if(tSort){
			var trName =$(this).html();
			//绑定事件
			$(this).click(function(){
				
			});
		}
	});
});