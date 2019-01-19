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
                        <h3 class="box-title">商铺订单</h3>
                    </div>

                    <div class="box-body">

                        <!-- 数据表格 -->
                        <div class="table-box">

			                  <!--数据列表-->
			                  <table id="dataList" class="table table-bordered table-striped table-hover dataTable">
			                      <tbody>
			                      <c:forEach items="${orderList}" var="tb">
			                          <tr>
										  <td colspan="4">公司：${tb.nick_name}&nbsp&nbsp
									                                                                  公司联系人：${tb.linkman_name}&nbsp&nbsp									      
									                                                                  公司联系电话：${tb.linkman_mobile}&nbsp&nbsp									     				
					                                                                                                                  公司地址：${tb.addressName}</td>
			                          </tr>
			                          <tr>
			                            <td>
			                              <ul>
										  <li>
										  <p>用户名：${tb.receiver}</p>
										  <p>订单号：${tb.order_id}</p>
										  <p>地址：${tb.receiver_area_name}</p>
										  <p>消费总金额：${tb.total_fee}</p>
										  <p>订单时间：${tb.create_time}</p>
										  <p>商品名称：${tb.title}</p>
										  <c:if test="${tb.status==1}">
										    <p>订单状态：未付款</p>
										  </c:if>
										  <c:if test="${tb.status==2}">
										    <p>订单状态：已付款</p>
										  </c:if>
										  <c:if test="${tb.status==3}">
										    <p>订单状态：未发货</p>
										  </c:if>
										  <c:if test="${tb.status==4}">
										    <p>订单状态：已发货</p>
										  </c:if>
										  <c:if test="${tb.status==5}">
										    <p>订单状态：交易成功</p>
										  </c:if>
										  <c:if test="${tb.status==6}">
										    <p>订单状态：交易关闭</p>
										  </c:if>
										  <c:if test="${tb.status==7}">
										    <p>订单状态：待评价</p>
										  </c:if>
										  <p>付款时间：</p>
										  <c:if test="${tb.payment_type==1}">
										    <p>支付方式：微信支付</p>
										  </c:if>
										  <c:if test="${tb.payment_type==2}">
										    <p>支付方式：货到付款</p>
										  </c:if>
										  <p>购买数量：${tb.num}</p>
										  </li>
			                          </ul>
			                            </td>
			                          </tr>
			                      </c:forEach>
			                      <tr align="right">
			                        <td colspan="4">
			                        <button type="button" class="btn bg-olive btn-xs" data-toggle="modal" onclick="fan()">返回</button>
			                        </td>
			                      </tr>
			                      </tbody>
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

     function fan(){
     window.location.href="/selectSellerAll";
     }
     
   </script>