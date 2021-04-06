<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootStrap.jsp"></c:import>
<style type="text/css">
	#sample {
		display: none;
	}
</style>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

	<div class="container">
		<h2>${board} form</h2>
		<form id="frm" action="./${board}Insert" method="post">
			<div class="form-group">
				<label for="writer">Writer:</label> 
				<input type="text" readonly="readonly" value="${member.id}" class="form-control myCheck" id="writer" name="writer"> 
			</div>
		
			<div class="form-group">
				<label for="title">Title:</label> 
				<input type="text" class="form-control myCheck" id="title" name="title"> 
			</div>			
		
			<div class="form-group">
				<label for="contents">Contents:</label> 
				 <textarea class="form-control myCheck" rows="5" id="contents" name="contents"></textarea>
			</div>
			<input type="button" id="add" value="ADD" class="btn btn-danger">
			<div id="files">
				
			</div>
			
			
			<input type="button" id="btn" value="WRITE" class="btn btn-primary">
		</form>
	</div>
	
	<div id="sample">
		<div class="form-group">
	      <input type="file" class="form-control-file border" name="file">
	    </div>
    </div>

  <script type="text/javascript" src="../resources/jquery/boardInsert.js"></script> 
  <script type="text/javascript">
  	
  
  	$("#add").click(function(){
  		$("#files").append($("#sample").html());
  		//if($("#files").
  	})
  
  </script>
</body>
</html>