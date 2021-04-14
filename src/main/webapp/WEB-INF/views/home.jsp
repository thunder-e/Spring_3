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
<style>
	#d1 {
		width: 200px;
		height: 200px;
		background-color: red;
		overflow: hidden;
	}
	
	#d2 {
		width: 50px;
		height: 50px;
		background-color: yellow;
		margin: 75px auto;
	}

</style>
</head>
<body>
<c:import url="./template/header.jsp"></c:import>
	
	
<button class="b" ID="btn1">BUTTON</button>
<button id="btn" class="b">CLICK</button>
<button id="btn2" class="b">CLICK2</button>
<button id="btn3">Exchange</button>

<input type="text" id="num">
<h1 id="t">version 3</h1>
<ol id="result">
	<li>A</li>
</ol>


<select id="mon">
	
</select>


<div id="d1">
	<div id="d2">
		<!-- title, contents -->
		<h3 id="d3"> </h3>
		<h3 id="d4"> </h3>
	</div>
</div>

 
<div id="exchange">
	<!-- KRW 입력 후 USD, JPY -->
	<h3 id="krw"></h3>
	<h3 id="usd"></h3>
	<h3 id="jpy"></h3>
</div>
 
 
<div id="map" style="width:500px;height:400px;"></div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=969c954537bd868d510e8f40a4ce5a09"></script>
	<script>
	getMap(33.333333,126.444444)
	
	function getMap(lat, lng) {
		var container = document.getElementById('map');
		var options = {
			center: new kakao.maps.LatLng(lat, lng),
			level: 3
		};
		var map = new kakao.maps.Map(container, options);
	}
		
		
		$("#btn1").click(function(){
			$.get("https://jsonplaceholder.typicode.com/users", function(data){
				console.log(data);
				
				for(index of data) {
					console.log(index.company.name);
				}
				
				//첫번째 user의 내용 중 geo의 lat, lng
				console.log(data[0].address.geo.lat);
				console.log(data[0].address.geo.lng);
				let t = parseFloat(data[0].address.geo.lat);
				let n = parseFloat(data[0].address.geo.lng);
				getMap(t,n);
			});
		});
		
		
		$("#btn3").click(function(){
			let num = $("#num").val();
			
			$.ajax({
				type: "GET",
				url: "https://api.manana.kr/exchange/price.json",
				data: {
					base: "KRW",
					price: 1300,
					code: "KRW,USD,JPY"
				},
				success: function(data){
					console.log(data);
					$("#krw").html(data.KRW);
					$("#usd").html(data.USD);
				}
		
			});
		});
		
		
		
		
		$("#btn2").click(function() {
			let num = $("#num").val();
			
			$.get("https://jsonplaceholder.typicode.com/posts/"+ num, function(data){

				console.log(data);
				
				$("#d3").html(data.title);
				$("#d4").html(data.body);
			});
		});

		
		
		
		
	</script>

<!-- <script type="text/javascript">
	$("#btn2").click(function(){
		$.get("./test?num=3", function(data){ 		//결과물을 data로 받아 -> test.jsp 전체
			console.log(data);
			$("#d2").html(data);
		});	
	})
	


</script> -->

</body>
</html>