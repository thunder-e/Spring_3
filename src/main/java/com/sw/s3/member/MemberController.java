package com.sw.s3.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	
	@RequestMapping("memberLogin")		// 입력폼으로 가는
	public void memberLogin() throws Exception{
		
	}
	
	@RequestMapping(value="memberLogin", method=RequestMethod.POST) 	// DB
	public String memberLogin(MemberDTO memberDTO, HttpSession session) throws Exception {
		memberDTO = memberService.memberLogin(memberDTO);	 // 받아온 dto를 service로 보내
		System.out.println(memberDTO);
		session.setAttribute("member", memberDTO);
		return "redirect:../";
	}
	
	
	@RequestMapping("memberJoin")
	public void memberJoin() throws Exception{

	}
	
	@RequestMapping(value="memberJoin", method = RequestMethod.POST)
	public String memberJoin(MemberDTO memberDTO) throws Exception {
		int result = memberService.memberJoin(memberDTO);
		return "redirect:../";
		
	}
	
	
	
	

}
