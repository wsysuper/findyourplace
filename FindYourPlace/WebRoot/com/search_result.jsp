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
	</head><body>
	<style>
.mytable {border-collapse:collapse;border:solid #6AA70B;border-width:0px 0 0 0px;width:50%;}
.mytable ul li {padding-top:5px;text-indent:2em;list-style:none;background:url(http://www.blueidea.com/img/common/new_flash.gif) 3px 50% no-repeat;border-bottom:#6AA70B 1px dotted ;font-family: "Verdana,宋体";font-size: 12px;color:#008000;text-align:left;height:25px;}
.mytable ul li.t1 {background-color:#EFFEDD;}/* 第一行的背景色 */
.mytable ul li.t2{background-color:#ffffff;}/* 第二行的背景色 */
.mytable ul li.t3 {background-color:#D2FCA0;}/* 鼠标经过时的背景色 */
</style>
	
	<body style=margin:0;><br><br><br>
	<div align="center">
	<div class=mytable id=tab>
	<ul>
<!--		<table>-->
			<s:iterator id="qid" value="resultQuestionList">
				<tr>
					<s:url id="url" action="showquestion">
						<s:param name="questionID" value="#qid.questionID" />
					</s:url>
					<li>
						问题:
						<s:a href="%{url}">
							<s:property value="title" />
						</s:a>
					</li>
				</tr>
				<tr>
					<li>
						问题描述：
						<s:property value="content" />
					</li>
				</tr>
				<!--	<tr>-->
				<!--		<td>提问人：</td><td><s:property value="curQuestion.user.userName"/></td>-->
				<!--	</tr>-->
				<!--	<tr>-->
				<!--		<td>提问日期：</td><td><s:property value="curQuestion.pubDate"/></td>	-->
				<!--	</tr>-->
			</s:iterator>
<!--		</table>-->
		</ul>
		</div>
		共
		<s:property value="totalPage" />
		页 当前第
		<s:property value="page+1" />
		页
		<br>

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
	<script type="text/javascript">
<!--
var Ptr=document.getElementById("tab").getElementsByTagName("li");
function $() {
      for (i=1;i<Ptr.length+1;i++) { 
      Ptr[i-1].className = (i%2>0)?"t1":"t2"; 
      }
}
window.onload=$;
for(var i=0;i<Ptr.length;i++) {
      Ptr[i].onmouseover=function(){
      this.tmpClass=this.className;
      this.className = "t3";    
      };
      Ptr[i].onmouseout=function(){
      this.className=this.tmpClass;
      };
}
//-->
</script>
	
	</body>
</html>
