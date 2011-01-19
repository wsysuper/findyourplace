<%@ page language="java" import="java.util.*" contentType = " text/html; charset=utf-8 " pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html >
  
  <head>
  
    <base href="<%=basePath%>">
       
    <title>问题</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="/styles.css">
	</head>
     
  <body class="main" onload="initialize()" onunload="GUnload()">


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



  
  
  
  
  
  
  
  
	    
  
		<!--<s:a href="https://casserver:60462/cas/logout">退出</s:a>-->
		<br>
		<s:a href="/FindYourPlace/main.action">返回主页</s:a>
		<br>
		  <s:set name="qID"><s:property value="question.questionID"/></s:set>
		  
		 <s:label value="问题：" /><s:property value="question.title" /><br>
		 <s:label value="问题描述：" /><s:property value="question.content" /><br>
		<s:label value="问题类型：" /><s:text name="%{'questionType.'+question.type}" /><br>
		<s:label value="积分悬赏：" /><s:property value="question.reward" /><br>
		<s:label value="提问人：" /><s:property value="question.user.userName" /><br>
		<s:label value="提问日期：" /><s:property value="question.pubDate" /><br>
		<s:if test="%{question.pictureURL!=null}">
			<div
				style="padding: 3px; border: solid 1px #cccccc; text-align: center">
				<img src="UploadImages/<s:property value ="question.pictureURL" />" />
				<br />
			</div>
		</s:if><br><br>
	
	<s:iterator id="id" value="answerList">
	<s:label value="回答人：" /><s:property value="user.userName" /><br>
    <s:label value="回答日期：" /><s:property value="pubDate" /><br>
	<s:label value="是否为标准答案：" /><s:property value="isStandard" /><br>
    <s:label value="答案："/><s:property value="content"/><br>
    <s:if test="%{pictureURL!=null}">
			<div
				style="padding: 3px; border: solid 1px #cccccc; text-align: center">
				<img src="UploadImages/<s:property value ="pictureURL" />" />
				<br />
			</div>
	</s:if>
	
	<s:url id="url" action="showGooglemap">
		<s:param name="mapId" value="%{mapId}" />
	</s:url>
	<li>
		<s:a href="%{url}">
		查看地图
		</s:a>
	</li>
	
	<br><br>
	</s:iterator><br>
	
	
		<s:label value="我来回答：" /><br><br>
		
        <s:hidden name="keyWords" value="#session.key"/>
		<s:form id="save" action="submitanswer" method = "POST" enctype="multipart/form-data">
			<s:textarea name="answer.content"  value="" label="回答问题" cols="80" rows="10" />		
  			<s:file name="upload" label="上传图片"/>
  			<s:hidden name="question.questionID" value="%{qID}"/>
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
  			<s:submit value="提交" onclick="doPost()" title="完成编辑" type="button"></s:submit>
		</s:form>
	</body>
</html>
