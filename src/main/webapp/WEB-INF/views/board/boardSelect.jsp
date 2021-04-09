<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<h2>${board}SelectPage</h2>
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

		<div>
			<c:forEach items="${dto.boardFiles}" var="file">
				<a href="../resources/upload/${board}/${file.fileName}">${file.origineName}</a>
			</c:forEach>
		</div>


		<!-- 댓글 리스트 -->
		<div id="comments" title="${dto.num}"></div>


		<div>
			<div class="form-group">
				<label for="usr">Name:</label> <input type="text"
					class="form-control" id="writer">
			</div>

			<div class="form-group">
				<label for="comment">Comment:</label>
				<textarea class="form-control" rows="5" id="contents"></textarea>
			</div>
			
			<button type="button" class="btn btn-success" id="write">Write</button>
		</div>

	</div>



	<c:catch>
		<%-- <c:if test="${member.id eq 'admin'}"> --%>
		<div class="container">
			<a href="./${board}Update?num=${dto.num}" class="btn btn-primary"
				role="button">Update</a> <a href="#" id="del" class="btn btn-danger"
				role="button">Delete</a>
			<c:if test="${board ne 'notice'}">
				<a href="./${board}Reply?num=${dto.num}" class="btn btn-info">Reply</a>
			</c:if>


			<form action="./${board}Delete" id="frm" method="get">
				<input type="hidden" name="num" value="${dto.num}">
			</form>


		</div>
		<%-- </c:if> --%>
	</c:catch>
	<script type="text/javascript" src="../resources/jquery/comments.js"></script>
	<script type="text/javascript">
		const del = document.getElementById("del");
		const frm = document.getElementById("frm");

		del.addEventListener("click", function() {
			let result = confirm("Delete??");

			if (result) {
				//frm.method="post";
				frm.setAttribute("method", "post");
				frm.submit();
				//location.href="./${board}Delete?num=${dto.num}";
			}
		})
	</script>

</body>
</html>