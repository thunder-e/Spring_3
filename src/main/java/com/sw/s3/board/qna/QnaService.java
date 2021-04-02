package com.sw.s3.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sw.s3.board.BoardDTO;
import com.sw.s3.board.BoardService;
import com.sw.s3.board.notice.NoticeDAO;
import com.sw.s3.util.Pager;

@Service
public class QnaService implements BoardService{

	@Autowired
	private QnaDAO qnaDAO;

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		int perPage = 10;
		int perBlock = 5;
		
		// ---- startRow, lastRow ----
		long startRow = (pager.getCurPage()-1)*perPage+1;	//화면의 첫 글		:	1	11	21	31
		long lastRow = pager.getCurPage()*perPage;			//화면의 마지막 글	:	10	20	30	40	
		
		pager.setStartRow(startRow);
		pager.setLastRow(lastRow);
		
		// 1. totalCount
		long totalCount	= qnaDAO.getTotalCount(pager);
		
		// 2. totalPage
		long totalPage = totalCount / perPage;
		if(totalCount%perPage!=0) {
			totalPage++;
		}
		
		// 3. totalBlock
		long totalBlock = totalPage / perBlock;
		if(totalPage%perBlock!=0) {
			totalBlock++;
		}
		
		// 4. curBlock
		long curBlock = pager.getCurPage() / perBlock;
		if(pager.getCurPage()%perBlock!=0) {
			curBlock++;
		}
		
		// 5. startNum, lastNum
		long startNum = (curBlock-1)*perBlock;
		long lastNum = curBlock*perBlock;
		
		//6. culBlock이 마지막 block일 때(totalBlock)
		if(curBlock == totalBlock) {
			lastNum = totalPage;
		}
		
		//7. 이전, 다음 block 존재 여부
		// 이전
		if(curBlock!=1) {
			pager.setPre(true);
		}
		//다음
		if(curBlock!=totalBlock) {
			pager.setNext(true);
		}
		
		pager.setStartNum(startNum);
		pager.setLastNum(lastNum);
		
		return qnaDAO.getList(pager);
	}

	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		return qnaDAO.getSelect(boardDTO);
	}

	@Override
	public int setInsert(BoardDTO boardDTO) throws Exception {
		return qnaDAO.setInsert(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return qnaDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return qnaDAO.setDelete(boardDTO);
	}
	

	
	
	
	
}
