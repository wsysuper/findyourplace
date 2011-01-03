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
     <s:label value="问题："/>
     <s:property value="question.title"/><br>
     <s:label value="问题描述："/>
     <s:property value="question.content"/><br>
     <s:label value="提问人："/>
     <s:property value="question.user.userName"/><br>
     <s:label value="提问日期："/>
     <s:property value="question.pubDate"/><br>
     
     
 <div style ="padding: 3px; border: solid 1px #cccccc; text-align: center" >
  <img src ="UploadImages/<s:property value ="questionFileName" />" />
  <br/>
  <s:property value ="caption" />
  </div >
    	
  <table border="1">
	//<s:iterator id="id" value="resultAnswerList">
    <tr>		
		<td>回答人：</td><td><s:property value="user.userName"/></td>
	</tr>
   <tr>		
		<td>回答日期：</td><td><s:property value="pubDate"/></td>
	</tr>
   <tr>		
		<td>是否为标准答案：</td><td><s:property value="isStandard"/></td>
	</tr>
  <s:label value="答案："/>
  <s:property value="content"/><br>
  <tr>
		<td></td><td><div style ="padding: 3px; border: solid 1px #cccccc; text-align: center" >
  		<img src ="UploadImages/<s:property value ="fileName" />" />
  		</div>
  		</td>
  	</tr>
	//</s:iterator>
	</table>
  </body>
</html>
