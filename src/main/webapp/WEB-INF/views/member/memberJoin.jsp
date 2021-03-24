<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member Join Form</h1>
	
	<form action="./memberJoin" method="post">
		ID : <input type="text" name="id" value="${dto.id}"><br>
		PW : <input type="password" name="pw" value="${dto.pw}"><br>
		Name : <input type="text" name="name" value="${dto.name}"><br>
		Phone : <input type="text" name="phone" value="${dto.phone}"><br>
		Email : <input type="text" name="email" value="${dto.email}"><br>
		<button>Join</button>
	</form>
	
	
	

</body>
</html>