<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<base href="${baseUrl}">
	<title>机票管理系统</title>
	<%@include file="../common/common-css.jsp" %>
	<link rel="stylesheet" href="static/css/policy/policy.css" />
</head>

<body class="easyui-layout" data-options="fit:true">
	<%-- 搜索部分 --%>
	<div id="search-box">
		<div id="search-table">
			<div id="search-tr">
				<div class="title">供应商：</div>
				<div class="data"><input class="easyui-textbox" style="width:99%" id="vendor"/></div>
				<div class="title">CID：</div>
				<div class="data"><input class="easyui-textbox" style="width:99%" id="cid"/></div>
				<div class="title">行程类型：</div>
				<div class="data">
					<select id="tripType" class="easyui-combobox" panelHeight="auto" style="width:99%;">
						<option value="all">全部</option>
						<option value="oneway">单程</option>
						<option value="roundway">往返</option>
					</select>
				</div>
				<div class="title">是否有效：</div>
				<div class="data">
					<select id="isValid" class="easyui-combobox" panelHeight="auto" style="width:99%;">
						<option value="all">全部</option>
						<option value="1">有效</option>
						<option value="0">无效</option>
					</select>
				</div>
			</div>
		</div>
		
		<div id="search-submit">
			<a id="search" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>
			<a id="clear" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">清空</a>
		</div>
		
		<div id="search-toolbar">
			<a id="addPolicy" class="easyui-linkbutton c1" iconCls="icon-add" onclick="addPolicy();">添加政策</a>
			<a id="delPolicy" class="easyui-linkbutton c5" iconCls="icon-remove" onclick="delPolicy();">删除政策</a>
			<a id="delPolicy" class="easyui-linkbutton c8" iconCls="icon-reload" onclick="refreshPolicy();">更新到缓存</a>
		</div>
		
	</div>
	
	<%-- 数据部分 --%>
	<div id="center" data-options="region:'center'" style="background-color: red;">
		<table id="policyList" data-options=""></table>
	</div>
	
	<%@include file="../common/common-js.jsp" %>
	<script type="text/javascript" src="static/js/policy/policy.js"></script>
</body>
</html>
