function changeRows(){
	var txtPageNum =$("#txtPageNum").val();
	addCookie("rows",txtPageNum,0);
	pagination(1);
}

function doJump(page,toatlPage){
	var jump =$("#pageGo").val();
	if(jQuery.trim(jump).length == 0||parseInt(jump) < 1){
		$("#pageGo").focus();
		$("#pageGo").attr("value",'');
	} else{
		if(jump.search("^-?\\d+$") != 0){
			$("#pageGo").focus();
			$("#pageGo").attr("value",'');
		}
		if(jump>toatlPage){
			jump = toatlPage;
		}
		if(page!=jump){
			pagination(jump);
		}
	}
}
(function(jQuery) {
	jQuery.fn.getLinkStr = function(pageInfo) {
		pageInfo = jQuery.extend({
			page:1,//当前页
			totalPage:10,//总页数
			pageSize:10,//总页数
			totalCount:10,//总记录
			breakpage:8,//总页数<=该值时，全部显示
			isShowPage:true,//是否显示总页数，默认显示
			isShowJump:true//是否显示跳到第几页，默认显示
		}, pageInfo);
		var jsfunction = pageInfo.jsfunction;
		$obj = this;
		var createPage = function(num){
			if(pageInfo.page == num){
				return "<li class='active'><a href='#' page='"+num+"'>"+num+"</a></li>";
			}
			else{
				return "<li><a href='#' page='"+num+"'>"+num+"</a></li>";
			}
		};
		
		jQuery(this).html("");
		var page = parseInt(pageInfo.page);
		var totalPage = parseInt(pageInfo.totalPage);
		var htmlPage ='<ul class="pagination">';
			
		if(pageInfo.page>1){
			htmlPage += "<li><a href=\"#\" page=\""+(page-1)+"\">上一页</a></li>";
		}
		
		//当总页数小于等于breakpage值时，页码全部显示
		if(totalPage <= pageInfo.breakpage){
			for(var i=1;i<=totalPage;i++){
				htmlPage += createPage(i);
			}
		}
		else{
			if(page <= 4){
				for(var i=1;i<page + 4;i++){
					htmlPage += createPage(i);
				}
				htmlPage += "<li><span>...</span></li>";
				htmlPage += createPage(totalPage);
			}
			else if(page > 4 && page <= totalPage - 4){
				htmlPage += createPage(1);
				htmlPage += "<li><span>...</span></li>";
				for(var i=page-2;i<page+3;i++){
					htmlPage += createPage(i);
				}
				htmlPage += "<li><span>...</span></li>";
				htmlPage += createPage(totalPage);	
			}
			else{
				htmlPage += createPage(1);
				htmlPage += "<li><span>...</span></li>";
				for(var i=page-2;i<=totalPage;i++){
					htmlPage += createPage(i);
				}
			}
		}
		if(pageInfo.page<pageInfo.totalPage){
			htmlPage += "<li><a href=\"#\" page=\""+(page+1)+"\">下一页</a></li>";
		}
		
		if(pageInfo.isShowJump && pageInfo.totalPage>20){
			htmlPage +='<li><input type="text" size="3" id="pageGo" name="pageGo" value="'+page+'" onKeyDown="javascript:if(event.keyCode==13) doJump('+page+','+pageInfo.totalPage+');" style="padding:6px 6px;text-align:center"/></li>'+
						'<li><a href="#" onclick="doJump('+page+','+pageInfo.totalPage+');">Go</a></li>'+
						'<li><span>共'+pageInfo.totalCount+'条</span></li>';
		}
		htmlPage +='</ul>';
		jQuery(this).html(htmlPage);
		$('.pagelist a').click(function(){
			pagination($(this).attr('page'));
		});
	};
})(jQuery);