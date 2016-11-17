<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%-- 左侧 --%>
<div id="west" data-options="region:'west',title:'机票系统',collapsible:true">
	<ul id="menu" class="easyui-tree">
		<li data-options="iconCls:'icon-large-chart'"><span>业务管理</span>
			<ul>
				<li data-options="iconCls:'icon-man'" >
					<span><span onclick="addTab('订单管理','${baseUrl}order/goOrder');" >订单管理</span></span>
				</li>
				<li data-options="iconCls:'icon-man'" >
					<span><span onclick="addTab('票号状态','${baseUrl}order/goOrderStatus');" >票号状态</span></span>
				</li>
				<c:if test="${sessionUser.userName == 'admin'}">
				<li data-options="iconCls:'icon-man'">
					<span><span onclick="addTab('政策管理','${baseUrl}policy/goPolicy');">政策管理</span></span>
				</li>
				</c:if>
			</ul>
		</li>
	</ul>
</div>