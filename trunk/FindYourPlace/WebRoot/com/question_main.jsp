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

		<title>问题</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css" href="/styles.css">

	</head>

	<body class="main">
		<!--<s:a href="https://casserver:60462/cas/logout">退出</s:a>-->
		<br>
		<s:a href="/FindYourPlace/com/main.jsp">返回主页</s:a>
		<br>
		<s:label value="问题：" />
		<s:property value="question.title" />
		<br>
		<s:label value="问题描述：" />
		<s:property value="question.content" />
		<br>
		<s:label value="问题类型：" />
		<s:text name="%{'questionType.'+question.type}" />
		<br>
		<s:label value="积分悬赏：" />
		<s:property value="question.reward" />
		<br>
		<s:label value="提问人：" />
		<s:property value="question.user.userName" />
		<br>
		<s:label value="提问日期：" />
		<s:property value="question.pubDate" />
		<br>
		<s:if test="%{question.pictureURL!=null}">
			<div
				style="padding: 3px; border: solid 1px #cccccc; text-align: center">
				<img src="UploadImages/<s:property value ="question.pictureURL" />" />
				<br />
			</div>
		</s:if>
	</body>
</html>
