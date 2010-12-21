<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="code.model.Question" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
   	<table>
	<struts:iterator id="question" value="resultList">
		<tr>
			<td><a href="showinfo.action?bookid=<struts:property value="%{#book.bid}"/>">${question.title}</a></td>	
			<s:label value="问题"/>
			<s:property value="question.title"/><br>
			<s:label value="问题描述："/>
			<s:property value="question.content"/><br>
			<s:label value="提问人："/><br>
			<s:property value="question.user.userName"/><br>
			<s:label value="提问日期："/><br>
			<s:property value="question.pubDate"/><br>
		</tr>
	</struts:iterator>
</table>
  </body>
</html>
