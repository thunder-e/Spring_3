<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook Select</h1>
	
	<h3>Name : ${dto.bookName}</h3>
	<h3>Number : ${dto.bookNumber}</h3>
	
	<a href="./bankbookDelete?bookNumber=${dto.bookNumber}">Delete</a>
	<a href="./bankbookUpdate?bookNumber=${dto.bookNumber}">Update</a>

</body>
</html>