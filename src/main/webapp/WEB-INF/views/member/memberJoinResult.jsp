<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	alert('${msg}');    /* el에서 문자열 출력하고 싶을땐 앞뒤로 홑따옴표나 쌍따옴표 */
	location.href="${path}"; //성공 - ../   실패 - ./memberJoin
</script>
</head>
<body>

</body>
</html>