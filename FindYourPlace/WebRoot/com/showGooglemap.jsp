<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html "-//W3C//DTD XHTML 1.0 Strict//EN"    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>

	<head>
	
		<base href="<%=basePath%>">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<script
			src="http://ditu.google.cn/maps?file=api&amp;v=2&amp;sensor=true&key=ABQIAAAAcX1QL3V56daOcJ-r8vNY3RSu9Dt6w49ZfFJ9AZ4Vhn1yvQqjEhT9cb1v1wes-uVnSM43g5QRlafJpg"
			type="text/javascript">
		</script>
		
		<script type="text/javascript">
			var latArr = new Array();
			var lonArr = new Array();
		</script>

		<s:iterator value="pointArr" status="stuts">
		<s:if test="#stuts.odd == true">
			<script type="text/javascript">
				latArr.push('<s:property/>');
			</script>
		</s:if>
		<s:else>
			<script type="text/javascript">
				lonArr.push('<s:property/>');
			</script>
		</s:else>
		</s:iterator>
		
		<script type="text/javascript">
		function initialize()
		{
		if (GBrowserIsCompatible())
		{
			var latitude = Number('<s:property value="latitude"/>');
			var lonitude = Number('<s:property value="longitude"/>');
			var zoomlevel = Number('<s:property value="zoomLevel"/>');

			var map = new GMap2(document.getElementById("map_canvas"));//创建地图对象
			map.setCenter(new GLatLng(latitude, lonitude), zoomlevel);//设置地图中心
			map.enableGoogleBar();//搜索栏
			map.enableContinuousZoom();//平滑缩放
			map.enableScrollWheelZoom();//用鼠标滚轮缩放
			map.disableDoubleClickZoom();//双击缩放无效
			
			map.addMapType(G_SATELLITE_3D_MAP);//加入GoogleEarth类型控件
//			map.addControl(new GMapTypeControl());//加入类型控件
			map.addControl(new GMenuMapTypeControl);//使用菜单式地图类型
			map.addControl(new GLargeMapControl());//大号缩放平移控件
			map.addControl(new GOverviewMapControl());//可隐藏的缩略图控件
			new GKeyboardHandler(map);//启用支持键盘操作
			
			for(i = 0; i < latArr.length; i++)
			{
				map.addOverlay(new GMarker(new GLatLng(latArr[i],lonArr[i])));
			}
		}
		}
		</script>

	</head>

	<body onload="initialize()" onunload="GUnload()">
	<br>
		<s:a href="/FindYourPlace/main.action">返回主页</s:a>
	<br>
		
		<center>
			<div>
				显示 Google Map
				<br>
				<br>
			</div>
			<div id="map_canvas" style="width: 640px; height: 480px"></div>
		</center>
		
	</body>

</html>
