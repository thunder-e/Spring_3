package com.sw.s3.notice;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sw.s3.util.Pager;

@Repository
public class NoticeDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.sw.s3.notice.NoticeDAO.";
	
	public Long getTotalCount(Pager pager) throws Exception  {
		return sqlSession.selectOne(NAMESPACE+"getTotalCount", pager);
	}
	
	
	public List<NoticeDTO> getList(Pager pager) throws Exception{
//		HashMap<String, Long> map = new HashMap<String, Long>();
//		map.put("startRow", 1L);
//		map.put("lastRow", 10L);
		return sqlSession.selectList(NAMESPACE+"getList", pager);
	}
	
	public NoticeDTO getSelect(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getSelect", noticeDTO);
	}
	
	public int setInsert(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setInsert", noticeDTO);
	}
	
	public int setUpdate(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"setUpdate", noticeDTO);
	}
	
	public int setDelete(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"setDelete", noticeDTO);
	}
	
	public int setHitUpdate(NoticeDTO noticeDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"setHitUpdate", noticeDTO);
	}
	
	
	
	
	
	
	

}
