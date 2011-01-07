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
		var markArr = new Array(); // 用于存储mark坐标
		var map;	// 基本map类型
		// 通过mark数组生成字符串消息以备提交
		function readarr()
		{
			var str = "";
			for(i = 0; i < markArr.length; i++)
			{
				str = str + markArr[i].value + "," + markArr[i].getLatLng().lat()+ "," + markArr[i].getLatLng().lng() + ";";
			}
			return str;
		}
		</script>

		<script type="text/javascript">
		function initialize()
		{
			if (GBrowserIsCompatible())
			{
			// 初始化为默认值
				var latitude = 31;
				var lonitude = 121;
				var zoomlevel = 8;
			
				map = new GMap2(document.getElementById("map_canvas"));//创建地图对象
				map.setCenter(new GLatLng(latitude, lonitude), zoomlevel);//设置地图中心
				map.enableGoogleBar();//搜索栏
				map.enableContinuousZoom();//平滑缩放
				map.enableScrollWheelZoom();//用鼠标滚轮缩放
				map.disableDoubleClickZoom();//双击缩放无效
			
				map.addMapType(G_SATELLITE_3D_MAP);//加入GoogleEarth类型控件
				//map.addControl(new GMapTypeControl());//加入类型控件(已用菜单式代替)
				map.addControl(new GMenuMapTypeControl);//使用菜单式地图类型
				map.addControl(new GLargeMapControl());//大号缩放平移控件
				map.addControl(new GOverviewMapControl());//可隐藏的缩略图控件
				new GKeyboardHandler(map);//启用支持键盘操作

				//监听，双击地图就创建标记点
				GEvent.addListener(map, "dblclick", function(overlay,latlng)
				{
					var marker = new GMarker(latlng, {draggable: true});
					map.addOverlay(marker);
					marker.value = 1;	// value用于在序列中标记该mark是否有效
					var index = markArr.length;
					markArr.push(marker);

					//双击标记点后删除该标记点
					GEvent.addListener(marker, "dblclick", function()
					{
						map.removeOverlay(marker);
						markArr[index].value = 0;	// 已删除的mark的value设为无效
					});
				});
			}
		}
		</script>

		<script type="text/javascript">
		function doPost()
		{
			document.getElementById("latitude").value = map.getCenter().lat();
			document.getElementById("longitude").value = map.getCenter().lng();
			document.getElementById("zoomLevel").value = map.getZoom();
			document.getElementById("markArr").value = readarr();

			document.getElementById("save").submit(); // 提交信息跳转页面
		}
		</script>

	</head>

	<body onload="initialize()" onunload="GUnload()">

		<center>
			<div>
				编辑 Google Map
				<br>
				<br>
			</div>
			<div id="map_canvas" style="width: 640px; height: 480px"></div>
			<p></p>
			<div>
				<button onclick="doPost()" title="完成编辑" type="button">
					finish
				</button>
			</div>
		</center>
		<s:form id="save" action="saveGooglemap">
			<s:hidden id="latitude" name="latitude" />
			<s:hidden id="longitude" name="longitude" />
			<s:hidden id="zoomLevel" name="zoomLevel" />
			<s:hidden id="markArr" name="markArr" />
		</s:form>

	</body>

</html>
