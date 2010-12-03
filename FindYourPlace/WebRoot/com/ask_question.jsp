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
		<title>Find Your Place - 提问</title>
	<link rel="stylesheet" type="text/css" href="/styles.css">

	</head>

	<body class="main">
        <s:label value="欢迎，"/><s:property value = "user.userName"/><br>
		<s:form action="askquestion">
			<s:textfield name="question.title" label="标题" />
			<s:textarea name="question.content" label="内容" cols="50" rows="6" />
			<s:reset value="清空" />
			<s:submit value="提交" ></s:submit>
		</s:form></body>
</html>
