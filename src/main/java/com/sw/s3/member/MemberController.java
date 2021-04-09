package com.sw.s3.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

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
		int result = memberService.memberDelete(memberDTO, session); //DB에서 삭제 session에서는 DTO가지고 있어
		
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
	public String memberJoin(MemberDTO memberDTO, MultipartFile avatar, HttpSession session, Model model) throws Exception { //Controller에서 MultipartFile 변수명은 parameter이름과 동일해야(name속성) ---jsp에서 보낼때 avatar로 보내니까
		int result = memberService.memberJoin(memberDTO, avatar, session);
		
		System.out.println(avatar.getName());				//파라미터명
		System.out.println(avatar.getOriginalFilename());	//upload 할 때 파일명
		System.out.println(avatar.getSize());				//파일의 크기(byte)
		System.out.println(avatar.isEmpty());				//파일의 존재유무
		
		String message = "회원가입 실패";
		String path = "./memberJoin"; //url주소창 보고 현재 위치가 member폴더 밑
		
		if(result>0) {
			message="회원가입 성공";
			path = "../";
		}
		
		model.addAttribute("msg", message);
		model.addAttribute("path", path);
		
		return "common/commonResult"; //dispatcherServlet에서 앞뒤로 붙여줘
	}
	
	
	
	

}
