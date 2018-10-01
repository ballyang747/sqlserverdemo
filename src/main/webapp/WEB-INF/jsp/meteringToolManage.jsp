<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>

  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>计量器具管理</title>
	    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="apple-mobile-web-app-capable" content="yes" />
			<link href="${ctx }/css/lao.css" rel="stylesheet">
			<link href="${ctx }/bootstrap/bootstrap-theme.css" rel="stylesheet">
	
		<link rel="stylesheet" href="${ctx }/bootstrap/bootstrap.min.css" />
		<link href="${ctx }/jquery/jquery-ui-1.12.1/jquery-ui.theme.min.css" type="text/css" rel="stylesheet" />
		<link href="${ctx }/jquery/jquery-ui-1.12.1/jquery-ui.css" type="text/css" rel="stylesheet" />
		<script src="${ctx }/jquery/jquery-3.3.1.min.js"></script>
		<script src="${ctx }/bootstrap/bootstrap.min.js"></script>
		<script src="${ctx }/jquery/jquery-ui-1.12.1/jquery-ui.min.js"></script>
		<script src="${ctx }/js/lao.js"></script>
		<script src="${ctx }/js/echarts.min.js"></script>
</head>
<style>
		select {
			  border: solid 1px #000;

              /*很关键：将默认的select选择框样式清除*/
				  appearance:none;
				  -moz-appearance:none;
				/*清除箭头*/
				-webkit-appearance:none; 
				  
				
				  /*在选择框的最右侧中间显示小箭头图片*/
				 
				  background: url(image/u236.png) no-repeat scroll right center transparent;
				
				cursor: pointer;
				  /*为下拉小箭头留出一点位置，避免被文字覆盖*/
				  padding-right: 14px;
		}
	
		
	</style>
	<script type="text/javascript">
	function getTime(time){
        var time = new Date(time);
        var y = zeroBu(time.getFullYear());//年
        var m = zeroBu(time.getMonth() + 1);//月
        var d = zeroBu(time.getDate());//日
        var h =zeroBu( time.getHours());//时
        var mm =zeroBu( time.getMinutes());//分
        var s = zeroBu(time.getSeconds());//秒
        var times=y+"-"+m+"-"+d+" "+h+":"+mm+":"+s;
        return times;
    }
	
	
	 $(function(){
		 $("#addTest").click(function(){
			 window.location.href="${ctx}/at";	
			 window.event.returnValue=false;
		 });
		 
		 $.ajax({
				type:"post",
				url:"${ctx}/findAll",
		        datatype:"json",
				 success:function(obj){
					 var data = obj;
					 $("#J_TbData").empty();
					 $.each(data,function(i,val){
						 var $trTemp = $("<tr></tr>");
						 $trTemp.append("<td>"+val.id +"</td>");
						 $trTemp.append("<td>"+val.number +"</td>");
						 $trTemp.append("<td>"+val.name +"</td>");
						 $trTemp.append("<td>"+val.type +"</td>"); 
						 $trTemp.append("<td>"+val.quantity +"</td>"); 
						 $trTemp.append("<td>"+val.area +"</td>"); 
						 $trTemp.append("<td>"+val.checktype +"</td>"); 
						 $trTemp.append("<td>"+val.checktime+"</td>");
						 $trTemp.append("<td>"+val.tochecktime+"</td>");
						 $trTemp.append("<td>"+val.tousetime+"</td>");
						 $trTemp.append("<td>"+val.remark +"</td>"); 
						 $trTemp.appendTo("#J_TbData");
					     
					 });
				 },error:function(){
			    	alert("提示信息");
			    	}
			 });                    
		 
     });                                                                                                                               
		                                                                                                          
		 

	</script>
<body style="margin-right: 138px;">

		
			<form id="" class="main form-horizontal" action="" method="">
				<table class="table-condensed">
					<tbody>
						<tr>
						<td><label class="control-label">器具编号:</label></td>
						<td><input  class="formstyle"  type="text"></td>
						<td><label class="control-label">器具名称:</label></td>
						<td><input  class="formstyle"  type="text"></td>
						
					    </tr>
					    
					    <tr>
						<td><label class="control-label">所属线体:</label></td>
						<td><input  class="formstyle"  type="text"></td>
						<td><label class="control-label">设备名称:</label></td>
						<td ><select class="formstyle" >
								<option value="1">test</option>
						</select></td>
						</tr>
					   
					 
				       
				</tbody>
            </table>
             <div class="button_position" style="margin-left: 550px;">
						 	<button class="blue_btn" value="查询">查询</button>
						 	<button class="blue_btn"   id="addTest"  value="新增">新增</button>
						 	<button class="blue_btn" value="编辑">编辑</button>
						 	<button class="blue_btn" value="保存">保存</button>
		   </div> 
		</form>
		   
					   
       <table class="table table-bordered" >
       	<thead>
       		<tr id="" class="thcolor" style=" color: white;">
       			<th style="text-align: center;">序号</th>
       			<th style="text-align: center;">器具编号</th>
       			<th style="text-align: center;">器具名称</th>
       			<th style="text-align: center;">规格型号</th>
       			<th style="text-align: center;">数量</th>
       			<th style="text-align: center;">所属区域</th>
       			<th style="text-align: center;">检验方式</th>
       			<th style="text-align: center;">上次送检时间</th>
       			<th style="text-align: center;">下次送检时间</th>
       			<th style="text-align: center;">投入使用时间</th>
       			<th style="text-align: center;">备注</th>
       		
       			
       		</tr>
      <tbody id="J_TbData">
       
       		<tr>
       			<td data="1"  style="text-align: center;" id="id"></td>
       			<td  data="1"  style="text-align: center;" id="number" ></td>
       			<td  data="1"  style="text-align: center;" id="name"></td>
       			<td data="1"  style="text-align: center;" id="type"></td>
       			<td data="1"  style="text-align: center;" id="quantity"></td>
       			<td data="1"  style="text-align: center;" id="area"></td>
       			<td  data="1"  style="text-align: center;" id="checktype"></td>
       			<td  data="1"  style="text-align: center;" id="checktime"></td>
       			<td  data="1"  style="text-align: center;" id="tochecktime"></td>
       			<td  data="1"  style="text-align: center;" id="tousetime"></td>
       			<td  data="1"  style="text-align: center;" id="remark"></td>	
       		</tr>
       	 </tbody>
       	</thead>
       	
       </table>

	</body>

</html>