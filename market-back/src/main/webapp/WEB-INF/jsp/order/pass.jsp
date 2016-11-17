<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<base href="${baseUrl}">
	<title>机票管理系统</title>
	<%@include file="../common/common-css.jsp" %>
	<link rel="stylesheet" href="static/css/order/pass.css" />
</head>

<body class="easyui-layout" data-options="fit:true" style="background-corlor:red;">

	<%-- 数据部分 --%>
	<div id="center" data-options="region:'center'">
		<table id="passList" data-options=""></table>
	</div>

	<input type="hidden" id="order_id" value="${order_id}">
	
	<%@include file="../common/common-js.jsp" %>
	<script type="text/javascript" src="static/js/layer/layer.js"></script>
	<script type="text/javascript" src="static/js/order/pass.js"></script>
</body>
</html>
