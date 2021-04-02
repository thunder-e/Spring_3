package com.sw.s3.board.notice;

import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.sw.s3.board.BoardDTO;
import com.sw.s3.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping("noticeList")
	public ModelAndView getList(Pager pager) throws Exception { 		//b. 파라미터가 오지 않을 경우  @RequestParam(defaultValue="기본값") 데이터타입 변수명 @RequestParam(defaultValue = "1") long curPage
		ModelAndView mv = new ModelAndView();
		System.out.println(pager.getCurPage());
		List<BoardDTO> ar = noticeService.getList(pager);
		
//		List<NoticeDTO> ar = noticeService.getList(curPage);
		mv.addObject("list", ar);
		mv.setViewName("board/boardList");
		mv.addObject("board", "notice");
		mv.addObject("pager", pager);
		return mv;
	}
	
	@GetMapping("noticeSelect")
	public ModelAndView getSelect(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		boardDTO = noticeService.getSelect(boardDTO);
		mv.addObject("dto", boardDTO); //실제로 만들어진건 noticeDTO -> result type
		mv.addObject("board", "notice");
		mv.setViewName("board/boardSelect");
		return mv;
	}
	
	
	
	@RequestMapping("noticeInsert")
	public ModelAndView setInset() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardInsert");
		mv.addObject("board", "notice");
		
		return mv;
	}
	
	
	
	@RequestMapping(value = "noticeInsert", method = RequestMethod.POST)
	public String setInsert(BoardDTO boardDTO, Model model) throws Exception {
		int result = noticeService.setInsert(boardDTO);
		
		String message = "등록 실패";
		
		if(result>0) {
			message = "공지글이 작성되었습니다";
		}
		
		model.addAttribute("msg", message);
		model.addAttribute("path", "./noticeList");
		
		return "common/commonResult";
		//return "redirect:noticeList";
	}
	
	
	
	@GetMapping("noticeUpdate")
	public ModelAndView setUpdate() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", "notice");
		mv.setViewName("board/boardUpdate");
		return mv;
	}
	
	@PostMapping("noticeUpdate")
	public String setUpdate(BoardDTO boardDTO, Model model) throws Exception {
		System.out.println(boardDTO.getNum());
		int result = noticeService.setUpdate(boardDTO);
		model.addAttribute("dto", boardDTO);
		
		return "redirect:./noticeList";
	}
	
	@RequestMapping("noticeDelete")
	public String setDelete(BoardDTO boardDTO) throws Exception {
		int result = noticeService.setDelete(boardDTO);
		return "redirect:./noticeList";
	}
	
	
	
	
	
	
	
	

}
