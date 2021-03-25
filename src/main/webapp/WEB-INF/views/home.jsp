<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<a href="./bankbook/bankbookList">BankBook List</a>


<c:choose>

	<c:when test=""></c:when>
	<c:when test=""></c:when>
	<c:otherwise></c:otherwise>

</c:choose>






<c:if test="${empty member}">
<a href="./member/memberJoin">Join</a>
<a href="./member/memberLogin">Login</a>
</c:if>

<c:if test="${not empty member}">
<h3> ${member.id} 님 환영합니다</h3>
<a href="./member/memberPage">MyPage</a>
<a href="./member/memberLogout">Logout</a>
</c:if>

</body>
</html>
