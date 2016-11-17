<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";%>
<script type="text/javascript">var top = window;while(top != top.parent)top = top.parent;top.location.href = "<%=basePath%>login/goLogin";</script>
