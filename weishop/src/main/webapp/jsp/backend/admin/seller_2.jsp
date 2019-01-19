<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>品牌管理</title>
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/style.css">
	<script src="${pageContext.request.contextPath }/statics/plugins/jQuery/jquery-2.2.3.min.js"></script>
    <script src="${pageContext.request.contextPath }/statics/plugins/bootstrap/js/bootstrap.min.js"></script>
 
    
</head>
<body class="hold-transition skin-red sidebar-mini">
  <!-- .box-body -->
                    <div class="box-header with-border">
                        <h3 class="box-title">商铺审核</h3>
                    </div>

                    <div class="box-body">

                        <!-- 数据表格 -->
                        <div class="table-box">

			                  <!--数据列表-->
			                  <table id="dataList" class="table table-bordered table-striped table-hover dataTable">
			                      <c:forEach items="${tbSellerList}" var="tb">
			                      <tbody>
			                          <tr>
										  <td>总公司：${tb.name}</td>
									      <td>总公司联系人：${tb.linkmanName}</td>									      
									      <td>总公司联系电话：${tb.linkmanMobile}</td>									     				
					                      <td>总公司地址：${tb.addressName}</td>
			                          </tr>
			                      </tbody>
			                      <tbody>
			                          <c:forEach items="${tb.sList}" var="tbs">
			                          <tr>
										  <td>子公司：${tbs.nickName}</td>
									      <td>子公司联系人：${tbs.linkmanName}</td>									      
									      <td>子公司联系电话：${tbs.linkmanMobile}</td>									     				
					                      <td>子公司地址：${tbs.addressName}</td>
					                      <td>子公司状态：${tbs.statusName}</td>
					                      <td>
					                        <c:if test="${tbs.status==0}">
		                                 	     <button type="button" class="btn bg-olive btn-xs"  onclick="return statusYes(${tbs.sellerId})">审核通过</button>
		                                 	  </c:if>
		                                 	  
		                                 	  <c:if test="${tbs.status==1}">
		                                 	     <button type="button" class="btn bg-olive btn-xs"  onclick="return statusNo(${tbs.sellerId})">审核未通过</button>
			                                  </c:if>
					                      </td>
			                          </tr>
			                      </c:forEach>
			                      </tbody>
			                      </c:forEach>
			                  </table>
			                  <!--数据列表/-->                        
                        </div>
                        <!-- 数据表格 /-->
                     </div>
                    <!-- /.box-body -->
         
</body>
</html>
<script type="text/javascript" src="${ctx}/jsp/jquery-1.12.4.js"></script>
<script type="text/javascript">

     function statusYes(sellerId){
       $.post("/statusYes","sellerId="+sellerId,function(data){
       if(data=="true"){
         alert("审核通过");
         window.location.href="/selectSellerAll"
       }else{
         alert("审核未通过");
         window.location.href="/selectSellerAll"
       }
       })
     }
     
     function statusNo(sellerId){
       $.post("/statusNo","sellerId="+sellerId,function(data){
       if(data=="true"){
         alert("审核通过");
         window.location.href="/selectSellerAll"
       }else{
         alert("审核未通过");
         window.location.href="/selectSellerAll"
       }
       })
     }
     
   </script>