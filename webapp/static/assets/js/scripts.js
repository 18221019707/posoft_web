
jQuery(document).ready(function() {
    
    /*
        Form validation
    */
    $('.login-form input[type="text"], .login-form input[type="password"], .login-form textarea').on('focus', function() {
    	$(this).removeClass('input-error');
    	$(".msg").text("请输入用户名密码登录");
		$(".msg").css("color","#fff");
    });
    
    $('#submit').on('click', function(e) {
    	$(this).find('input[type="text"], input[type="password"], textarea').each(function(){
    		if( $(this).val() == "" ) {
    			e.preventDefault();
    			$(this).addClass('input-error');
    		}
    		else {
    			$(this).removeClass('input-error');
    		}
    	});
    	var param = $(".login-form").serialize();
    	var url = $(".login-form").attr("action");
    	$.ajax({
    		type : "post",
    		url : url,
    		data : param,
    		dataType : "json",
    		success:function(result){
    			if(result.code=="0000"){
    				window.location.href = window.location.href;
    			}else{
    				$(".msg").text(result.msg);
    				$(".msg").css("color","#de615e");
    			}
    		},
    		error:{
    			
    		}
    	});
    	
    });
    
    
});
