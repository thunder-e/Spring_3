package com.sw.s3.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sw.s3.MyAbstractTest;

public class MemberDAOTest extends MyAbstractTest {
	
	@Autowired
	private MemberDAO memberDAO;
	
	//@Test
	public void memberDelete() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("id2");
		int result = memberDAO.memberDelete(memberDTO);
		assertEquals(1, result);
		
	}
	
	
	
	
	//@Test
	public void memberLogin() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("iu");
		memberDTO.setPw("pw1");
		memberDAO.memberLogin(memberDTO);
		assertNotNull(memberDTO);
	}
	
	
	
	
	@Test
	public void memberUpdate() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("iu");
		memberDTO.setPw("iu");
		memberDTO.setName("jieun");
		memberDTO.setEmail("iu@gmail.com");
		memberDTO.setPhone("01012224555");
		
		int result = memberDAO.memberUpdate(memberDTO);
		assertEquals(1, result);
		
	}
	

	//@Test
	public void memberJoin() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("id2");
		memberDTO.setPw("pw2");
		memberDTO.setName("id2");
		memberDTO.setPhone("01012121212");
		memberDTO.setEmail("id2@gmail.com");
		
		int result = memberDAO.memberJoin(memberDTO);
		assertEquals(1, result);
		
		
		
	}

}
