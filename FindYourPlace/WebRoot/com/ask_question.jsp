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
        <s:label value="欢迎，"/><s:property value = "#session.user"/><br>
        <s:hidden name="keyWords" value="#session.key"/>
        <s:property value="result"/>
		<s:form action="submitquestion" method = "POST" enctype="multipart/form-data">
			<s:textfield name="question.title" label="问题" value="%{keyWords}"/>
			<s:textarea name="question.content" label="详细描述" cols="50" rows="6" />
			<s:set name="questionTypes" value="#{'1':getText('questionType.1'),'2':getText('questionType.2'), '0':getText('questionType.0')}"/>
			<s:select name="question.type" label="问题类型" list="questionTypes"/>
			<s:textfield name="question.reward" label="积分悬赏" value="0"/>	
   			<s:file name="upload" label="上传图片"/>
			<s:reset value="重置"/>
			<s:submit value="提交" ></s:submit>
		</s:form></body>
</html>
