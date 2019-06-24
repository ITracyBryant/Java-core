<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE html>

<html>

<head>
<style type="text/css">
body,html,{
	width: 100%;
	height: 100%;
	overflow: hidden;	
	margin: 0;
	font-family: "微软雅黑";
}
</style>
<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=2.0&ak=m13m1WknFGkeLFww8QqvTGwVixp40vtg"></script>

<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Plane</title>
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>

</head>

<body>
	<!-- 头部 -->
	<div class="header">
		<!-- 标题 -->
		<div class="header-top">
			<ul>
				<li><img src="img/4.jpg"></li>
				<li>实验室研究项目-无人机</li>
			</ul>
		</div>
		<!-- banner -->
		<div class="bannar">
			<div class="container-fluid">
				<div class="row clearfix">
					<div class="col-xs-12 col-md-12 column">
						<div class="carousel slide" id="carousel-242553">
							<ol class="carousel-indicators">
								<li class="active" data-slide-to="0"
									data-target="#carousel-242553"></li>
								<li data-slide-to="1" data-target="#carousel-242553"></li>
								<li data-slide-to="2" data-target="#carousel-242553"></li>
							</ol>
							<div class="carousel-inner">
								<div class="item active">
									<img alt="" src="img/1.jpg" />
								</div>
								<div class="item">
									<img alt="" src="img/2.jpg" />
								</div>
								<div class="item">
									<img alt="" src="img/3.jpg" />
								</div>
							</div>
							<a class="left carousel-control" href="#carousel-242553"
								data-slide="prev"> <span
								class="glyphicon glyphicon-chevron-left"></span>
							</a> <a class="right carousel-control" href="#carousel-242553"
								data-slide="next"> <span
								class="glyphicon glyphicon-chevron-right"></span>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 内容部分 -->
	<div class="wrap">
		<div class="container-fluid">
			<div class="row clearfix">
				<div class="col-xs-3 col-md-3 column">
					<table class="table table-hover table-bordered" contenteditable="true">
						<thead>
							<tr class="success">
								<th>
									<p>编号</p>
								</th>
								<th>
									<p>起飞时间</p>
								</th>
								<th>
									<p>降落时间</p>
								</th>
								<th>
									<p>起飞地点</p>
								</th>
								<th>
									<p>降落地点</p>
								</th>
							</tr>
						</thead>
						<tbody id="FlightRecord"></tbody>
					</table>
				</div>
				<div class="col-xs-9 col-md-9 column map-container-wrap">
					<iframe src="map.jsp" frameborder="0"></iframe>
				</div>
			</div>
		</div>
	</div>
	<!-- 底部 -->
	<div class="footer">实验室项目-无人机</div>
</body>
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

</html>