<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>My Page</h1>
	<h3>ID : ${member.id}</h3> <!-- session에 있는(login할때 담아둠) -->
	<h3>Name : ${member.name}</h3>
	<h3>Phone : ${member.phone}</h3>
	<h3>Email : ${member.email}</h3>
	<h3><img alt="" src="../resources/upload/member/${member.memberFileDTO.fileName}"></h3> <!-- session에 "member"라는 이름으로 memberDTO를 넘겨줬음 -->
	<!-- memberDTO에 있는 memberFileDTO의 파일이름을 꺼내와 -->
	
	
	<a href="./memberUpdate">수정</a>
	<a href="./memberDelete">탈퇴</a>
	<a href="../account/accountList">계좌관리</a>

</body>
</html>