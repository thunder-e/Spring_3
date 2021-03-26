package com.sw.s3.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bankbook/**")
public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService;
	
	@RequestMapping("bankbookUpdate")		//폼으로 이동 : GET
	public void setUpdate(BankBookDTO bankBookDTO, Model model) throws Exception {	//jsp에서 번호 준거(뭘 수정할지)를 받아와서 jsp로 다시 보내줘 
		bankBookDTO = bankBookService.getSelect(bankBookDTO);
		model.addAttribute("dto", bankBookDTO);
		
	}
	
	@RequestMapping(value="bankbookUpdate", method=RequestMethod.POST)	//입력한 것을 받아오는 post
	public String setUpdate(BankBookDTO bankBookDTO) throws Exception {
		int result = bankBookService.setUpdate(bankBookDTO);
		return "redirect:./bankbookList";
	}
	
	
	
	
	@RequestMapping("bankbookList")
	public void getList(Model Model) throws Exception {  	// void  :  요청한 URI가 View의 경로명으로 됨
		List<BankBookDTO> ar =  bankBookService.getList();
		Model.addAttribute("list", ar);
	}
	
	@RequestMapping("bankbookSelect")
	public ModelAndView getSelect(BankBookDTO bankBookDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		bankBookDTO = bankBookService.getSelect(bankBookDTO);
		
		mv.addObject("dto", bankBookDTO);
		mv.setViewName("bankbook/bankbookSelect");
		return mv;
	}
	
	@RequestMapping("bankbookDelete")
	public String setDelete(BankBookDTO bankBookDTO) throws Exception {
		System.out.println("Delete");
		System.out.println(bankBookDTO.getBookNumber());
		
		int result = bankBookService.setDelete(bankBookDTO);
		System.out.println(result);
	
		return "redirect:./bankbookList";
	}
	
	
}
