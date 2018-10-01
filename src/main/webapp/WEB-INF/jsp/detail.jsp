
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="css/bootstrap.min.css">
		
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="js/jquery-1.11.0.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="js/bootstrap.min.js"></script>


<script type="application/javascript">
			// jQuery是当前最强大的前端框架，封装JavaScript脚本，可以理解成前端的标准
			$(function(){
				
				$("#addBtn").click(function(){
					// 获得控件
					var count = $("#count");
					
					var message = "";
					if(count.val() == ""){
						message = "购买数量不能为空";
					}
					
					if(message != ""){
						alert(message);
						return false;
					}else{
						// 提交表单
						$("#addshopcarForm").submit();
					}
					
				})
				
			})
		</script>
		
</head>
<body>


<div class="container">

	<div class="alert alert-info" role="alert">欢迎${user.username }访问&nbsp;&nbsp;
	<a href="findAll">首页</a>
	</div>

	<div class="panel panel-primary">
	<div class="panel-heading">
		<div class="panel-title">图书详细信息</div>
	</div>
	<div class="panel-body">
	<div class="row">
		<div class="col-md-10 col-sm-12 col-xs-12">
			<table>
				<tbody>
					<tr>
						<!-- 图片占6行 -->
						<td rowspan="6">
							<img alt="" src="images/${book.image }" >
						</td>
					</tr>
					<tr>
						<td>${book.remark }</td>
					</tr>
					
					<tr>
						<td>${book.name }</td>
					</tr>
					
					<tr>
						<td>${book.author }</td>
					</tr>
					
					<tr>
						<td><font color="red">￥${book.price }</font></td>
					</tr>
					
					<tr>
						<td>
							<!-- form-inline 表单在一行水平排列 -->
							<form class="form-inline" action="addshopcar.jsp" method="post" id="addshopcarForm">
								<!-- hidden 隐藏表单域 -->
								<input type="hidden" name="id" value="${book.id }"/>
								<input type="text" name="count" size="2"  value="1" id="count"/>
							    <button type="submit" class="btn btn-danger" id="addBtn">加入购物车</button>
							</form>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	</div>
	</div>
	
</div>
	<%
%>

</body>
</html>