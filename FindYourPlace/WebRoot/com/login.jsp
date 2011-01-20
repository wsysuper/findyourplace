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
<body onload="initialize()">
<table width="739" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="281" valign="top"><table width="683" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="30" valign="top"><img src="images/spacer.gif" width="1" height="1"></td>
      </tr>
      <tr>
        <td height="29" valign="top"><table width="683" height="28" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="360" bgcolor="EFEFEF" class="top"><table width="360" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="31"><img src="images/sh_1.gif" width="9" height="10" style="margin-left:15px "></td>
                <td width="329"></td>
              </tr>
            </table></td>
            <td width="236"><img src="images/spacer.gif" width="1" height="1"></td>
            <td width="87" align="center" bgcolor="EFEFEF"><a href="index.html"><img src="images/i_1.gif" width="9" height="17" border="0"></a><img src="images/i_sp.gif" width="1" height="17" style="margin-left:9px; margin-right:9px "><a href="#"><img src="images/i_2.gif" width="10" height="17" border="0"></a><img src="images/i_sp.gif" width="1" height="17" style="margin-left:9px; margin-right:9px "><a href="#"><img src="images/i_3.gif" width="11" height="17" border="0"></a></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td valign="top"><table width="683" height="222" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td width="187" valign="top"><img src="images/logo.gif" width="187" height="222"></td>
            <td width="174" align="right" valign="top" background="images/menu_bg.gif"><table width="151" border="0" cellspacing="0" cellpadding="0">
              <tr>
              </tr>
              <tr>
              </tr>
              <tr>
              </tr>
              <tr>
              </tr>
              <tr>
              </tr>
              <tr>
              </tr>
              <tr>
              </tr>
              <tr>
              </tr>
              <tr>
              </tr>
              <tr>
              </tr>
              <tr>
              </tr>
              <tr>
              </tr>
            </table></td>
            <td width="322" valign="top" background="images/bgs_1.jpg"><img src="images/text_1.gif" width="166" height="50" style="margin-left:16px; margin-top:157px "></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="480" valign="top"><table width="739" height="100%" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="360" height="100%" valign="top" style="padding-top:1px "><table width="360" height="100%" border="0" cellpadding="0" cellspacing="0">
          <tr>
          <tr>
            <td height="100%" valign="top" bgcolor="EFEFEF"><table width="360" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="27" valign="top"><img src="images/spacer.gif" width="1" height="1"></td>
              </tr>
              <tr>
                <td height="38" valign="top" style="padding-left:23px "><img src="images/tit_1.gif" width="122" height="17"></td>
              </tr>
              <tr>
                <td height="135" valign="top"><table width="360" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="20"><img src="images/spacer.gif" width="1" height="1"></td>
                    <td width="230" valign="top"><table width="230" border="0" cellspacing="0" cellpadding="0">
                    </table></td>
                    
                  </tr>
                </table></td>
              </tr>
              <tr>
              <td>
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
				</td>
				</tr>
              <tr>
                <td height="24" align="center" valign="top"><img src="images/ln_1.gif" width="335" height="1"></td>
              </tr>
              <tr>
                <td valign="top"><table width="360" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="20"><img src="images/spacer.gif" width="1" height="1"></td>
                    <td width="230" valign="top"><table width="230" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                        </tr>
                    </table></td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
        <td width="22" valign="top"><img src="images/spacer.gif" width="1" height="1"></td>
        <td width="357" height="100%" valign="top">
          <tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
    </table>
 

</body>
</html>
