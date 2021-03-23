package com.sw.s3.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberDAOTest {
	
	@Autowired
	private MemberDAO memberDAO;

	@Test
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
