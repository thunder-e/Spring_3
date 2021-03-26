package com.sw.s3.account;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.sw.s3.MyAbstractTest;


public class AccountDAOTest extends MyAbstractTest{

	@Autowired
	private AccountDAO accountDAO;
	
	
	@Test
	public void getListTest() throws Exception {
		AccountDTO accountDTO = new AccountDTO(); //새로운 dto 준비
		accountDTO.setId("iu");
		
		List<AccountDTO> ar = accountDAO.getList(accountDTO);
		
		assertNotEquals(0, ar.size());
	}
	
	
	@Test
	public void setInsert() throws Exception {
		AccountDTO accountDTO =  new AccountDTO();
		accountDTO.setAccountNumber("123-3-11111");
		accountDTO.setAccountBalance(0);
		accountDTO.setId("iu");
		accountDTO.setBookNumber(3L);
		int result = accountDAO.setInsert(accountDTO);
		assertEquals(1, result);
	}
	
	

}
