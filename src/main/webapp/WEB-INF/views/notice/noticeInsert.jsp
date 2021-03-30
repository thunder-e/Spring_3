<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootStrap.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

	<div class="container">
		<h2>Notice form</h2>
		<form action="./noticeInsert" method="post">
			<div class="form-group">
				<label for="writer">Writer:</label> 
				<input type="text" readonly="readonly" value="${member.id}" class="form-control" id="writer" name="writer"> 
			</div>
		
			<div class="form-group">
				<label for="title">Title:</label> 
				<input type="text" class="form-control" id="title" name="title"> 
			</div>			
		
			<div class="form-group">
				<label for="contents">Contents:</label> 
				 <textarea class="form-control" rows="5" id="contents" name="contents"></textarea>
			</div>
			
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>



</body>
</html>