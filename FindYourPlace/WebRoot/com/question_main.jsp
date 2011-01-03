<%@ page language="java" import="java.util.*" contentType = " text/html; charset=utf-8 " pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>

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
		<s:a href="/FindYourPlace/main.action">返回主页</s:a>
		<br>
		  <s:set name="qID"><s:property value="question.questionID"/></s:set>
		  
		 <s:label value="问题：" /><s:property value="question.title" /><br>
		 <s:label value="问题描述：" /><s:property value="question.content" /><br>
		<s:label value="问题类型：" /><s:text name="%{'questionType.'+question.type}" /><br>
		<s:label value="积分悬赏：" /><s:property value="question.reward" /><br>
		<s:label value="提问人：" /><s:property value="question.user.userName" /><br>
		<s:label value="提问日期：" /><s:property value="question.pubDate" /><br>
		<s:if test="%{question.pictureURL!=null}">
			<div
				style="padding: 3px; border: solid 1px #cccccc; text-align: center">
				<img src="UploadImages/<s:property value ="question.pictureURL" />" />
				<br />
			</div>
		</s:if><br><br>
	
	<s:iterator id="id" value="answerList">
	<s:label value="回答人：" /><s:property value="user.userName" /><br>
    <s:label value="回答日期：" /><s:property value="pubDate" /><br>
	<s:label value="是否为标准答案：" /><s:property value="isStandard" /><br>
    <s:label value="答案："/><s:property value="content"/><br>
    <s:if test="%{pictureURL!=null}">
			<div
				style="padding: 3px; border: solid 1px #cccccc; text-align: center">
				<img src="UploadImages/<s:property value ="pictureURL" />" />
				<br />
			</div>
	</s:if><br>
	</s:iterator><br>
	
	
		<s:label value="我来回答：" /><br>
        <s:hidden name="keyWords" value="#session.key"/>
		<s:form action="submitanswer" method = "POST" enctype="multipart/form-data">
			<s:textarea name="answer.content"  value="" label="回答问题" cols="80" rows="10" />		
  			<s:file name="upload" label="上传图片"/>
  			<s:hidden name="question.questionID" value="%{qID}"/>
  			<s:reset value="重置"/>
  			<s:submit value="提交" ></s:submit>
		</s:form>
	</body>
</html>
