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

@Repository
public class BankBookDAO {
	
	@Autowired
	private SqlSession sqlSession; //root-context.xml에 있는
	private final String NAMESPACE="com.sw.s3.bankbook.BankBookDAO";

	public int setWrite(BankBookDTO bankBookDTO) throws Exception {
		int result = sqlSession.insert(NAMESPACE+".setWrite", bankBookDTO); //파라미터는 타입 하나만 보낼 수 있어
		return result;

	}





	public BankBookDTO getSelect(BankBookDTO bankBookDTO)throws Exception{
		


	
		return bankBookDTO;

	}	





	//getList
	//bankbook table의 모든 데이터 조회 후 리턴
	public List<BankBookDTO> getList() throws Exception {
		ArrayList<BankBookDTO> ar = new ArrayList<BankBookDTO>();


	
		return ar;
	}



}
