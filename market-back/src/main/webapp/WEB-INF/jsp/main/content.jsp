<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%-- 标签页 --%>
<div id="center" data-options="region:'center'">
	<div id="tabs" class="easyui-tabs" data-options="fit:true"></div>
	<%-- 右键菜单 --%>
	<div id="mm" style="width:120px;">
		<div data-options="name:'cur',iconCls:'icon-save'">关闭当前选项卡</div>
		<div data-options="name:'other',iconCls:'icon-save'">关闭其他选项卡</div>
		<div class="menu-sep"></div>
		<div data-options="name:'all',iconCls:'icon-print'">关闭所有</div>
	</div>
</div>