<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>商家管理</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/style.css">
	<script src="${pageContext.request.contextPath }/statics/plugins/jQuery/jquery-2.2.3.min.js"></script>
    <script src="${pageContext.request.contextPath }/statics/plugins/bootstrap/js/bootstrap.min.js"></script>
    
</head>

<body class="hold-transition skin-red sidebar-mini"  >
  <!-- .box-body -->
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <h3 class="box-title">店铺分类</h3>
                    </div>

                    <div class="box-body">
                        <div class="table-box">

			                  <!--数据列表-->
			                  <table id="dataList" class="table table-bordered table-striped table-hover dataTable">
			                      <thead>
			                          <tr>
										  <th class="sorting_asc">店铺类别</th>
									      <th class="sorting">分成百分比</th>
									      <th class="sorting">状态</th>
					                      <th class="text-center">操作</th>
			                          </tr>
			                      </thead>
			                      <tbody>
			                      <c:forEach items="${typeList}" var="book">
                                    <tr>
                                       <td>${book.sType}</td>
                                       <td>${book.sPercent}</td>
                                       <td>${book.statusName}</td>
                                       <td class="text-center">                                          
		                                 	  <button type="button" class="btn bg-olive btn-xs" data-toggle="modal" data-target="#editModal" onclick="return xiu(${book.sTypeid})">修改</button>
		                                 	  <c:if test="${book.status==0}">
		                                 	     <button type="button" class="btn bg-olive btn-xs"  onclick="return qi(${book.sTypeid})">启用</button>
		                                 	  </c:if>
		                                 	  
		                                 	  <c:if test="${book.status==1}">
		                                 	     <button type="button" class="btn bg-olive btn-xs"  onclick="return jin(${book.sTypeid})">禁用</button>
			                                  </c:if>
			                           </td>
			                        </tr>
			                      </c:forEach>
			                      </tbody>
			                  </table>
                        </div>
                     </div>
                     
<!-- 编辑窗口 -->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog" >
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
			<h3 id="myModalLabel">广告分类编辑</h3>
		</div>
		<div class="modal-body">							
			
			<table class="table table-bordered table-striped"  width="800px">
		      	<tr>
		      		<td>店铺类别</td>
		      		<td>
		      		    <input type="hidden" name="sTypeid" id="sTypeid">
		      		    <input  class="form-control" placeholder="店铺类别" name="sType" id="sType">  
		      		</td>
		      	</tr>
		      	<tr>
		      	
		      		<td>分成百分比</td>
		      		<td><input  class="form-control" placeholder="分成百分比" name="sPercent" id="sPercent">  </td>
		      	</tr>	
			 </table>				
		</div>
		<div class="modal-footer">						
			<button class="btn btn-success" data-dismiss="modal" aria-hidden="true" onclick="return bao()">保存</button>
			<button class="btn btn-default" data-dismiss="modal" aria-hidden="true">关闭</button>
		</div>
	  </div>
	</div>
</div>
</html>

<script type="text/javascript" src="${ctx}/jsp/jquery-1.12.4.js"></script>
<script type="text/javascript">

     function xiu(sTypeid){
       $.post("/selectSellerId","sTypeid="+sTypeid,function(data){
         if(data!=null){
           $("#sTypeid").val(data.sTypeid);
           $("#sType").val(data.sType);
           $("#sPercent").val(data.sPercent);
         }
       })
     }

     
     function qi(sTypeid){
       $.post("/sellerQi","sTypeid="+sTypeid,function(data){
       if(data=="true"){
         alert("启用成功");
         window.location.href="/selectSellerType"
       }else{
         alert("启用失败");
         window.location.href="/selectSellerType"
       }
       })
     }
     
     function jin(sTypeid){
       $.post("/sellerJin","sTypeid="+sTypeid,function(data){
       if(data=="true"){
         alert("禁用成功");
         window.location.href="/selectSellerType"
       }else{
         alert("禁用失败");
         window.location.href="/selectSellerType"
       }
       })
     }
     
     function bao(sTypeid){
     var sTypeid=$('[name="sTypeid"]').val();
     var sType=$('[name="sType"]').val();
     var sPercent=$('[name="sPercent"]').val();
      $.post("/updateSellerType","sTypeid="+sTypeid+"&sType="+sType+"&sPercent="+sPercent,function(data){
       if(data=="true"){
         alert("修改成功");
         window.location.href="/selectSellerType"
       }else{
         alert("修改失败");
         window.location.href="/selectSellerType"
       }
       })
     }
   </script>
<!-- <SCRIPT Language=VBScript></SCRIPT> -->
