/**
 * 
 */
//번호 가져오려는데 jsp가 아니면 el 쓸 수 없으므로 boardSelect.jsp에서 title에 값을 넣어 준 뒤 가져오기
let num=$("#comments").attr("title");
getList();

$("#comments").on("click", "#remove", function(){
	const ar = []; //빈 배열
	$(".del").each(function(){
		let ch = $(this).prop("checked");
		if(ch){
			ar.push($(this).val());
		}
	});
	
	$.ajax({
		type: "POST",
		url: "../comments/commentsDelete",
		traditional: true, //배열은 전송
		data:{commentNum:ar},
		success:function(data){
			alert(data);
		}
	});

	
	
});




//호출하기 쉽게 function으로 만들어
function getList(){
	
	//ajax get
	$.get("../comments/commentsList?num="+num, function(data){
		console.log(data);
		$("#comments").html(data.trim());
	});
}



$("#write").click(function(){
	let writer = $("#writer").val();
	let contents = $("#contents").val();
	
	$.post("../comments/commentsInsert", 
	{
		num:num,
		writer:writer,						//파라미터명:변수명
		contents:contents
	},
	function(data){					//1:성공, 0:실패
		 data = data.trim();
		if(data==1) {
			alert("등록 성공");
			$("#writer").val("");
			$("#contents").val("");
			getList();
		} else {
			alert("등록 실패");
		}
	}) 
});

