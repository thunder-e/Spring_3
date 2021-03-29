package com.sw.s3.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

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
		System.out.println("Service 호출전 : " + pager.getTotalPage());
		List<NoticeDTO> ar = noticeService.getList(pager);
		System.out.println("Service 호출후 : " + pager.getTotalPage());
//		List<NoticeDTO> ar = noticeService.getList(curPage);
		mv.addObject("list", ar);
		mv.setViewName("notice/noticeList");
		mv.addObject("pager", pager);
		return mv;
	}
	
	private boolean toString(long curPage) {
		// TODO Auto-generated method stub
		return false;
	}

	@RequestMapping("noticeSelect")
	public void getSelect(NoticeDTO noticeDTO, Model model) throws Exception {
		noticeDTO = noticeService.getSelect(noticeDTO);
		model.addAttribute("dto", noticeDTO);
	}
	
	@RequestMapping("noticeInsert")
	public void setInset() throws Exception {
		
	}
	@RequestMapping(value = "noticeInsert", method = RequestMethod.POST)
	public String setInset(NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.setInsert(noticeDTO);
		return "redirect:noticeList";
	}
	
	@RequestMapping("noticeUpdate")
	public void setUpdate() throws Exception {
	}
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.POST)
	public String setUpdate(NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.setUpdate(noticeDTO);
		return "redirect:noticeList";
	}
	
	@RequestMapping("noticeDelete")
	public String setDelete(NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.setDelete(noticeDTO);
		return "redirect:noticeList";
	}
	

}
