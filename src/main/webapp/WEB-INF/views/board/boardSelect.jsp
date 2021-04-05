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


<div class="container">
<h2>${board} Select Page</h2>
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
			<td>${dto.regDate}</td>
			<td>${dto.hit}</td>
		</tr>
	</tbody>
</table>
		<div>${dto.contents}</div>
</div>

<c:catch>
<c:if test="${member.id eq 'admin'}">
<div class="container">
<a href="./${board}Update?num=${dto.num}" class="btn btn-primary" role="button">Update</a>
<a href="./${board}Delete?num=${dto.num}" class="btn btn-danger" role="button">Delete</a>
<c:if test="${board ne 'notice'}">
	<a href="./${board}Reply?num=${dto.num}" class="btn btn-info">Reply</a>
</c:if>
</div>
</c:if>
</c:catch>


</body>
</html>