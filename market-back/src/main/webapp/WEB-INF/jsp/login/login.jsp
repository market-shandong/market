<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html >
<html>
<head>
	<base href="${baseUrl}">
	<title>登录</title>
	<link href="static/css/login/login.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="login">
		<form action="" method="post" id="form">
			<div class="logo"></div>
			<div class="login_form">
				<div class="user">
					<input value="" oninput="changeTxt();" class="text_value" value="" name="usr" type="text" id="username" placeholder="用户名" />
					<input value="" oninput="changeTxt();" class="text_value" value="" name="pwd" type="password" id="password" placeholder="密码" />
				</div>
				<button class="button" id="btn-login" type="button">登录</button>
			</div>
			<div id="tip"></div>
			<div class="foot">版权 &copy; 2016<a id="diandong" target="_blank" href="http://www.diandong100.com"> 点动创想</a> 保留所有权利</div>
		</form>
	</div>
	<script type="text/javascript" src="static/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="static/js/login/login.js"></script>
</body>
</html>