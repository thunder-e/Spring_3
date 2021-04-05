package com.sw.s3.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sw.s3.board.BoardDTO;
import com.sw.s3.board.BoardService;
import com.sw.s3.util.Pager;
import com.sw.s3.util.Pager_backUp;

@Service
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	public List<BoardDTO> getList(Pager pager) throws Exception {

		// ---- startRow, lastRow ----
		pager.makeRow();

		// ---- 페이징계산 ----
		long totalCount = noticeDAO.getTotalCount(pager);
		pager.makeNum(totalCount);
		
		return noticeDAO.getList(pager);
	}

	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		noticeDAO.setHitUpdate(boardDTO);
		return noticeDAO.getSelect(boardDTO);
	}

	@Override
	public int setInsert(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setInsert(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		System.out.println("NUM : " + boardDTO.getNum());
		return noticeDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return noticeDAO.setDelete(boardDTO);
	}
	
	
	
	

}
