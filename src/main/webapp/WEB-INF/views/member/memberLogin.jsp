<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member Login Form</h1>
	
	<form action="./memberLogin" method="post">
		ID : <input type="text" name="id" value="${dto.id}">
		PW : <input type="password" name="pw" value="${dto.pw}">
		<button>Login</button>
	</form>
	
	
</body>
</html>