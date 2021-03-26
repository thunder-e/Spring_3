package com.sw.s3.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping("noticeList")
	public void getList(Model model) throws Exception {
		List<NoticeDTO> ar = noticeService.getList();
		model.addAttribute("list", ar);
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
