package com.sw.s3.account;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sw.s3.member.MemberDTO;

@Controller
@RequestMapping("/account/**")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("accountList")
	public void getList(HttpSession session, Model model) throws Exception {
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");	// session 안에 있는 멤버디티오
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setId(memberDTO.getId());
		List<AccountDTO> ar = accountService.getList(accountDTO);	
		model.addAttribute("list", ar);	
	}
	
	@RequestMapping("accountInsert")
	public String setInsert(AccountDTO accountDTO, HttpSession session) throws Exception { //bookSelect.jsp에서 넘겨준 북넘버 -> accountDTO, id -> Session에서 꺼내
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		accountDTO.setId(memberDTO.getId());
		int result = accountService.setInsert(accountDTO);
		return "redirect:./accountList";
	}

	/*
	@RequestMapping(value = "accountInsert", method = RequestMethod.POST)
	public String setInsert(HttpSession session) throws Exception {
		int result = accountService.setInsert(accountDTO);
		if(result>0) {
			session.setAttribute("account", accountDTO);
		}
		
		return "redirect:../";
	}
	*/
	

}
