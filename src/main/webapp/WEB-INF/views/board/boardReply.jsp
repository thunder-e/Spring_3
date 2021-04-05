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
		<h2>${board} Reply form</h2>
		<form id="frm" action="./${board}Reply" method="post">
			<input type="hidden" name="num" value="${param.num}"> 
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
			
			<input type="submit" id="btn" value="WRITE" class="btn btn-primary">
		</form>
	</div>


<!--  <script type="text/javascript" src="../resources/js/insertCheck.js"></script> -->
</body>
</html>