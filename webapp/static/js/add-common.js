$(function(){
	$("[atr='info']").each(function(){
		if($(this).text()==''){
			$(this).hide();
		}
	});
});