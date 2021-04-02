package com.sw.s3.notice;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sw.s3.MyAbstractTest;
import com.sw.s3.bankbook.BankBookDTO;
import com.sw.s3.board.notice.NoticeDAO;
import com.sw.s3.board.notice.NoticeDTO;

public class NoticeDAOTest extends MyAbstractTest {

	@Autowired
	private NoticeDAO noticeDAO;

	//@Test 		//성공
	public void getListTest() throws Exception {
		List<NoticeDTO> ar = noticeDAO.getList();
		assertNotEquals(0, ar.size());
	}


	//@Test			//성공
	public void getSelectTest() throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO(); 
		noticeDTO.setNum(1);
		noticeDTO = noticeDAO.getSelect(noticeDTO);
		assertNotNull(noticeDTO);
	}


	@Test			//성공 
	public void setInsertTest() throws Exception {

		for(int i=0;i<120;i++) {
			NoticeDTO noticeDTO = new NoticeDTO();		//새로운 데이터가 들어갈 수 있는 DTO 준비
			noticeDTO.setTitle("test Title"+i);
			noticeDTO.setContents("test Contents"+i);
			noticeDTO.setWriter("test Writer"+i);
			int result = noticeDAO.setInsert(noticeDTO);
			if(i%10==0) {
				Thread.sleep(500);
			}
		}


		//	assertEquals(1, result);
	}

	//@Test		//성공
	public void setUpdateTest() throws Exception { 
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(3);

		noticeDTO = noticeDAO.getSelect(noticeDTO);

		noticeDTO.setTitle("update test");

		int result = noticeDAO.setUpdate(noticeDTO);
		assertEquals(1, result);
	}

	//@Test			//성공 
	public void setDeleteTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(4);
		int result = noticeDAO.setDelete(noticeDTO);
		assertEquals(1, result);
	}

	//@Test			//성공
	public void setHitUpdateTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(2);
		int result = noticeDAO.setHitUpdate(noticeDTO);
		assertEquals(1, result);
	}





















}
