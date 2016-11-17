<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<base href="${baseUrl}">
	<title>机票管理系统</title>
	<%@include file="../common/common-css.jsp"%>
	<link rel="stylesheet" href="static/css/policy/policy_add.css" />
</head>

<body class="easyui-layout" data-options="fit:true">
	<div class="easyui-panel" data-options="fit:true,region:'center'" title="<div style='width:100%;text-align:center;'>添加政策</div>">
		<div id="formBox">
			<form id="ff" method="post">
				<table id="tab">
					<tr>
						<td>CID:</td>
						<td><input class="easyui-textbox" style="width: 100%;" data-options="required:true" name="cid" id="cid" ></input></td>
					</tr>
					<tr>
						<td>供应商:</td>
						<td><input class="easyui-textbox" style="width: 100%;" data-options="required:true" name="vendor" id="vendor"></input></td>
					</tr>
					<tr>
						<td>开始延迟:</td>
						<td><input class="easyui-numberbox" style="width: 100%;" data-options="required:true" name="begdelay" id="begdelay"></input></td>
					</tr>
					<tr>
						<td>结束延迟:</td>
						<td><input class="easyui-numberbox" style="width: 100%;" data-options="required:true" name="enddelay" id="enddelay"></input></td>
					</tr>
					<tr>
						<td>加价:</td>
						<td><input class="easyui-numberbox" style="width: 100%;" data-options="required:true" name="add_price" id="add_price"></input></td>
					</tr>
					<tr>
						<td>减价:</td>
						<td><input class="easyui-numberbox" style="width: 100%;" data-options="required:true" name="sub_price" id="sub_price"></input></td>
					</tr>
					<tr>
						<td>加价比率:</td>
						<td><input class="easyui-numberbox" style="width: 100%;" data-options="required:true,precision:2" name="add_ratio" id="add_ratio"></input></td>
					</tr>
					<tr>
						<td>加价百分比:</td>
						<td><input class="easyui-numberbox" style="width: 100%;" data-options="required:true,precision:2" name="add_percent" id="add_percent"></input></td>
					</tr>
					<tr>
						<td>缓存阀值:</td>
						<td><input class="easyui-numberbox" style="width: 100%;" data-options="required:true" name="cache_price" id="cache_price"></input></td>
					</tr>
					<tr>
						<td>变价阀值:</td>
						<td><input class="easyui-numberbox" style="width: 100%;" data-options="required:true" name="change_price" id="change_price"></input></td>
					</tr>
					<tr>
						<td>数据源:</td>
						<td><input class="easyui-textbox" style="width: 100%;" data-options="required:true" name="data_source" id="data_source"></input></td>
					</tr>
					<tr>
						<td>是否有效:</td>
						<td>
							<select id="is_valid" class="easyui-combobox" name="is_valid" data-options="editable:false" panelHeight="auto" style="width:100%;">
								<option selected value="1">是</option>
								<option value="0">否</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>行程类型:</td>
						<td>
							<select id="trip_type" class="easyui-combobox" name="trip_type" data-options="editable:false" panelHeight="auto" style="width:100%;">
								<option selected value="oneway">单程</option>
								<option value="roundway">往返</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>ota类型:</td>
						<td><input class="easyui-textbox" style="width: 100%;" data-options="required:false" name="ota_type" id="ota_type"></input></td>
					</tr>
					<tr>
						<td>ota名字:</td>
						<td><input class="easyui-textbox" style="width: 100%;" data-options="required:false" name="ota_name" id="ota_name"></input></td>
					</tr>
				</table>
			</form>
			<div id="submit">
				<a href="javascript:void(0)" class="easyui-linkbutton c1" id="sub">提交</a> 
				<a href="javascript:void(0)" class="easyui-linkbutton c7" id="clear">清除</a>
				<a href="javascript:void(0)" class="easyui-linkbutton c5" id="exit">退出</a>
			</div>
		</div>

		<%@include file="../common/common-js.jsp"%>
		<script type="text/javascript" src="static/js/policy/policy_add.js"></script>
</body>
</html>
