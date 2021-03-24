package com.sw.s3.member;

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
	
	
	@RequestMapping("memberLogin")
	public void memberLogin(MemberDTO memberDTO, Model model) throws Exception{
		model.addAttribute("dto", memberDTO);
		
	}
	
	@RequestMapping(value="memberLogin", method=RequestMethod.POST)
	public ModelAndView memberLogin(MemberDTO memberDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		memberDTO = memberService.memberLogin(memberDTO);
		mv.addObject("dto", memberDTO);
		mv.setViewName("redirect:../");
		return mv;
	}
	
	
	@RequestMapping("memberJoin")
	public void memberJoin(MemberDTO memberDTO, Model model) throws Exception{
		model.addAttribute("dto", memberDTO);
	}
	
	@RequestMapping(value="memberJoin", method = RequestMethod.POST)
	public String memberJoin(MemberDTO memberDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		memberService.memberJoin(memberDTO);
		return "redirect:../";
		
	}
	
	
	
	

}
