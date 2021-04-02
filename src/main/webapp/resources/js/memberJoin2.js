/**
 * 
 */

let id = document.getElementById("id");
let pw = document.getElementById("pw");
let pw2 = document.getElementById("pw2");
let btn = document.getElementById("btn");
let name = document.getElementById("name");
let phone = document.getElementById("phone");
let email = document.getElementById("email");
let frm = document.getElementById("frm");

id.addEventListener("blur", function(){
	let message = "6글자 미만입니다";
	let c = "r1";
	if(id.value.length>5) {
		message = "6글자 이상입니다"
		c = "r2";
	}
	
	let idResult = document.getElementById("idResult");
	idResult.innerHTML = message;
	idResult.setAttribute("class", c);
})


pw.addEventListener("blur", function(){
	let message="8글자 미만입니다";
	let c= "r1";	
	if(pw.value.length>7) {
		message="8글자 이상입니다";
		c="r2";
	}
	
	let pwR = document.getElementById("pwResult");
	pwR.innerHTML = message;
	pwR.setAttribute("class",c);

})

pw.addEventListener("change", function(){
	pw2.value="";
})

pw2.addEventListener("blur", function(){
	if(pw.value!=pw2.value) {
		pw2.value="";
	}
})





btn.addEventListener("click",function(){
	if(name.value!=""&&email.value!=""&&phone.value!="") {
	//frm.submit();	
	alert("회원가입 진행")
	}

})
