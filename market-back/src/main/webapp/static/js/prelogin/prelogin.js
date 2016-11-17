
var baseUrl = $("base").attr("href");

$(function(){
	var top = getTopWinow();
	top.location.href = baseUrl + 'login/goLogin';
});

