<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'search.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no" /> 
	<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=true"></script> 
	<script type="text/javascript">  
	function initialize() {     
	var latlng = new google.maps.LatLng(-34.397, 150.644);     
	var myOptions = {       
	zoom: 8, center: latlng, 
	mapTypeId: google.maps.MapTypeId.ROADMAP     };     
	var map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);  
	 google.maps.event.addListener(map, 'click', function(event) {     
	 placeMarker(event.latLng,map);   
	 });  
	 }
	 function placeMarker(location,map) {   
	 var clickedLocation = new google.maps.LatLng(location,map);   
	 var marker = new google.maps.Marker({       position: location,        map: map   });   
	 map.setCenter(location); 
	 document.getElementById("lat").value = location.lat();
	 document.getElementById("lng").value = location.lng();
	 
	 }
	</script> 
  </head>
  <script>
function redirectJS()
{
 //window.location="http://www.yahoo.com";
 // window.location.href="http://www.yahoo.com";
 window.location.replace("http://www.google.com"); //not create entry in history
}
</script>
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
              <tr></tr>
              <td>
              <s:form action="submitsearch">
					<s:textfield name="content" label="搜索" />
					<s:radio list="#{'0':'模糊','1':'精确'}" name="searchType" theme="simple"/>
					<a href="javascript:redirectJS()">站外搜索</a>
					<s:submit value="go" ></s:submit>
					</s:form>
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
              <div style="float:right;width:100%; height:70%">
              <div id="map_canvas" style="float:up; width:100%; height:100%"></div>
              <s:form action="mapSearch">
				<s:hidden name="lat" value='' id="lat"/>
				<s:hidden name="lng" value='' id="lng"/>
			<s:submit value="go"></s:submit>
				</s:form>
				</div>
          <tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
    </table>
 

</body>
</html>
<!--  <body onload="initialize()">-->
<!--  <div style="float:left">-->
<!--		<s:form action="submitsearch">-->
<!--			<s:textfield name="content" label="搜索" />-->
<!--			<s:radio list="#{'0':'模糊','1':'精确'}" name="searchType" theme="simple"/>-->
<!--			<a href="javascript:redirectJS()">站外搜索</a>-->
<!--			<s:submit value="go" ></s:submit>-->
<!--		</s:form>-->
<!--		</div>-->
<!--		<div style="float:right;width:50%; height:100%">-->
<!--		<div id="map_canvas" style="float:up; width:100%; height:100%"></div>-->
<!--		<s:form action="mapSearch">-->
<!--		<s:hidden name="lat" value='' id="lat"/>-->
<!--		<s:hidden name="lng" value='' id="lng"/>-->
<!--		<s:submit value="go"></s:submit>-->
<!--		</s:form>-->
<!--		</div>-->
<!--	</body>-->
<!--</html>-->
