package com.sw.s3.board;

import java.util.List;

import com.sw.s3.util.Pager;

public interface BoardDAO {
	//멤버로 상수, 추상메서드-선언부까지만
	//접근 지정자는 무조건 public abstract --> 생략가능
	
	//list 
	public List<BoardDTO> getList(Pager pager) throws Exception;
	
	
	
	
}
