<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>商品管理</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/style.css">
	<script src="${pageContext.request.contextPath }/statics/plugins/jQuery/jquery-2.2.3.min.js"></script>
    <script src="${pageContext.request.contextPath }/statics/plugins/bootstrap/js/bootstrap.min.js"></script>

</head>

<body class="hold-transition skin-red sidebar-mini" >
  <!-- .box-body -->
                
                    <div class="box-header with-border">
                        <h3 class="box-title">商品分类</h3>
                    </div>

                    <div class="box-body">
                     
                     <div class="pull-left">
                                <div class="form-group form-inline">
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-default" title="新建" data-toggle="modal" data-target="#editModal" ><i class="fa fa-file-o"></i> 新建</button>
                                    </div>
                                </div>
                            </div>

                        <!-- 数据表格 -->
                         <div class="table-box">
			                  <!--数据列表-->
			                  <table id="dataList" class="table table-bordered table-striped table-hover dataTable">
			                      <thead>
			                          <tr>
			                              
										  <th class="sorting_asc">商品ID</th>
									      <th class="sorting">分类名称</th>
									      <th class="sorting">分类级别</th>
					                      <th class="text-center">操作</th>
			                          </tr>
			                      </thead>
			                      <tbody>
			                          <c:forEach items="${list}" var="lists">
									  
									   <tr>
			                             
			                              <td>${lists.id}</td>			                              
				                          <td>${lists.name}</td>
									      <td>${lists.typeName}</td>
		                                  	                                  
		                                  <td class="text-center">      
		                                      <button type="button" class="btn bg-olive btn-xs" >修改</button>
		                                      <button type="button" class="btn bg-olive btn-xs" >删除</button>                                    
		                                  </td>
			                          </tr>
			                          </c:forEach>
			                          
			                          <tr align="center">
								          <td colspan="5">
								            <a href="${ctx}/selectAllParentId?num=1">首页</a>
								            <a href="${ctx}/selectAllParentId?num=${page.currNo-1}">上页</a>
								            <a href="${ctx}/selectAllParentId?num=${page.currNo+1}">下页</a>
								            <a href="${ctx}/selectAllParentId?num=${page.countCurrNo}">末页</a>
								          </td>
       								  </tr>
			                      </tbody>
			                  </table>
			                  <!--数据列表/-->                        
							  
							 
                        </div>
                        <!-- 数据表格 /-->
                        
                        
                     </div>
                    <!-- /.box-body -->

<!-- 编辑窗口 -->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog" >
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
			<h3 id="myModalLabel">商品编辑</h3>
		</div>
		<div class="modal-body">		
			<table class="table table-bordered table-striped"  width="800px">
			   	<tr>
		      		<td>请选择</td>
		      		<td>
		      		 <select class="form-control" name="type_id" id="ji" class="select" onchange="er()">
	                    <option value="0" selected="selected">请选择</option>
	                    <option value="1">一级分类</option>
	                    <option value="2">二级分类</option>
	                    <option value="3">三级分类</option>
                     </select>
		      		</td>
		      	</tr>	
		      	
		      	<tr id="yi2">
		      	  <td>一级分类:</td>
		      	  <td>
		      	    <select class="form-control" id="yi" name="parent_id">
		      	      <option value="0">请选择</option>
		      	    </select>
		      	  </td>
		      	</tr>
		      	
		      	<tr id="er2">
		      	  <td>二级分类:</td>
		      	  <td>
		      	    <select class="form-control" id="er" name="parent_id">
		      	      <option value="0">请选择</option>
		      	    </select>
		      	  </td>
		      	</tr>
			
		      	<tr>
		      		<td>商品名称</td>
		      		<td><input  class="form-control" placeholder="分类名称" name="name">  </td>
		      	</tr>		      	
		      	      	
			 </table>				
		</div>
		<div class="modal-footer">						
			<button class="btn btn-success" data-dismiss="modal" aria-hidden="true">保存</button>
			<button class="btn btn-default" data-dismiss="modal" aria-hidden="true">关闭</button>
		</div>
	  </div>
	</div>
</div>                    
      
</body>
  
</html>
<script type="text/javascript" src="jquery-1.4.2.min.js"></script>
<script type="text/javascript">
$(function(){
       $("#yi").css("display","none");
       $("#er").css("display","none");
      $("#ji").change(function(){
         var ji = $(this).val();
         if(ji==1){
           $("#er").css("display","none"); 
           $("#yi").css("display","none");         
         }
         if(ji==2){
          $("#yi").css("display","block");
         }
         if(ji==3){
          $("#yi").css("display","block");
          $("#er").css("display","block");
         
         }
      })
    })

   function er(){
   alert(1)
     var type_id = $('[name="type_id"]').val();
     alert(type_id)
     if(type_id==2){
       $.post("${pageContext.request.contextPath}/SelectTypeId1","type_id="+type_id,function(data){
         if(data.length>0){
          var htl = "<option value='0'>请选择</option>";
          for(var i=0;i<data.length;i++){
          htl+="<option value='"+data[i].id+"'>"+data[i].name+"</option>";
          }
          $("#yi").html(htl);
        }else{
          alert("一级加载失败");
        }
     
     });
     }
     
     if(type_id==3){
     $.post("${pageContext.request.contextPath}/SelectTypeId1","type_id="+type_id,function(data){
       if(data.length>0){
          var htl = "<option value='0'>请选择</option>";
          for(var i=0;i<data.length;i++){
          htl+="<option value='"+data[i].id+"'>"+data[i].name+"</option>";
          }
          $("#yi").html(htl);
        }else{
          alert("一级加载失败");
        }
     });
     
     var parent_id = $("[name=parent_id]").val();
     
     $.post("${pageContext.request.contextPath}/SelectTypeId2","parent_id="+parent_id,function(data){
       if(data.length>0){
          var htl = " <option value='0'>请选择</option>";
          for(var i=0;i<data.length;i++){
          htl+="<option value='"+data[i].id+"'>"+data[i].name+"</option>";
          }
          $("#er").html(htl);
        }else{
          alert("二级加载失败");
        }
     
     });
     
     
     
     
     }
     
   
   }
   
   
</script>
