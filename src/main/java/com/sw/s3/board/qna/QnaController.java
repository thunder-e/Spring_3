package com.sw.s3.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sw.s3.board.BoardDTO;
import com.sw.s3.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@GetMapping("qnaList")
	public ModelAndView getList(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar = qnaService.getList(pager);
		mv.addObject("list", ar);
		mv.addObject("board", "qna");
		mv.setViewName("board/boardList");
	
		return mv;
}
	
	@GetMapping("qnaInsert")
	public ModelAndView setInsert() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardInsert");
		mv.addObject("board", "qna");		
		
		return mv;
	}
	
	@PostMapping("qnaInsert")
	public String setInsert(QnaDTO qnaDTO, Model model) throws Exception {
		int result = qnaService.setInsert(qnaDTO);
		
		return "redirect:./qnaList";
	}
	
	@GetMapping("qnaSelect")
	public ModelAndView getSelect(QnaDTO qnaDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		qnaDTO = (QnaDTO)qnaService.getSelect(qnaDTO);
		mv.addObject("dto", qnaDTO);
		mv.addObject("board", "qna");
		mv.setViewName("board/boardSelect");
		
		return mv;
	}
	
	@GetMapping("qnaDelete")
	public String setDelete(QnaDTO qnaDTO) throws Exception {
		int result = qnaService.setDelete(qnaDTO);
		return "redirect:./qnaList";
	}
	
	
	
	@GetMapping("qnaUpdate")
	public ModelAndView setUpdate() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", "qna");
		mv.setViewName("board/boardUpdate");
		
		return mv;
	}
	
	@PostMapping("qnaUpdate")
	public String setUpdate(QnaDTO qnaDTO) throws Exception {
		int result = qnaService.setUpdate(qnaDTO);
		
		return "redirect:./qnaList";
	}
	
	
}
