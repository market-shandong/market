<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<base href="${baseUrl}">
	<title>机票管理系统</title>
	<%@include file="../common/common-css.jsp" %>
	<link rel="stylesheet" href="static/css/order/order_status.css" />
</head>

<body class="easyui-layout" data-options="fit:true" style="background-corlor:red;">
	<%-- 搜索部分 --%>
	<div id="search-box">
		<div id="search-table">
			<div id="search-tr">
				<div class="title">启程时间：</div>
				<div class="data"><input id="fromDate" type="text" class="easyui-datebox" style="width:48%;" /></div>
				<div class="title">回程时间：</div>
				<div class="data"><input id="retDate" type="text" class="easyui-datebox" style="width:48%;" /></div>
			</div>
		</div>
		<div id="search-submit">
			<a id="search" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>
			<a id="clear" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">清空</a>
		</div>
	</div>
	
	<%-- 数据部分 --%>
	<div id="center" data-options="region:'center'" style="background-color: red;">
		<table id="orderList" data-options=""></table>
	</div>
	
	<%@include file="../common/common-js.jsp" %>
	<script type="text/javascript" src="static/js/order/order_status.js"></script>
</body>
</html>
