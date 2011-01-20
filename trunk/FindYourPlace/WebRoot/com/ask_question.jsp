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
		<title>Find Your Place - 提问</title>
	<link rel="stylesheet" type="text/css" href="/styles.css">

	</head>

	<body class="main" class="main" onload="initialize()" onunload="GUnload()">
	<table width="739" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="281" valign="top"><table width="683" border="0" cellspacing="0" cellpadding="0">
      <tr>
      <td width="236"><img src="images/spacer.gif" width="1" height="1"></td>
            <td width="87" align="center" bgcolor="EFEFEF"><a href="/FindYourPlace/main.action"><img src="images/i_1.gif" width="9" height="17" border="0"></a><img src="images/i_sp.gif" width="1" height="17" style="margin-left:9px; margin-right:9px "><a href="#"><img src="images/i_2.gif" width="10" height="17" border="0"></a><img src="images/i_sp.gif" width="1" height="17" style="margin-left:9px; margin-right:9px "><a href="#"><img src="images/i_3.gif" width="11" height="17" border="0"></a></td>
      <script language="javascript" type="text/javascript">
function displayHideUI()
{
    var ui = document.getElementById("map_canvas");
    ui.style.display="none";
}
function displayShowUI()
{
    var ui = document.getElementById("map_canvas");
    ui.style.display="block";
}


</script>

        <s:label value="欢迎，"/>
        <!-- 原显示用户名 -->
		<s:property value="#session.user"/>
		<!-- ${sessionScope["edu.yale.its.tp.cas.client.filter.user"]}-->
		<br>
        <s:hidden name="keyWords" value="#session.key"/>
        <s:property value="result"/>
		<s:form action="submitquestion" method = "POST" enctype="multipart/form-data">
			<s:textfield name="question.title" label="问题" value="%{keyWords}"/>
			<s:textarea name="question.content" label="详细描述" cols="50" rows="6" />
			<s:set name="questionTypes" value="#{'1':getText('questionType.1'),'2':getText('questionType.2'), '0':getText('questionType.0')}"/>
			<s:select name="question.type" label="问题类型" list="questionTypes"/>
			<s:textfield name="question.reward" label="积分悬赏" value="0"/>	
   			<s:file name="upload" label="上传图片"/>
	
   			
   			
   			
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
		<center>
			<div>
				编辑 GoogleMap
				<br>
				<br>
			</div>
			<div id="map_canvas" style="width: 640px; height: 480px"></div>
			<p> 
<input type="button" value='隐藏地图' onclick='displayHideUI()'>
<input type="button" value='显示地图' onclick='displayShowUI()'>
<br />
</p>
			
			<p></p>
			<div>
				
			</div>
		</center>
		
  			<s:hidden id="latitude" name="latitude" />
			<s:hidden id="longitude" name="longitude" />
			<s:hidden id="zoomLevel" name="zoomLevel" />
			<s:hidden id="markArr" name="markArr" />
			
		<s:checkbox name="addGoogleMap" value="true" label="插入GoogleMap" ></s:checkbox>
			<s:reset value="重置"/>
			<s:submit value="提交"  onclick="doPost()"></s:submit>
		</s:form>
        <td height="30" valign="top"><img src="images/spacer.gif" width="1" height="1"></td>
      </tr>
      <tr>
      <td height="44" bgcolor="4D6677" class="copy" style="padding-left:20px ">FindYourPlace.Com &copy; 2005 | <a href="index-6.html" class="copy">Privacy Policy</a> | <a href="#" class="copy">Terms Of Use</a></td>
        <td height="29" valign="top"><table width="683" height="28" border="0" cellpadding="0" cellspacing="0">
        </table>
            </td>
          </tr>
          </table></td>
  		</tr>
        </table>
	</body>
</html>
	
	