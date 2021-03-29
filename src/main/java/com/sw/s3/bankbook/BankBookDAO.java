package com.sw.s3.bankbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sw.s3.util.Pager;

@Repository
public class BankBookDAO {
	
	@Autowired
	private SqlSession sqlSession; //root-context.xml에 있는
	private final String NAMESPACE="com.sw.s3.bankbook.BankBookDAO"; //Mapper의 namespace이름과 동일하게
	
	
	public long getTotalCount() throws Exception {
		return sqlSession.selectOne(NAMESPACE+".getTotalCount");
	}
	
	
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception {
		return sqlSession.update(NAMESPACE + ".setUpdate", bankBookDTO);
	}
	
	
	public int setDelete(BankBookDTO bankBookDTO) throws Exception {
		return sqlSession.delete(NAMESPACE + ".setDelete", bankBookDTO);
	}
	

	public int setWrite(BankBookDTO bankBookDTO) throws Exception {
		int result = sqlSession.insert(NAMESPACE+".setWrite", bankBookDTO); //파라미터는 타입 하나만 보낼 수 있어
		return result;
	}


	public BankBookDTO getSelect(BankBookDTO bankBookDTO)throws Exception{
//		long num = 1L;
		bankBookDTO = sqlSession.selectOne(NAMESPACE+".getSelect", bankBookDTO); //없으면 자동으로 null이 들어가
		return bankBookDTO;
	}	

	//getList
	//bankbook table의 모든 데이터 조회 후 리턴
	public List<BankBookDTO> getList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE+".getList", pager);
	}
	
	



}
