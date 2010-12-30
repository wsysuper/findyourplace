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
  <div style="float:left">
		<s:form action="submitsearch">
			<s:textfield name="content" label="搜索" />
			<s:radio list="#{'0':'模糊','1':'精确'}" name="searchType" theme="simple"/>
			<a href="javascript:redirectJS()">站外搜索</a>
			<s:submit value="go" ></s:submit>
		</s:form>
		</div>
		<div style="float:right;width:50%; height:100%">
		<div id="map_canvas" style="float:up; width:100%; height:100%"></div>
		<s:form action="mapSearch">
		<s:hidden name="lat" value='' id="lat"/>
		<s:hidden name="lng" value='' id="lng"/>
		<s:submit value="go"></s:submit>
		</s:form>
		</div>
	</body>
</html>
