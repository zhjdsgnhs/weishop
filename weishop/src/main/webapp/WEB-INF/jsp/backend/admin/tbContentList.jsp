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
    <title>广告管理</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/style.css">
	<script src="${pageContext.request.contextPath }/statics/plugins/jQuery/jquery-2.2.3.min.js"></script>
    <script src="${pageContext.request.contextPath }/statics/plugins/bootstrap/js/bootstrap.min.js"></script>
    
</head>

<script type="text/javascript">
	function xiu(id){
		selectCategory();
    	$("#myModalLabel").html('广告编辑');
       		$.post("/selContentId","id="+id,function(data){
       			if(data!=null){
       		 		$("#title").val(data.title)
       		 		$("#name").val(data.name)
       		 		$('#er').find("option[value='" + data.categoryId + "']")
       		 		$("#sortOrder").val(data.sortOrder)
       		 		$("#pic").val(data.pic)
       		 		$("#srcFile").attr('src',data.pic)
       		 		$("#id").val(data.id)
       		 	}
    		})
	}
        
   	function tianjia(){
   		$("#myModalLabel").html('新增广告');
        	$("#title").val('')
       		$("#name").val('')
   		    selectCategory();
       		$("#sortOrder").val('')
       		$("#pic").val('')
       		$("#id").val('')
    }
        
    function selectCategory(){
     	$.post("selectCategory","",function(data){
   			if(data.length>0){
   					var htl = " <option value='0'>---请选择---</option>";
			        for(var i=0;i<data.length;i++){
			       		 htl+="<option value='"+data[i].id+"'>"+data[i].categoryName+"</option>";
	      			}
          			$("#er").html(htl);
   			}
   		})
     }
        
    function shan(id){
  		if(confirm("确认是否删除？")){
  			$.post("${ctx}/delContent","id="+id,function(data){
  				if(data=="true"){
  					alert("删除成功！")
  					location="${ctx}/selectContent";
  				}else if(data=="false"){
  					alert("删除失败！")
  					location="${ctx}/selectContent";
  				}
  			})
  		}
  	}	
  	
  	function dels(){
		var chk_value =[];//定义一个数组    
        $('input[name="interest"]:checked').each(function(){//遍历每一个名字为interest的复选框，其中选中的执行函数    
            chk_value.push($(this).val());//将选中的值添加到数组chk_value中    
        });
        if(chk_value.length>0){
            for(var i=0; i<chk_value.length;i++){
            	shan(chk_value[i]);
            }
        }
	}
  	
  	function save(){
  	 	var formData = new FormData();
        formData.append("file", document.getElementById("a_pic").files[0]);
        $.ajax({
            type: 'post',
            url: "/file/pictureFile",
            data: formData,
            cache: false,
            processData: false,
            contentType: false
        }).success(function (data) {
            var filebool = data.success;
            var logoPicPath = data.data.logoPicPath;
            var logoLocPath = data.data.logoLocPath;

            if (filebool) {
                        var title = $("#title").val();
						var name = $("#name").val();
						var categoryId=$("#er").val();
						var	sortOrder=$("#sortOrder").val();
						var id = $("#id").val();

                        $.post("/saveAndupdate", {
                            title:title,
                            name:name,
                            categoryId:categoryId,
                            sortOrder:sortOrder,
                            id:id,
                            pic:logoPicPath,
                        }, function (data) {
                            if (data.success) {
                                alert("新增成功");
                                window.location.reload();
                            } else {
                                alert(data.message);
                            }
                        })
                }
        }).error(function () {
            alert("上传失败");
        });
  	}
	
</script>

