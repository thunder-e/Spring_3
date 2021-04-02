package com.sw.s3.board;

import java.util.List;

import com.sw.s3.util.Pager;

public interface BoardService {

	//list 
	public List<BoardDTO> getList(Pager pager) throws Exception;
	
	//글 조회
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception;
	
	//글 추가	- writer, title, contents
	public int setInsert(BoardDTO boardDTO) throws Exception;
	
	//글 수정 - title, contents
	public int setUpdate(BoardDTO boardDTO) throws Exception;
	
	//글 삭제 - num
	public int setDelete(BoardDTO boardDTO) throws Exception;
	
	
	
}
