<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="code.model.Question"%>

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

		<title>My JSP 'search_result.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<<<<<<< .mine
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
  <s:hidden name="keyWords" value="#session.key"/>
		<s:form action="submitanswer" method = "POST" enctype="multipart/form-data">
			 <s:textarea name="answer.content" label="回答问题" cols="80" rows="10" />		
  			<s:file name="upload" label="上传图片"/>
  			<s:textfield name="caption" label="图片名"/>
  			<s:reset value="重置"/>
  			<s:submit value="提交" ></s:submit>
		</s:form>
	</s:iterator>
	</table>
=======
	</head>

	<body>
		<table border="1">
			<s:iterator id="qid" value="resultQuestionList">
				<tr>
					<s:url id="url" action="showquestion">
						<s:param name="questionID" value="#qid.questionID" />
					</s:url>
					<td>
						问题:
					</td>
					<td>
						<s:a href="%{url}">
							<s:property value="title" />
						</s:a>
					</td>
				</tr>
				<tr>
					<td>
						问题描述：
					</td>
					<td>
						<s:property value="content" />
					</td>
				</tr>
<!--	<tr>-->
				<!--		<td>提问人：</td><td><s:property value="curQuestion.user.userName"/></td>-->
				<!--	</tr>-->
				<!--	<tr>-->
				<!--		<td>提问日期：</td><td><s:property value="curQuestion.pubDate"/></td>	-->
				<!--	</tr>-->
				<tr>
					<td></td>
					<td>
						<div
							style="padding: 3px; border: solid 1px #cccccc; text-align: center">
							<img src="UploadImages/<s:property value ="pictureURL" />" />
						</div>
					</td>
				</tr>
			</s:iterator>
			<s:iterator id="id" value="resultAnswerList">
			</s:iterator>
		</table>
		共
		<s:property value="totalPage" />
		页 当前第
		<s:property value="page+1" />
		页
		<br />

		<s:if test="%{page = 0}">
		</s:if>
		<s:else>
			<a href="turnPage.action?page=1">第一页</a>
			<a href="turnPage.action?page=<s:property value="%{page-1}"/>">上一页</a>
		</s:else>
		<s:if test="%{page != totalPage-1}">
			<a href="turnPage.action?page=<s:property value="%{page+1}"/>">下一页</a>
			<a href="turnPage.action?page=<s:property value="totalPage"/>">最后一页</a>
		</s:if>
		<s:else> 
　　		下一页 最后一页 
	</s:else>
>>>>>>> .r19
	</body>
</html>
