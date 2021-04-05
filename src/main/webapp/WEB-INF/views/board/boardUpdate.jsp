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
<h1>${board} Update Page</h1>
		<form action="./${board}Update" method="post">
			<input type="hidden" name="num" value="${param.num}">
			
			<div class="form-group">
				<label for="title">Subject</label> 
				<input type="text" class="form-control" id="title" name="title" value="${param.title}"> 
			</div>			
			
<%-- 		<div class="form-group">
				<label for="writer">name</label> 
				<input type="text" class="form-control" id="writer" name="writer" value="${dto.writer}"> 
			</div>
--%>	
			
			<div class="form-group">
				<label for="contents">Contents</label> 
				<input type="text" class="form-control" id="contents" name="contents" value="${param.contents}"> 
			</div>
			
			
			<input type="hidden" name="writer" value="${dto.writer}">
			<input type="hidden" name="hit" value="${dto.hit}">
			<input type="hidden" name="regDate" value="${dto.regDate}">
			
			
			
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>

</body>
</html>