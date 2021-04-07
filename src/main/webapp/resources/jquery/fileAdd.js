/**
 * 
 */
let count = 0;

$("#add").click(function(){
	
	if(count<5) {
	$("#files").append($("#sample").html());
	count++;
	} else {
		alert("최대 5개만 가능");
	}
	
	/*
	let contents = $("#sample").html();
	$("#files").append(contents);
	*/	
})



$("#del").click(function(){
	$("#files").empty();
})
	
//이벤트 전달(위임)
$("#files").on("click", ".delete", function(){
	$(this).parent().remove();
	count--;
});
