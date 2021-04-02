package com.sw.s3.board;

import java.util.List;

import com.sw.s3.util.Pager;

public interface BoardDAO {
	//멤버로 상수, 추상메서드-선언부까지만
	//접근 지정자는 무조건 public abstract --> 생략가능
	
	//list 
	public List<BoardDTO> getList(Pager pager) throws Exception;
	
	//전체 글의 갯수
	public long getTotalCount(Pager pager) throws Exception;
	
	//글 조회
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception;
	
	//hit update - num
	public int setHitUpdate(BoardDTO boardDTO) throws Exception;
	
	//글 추가	- writer, title, contents
	public int setInsert(BoardDTO boardDTO) throws Exception;
	
	//글 수정 - title, contents
	public int setUpdate(BoardDTO boardDTO) throws Exception;
	
	//글 삭제 - num
	public int setDelete(BoardDTO boardDTO) throws Exception;
	
	
	
}
