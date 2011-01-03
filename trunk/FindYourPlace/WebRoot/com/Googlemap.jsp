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

		<title>Google Map</title>
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
		function initialize()
		{
		if (GBrowserIsCompatible())
		{
			var latitude = ${sessionScope.lat};
			var lonitude = ${sessionScope.lon};
			var zoomlevel = ${sessionScope.zoom};
//			var pointlat = ${sessionScope.pointlat};
//			var pointlon = ${sessionScope.pointlon};
			
			var map = new GMap2(document.getElementById("map_canvas"));
			map.setCenter(new GLatLng(latitude, lonitude), zoomlevel);
			map.enableGoogleBar();
			map.enableContinuousZoom();
			map.enableScrollWheelZoom();
			map.disableDoubleClickZoom();
			
			map.addMapType(G_SATELLITE_3D_MAP);
			var mapControl = new GMapTypeControl();
			map.addControl(mapControl);
//			map.setMapType(G_SATELLITE_3D_MAP);

			map.addControl(new GLargeMapControl());
			map.addControl(new GMapTypeControl());
			map.addControl(new GOverviewMapControl());
			
			map.addOverlay(new GMarker(new GLatLng(pointlat,pointlon)));
			var polyline = new GPolyline([
			   new GLatLng(39.9493, 116.3975),
			   new GLatLng(39.9593, 116.4071) ],
			    "#ff0000", 10);
			map.addOverlay(polyline);			
			
			GEvent.addListener(map, "moveend", function()
			{
				document.getElementById("message").innerHTML = "中心：" + map.getCenter().toString();
			});
			
			GEvent.addListener(map, "zoomend", function()
			{
				document.getElementById("message").innerHTML = "缩放级别为：" + map.getZoom();
			});

			GEvent.addListener(map, "dblclick", function(overlay,latlng)
			{
				var marker = new GMarker(latlng, {draggable: true});
				map.addOverlay(marker);
				GEvent.addListener(marker, "dblclick", function()
				{
					map.removeOverlay(marker);
				});
			});
		}
		}
		</script>

	</head>

	<body onload="initialize()" onunload="GUnload()">
		<div id="map_canvas" style="width: 640px; height: 480px"></div>
		<div id="message"></div>
	</body>

</html>