<body class="hold-transition skin-red sidebar-mini">
  <!-- .box-body -->
                
                    <div class="box-header with-border">
                        <h3 class="box-title">广告管理</h3>
                    </div>

                    <div class="box-body">

                        <!-- 数据表格 -->
                        <div class="table-box">

                            <!--工具栏-->
                            <div class="pull-left">
                                <div class="form-group form-inline">
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-default" title="新建" data-toggle="modal" data-target="#editModal" onclick="tianjia()"><i class="fa fa-file-o"></i> 新建</button>
                                        <button type="button" class="btn btn-default" title="删除" onclick="dels()"><i class="fa fa-trash-o"></i> 删除</button>
                                    </div>
                                </div>
                            </div>
                            <div class="box-tools pull-right">
                                <div class="has-feedback">
							                                  
                                </div>
                            </div>
                            <!--工具栏/-->

			                  <!--数据列表-->
			                  <form action="/selectContent">
			                  	<div class="box-tools pull-right">
	                                <div class="has-feedback">
								                      广告名：<input type="text" name="name" value="${name}">									
										<input type="submit" class="btn btn-default" value="查询">
	                                </div>
	                            </div>
			                    <table id="dataList" class="table table-bordered table-striped table-hover dataTable">
			                      <thead>
			                          <tr>
			                              <th class="" style="padding-right:0px">
			                                  <input id="selall" type="checkbox" class="icheckbox_square-blue">
			                              </th> 
										  <th class="sorting_asc">ID</th>
									      <th class="sorting">标题</th>
									      <th class="sorting">广告名</th>
									      <th class="sorting">类别</th>	
									      <th class="sorting">排序</th>	
									      <th class="sorting">图片路径</th>	
									      <th class="sorting">修改日期</th>											     						      							
					                      <th class="text-center">操作</th>
			                          </tr>
			                      </thead>
			                      <tbody>
			                      	<c:forEach items="${tbContentList}" var="tbContentList">
			                          <tr>
			                          	  <td><input type="checkbox" name="interest" value="${tbContentList.id}"  ></td>
			                              <td>${tbContentList.id}</td>			                              
					                      <td>${tbContentList.title}</td>
										  <td>${tbContentList.name}</td>	
										  <td>${tbContentList.categoryName}</td>
										  <td>${tbContentList.sortOrder}</td>
										  <td><img src="${ctx}/${tbContentList.pic}" width="50px" height="30px" alt="${tbContentList.name}" /></td>		                              
					                      <td>${tbContentList.updateTime}</td>								     								     
		                                  <td class="text-center">                                           
		                                 	  <button type="button" class="btn bg-olive btn-xs" data-toggle="modal" data-target="#editModal" onclick="xiu(${tbContentList.id})">修改</button>        
		                                 	  <button type="button" class="btn bg-olive btn-xs" onclick="shan(${tbContentList.id})">删除</button>                                                                       
		                                  </td>
			                          </tr>
			                        </c:forEach>
			                        <tr align="left">
										<td colspan="9">
									    	共${page.countCurrSize}条记录
									    </td>
	       							</tr>
				                    <tr align="right">
									    <td colspan="9">
										    <a href="${ctx}/selectContent?num=1&name=${name}">首页</a>
										    <a href="${ctx}/selectContent?num=${page.currNo-1}&name=${name}">上页</a>
									            
										    <a href="${ctx}/selectContent?num=${page.currNo+1}&name=${name}">下页</a>
										    <a href="${ctx}/selectContent?num=${page.countCurrNo}&name=${name}">末页</a>
									    </td>
	       							</tr> 
			                      </tbody>
			                  </table>
			                  <!--数据列表/--> 
			                 </form>
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
			<h3 id="myModalLabel">广告编辑</h3>
		</div>
		<form action="${ctx}/insertContent" method="post" enctype="multipart/form-data">
			<div class="modal-body">	   						
				
				<table class="table table-bordered table-striped"  width="800px">
			      	<tr>
			      		<td>广告标题</td>
			      		<td>
			      			<input type="hidden" name="id"  id="id" value="${content.id}">
			      			<input  class="form-control" placeholder="广告标题" name="title" id="title" value="${content.title}" required="required">
			      		</td>
			      	</tr>
			      	<tr>
			      		<td>广告名</td>
			      		<td><input  class="form-control" placeholder="广告名" name="name" id="name" value="${content.name}" required="required">  </td>
			      	</tr>
				    <tr>
			      		<td >广告类型</td>
			      		<td>
			      			<select class="form-control" placeholder="广告类型" name="categoryId" id="er" required="required">
	              				
	            			</select>
			      		</td>
			      	</tr>	
			      	<tr>
			      		<td>排序</td>
			      		<td><input  class="form-control" placeholder="排序" name="sortOrder" id="sortOrder" value="${content.sortOrder}" required="required">  </td>
			      	</tr>			      	
			      	<tr>
			      		<td>广告图片</td>
			      		<td>
							<table>
								<tr>
									<td>
										<img alt="" src="" width="50px" height="30px" id="srcFile">
	                 					<input type="hidden" id="pic" name="pic" value="${tbTheme.pic}"/>
										<input type="file" id="a_pic" name="a_pic" required="required"/>				                
						            </td>
								</tr>						
							</table>
							<%-- <span>${fileUploadError }</span> --%>
			      		</td>
			      	</tr>	      
				 </table>				
				
			</div>
			<div class="modal-footer">						
				<input type="button" class="btn btn-success" data-dismiss="modal" aria-hidden="true" value="保存" onclick="save()"/>
				<button class="btn btn-default" data-dismiss="modal" aria-hidden="true">关闭</button>
			</div>
		</form>
		</div>
	</div>
</div>

</body>

</html>