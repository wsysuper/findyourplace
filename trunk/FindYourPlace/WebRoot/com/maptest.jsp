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

		<title>登录</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" rev="stylesheet" type="text/css"
			href="styles.css" media="all" />

	</head>

	<body>
			<s:form action="Googlemap">
				<table width="300" height="200" border="0" cellpadding="0"
					cellspacing="0" class="tableForm">
					<tr>
						<td colspan="2" align="left">
							<p class="loginRegTitle">
								Map ID
							</p>
						</td>
					</tr>
					<tr>
						<s:textfield name="mapID" label="地图ID" />
					</tr>
					<tr>
						<td align="center">
							<s:submit cssStyle="font-size:15px;float:left" />
						</td>

					</tr>
				</table>
			</s:form>
<!--
		<s:action name="Googlemap" executeResult="true"></s:action>
-->
  	</body>
</html>
