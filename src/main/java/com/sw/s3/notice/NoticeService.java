package com.sw.s3.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sw.s3.util.Pager;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	public List<NoticeDTO> getList(Pager pager) throws Exception {
		int perPage = 10; // 한 페이지당 보여줄 글의 갯수
		int perBlock = 5; // 한 블럭당 보여줄 숫자의 갯수
		
		// ---- startRow, lastRow ----
		long startRow = (pager.getCurPage()-1)*perPage+1;
		long lastRow = pager.getCurPage()*perPage;
		
		pager.setStartRow(startRow);
		pager.setLastRow(lastRow);
		// ---------------------------
		
		// ---------------------------
		long totalCount=120;
		long totalPage= totalCount/perPage;
		if(totalCount%perPage!=0) {
			totalPage++;
		}
		pager.setTotalPage(totalPage);
		// jsp로 보낼 데이터는 Controller에서 Model이나 MV로 보내줌
		// Controller에 보내야 하는데 이미 리턴은 있으니까 Pager에 멤버변수로 
		System.out.println("TotalPage : " + totalPage);
				
		return noticeDAO.getList(pager);
	}
	
	public NoticeDTO getSelect(NoticeDTO noticeDTO) throws Exception {
		noticeDAO.setHitUpdate(noticeDTO); 
		return noticeDAO.getSelect(noticeDTO);
	}
	
	public int setInsert(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.setInsert(noticeDTO);
	}
	
	public int setUpdate(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.setUpdate(noticeDTO);
	}
	
	public int setDelete(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.setDelete(noticeDTO);
	}

}
