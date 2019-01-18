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
<title>使用新的收货地址</title>
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
  //测试返回页面，程序对接删除即可
  $(".userForm input[type='button']").click(function(){
	  alert("地址修改成功！");
	  location.href="${ctx}/jsp2/user_set.jsp";
	  });	
});
</script>
</head>
<body>
<!--header-->
<header>
 <a href="javascript:history.go(-1);" class="iconfont backIcon">&#60;</a>
 <h1>收货人信息</h1>
</header>
<div style="height:1rem;"></div>
<ul class="userForm">
 <li>
  <label class="radio istrue"><input type="radio" checked/>使用新地址</label>
 </li>
 <li>
  <span>收货地址：</span>
  <select style="width:auto;display:inline-block; vertical-align:middle;">
   <option>选择所在区</option>
  </select>
  <select style="width:auto;display:inline-block; vertical-align:middle;">
   <option>德州市</option>
  </select>
 </li>
 <li>
  <input type="text" value="" placeholder="详细地址"/>
 </li>
 <li>
  <input type="text" value="" placeholder="手机号码"/>
 </li>
 <li>
  <input type="text" value="" placeholder="固定电话"/>
 </li>
 <li>
  <label class="checkbox"><input type="checkbox" />设为默认地址</label>
 </li>
 <li>
  <input type="button" value="保存地址" class="formLastBtn"/>
 </li>
</ul>
</body>
</html>
