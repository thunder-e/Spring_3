<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<c:import url="./template/bootStrap.jsp"></c:import>

<link rel="stylesheet" href="./resources/css/test.css">
<title>Home</title>
</head>
<body>

	<c:import url="./template/header.jsp"></c:import>




 <div>
 	<button id="btn" onclick="go()">CLICK</button>
 	<button onclick="go2()">CLICK2</button>
 </div>
 
 
 <div id="c1" class="b1">
 	<h1 id="t1">Welcome Home Page</h1> 
 	<input type="text">
 </div>
 
 
 
<script type="text/javascript" src="./resources/js/test.js"></script>
 
 
</body>
</html>