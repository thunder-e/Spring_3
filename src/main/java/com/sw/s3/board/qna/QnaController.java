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
import com.sw.s3.util.Pager_backUp;

import oracle.jdbc.proxy.annotation.Post;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	
	
	@PostMapping("qnaReply")
	public ModelAndView setReply(QnaDTO qnaDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setReply(qnaDTO);
		mv.setViewName("redirect:./qnaList");
		
		return mv;
	}
	
	@GetMapping("qnaReply")
	public ModelAndView setReply() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardReply");
		mv.addObject("board", "qna");

		return mv;
	}
	
	
	@GetMapping("qnaList")
	public ModelAndView getList(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar = qnaService.getList(pager);
		mv.addObject("list", ar);
		mv.addObject("board", "qna");
		mv.setViewName("board/boardList");
		mv.addObject("pager", pager);
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
	public ModelAndView setInsert(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setInsert(boardDTO);
		mv.setViewName("redirect:./qnaList");
		
		return mv;
	}
	
	@GetMapping("qnaSelect")
	public ModelAndView getSelect(BoardDTO boardDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		boardDTO = qnaService.getSelect(boardDTO);
		mv.addObject("dto", boardDTO);
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
