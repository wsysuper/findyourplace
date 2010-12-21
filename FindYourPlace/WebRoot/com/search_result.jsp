<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="code.model.Question" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'search_result.jsp' starting page</title>
    
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
  <table border="1">
	<s:iterator id="id" value="resultQuestionList">
	
	<tr>
		<td>问题:</td><td><s:property value="title"/></td>
	</tr>
	<tr>		
		<td>问题描述：</td><td><s:property value="content"/></td>
	</tr>
	<tr>
		<td>提问人：</td><td><s:property value="user.userName"/></td>
	</tr>
	<tr>
		<td>提问日期：</td><td><s:property value="pubDate"/></td>	
	</tr>
	<tr>
		<td></td><td><div style ="padding: 3px; border: solid 1px #cccccc; text-align: center" >
  		<img src ="UploadImages/<s:property value ="pictureURL" />" />
  		</div>
  		</td>
  	</tr>
	</s:iterator>
	</table>
  </body>
</html>
