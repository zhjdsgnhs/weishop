<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script src="${pageContext.request.contextPath }/statics/plugins/bootstrap/js/bootstrap.min.js">
    </script>
    
    <script type="text/javascript">
        function shanchu(id){
            var id = id;
		if(confirm("你确定要删除嘛？")){
			  window.location.href="/brand/delete?id="+id
        
        
        }
        }
    
    	function lala(id){
    	 $("#myModalLabel").html('品牌修改');
       		 $.post("/brand/update","id="+id,function(data){
       		 		if(data!=null){
       		 			$("#name").val(data.name)
       		 			$("#firstChar").val(data.firstChar)
       		 			$("#publish").val(data.publish)
       		 			$("#publishTime").val(data.publishTime)
       		 			$("#id").val(data.id)
       		 		}
       		 })
        }
        
        function qiyong(id){
		var id = id;
		if(confirm("你确定要启用吗？")){
			  window.location.href="/brand/qiyong?id="+id
		}
	}
	     function jinyong(id){
		if(confirm("你确定要禁用吗？")){
			  window.location.href="/brand/jinyong?id="+id
		}
	}
        
        
        function haha(){
            $("#myModalLabel").html('品牌添加');
            $("#name").val('')
       		$("#firstChar").val('')
       		$("#publish").val('')
       		 $("#publishTime").val('')
       		 $("#id").val('')
        }
        function save(){
        
	       var   name= $("#name").val();
	       var	 firstChar=	$("#firstChar").val();
	       var	 publish=$("#publish").val();
	       var	 publishTime=$("#publishTime").val();
	       publishTime.toString();
	       var   id=$("#id").val();
         window.location='/brand/SaveOrUpdate?name='+name+'&firstChar='+firstChar+'&publish='+publish+'&publishTime='+
         publishTime+'&id='+id;
            
        }
    
    </script>
</head>
<body class="hold-transition skin-red sidebar-mini">
  <!-- .box-body -->
   <form action="/brand/select">
                    <div class="box-header with-border">
                        <h3 class="box-title">品牌管理</h3>
                    </div>

                    <div class="box-body">

                        <!-- 数据表格 -->
                        <div class="table-box">

                            <!--工具栏-->
                            <div class="pull-left">
                                <div class="form-group form-inline">
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-default" title="新建" data-toggle="modal" data-target="#editModal" onclick="haha()" ><i class="fa fa-file-o"></i> 新建</button>
                                        <span style="margin-left: 1100px">          查找：<input type="text" name="name"  value="${name}" > 
                                        <input type="submit" value="查询">   </span>
                                        <button type="button" class="btn btn-default" title="刷新" onclick="window.location.reload();"><i class="fa fa-refresh"></i> 刷新</button>
                                    </div>
                                </div>
                            </div>
                            <div class="box-tools pull-right">
                                <div class="has-feedback">                                
                                </div>
                            </div>
                            <!--工具栏/-->

			                  <!--数据列表-->
			                  <table id="dataList" class="table table-bordered table-striped table-hover dataTable">
			                      <thead>
			                          <tr>
			                            
										  <th class="sorting_asc">品牌ID</th>
									      <th class="sorting">品牌名称</th>									      
									      <th class="sorting">品牌首字母</th>	
									      <th class="sorting">状态</th>	
									      <th class="sorting">发布人</th>	
									      <th class="sorting">发布时间</th>									     				
					                      <th class="text-center">操作</th>
			                          </tr>
			                      </thead>
			                      <tbody>
			                          <c:forEach items="${list}" var="list">
			                        <tr>
			                          <td>${list.id }</td>
			                         <td>${list.name}</td>
			                         <td>${list.firstChar}</td>
			                         <c:if test="${list.status==1}">
			                         <td>启用</td>
			                         </c:if>
			                         <c:if test="${list.status==0}">
			                         <td>禁用</td>
			                         </c:if>
			                            <td>${list.publish}</td>
			                         <td>${list.publishTime}</td>         
			                         
			                           <td class="text-center">                                           
		                                 	  <button type="button" class="btn bg-olive btn-xs" data-toggle="modal" data-target="#editModal"
		                                 	   onclick="lala(${list.id})" >
		                                 	   编辑
		                                 	  </button>  
		                                 	      <c:if test="${list.status==0}">
			                                      <button type="button" class="btn bg-olive btn-xs"  onclick="qiyong(${list.id})">启用</button>
			                                      </c:if>
			                                      
			                                      <c:if test="${list.status==1}">
			                                      <button type="button" class="btn bg-olive btn-xs" onclick="jinyong(${list.id})">禁用</button>
			                                      </c:if>     
		                                 	  <button type="button" class="btn bg-olive btn-xs"  onclick="shanchu(${list.id})"  >
		                                        	   删除
		                                 	  </button>                                          
		                                </td>
			                         
			                        </tr>
			                        </c:forEach>
			                        </tbody>
			                         
			                <tr> 
			                  <th colspan="7">     
			      ${count}条记录 
			        <span  style="margin-left: 550"> 
			        共${pageNum} 页&nbsp;当前页第${num}页
			        
			        </span>
				&nbsp;&nbsp;&nbsp; <a href="/brand/select?num=1&name=${name}">首页</a> 
				
				 <c:if test="${num>1}">
				<a href="/brand/select?num=${num-1}&name=${name}" >上一页</a>
				</c:if>
				
				    <c:if test="${num<pageNum}">
				<a href="/brand/select?num=${num+1}&name=${name}">下一页</a>
				</c:if>
				<a href="/brand/select?num=${pageNum}&name=${name}">末页</a>
			
			               </th>            </tr>
			                  </table>
			                    
			                  <!--数据列表/-->                        
							  
							 
                        </div>
                        <!-- 数据表格 /-->
                        
                        
                        
                        
                     </div>
   </form>
                    <!-- /.box-body -->
         
<!-- 编辑窗口 -->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog" >
	<div class="modal-content">
		<div class="modal-header">
	
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true" >×</button>
			
						<h3 id="myModalLabel" ></h3>
			
		</div>
		<div class="modal-body">		
			<table class="table table-bordered table-striped"  width="800px">
		      	<tr>
		      		<td>品牌名称</td>
		      		<td><input  type="text" value="${name}" name="name" id="name" class="form-control" placeholder="品牌名称" >  </td>
		      	</tr>		      	
		      	<tr>
		      		<td>首字母</td>
		     	<td><input  type="text" value="${firstChar}" name="firstChar" id="firstChar" class="form-control" placeholder="首字母" >   </td>
		      	</tr>	
		      		
		      		<tr>
		      		<td>发布人</td>
		     	<td><input  type="text" value="${publish}" name="publish" id="publish" class="form-control" placeholder="首字母" >   </td>
		      	</tr>
		      		<tr>
		      		<td>发布时间</td>
		     	<td>
		     	<input  type="text" value="${publishTime}" name="publishTime" id="publishTime" class="form-control" placeholder="首字母" >
		        
		     		<input  type="hidden" value="${id}" name="id" id="id" class="form-control"  >      </td>
		      	</tr>	  
		      
		      		
		     
		      		    	
			 </table>				
		</div>
		<div class="modal-footer">						
			<button  onclick="save()"  class="btn btn-default" aria-hidden="true" data-dismiss="modal" >保存</button>
			<button class="btn btn-default" data-dismiss="modal" aria-hidden="true">关闭</button>
		</div>
	  </div>
	</div>
</div>
	 
   
</body>
</html>