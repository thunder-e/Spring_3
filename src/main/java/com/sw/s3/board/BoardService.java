package com.sw.s3.board;

import java.util.List;

import com.sw.s3.util.Pager;

public interface BoardService {

	//list
	public List<BoardDTO> getList(Pager pager) throws Exception; 
	
	
}
