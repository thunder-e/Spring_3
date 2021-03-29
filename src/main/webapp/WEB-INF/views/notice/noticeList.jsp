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



<div class="container">
<h2>Notice List Page</h2>
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
	<c:forEach items="${list}" var="dto">
	<tr>
		<td>${dto.num}</td>
		<td><a href="./noticeSelect?num=${dto.num}">${dto.title}</a></td>
		<td>${dto.writer}</td>
		<td>${dto.regDate}</td>
		<td>${dto.hit}</td>
	</tr>
	</c:forEach>
</tbody>
</table>

	
	<div class="container">
 
  <ul class="pagination">
    <li class="page-item"><a class="page-link" href="#">Previous</a></li>
    
    <c:forEach begin="1" end="${pager.totalPage}" var="i">
    <li class="page-item"><a class="page-link" href="./noticeList?curPage=${i}">${i}</a></li>
	</c:forEach>
    <li class="page-item"><a class="page-link" href="#">Next</a></li>
  </ul>
</div>
	


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