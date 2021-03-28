<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootStrap.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<h2>Notice Select Page</h2>

<div class="container">
<table class="table">
	<thead class="thead-dark">
		<tr>
			<th>SUBJECT</th>
			<th>NAME</th>
			<th>DATE</th>
			<th>HIT</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>${dto.title}</td>
			<td>${dto.writer}</td>
			<td>${dto.regdate}</td>
			<td>${dto.hit}</td>
		</tr>
	</tbody>
</table>
		<div>${dto.contents}</div>
	
</div>

<c:catch>
<c:if test="${member.id eq 'admin'}">
<div class="container">
<a href="./noticeUpdate" class="btn btn-primary" role="button">Update</a>
<a href="./noticeDelete" class="btn btn-primary" role="button">Delete</a>
</div>
</c:if>
</c:catch>


</body>
</html>