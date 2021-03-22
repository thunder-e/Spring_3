package com.sw.s3.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService;
	
	//상품 리스트
	@RequestMapping(value="/bankbook/bankbookList")
	public void bankbookList(Model model) throws Exception{
		
		List<BankBookDTO> ar = bankBookService.getList();
		model.addAttribute("list", ar);
	//	model.addAttribute("kind", "Bankbook EL Test");
	}
	//상품 등록
	@RequestMapping(value="/bankbook/bankbookAdd")
	public void bankbookAdd() throws Exception{
		
	}//-> 폼으로 이동
	
	@RequestMapping(value="/bankbook/bankbookAdd", method = RequestMethod.POST)
	public ModelAndView bankbookAdd(BankBookDTO bankBookDTO, ModelAndView mv) throws Exception{
		
		bankBookService.setAdd(bankBookDTO);
		mv.addObject("dto", bankBookDTO);
		mv.setViewName("redirect:bankbookList");
		return mv;
	}//-> 파라미터 받아서 db에 연결
	
	//상품 상세
	@RequestMapping(value="/bankbook/bankbookSelect")
	public ModelAndView bankbookSelect(BankBookDTO bankBookDTO, ModelAndView modelAndView) throws Exception {
		System.out.println("Number : " + bankBookDTO.getBookNumber());
		bankBookDTO = bankBookService.getSelect(bankBookDTO);
		modelAndView.addObject("dto", bankBookDTO);
		modelAndView.setViewName("bankbook/bankbookSelect");
		
		return modelAndView;
	}
	
	//상품 수정
	@RequestMapping(value="/bankbook/bankbookUpdate")
	public void bankbookUpdate() throws Exception {
		
	}
	
	@RequestMapping(value="/bankbook/bankbookUpdate", method = RequestMethod.POST)
	public ModelAndView bankbookUpdate(BankBookDTO bankBookDTO, ModelAndView modelAndView) throws Exception {
		
		modelAndView.setViewName("bankbook/bankbookUpdate");
		modelAndView.addObject("dto", bankBookDTO);
		return modelAndView;
	}
	
	
	//상품 삭제
	@RequestMapping(value="/bankbook/bankbookDelete")
	public ModelAndView bankbookDelete(ModelAndView modelAndView) throws Exception {
		
		return modelAndView;
	}
	
	
	
	
	
	
	
	
	
}
