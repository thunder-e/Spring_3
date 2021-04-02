/**
 * 
 */

let id= document.getElementById("id");
let pw = document.getElementById("pw");
let pw2 = document.getElementById("pw2");
let btn = document.getElementById("btn");
let etc = document.getElementsByClassName("etc");

let idCheckResult = false; 	// id check 결과
let pwCheckResult = false; 	// pw check 결과
let pwEqualResult = false; 	// pw equal 결과
let etcResult = true; 		// name, email, phone 결과

/***** ID CHECK ******************/
id.addEventListener("blur", function(){
	let message = "6글자 미만입니다";
	let c = "r1";
	if(id.value.length>5){
		message="6글자 이상입니다";
		c="r2";
		idCheckResult=true;
	} else {
		idCheckResult=false;
	}
	
	let idResult = document.getElementById("idResult");
	idResult.innerHTML = message;
	idResult.setAttribute("class", c);
});
/********************************/ //또는 change함수를 또 불러


/***** PW CHECK ******************/
pw.addEventListener("blur", function(){
	pwCheckResult=false;
	let message="8글자 미만입니다";
	let c= "r1";	
	if(pw.value.length>7) {
		message="8글자 이상입니다";
		c="r2";
		pwCheckResult=true;
	} 
	let pwR = document.getElementById("pwResult");
	pwR.innerHTML = message;
	pwR.setAttribute("class",c);

})
/*************** ******************/


pw.addEventListener("change", function(){
	pw2.value="";
})



/***** PW EQUAL CHECK ******************/
pw2.addEventListener("blur", function(){
	if(pw.value!=pw2.value) {
		pw2.value="";
	} else {
		pwEqualResult = true;
	}
})


/********** ETC ***********/




btn.addEventListener("click", function(){
	for(let e of etc) {
		if(e.value=="") {
			etcResult=false;
			break;
		}
	}
	
	
	
	
	
	

	//조건이 만족하면 서버로, submit 이벤트를 강제발생시켜야
	if(idCheckResult && pwCheckResult && pwEqualResult && etcResult) {
		
	let frm = document.getElementById("frm");
	//frm.submit();	
	alert("회원가입 진행")
	} else {
		alert("필수 항목을 입력하세요");
	}
})



