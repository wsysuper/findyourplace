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
		<div class="login">
			<s:property value="loginResult" />
			<s:form action="login">
				<table width="300" height="200" border="0" cellpadding="0"
					cellspacing="0" class="tableForm">
					<tr>
						<td colspan="2" align="left">
							<p class="loginRegTitle">
								Find Your Place 登录
							</p>
						</td>
					</tr>
					<tr>
						<s:textfield name="user.userName" label="用户名" />
					</tr>
					<tr>
						<s:password name="user.userPassword" label="密码" />
					</tr>
					<tr>
						<td align="center">
							<s:submit value="登录" cssStyle="font-size:15px;float:left" />
						</td>

					</tr>
				</table>
			</s:form>
		</div>
	</body>
</html>
