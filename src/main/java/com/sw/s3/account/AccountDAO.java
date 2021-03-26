package com.sw.s3.account;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO {
	
	@Autowired
	private SqlSession sqlSession; //db연결하고 mapper위치 알고있는
	private final String NAMESPACE = "com.sw.s3.account.AccountDAO."; //id 넣을때 . 넣어야 하니까 미리 넣어주기
	
	public List<AccountDTO> getList(AccountDTO accountDTO) throws Exception{
		return sqlSession.selectList(NAMESPACE+"getList", accountDTO);
		
	}
	
	public int setInsert(AccountDTO accountDTO) throws Exception{
		return sqlSession.insert(NAMESPACE + "setInsert", accountDTO);
	}

}
