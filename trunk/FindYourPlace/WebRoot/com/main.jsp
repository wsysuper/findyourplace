<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>Find Your Place 主页</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
		<br>
		<s:label value="欢迎，" />
		<s:property value="#session.user.userName" />
		<br>
		<s:label value="Find Your Place" />
		<br>
		<s:form action="submitquestion">
			<!--搜索做好后action应为搜索的action名-->
			<s:textfield name="keyWords" />
			<s:submit value="搜索" />
			<s:submit value="我要提问" action="askquestion" />
		</s:form>
		<br>
	</body>
</html>
