/**
 * 
 */

$(".fileDelete").click(function(){
	let check = confirm("정말 삭제하시겠습니까?");
	
	if(check) {
	//fileNum
	let fileNum = $(this).attr("title");
	let obj = $(this);
	//noticeFileDelete
	$.ajax({
		url:"./fileDelete",
		type: "GET",
		data: {fileNum:fileNum},
		success:function(result){
			result = result.trim();
			if(result>0){
				alert("삭제 성공");
				$(obj).parent().remove();
				count--;
			}else{
				alert("삭제 실패");
			}
		}
		
	});
}
});


