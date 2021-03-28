<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../template/bootStrap.jsp"></c:import>
<title>Insert title here</title>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>


<h1>Notice List Page</h1>

<div class="container">
<table class="table">
<thead class="thead-dark">
	<tr>
		<th>NO</th>
		<th>SUBJECT</th>
		<th>NAME</th>
		<th>DATE</th>
		<th>HIT</th>
	</tr>
</thead>
<tbody>
	<c:forEach items="${list}" var="notice">
	<tr>
		<td>${notice.num}</td>
		<td><a href="./noticeSelect?num=${notice.num}">${notice.title}</a></td>
		<td>${notice.writer}</td>
		<td>${notice.regdate}</td>
		<td>${notice.hit}</td>
	</tr>
	</c:forEach>
</tbody>
</table>
</div>


<c:catch>
<c:if test="${member.id eq 'admin'}">
<div class="container">
<a href="./noticeInsert" class="btn btn-primary" role="button">Write</a>
</div>
</c:if>
</c:catch>

</body>
</html>