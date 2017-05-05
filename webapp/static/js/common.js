$(function(){
	if($(".js-example-basic-single").length > 0){
		$(".js-example-basic-single").each(function(){
			if($(this).attr("search")=='-1'){
				$(this).select2({
					minimumResultsForSearch: -1,
					language: "zh-CN"
				});
			}else{
				$(this).select2({
					language: "zh-CN"
				});
			}
		});
	}
	$(".btn-primary.save").click(function(){
		Public.save(this);
	});
	$(".btn-primary.update").click(function(){
		Public.update(this);
	});
});
$.ajaxSetup({
	dataType:"JSON",
    complete:function(XMLHttpRequest,textStatus){
        var sessionstatus=XMLHttpRequest.getResponseHeader("sessionstatus");
        if(sessionstatus=="timeout"){
	        var ctx = XMLHttpRequest.getResponseHeader("ctx");
        	top.location.href= ctx+'/admin/console';
        }
    },
    error: function(XMLHttpRequest, textStatus, errorMsg){
    	if(XMLHttpRequest.status == '404'){
    		alert('抱歉，您访问的页面没有找到。。。');
			//popStatus(4, '抱歉，您访问的页面没有找到。。。', 2);
         	return false;
    	}else if(XMLHttpRequest.status == '500'){
    		alert('出错了！服务器忙，请稍后。。。');
			//popStatus(4, '出错了！服务器忙，请稍后。。。', 3);
         	return false;
    	}else{
    		alert('系统忙，请联系管理员！！！ ');
			//popStatus(4, '系统忙，请联系管理员！！！ ', 2);
         	return false;
    	}
    }
});
function addCookie(objName, objValue, objHours) {
	var str = objName + "=" + escape(objValue);
	if (objHours > 0) {
		var date = new Date();
		var ms = objHours * 3600 * 1000;
		date.setTime(date.getTime() + ms);
		str += "; expires=" + date.toGMTString();
	}
	document.cookie = str;
};
function getCookie(objName) {
	var arrStr = document.cookie.split("; ");
	for (var i = 0; i < arrStr.length; i++) {
		var temp = arrStr[i].split("=");
		if (temp[0] == objName) {
			return unescape(temp[1]);
		}
	}
	return "";
}

var Public = Public || {};
Public.isIE6 = !window.XMLHttpRequest;	//ie6
/*获取URL参数值*/
Public.getRequest = Public.urlParam = function() {
   var param, url = location.search, theRequest = {};
   if (url.indexOf("?") != -1) {
      var str = url.substr(1);
      strs = str.split("&");
      for(var i = 0, len = strs.length; i < len; i ++) {
		 param = strs[i].split("=");
         theRequest[param[0]]=decodeURIComponent(param[1]);
      }
   }
   return theRequest;
};
Public.goAdd = function(url){
	$("#addModal").find(".modelIframe")[0].contentWindow.document.body.innerText = "";
	$("#addModal").find(".modelIframe").attr("src",url);
	$("#addModal").modal("show"); 
};
Public.goEdit = function(url){
	$("#editModal").find(".modelIframe")[0].contentWindow.document.body.innerText = "";
	$("#editModal").find(".modelIframe").attr("src",url);
	$("#editModal").modal("show"); 
};
/*
  通用post请求，返回json
  url:请求地址， params：传递的参数{...}， callback：请求成功回调
*/ 
Public.ajaxPost = function(url, params, callback, errCallback){
	$.ajax({
	   type: "POST",
	   url: url,
	   data: params, 
	   
	   success: function(data, status){  
		   callback(data);  
	   },  
	   error: function(err){  
			errCallback && errCallback(err);
	   }
	});  
};  
Public.ajaxGet = function(url, params, callback, errCallback){    
	$.ajax({  
	   type: "GET",
	   url: url,
	   data: params,    
	   success: function(data, status){  
		   callback(data);  
	   },   
	   error: function(err){  
			errCallback && errCallback(err);
	   }
	});  
};

Public.save = function(that){
	$(that).parent().parent().find(".modelIframe")[0].contentWindow.Public.ajaxInsert();
};
Public.update = function(that){
	$(that).parent().parent().find(".modelIframe")[0].contentWindow.Public.ajaxUpdate();
};

Public.modelShowHide = function(name,showHide){
	$("#"+name).modal(showHide);
};


Public.ajaxInsert = function(){
	$("span[atr='info']").each(function() {
		$(this).html('');
		$(this).removeClass("error");
	});
	var url = $('#data_form').attr("url");
	jQuery.ajax({
		url  : url,
		data : $('#data_form').serialize(),
		type : "POST",
		success : function(result) {
			if (result.code == '0000') {
				window.parent.pagination();
				alert('新增成功！！！');
				window.parent.Public.modelShowHide("addModal","hide");
			}else if (result.code == '1002') {
				$("span[atr='info']").each(function() {
					$(this).html('');
					$(this).hide();
					$(this).removeClass("error");
				});
				$.each(result.data, function(tag, msg) {
					$obj = $("#" + tag).next('span');
					$obj.addClass("error");
					$obj.show();
					$obj.html(msg);
				});
			}else if(result.code == '403'){
				
			}else{
				alert(result.msg);
			}
		}
	});
};

Public.ajaxUpdate = function(url){
	$("span[atr='info']").each(function() {
		$(this).html('');
		$(this).removeClass("error");
	});
	var url = $('#data_form').attr("url");
	jQuery.ajax({
		url  : url,
		data : $('#data_form').serialize(),
		type : "POST",
		success : function(result) {
			if (result.code == '0000') {
				window.parent.pagination();
				alert('编辑成功！！！');
				window.parent.Public.modelShowHide("editModal","hide");
			}else if (result.errMsg) {
				$("span[atr='info']").each(function() {
					$(this).html('');
					$(this).hide();
					$(this).removeClass("error");
				});
				$.each(result.data, function(tag, msg) {
					$obj = $("#" + tag).next('span');
					$obj.addClass("error");
					$obj.show();
					$obj.html(msg);
				});
			}else if(result.code == '403'){
				
			}else{
				alert(result.msg);
			}
		}
	});
};
Public.ajaxDel = function(url,msg){
	if(confirm("确认是否删除!")){
		$.ajax({  
		   type: "Get",
		   url: url,
		   data: null,    
		   success: function(result){  
			   if (result.code == '0000') {
					pagination();
					alert('删除成功！！！');
				}else if(result.code == '403'){
					
				}else{
					alert(result.msg);
				}
		   },   
		   error: function(err){  
				
		   }
		}); 
	}
};

Public.ajaxImport = function(url){
	var idx = loading('操作中。。。');
	jQuery.ajax({
		url  : url,
		data : $('#data_form').serialize(),
		type : "POST",
		success : function(result) {
			layer.close(idx);
			if (result.code == '0000') {
				parent.pagination();
				parent.popStatus(2, result.msg , 5);
				Public.closeDialog();
			}else if (result.errMsg) {
				$("span[id='Validform_checktip']").each(function() {
					$(this).html('');
					$(this).attr("class", "Validform_right");
				});
				$.each(result.errMsg, function(tag, msg) {
					$obj = $("#" + tag).next('span');
					$obj.attr("class", "Validform_wrong");
					$obj.html(msg);
				});
			}else{
				popStatus(4, result.msg, 2);
			}
		}
	});
};