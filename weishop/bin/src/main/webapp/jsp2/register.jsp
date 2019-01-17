<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8"/>
<title>注册</title>
<meta name="keywords"  content="KEYWORDS..." />
<meta name="description" content="DESCRIPTION..." />
<meta name="author" content="DeathGhost" />
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name='apple-touch-fullscreen' content='yes'>
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<meta name="format-detection" content="address=no">
<link rel="icon" href="${ctx}/statics/qiantai/images/icon/favicon.ico" type="image/x-icon">
<link rel="apple-touch-icon-precomposed" sizes="57x57" href="${ctx}/statics/qiantai/images/icon/apple-touch-icon-57x57-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="120x120" href="${ctx}/statics/qiantai/images/icon/apple-touch-icon-120x120-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="196x196" href="${ctx}/statics/qiantai/images/icon/apple-touch-icon-196x196-precomposed.png">
<meta name="viewport" content="initial-scale=1, width=device-width, maximum-scale=1, user-scalable=no">
<link rel="stylesheet" type="text/css" href="${ctx}/statics/qiantai/css/style.css" />
<script src="${ctx}/statics/qiantai/js/jquery.js"></script>
<script>
$(document).ready(function(){
   $(".formarea li:last input[type='button']").click(function(){
	   alert("测试跳转效果，程序对接予以删除!");
	   location.href="${ctx}/jsp2/login.jsp";
	   });	
});
</script>
</head>
<body>
<!--header-->
<header>
 <a href="javascript:history.go(-1);" class="iconfont backIcon">&#60;</a>
 <h1>注册</h1>
</header>
<div style="height:1rem;"></div>
<mark class="formMark">这里放电话做什么，请联系400-8200-5385</mark>
<ul class="formarea">
 <li>
  <label class="lit">账号：</label>
  <input type="tel" placeholder="手机号码" class="textbox"/>
 </li>
 <li>
  <label class="lit">密码：</label>
  <input type="password" placeholder="设置密码" class="textbox"/>
 </li>
 <li>
  <label class="lit">确认密码：</label>
  <input type="password" placeholder="确认密码" class="textbox"/>
 </li>
 <li>
  <label class="lit">所在城市：</label>
  <select>
   <optgroup label="山东省">
    <option>德州市</option>
   </optgroup>
  </select>
 </li>
 <li>
  <label class="lit">餐馆名称：</label>
  <input type="text" placeholder="餐馆名称" class="textbox"/>
 </li>
 <li>
  <label class="lit">收货人：</label>
  <input type="text" placeholder="收件人真实姓名" class="textbox"/>
 </li>
 <li>
  <label class="lit">联系电话：</label>
  <input type="tel" placeholder="联系电话" class="textbox"/>
 </li>
 <li>
  <label class="lit">收货地址：</label>
  <input type="text" placeholder="区-街道-小区-门牌号" class="textbox"/>
 </li>
 <li class="liLink">
  <a href="${ctx}/jsp2/article.jsp" class="fl">《用户协议》</a>
  <a href="${ctx}/jsp2/login.jsp" class="fr">已有账号，登陆</a>
 </li>
 <li>
  <input type="button" value="立即注册"/>
 </li>
</ul>
<div style="height:1.2rem;"></div>
<nav>
 <a href="${ctx}/jsp2/index.jsp" class="homeIcon">首页</a>
 <a href="${ctx}/jsp2/category.jsp" class="categoryIcon">分类</a>
 <a href="${ctx}/jsp2/cart.jsp" class="cartIcon">购物车</a>
 <a href="${ctx}/jsp2/user.jsp" class="userIcon">我的</a>
</nav>
<script>
  document.oncontextmenu=new Function("event.returnValue=false;");
  document.onselectstart=new Function("event.returnValue=false;"); 
</script>

</body>
</html>
