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
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="layui/css/layui.css" media="all">
<title>UAV~User</title>
</head>

<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">无人机管理平台</div>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="http://t.cn/RCzsdCq" class="layui-nav-img">用户名:${username}
        </a>
      </li>
      <li class="layui-nav-item"><a href="login.do">退出登录</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
    	<div class="kit-side-fold" style="text-align: center;">
        	<i class="layui-icon layui-icon-home"></i>
    	</div>
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree" lay-filter="main">
        <li class="layui-nav-item layui-nav-itemed">
          <a href="javascript:;"><i class="layui-icon">&#xe665;</i><span>飞行记录</span></a>
          <dl class="layui-nav-child">
            <dd id="realtime_monitor"><a href="javascript:;"><i class="layui-icon">&#xe715;</i><span>实时监控</span></a></dd>
            <dd id="history"><a href="javascript:;"><i class="layui-icon">&#xe705;</i><span>历史记录</span></a></dd>
          </dl>
        </li>
        <li class="layui-nav-item layui-nav-itemed">
          <a href="javascript:;"><i class="layui-icon">&#xe60a;</i><span>飞行计划</span></a>
          <dl class="layui-nav-child">
            <dd id="flightapply"><a href="javascript:;"><i class="layui-icon">&#xe62f;</i><span>飞行计划申请</span></a></dd>
            <dd id="flightsearch"><a href="javascript:;"><i class="layui-icon">&#xe615;</i><span>飞行计划查询</span></a></dd>
          </dl>
        </li>
        <li class="layui-nav-item layui-nav-itemed">
          <a href="javascript:;"><i class="layui-icon">&#x1006;</i><span>禁飞区</span></a>
          <dl class="layui-nav-child">
            <dd id="noflysearch"><a href="javascript:;"><i class="layui-icon">&#xe615;</i><span>禁飞区查询</span></a></dd>
            <dd id="noflymap"><a href="javascript:;"><i class="layui-icon">&#x1007;</i><span>禁飞区地图</span></a></dd>
          </dl>
        </li>
        <li class="layui-nav-item" id="police">
        	<a href="javascript:;"><i class="layui-icon">&#xe622;</i><span>政策法规</span></a>
        </li>
        <li class="layui-nav-item" id="auth">
        	<a href="javascript:;"><i class="layui-icon">&#xe612;</i><span>用户认证</span></a>
        </li>
      </ul>
    </div>
  </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
    <iframe id="matter1" src="realtime_monitor.do?username=${username}" style="display: block;overflow: auto;" scrolling="no" frameborder="0" width="100%" height="100%"></iframe>
    <iframe id="matter2" src="history.do?username=${username}" style="display: none;overflow: auto;" scrolling="yes" frameborder="0" width="100%" height="100%"></iframe>
    <iframe id="matter3" src="flightapply.do?username=${username}" style="display: none;overflow: auto;" scrolling="yes" frameborder="0" width="100%" height="100%"></iframe>
    <iframe id="matter4" src="flightsearch.do?username=${username}" style="display: none;overflow: auto;" scrolling="yes" frameborder="0" width="100%" height="100%"></iframe>
    <iframe id="matter5" src="flight.jsp" style="display: none;overflow: auto;" scrolling="yes" frameborder="0" width="100%" height="100%"></iframe>
    <iframe id="matter6" src="nofly_map.jsp" style="display: none;overflow: auto;" scrolling="no" frameborder="0" width="100%" height="100%"></iframe>
    <iframe id="matter7" src="police.jsp" style="display: none;overflow: auto;" scrolling="yes" frameborder="0" width="100%" height="100%"></iframe>
    <iframe id="matter8" src="auth.jsp" style="display: none;overflow: auto;" scrolling="yes" frameborder="0" width="100%" height="100%"></iframe>
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    ©2018 上海海事大学-信息工程学院-无人机管理平台
  </div>
</div>

<script src="layui/layui.js"></script>
<script src="js/jquery-1.11.1.js"></script>
<script>
$(document).ready(function(){
	var temp = "none";
	$("#realtime_monitor").click(function(){openMatter(1);});
	$("#history").click(function(){openMatter(2);});
	$("#flightapply").click(function(){openMatter(3);});
	$("#flightsearch").click(function(){openMatter(4);});
	$("#noflysearch").click(function(){openMatter(5);});
	$("#noflymap").click(function(){openMatter(6);});
	$("#police").click(function(){openMatter(7);});
	$("#auth").click(function(){openMatter(8);});
	function openMatter(obj){
		for(var i = 1; i < 9; i++){
			if(i == obj){
				temp = "block";
			}else{
				temp = "none";
			}
			document.getElementById("matter" + i).style.display = temp;
		}
	}
});
 //导航栏跳转
layui.use('element', function(){
	var element = layui.element;
	//监听导航点击
	element.on('nav(main)', function(elem) {
	//console.log(elem)
	layer.msg(elem.text());
	}); 
});
	var isShow = true;  //定义一个标志位
    $('.kit-side-fold').click(function(){
        //选择出所有的span，并判断是不是hidden
        $('.layui-nav-item span').each(function(){
            if($(this).is(':hidden')){
                $(this).show();
            }else{
                $(this).hide();
            }
        });
        //判断isshow的状态
        if(isShow){
            $('.layui-side.layui-bg-black').width(60); //设置宽度
            $('.kit-side-fold').css('width', 60+'px');  //修改图标的位置
            //将footer和body的宽度修改
            $('.layui-body').css('left', 60+'px');
            $('.layui-footer').css('left', 60+'px');
            //将二级导航栏隐藏
            $('dd span').each(function(){
                $(this).hide();
            });
            //修改标志位
            isShow =false;
        }else{
            $('.layui-side.layui-bg-black').width(200);
            $('.kit-side-fold').css('width', 200+'px');
            $('.layui-body').css('left', 200+'px');
            $('.layui-footer').css('left', 200+'px');
            $('dd span').each(function(){
                $(this).show();
            });
            isShow =true;
        }
    }); 
</script>

</body>

</html>