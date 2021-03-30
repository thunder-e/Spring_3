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
		long startRow = (pager.getCurPage()-1)*perPage+1;	// 첫 글 		:	1	11	21	31
		long lastRow = pager.getCurPage()*perPage;			// 마지막 글	:	10	20	30	40
		
		pager.setStartRow(startRow);
		pager.setLastRow(lastRow);
		// ---------------------------
		
		// ---------------------------
		//1. totalCount
		long totalCount=noticeDAO.getTotalCount(pager);
		
		//2. totalPage
		long totalPage= totalCount / perPage;
		if(totalCount%perPage!=0) {
			totalPage++;
		}
		
		//3. totalBlock
		long totalBlock = totalPage / perBlock;
		if(totalPage%5 != 0) {
			totalBlock++;
		}
		
		//4. curBlock
		long curBlock = pager.getCurPage() / perBlock;
		if(pager.getCurPage()%perBlock != 0) {
			curBlock++;
		}
		
		//5. startNum, lastNum
		long startNum = (curBlock-1)*perBlock+1;
		long lastNum = curBlock*perBlock;
		
		//6. curBlock이 마지막 block일 때(totalBlock)
		if(curBlock == totalBlock) {
			lastNum = totalPage;
		}		
		
		//7. 이전, 다음 block 존재 여부
		//이전
		if(curBlock!=1) {
			pager.setPre(true);
		}
		//다음
		if(curBlock!=totalBlock) {
			pager.setNext(true);
		}
		
		
		// jsp로 보낼 데이터는 Controller에서 Model이나 MV로 보내줌
		// Controller에 보내야 하는데 이미 리턴은 있으니까 Pager에 멤버변수로  totalPage
	
		pager.setStartNum(startNum);
		pager.setLastNum(lastNum);
		System.out.println("TotalPage : " + totalPage);
		System.out.println("TotalBlock : " + totalBlock);
		System.out.println("CurBlock : " + curBlock);
		
				
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
