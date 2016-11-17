<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<base href="${baseUrl}">
	<title>机票管理系统</title>
	<%@include file="../common/common-css.jsp" %>
	<link rel="stylesheet" href="static/css/order/order.css" />
</head>

<body class="easyui-layout" data-options="fit:true" style="background-corlor:red;">
	<%-- 搜索部分 --%>
	<div id="search-box">
		<div id="search-table">
			<div id="search-tr">
				<div class="title">时间：</div>
				<div class="data"><input id="startDate" type="text" class="easyui-datebox" style="width:48%;"></input>-<input id="endDate" type="text" class="easyui-datebox" style="width:48%;"></input></div>
				<div class="title">订单号：</div>
				<div class="data"><input class="easyui-textbox" style="width:99%" id="orderNo"/></div>
				<div class="title">CID：</div>
				<div class="data"><input class="easyui-textbox" style="width:99%" id="cid"/></div>
				<div class="title">PNR：</div>
				<div class="data"><input class="easyui-textbox" style="width:99%" id="pnr"/></div>
			</div>
			<div id="search-tr">
				<div class="title">订单状态：</div>
				<div class="data">
					<select id="orderStatus" class="easyui-combobox" panelHeight="auto" style="width:99%;">
						<option value="all">全部</option>
						<option value="unpay">未支付</option>
						<option value="unticket">待出票</option>
						<option value="ticketed">已出票</option>
					</select>
				</div>
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
	<script type="text/javascript" src="static/js/order/order.js"></script>
</body>
</html>
