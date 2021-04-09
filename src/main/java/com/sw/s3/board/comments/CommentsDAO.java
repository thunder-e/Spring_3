package com.sw.s3.board.comments;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentsDAO {
	
	@Autowired 
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.sw.s3.board.comments.CommentsDAO.";
	
	
	public int setInsert(CommentsDTO commentsDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setInsert", commentsDTO);
	}
	
	
	public List<CommentsDTO> getList(CommentsDTO commentsDTO) throws Exception{
		return sqlSession.selectList(NAMESPACE+"getList", commentsDTO);
	}
	
	

}
