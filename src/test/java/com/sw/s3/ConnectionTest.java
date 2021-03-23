package com.sw.s3;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class ConnectionTest extends MyAbstractTest { //Annotation 같이 상속받아옴
 
	@Autowired
	private DataSource dataSource;
	
	//Main Branch Test
	
	//Member Test
	
	@Autowired
	private SqlSession sqlSession;
	
	
	@Test
	public void connectionTest() throws Exception {
		assertNotNull(sqlSession);
	}
	
	

}
