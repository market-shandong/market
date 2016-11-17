<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
	<base href="${baseUrl}">
	<title>机票管理系统</title>
	<%@include file="../common/common-css.jsp" %>
	<link rel="stylesheet" href="static/css/main/main.css" />
</head>

<body class="easyui-layout" data-options="fit:true">
	<%@include file="header.jsp" %>
	<%@include file="left.jsp" %>
	<%@include file="content.jsp" %>
	<%@include file="footer.jsp" %>
	
	<%@include file="../common/common-js.jsp" %>
	<script type="text/javascript" src="static/js/main/main.js"></script>
</body>
</html>
