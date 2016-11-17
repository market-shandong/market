<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<% String baseUrl = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";%>
<script type="text/javascript">location.href = "<%=baseUrl%>login/goLogin";</script>