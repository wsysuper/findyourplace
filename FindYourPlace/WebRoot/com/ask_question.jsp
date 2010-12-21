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
        <s:label value="欢迎，"/><s:property value = "#session.user.userName"/><br>
        <s:hidden name="keyWords" value="#session.key"/>
		<s:form action="submitquestion" method = "POST" enctype="multipart/form-data">
			<s:textfield name="question.title" label="问题" value="%{keyWords}"/>
			<s:textarea name="question.content" label="详细描述" cols="50" rows="6" />			
   			<s:file name="upload" label="上传图片"/>
  			<s:textfield name="caption" label="图片名"/>
			<s:reset value="重置"/>
			<s:submit value="提交" ></s:submit>
		</s:form></body>
</html>
