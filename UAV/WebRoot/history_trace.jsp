<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>

<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<style type="text/css">
body, html, #allmap {
	width: 100%;
	height: 100%;
	overflow: hidden;
	margin: 0;
	font-family: "微软雅黑";
}

#l-map {
	height: 100%;
	width: 100%;
}

#r-result {
	width: 50%;
}
</style>
<link rel="stylesheet" href="http://api.map.baidu.com/library/DrawingManager/1.4/src/DrawingManager_min.css" />
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=m13m1WknFGkeLFww8QqvTGwVixp40vtg"></script>
<script type="text/javascript" src="http://api.map.baidu.com/library/DrawingManager/1.4/src/DrawingManager_min.js"></script>

<title>历史轨迹</title>
</head>

<body>
	<div id="l-map"></div>
</body>
<script>
	// 百度地图API功能
	
	
	var map = new BMap.Map("l-map");       // 创建地图实例
	//var point = new BMap.Point(116.404, 39.915);
   // map.centerAndZoom(point, 15);
	map.centerAndZoom(new BMap.Point(121.9150776542, 30.8803154881), 18); //测试地点
    map.enableScrollWheelZoom(); // 开启鼠标滚轮缩放
    map.addControl(new BMap.ScaleControl()); // 添加比例尺控件
    var mapType2 = new BMap.MapTypeControl({
		anchor : BMAP_ANCHOR_TOP_LEFT
	});
	map.addControl(mapType2);
	
    var pointStr = ${lon_lat};
	//var pointStr;
	//在运行下面代码之前将经纬度数据存储在这个数组里，如上所示,记得加上.split(",");
    var pointArr = [];
    
    for (var k = 0; k < pointStr.length; k += 2) {
        pointArr.push({
            lng: pointStr[k],
            lat: pointStr[k + 1]
        });
    }
    
    // 生成坐标点
    var trackPoint = [];
    for (var i = 0, j = pointArr.length; i < j; i++) {
        trackPoint.push(new BMap.Point(pointArr[i].lng, pointArr[i].lat));
    }

    map.centerAndZoom(trackPoint[0], 15);
    
    // 画线
    var polyline = new BMap.Polyline(trackPoint, {
        strokeColor: "red",
        strokeWeight: 3,
        strokeOpacity: 1
    });
    map.addOverlay(polyline);
       
   
    //根据经纬极值计算绽放级别。 (从网上复制)
    function getZoom(maxLng, minLng, maxLat, minLat) {
        var zoom = ["50", "100", "200", "500", "1000", "2000", "5000", "10000", "20000", "25000", "50000", "100000", "200000", "500000", "1000000", "2000000"]; // 级别18到3。
        var pointA = new BMap.Point(maxLng, maxLat); // 创建点坐标A
        var pointB = new BMap.Point(minLng, minLat); // 创建点坐标B
        var distance = map.getDistance(pointA, pointB).toFixed(1); //获取两点距离,保留小数点后两位
        for (var i = 0, zoomLen = zoom.length; i < zoomLen; i++) {
            if (zoom[i] - distance > 0) {
                return 18 - i + 3; //之所以会多3，是因为地图范围常常是比例尺距离的10倍以上。所以级别会增加3。
            }
        }
    }
    
    //  (从网上复制)
    function setZoom(points) {
        if (points.length > 0) {
            var maxLng = points[0].lng;
            var minLng = points[0].lng;
            var maxLat = points[0].lat;
            var minLat = points[0].lat;
            var res;
            for (var i = points.length - 1; i >= 0; i--) {
                res = points[i];
                if (res.lng > maxLng) maxLng = res.lng;
                if (res.lng < minLng) minLng = res.lng;
                if (res.lat > maxLat) maxLat = res.lat;
                if (res.lat < minLat) minLat = res.lat;
            }
            var cenLng = (parseFloat(maxLng) + parseFloat(minLng)) / 2;
            var cenLat = (parseFloat(maxLat) + parseFloat(minLat)) / 2;
            var zoom = getZoom(maxLng, minLng, maxLat, minLat);
            map.centerAndZoom(new BMap.Point(cenLng, cenLat), zoom);
        } else {
            //没有坐标，显示全中国
            map.centerAndZoom(new BMap.Point(103.388611, 35.563611), 5);
        }
    }

    //setZoom(pointArr)
</script>
</html>	