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
    <title>规格管理</title>
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/style.css">
	<script src="${pageContext.request.contextPath }/statics/plugins/jQuery/jquery-2.2.3.min.js"></script>
    <script src="${pageContext.request.contextPath }/statics/plugins/bootstrap/js/bootstrap.min.js"></script>
    
</head>
	<script type="text/javascript">
    	function xiugai(id){
    		$("#myModalLabel").html('主题修改');
       			$.post("${ctx}/selTbThemeId","themeid="+id,function(data){
       		 		if(data!=null){
       		 			$("#themename").val(data.themename)
       		 			$("#picture").val(data.picture)
       		 			$("#status").val(data.status)
       		 			$("#srcFile").attr('src',data.picture)
       		 			$("#createTime").val(data.createTime)
       		 			$("#closeTime").val(data.closeTime)
       		 			$("#themeid").val(data.themeid)
       		 		}
       			})
        }
        
        function tianjia(){
        	$("#myModalLabel").html('主题添加');
            	$("#themename").val('')
       		 	$("#picture").val('')
       		 	$("#status").val('')
       		 	$("#createTime").val('')
       		 	$("#closeTime").val('')
       		 	$("#themeid").val('')
        }
        
    function shan(id){
  		if(confirm("确认是否删除？")){
  			$.post("${ctx}/delTbTheme","themeid="+id,function(data){
  				if(data=="true"){
  					alert("删除成功！")
  					location="${ctx}/selectTbTheme";
  				}else if(data=="false"){
  					alert("删除失败！")
  					location="${ctx}/selectTbTheme";
  				}
  			})
  		}
  	}	
  	
  	function save(){
  	 	var formData = new FormData();
        formData.append("file", document.getElementById("a_picture").files[0]);
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
                        var themename = $("#themename").val();
						var status = $("#status").val();
						var createTime=$("#createTime").val().toString();
						var	closeTime=$("#closeTime").val().toString();
						var themeid = $("#themeid").val();

                        $.post("/saveAndUpdate", {
                            themename:themename,
                            status:status,
                            createTime:createTime,
                            closeTime:closeTime,
                            themeid:themeid,
                            picture: logoPicPath,
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
<body class="hold-transition skin-red sidebar-mini" >
  <!-- .box-body -->                
                    <div class="box-header with-border">
                        <h3 class="box-title">主题管理》主题列表</h3>
                    </div>
                    <div class="box-body">
                        <!-- 数据表格 -->
                        <div class="table-box">

                            <!--工具栏-->
                            <div class="pull-left">
                                <div class="form-group form-inline">
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-default" title="新建" data-toggle="modal" data-target="#editModal" onclick="tianjia()" ><i class="fa fa-file-o"></i> 新建</button>
                                    </div>
                                </div>
                            </div>
                            <form action="${ctx}/selectTbTheme">
	                            <div class="box-tools pull-right">
	                                <div class="has-feedback">
								                    主题标题：<input type="text" name="themename" value="${themename}">									
										<input type="submit" class="btn btn-default" value="查询">
										                                
	                                </div>
	                            </div>
	                            <!--工具栏/-->
				                         <!--数据列表-->
				                  <table id="dataList" class="table table-bordered table-striped table-hover dataTable">
				                      <thead>
				                          <tr>
											  <th class="sorting_asc">主题编号</th>
										      <th class="sorting">关联标题</th>
										      <th class="sorting">封面图</th>
										      <th class="sorting">是否有效</th>
										      <th class="sorting">起始时间</th>
										      <th class="sorting">截止时间</th>
										      <th class="sorting">操作人</th>
										      <th class="sorting">操作时间</th>
						                      <th class="text-center">操作</th>
				                          </tr>
				                      </thead>
				                      <tbody>
				                          <c:forEach items="${tbThemeList}" var="tbThemeList">
										  	<tr>
				                              <td>${tbThemeList.themeid}</td>			                              
					                          <td>${tbThemeList.themename}</td>
										      <td><img src="${tbThemeList.picture}" width="50px" height="30px" alt="${tbThemeList.themename}" /></td>
										      <td>${tbThemeList.status}</td>			                              
					                          <td>${tbThemeList.createTime}</td>
										      <td>${tbThemeList.closeTime}</td>
										      <td>${tbThemeList.person}</td>
										      <td>${tbThemeList.updateTime}</td>
			                                  <td class="text-center">      
			                             		<button type="button" class="btn bg-olive btn-xs" data-toggle="modal" data-target="#editModal"   onclick="xiugai(${tbThemeList.themeid})">修改</button>
			                                    <button type="button" class="btn bg-olive btn-xs" onclick="shan(${tbThemeList.themeid})">删除</button>                                    
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
									          	<%-- <c:if test="${page.currNo > 1}"> --%>
										            <a href="${ctx}/selectTbTheme?num=1&themeName=${themeName}">首页</a>
										            <a href="${ctx}/selectTbTheme?num=${page.currNo-1}&themeName=${themeName}">上页</a>
									            <%-- </c:if>
									            <c:if test="${page.currNo < page.countCurrNo }"> --%>
										            <a href="${ctx}/selectTbTheme?num=${page.currNo+1}&themeName=${themeName}">下页</a>
										            <a href="${ctx}/selectTbTheme?num=${page.countCurrNo}&themeName=${themeName}">末页</a>
									          	<%-- </c:if> --%>
									          </td>
	       								  </tr>
				                      </tbody>
				                  </table>
			                  </form>
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
			<h3 id="myModalLabel">新增主题</h3>
		</div>
			<div class="modal-body">							
				 <table class="table table-bordered table-striped table-hover dataTable">
	                <tr>
			      		<td>关联标题</td>
			      		<td><input  class="form-control" placeholder="关联标题" id="themename" name="themename" required="required"></td>
			      	</tr>
			      	<tr>
			      		<td>封面图</td>
			      		<td>
				      		<img alt="" src="" width="50px" height="30px" id="srcFile">
	                 		<input type="hidden" id="picture" name="picture" value="${tbTheme.picture}"/>
			      			<input type="file" class="form-control" 
			      			placeholder="封面图" id="a_picture" name="a_picture"  required="required"/>
			      		</td>
	            		<%-- <span>${fileUploadError}</span> --%>
			      	</tr>		
			      	<tr>
			      		<td>是否有效</td>
			      		<td><input  class="form-control" placeholder="是否有效" name="status" id="status" required="required"></td>
			      	</tr>	
			      	<tr>
			      		<td>起始时间</td>
			      		<td><input  class="form-control" placeholder="起始时间" name="createTime" id="createTime" required="required"></td>
			      	</tr>	
			      	<tr>
			      	
			      		<td>截止时间</td>
			      		<td>
			      		<!-- 主题id隐藏 -->
			      			<input type="hidden" name="themeid"  id="themeid" value="${tbTheme.themeid}">
			      			<input  class="form-control" placeholder="截止时间" name="closeTime" id="closeTime" required="required">
			      		</td>
			      	</tr>	
			      	
				  </table> 
			</div>
			<div class="modal-footer">						
				<input type="submit" class="btn btn-success" data-dismiss="modal" aria-hidden="true" value="保存" onclick="save()"/>
				<button class="btn btn-default" data-dismiss="modal" aria-hidden="true" >关闭</button>
			</div>
	  </div>
	</div>
</div>    

</body>

</html>
