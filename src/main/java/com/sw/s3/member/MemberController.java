package com.sw.s3.member;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("memberUpdate")
	public void memberUpdate() throws Exception {
	}

	@RequestMapping(value = "memberUpdate", method = RequestMethod.POST)
	public String memberUpdate(MemberDTO memberDTO, HttpSession session) throws Exception {
		int result = memberService.memberUpdate(memberDTO);
		
		if(result>0) {
			session.setAttribute("member", memberDTO);
		}
		return "redirect:../";
	}
	
	
	
	@RequestMapping("memberDelete")
	public String memberDelete(HttpSession session) throws Exception {
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member"); //object니까 형변환 필요
		int result = memberService.memberDelete(memberDTO); //DB에서 삭제 session에서는 DTO가지고 있어
		
		session.invalidate(); // session에서도 로그아웃 시켜줘야 안뜸
		
		return "redirect:../";
	}
	
	@RequestMapping("memberLogout")
	public String memberLogout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:../";
	}
	
	@RequestMapping("memberPage")
	public void memberPage() throws Exception {
	}
	
	
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
	
	@RequestMapping("memberJoinCheck")
	public void memberJoinCheck() throws Exception{
		
	}
	
	
	
	
	@RequestMapping("memberJoin")
	public void memberJoin() throws Exception{

	}
	
	@RequestMapping(value="memberJoin", method = RequestMethod.POST)
	public String memberJoin(MemberDTO memberDTO, Model model) throws Exception {
		//int result = memberService.memberJoin(memberDTO);
		Random random = new Random();
		int result = random.nextInt(2); //0이상 2미만
		
		String message = "회원가입 실패";
		String path = "./memberJoin";
		
		if(result>0) {
			message="회원가입 성공";
			path = "../";
		}
		
		model.addAttribute("msg", message);
		model.addAttribute("path", path);
		
		return "member/memberJoinResult";
	}
	
	
	
	

}
