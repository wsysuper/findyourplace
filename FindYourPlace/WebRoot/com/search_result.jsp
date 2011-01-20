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
	</head>
	
	<script>
	function attachXMenu(objid){
	var tds=objid.getElementsByTagName('td');
	for(var i=0;i<tds.length;i++){
		with(tds[i]){
			onmouseover=function(){
				with(this){
					filters[0].apply();
					style.background='#3ea936'; //这是鼠标移上去时的背景颜色
					style.border='1px solid #ffffff'; //边框
					style.color='#ffffff'; //文字颜色
					filters[0].play();
				}
			}
			onmouseout=function(){
				with(this){
					filters[0].apply();
					style.background='#f6f6f6'; //这是鼠标离开时的背景颜色
					style.border='1px solid #ffffff'; //边框
					style.color='#333333'; //文字颜色
					filters[0].play();
				}
			}
		}
	}
}
</script>
	<style>
.mytable {border-collapse:collapse;border:solid #6AA70B;border-width:0px 0 0 0px;width:50%;}
.mytable ul li {padding-top:5px;text-indent:2em;list-style:none;background:url(http://www.blueidea.com/img/common/new_flash.gif) 3px 50% no-repeat;border-bottom:#6AA70B 1px dotted ;font-family: "Verdana,宋体";font-size: 12px;color:#008000;text-align:left;height:25px;}
.mytable ul li.t1 {background-color:#EFFEDD;}/* 第一行的背景色 */
.mytable ul li.t2{background-color:#ffffff;}/* 第二行的背景色 */
.mytable ul li.t3 {background-color:#D2FCA0;}/* 鼠标经过时的背景色 */
.xmenu td{font-size:12px;font-family:verdana,arial;font-weight:none;color:#333333;border:1px solid #ffffff;background:#f6f6f6;filter:blendtrans(duration=0.5);cursor:hand;text-align:center;}

</style>
	<body style=margin:0;>
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
            <td width="87" align="center" bgcolor="EFEFEF"><a href="/FindYourPlace/main.action"><img src="images/i_1.gif" width="9" height="17" border="0"></a><img src="images/i_sp.gif" width="1" height="17" style="margin-left:9px; margin-right:9px "><a href="#"><img src="images/i_2.gif" width="10" height="17" border="0"></a><img src="images/i_sp.gif" width="1" height="17" style="margin-left:9px; margin-right:9px "><a href="#"><img src="images/i_3.gif" width="11" height="17" border="0"></a></td>
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
              <tr></tr>
              <td>
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



</script>
				</td>
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
<!--	<body style=margin:0;>-->
<!--	<div align="center">-->
<!--				<table border="1" width="100%" cellpadding="0" style="border-collapse: collapse" height="30" id="table4" bgcolor=#DBDBDB bordercolor="#DBDBDB" cellspacing="0">-->
<!--					<tr>-->
<!--						<td>-->
<!--						<div align="center">-->
<!--							<table class="xmenu" id="xmenu0" border="0" width="100%" cellspacing="3" cellpadding="3" height="30" id="table5">-->
<!--								<tr>-->
<!--									<td onclick="window.open('http://www.qpsh.com',   '_blank');">首  页</td>-->
<!--								</tr>-->
<!--							</table><script>attachXMenu(xmenu0); //在上面这个table结束的地方执行事件动作的绑定, 这里的这个xmenu0就是那个table的id</script>-->
<!--						</div>-->
<!--						</td>-->
<!--					</tr>-->
<!--				</table>-->
<!--			</div>-->
<!--	<br><br><br>-->
<!--	<div align="center">-->
<!--	<div class=mytable id=tab>-->
<!--	<ul>-->
		<table>
<!--			<s:iterator id="qid" value="resultQuestionList">-->
<!--				<tr>-->
<!--					<s:url id="url" action="showquestion">-->
<!--						<s:param name="questionID" value="#qid.questionID" />-->
<!--					</s:url>-->
<!--					<li>-->
<!--						问题:-->
<!--						<s:a href="%{url}">-->
<!--							<s:property value="title" />-->
<!--						</s:a>-->
<!--					</li>-->
<!--				</tr>-->
<!--				<tr>-->
<!--					<li>-->
<!--						问题描述：-->
<!--						<s:property value="content" />-->
<!--					</li>-->
<!--				</tr>-->
					<tr>
						<td>提问人：</td><td><s:property value="curQuestion.user.userName"/></td>
					</tr>
					<tr>
						<td>提问日期：</td><td><s:property value="curQuestion.pubDate"/></td>	
					</tr>
<!--			</s:iterator>-->
		</table>
<!--		</ul>-->
<!--		</div>-->
<!--		共-->
<!--		<s:property value="totalPage" />-->
<!--		页 当前第-->
<!--		<s:property value="page+1" />-->
<!--		页-->
<!--		<br>-->
<!---->
<!--		<s:if test="%{page = 0}">-->
<!--		</s:if>-->
<!--		<s:else>-->
<!--			<a href="turnPage.action?page=1">第一页</a>-->
<!--			<a href="turnPage.action?page=<s:property value="%{page-1}"/>">上一页</a>-->
<!--		</s:else>-->
<!--		<s:if test="%{page != totalPage-1}">-->
<!--			<a href="turnPage.action?page=<s:property value="%{page+1}"/>">下一页</a>-->
<!--			<a href="turnPage.action?page=<s:property value="totalPage"/>">最后一页</a>-->
<!--		</s:if>-->
<!--		<s:else> -->
<!--　　		下一页 最后一页 -->
<!--	</s:else>-->
<!--	<script type="text/javascript">-->
<!---->
<!--var Ptr=document.getElementById("tab").getElementsByTagName("li");-->
<!--function $() {-->
<!--      for (i=1;i<Ptr.length+1;i++) { -->
<!--      Ptr[i-1].className = (i%2>0)?"t1":"t2"; -->
<!--      }-->
<!--}-->
<!--window.onload=$;-->
<!--for(var i=0;i<Ptr.length;i++) {-->
<!--      Ptr[i].onmouseover=function(){-->
<!--      this.tmpClass=this.className;-->
<!--      this.className = "t3";    -->
<!--      };-->
<!--      Ptr[i].onmouseout=function(){-->
<!--      this.className=this.tmpClass;-->
<!--      };-->
<!--}-->
<!---->
<!---->
<!---->
<!--</script>-->
<!--	-->
<!--	</body>-->
<!--</html>-->
