
var baseUrl = $("base").attr("href");

/***回车事件*/
$('#password').keydown(function(e){
	if(e.keyCode == 13){
		login();
	}
});

/***提交登陆*/
$("#btn-login").click(login);

/***登录*/
function login(){
	var user_name = $("#username").val();
	var user_pass = $("#password").val();
	
	if (null == user_name || "" == user_name){
		$("#tip").html("用户名不能为空");
		return;
	}
	
	if (null == user_pass || "" == user_pass){
		$("#tip").html("密码不能为空");
		return;
	}
	
	$.ajax({
		url:baseUrl + "login/doLogin",
		data:$("#form").serialize(),
		type:'POST',
		dataType:'json',
		async:false,
		cache:false,
		success:function(retVal){
			if (retVal.code == '0'){
				location.href = baseUrl + "main/goMain";
			}else{
				$("#tip").html(retVal.msg);
			}
		}
	});
}

/***清空提示的错误信息*/
function changeTxt(){
	$("#tip").html("");
}

