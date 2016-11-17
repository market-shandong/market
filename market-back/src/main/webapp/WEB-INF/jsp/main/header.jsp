<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%-- 头部 --%>
<div id="north" data-options="region:'north'">
	<div id="imgDiv">
		<a href="http://www.diandong100.com" target="_blank"><img id="img_logo" alt="logo" src="static/images/main_logo.png"></a>
		<img id="img_caption" alt="logo" src="static/images/main_caption.png">
	</div>
	
	<div id="userInfo">
		<span><a class="easyui-linkbutton c1" data-options="iconCls:'icon-man'" >用户：${sessionUser.userName}</a></span>&nbsp;
		<span><a class="easyui-linkbutton c5" style="width:100px;" id="exit" href="${baseUrl}login/logout">退出</a></span>
	</div>
</div>
