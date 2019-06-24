<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>

<head>
<meta charset="UTF-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="layui/css/layui.css" media="all">
<script src="layui/layui.js"></script>
<title>飞行计划查询</title>
</head>

<body>
	<div class="layui-fluid">
		<div class="layui-row">
			<div class="layui-col-xs12">
				<table class="layui-table">
					<colgroup>
    					<col width="50">
    					<col width="100">
    					<col width="100">
    					<col width="150">
    					<col width="100">
    					<col width="100">
    					<col width="100">
    					<col width="100">
    					<col width="100">
    					<col width="100">
  					</colgroup>
  					<thead>
    					<tr>
      						<th id="id">ID</th>
      						<th id="flightzone">区域名称</th>
      						<th id="city">申请地区</th>
      						<th id="useful">空域用途</th>
      						<th id="max_height">最大高度</th>
      						<th id="onposition">起飞位置</th>
      						<th id="offposition">降落位置</th>
      						<th id="ontime">起飞时间</th>
      						<th id="offtime">降落时间</th>
      						<th id="istrue">申请是否通过</th>
    					</tr>
  					</thead>
  					<tbody>
  						<c:forEach items="${fly_plans}" var="fly_plan" varStatus="s">
  							<tr>
  								<th>${s.index+1}</th>
  								<th>${fly_plan.area }</th>
  								<th><c:choose>
  									<c:when test="${fly_plan.apply_city==0}">北京</c:when>
  									<c:when test="${fly_plan.apply_city==1}">上海</c:when>
  									<c:when test="${fly_plan.apply_city==2}">广州</c:when>
  									<c:when test="${fly_plan.apply_city==3}">深圳</c:when>
  									<c:when test="${fly_plan.apply_city==4}">杭州</c:when>
  								</c:choose></th>
  								<th>${fly_plan.plan_use }</th>
  								<th>${fly_plan.max_hight}</th>
  								<th>${fly_plan.start_index }</th>
  								<th>${fly_plan.end_index }</th>
  								<th>${fly_plan.start_time }</th>
  								<th>${fly_plan.end_time }</th>
  								<th>
  									<c:choose>
  										<c:when test="${fly_plan.status==1 }">通过</c:when>
  										<c:when test="${fly_plan.status==0 }">不通过</c:when>
  										<c:otherwise>未审核</c:otherwise>
  									</c:choose>
  								</th>
  							</tr>
  						</c:forEach>
  					</tbody>
				</table>
			</div>
		</div>
	</div>
	
	<script>
	//表格       
	layui.use('table', function(){
    var table = layui.table;
    });
  
	</script> 
</body>

</html>