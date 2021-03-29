package com.sw.s3.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sw.s3.notice.NoticeDAO;
import com.sw.s3.notice.NoticeService;
import com.sw.s3.util.Pager;

@Service
public class BankBookService {
	
	@Autowired 							// DI (Dependency Injection) 
	private BankBookDAO bankBookDAO; 	//Service는 dao에 대해 의존적 
	
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.setUpdate(bankBookDTO);
		
	}
	
	public List<BankBookDTO> getList(Pager pager) throws Exception {
		int perPage=10; // 한 페이지당 보여줄 글의 갯수
		int perBlock=5; // 한 블럭당 보여줄 숫자의 갯수
		
		// ---- startRow, lastRow ----
		long startRow = (pager.getCurPage()-1)*perPage+1;
		long lastRow = pager.getCurPage()*perPage;
		
		pager.setStartRow(startRow);
		pager.setLastRow(lastRow);
		// ---------------------------
		
		
		//1. totalCount 
		long totalCount = bankBookDAO.getTotalCount();
		
		//2. totalPage 
		long totalPage= totalCount / perPage;
		if(totalCount/perPage!=0) {
			totalPage++;
		}
		
		//3.totalBlock
		long totalBlock = totalPage / perBlock;
		if(totalPage%5!=0) {
			totalBlock++;
		}
		
		//4. curBlock
		long curBlock = pager.getCurPage() / perBlock;
		if(pager.getCurPage()%perBlock!=0) {
			curBlock++;
		}
		
		//5. startNum, lastNum
		long startNum = (curBlock-1)*perBlock+1;
		long lastNum = curBlock*perBlock;
		
	
		pager.setStartNum(startNum);
		pager.setLastNum(lastNum);
		
		
		System.out.println("TotalPage : " + totalPage);
		System.out.println("TotalBlock : " + totalBlock);
		System.out.println("CurBlock : " + curBlock);
		
		return bankBookDAO.getList(pager);
	}
	
	public BankBookDTO getSelect(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.getSelect(bankBookDTO);
	}
	
	public int setDelete(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.setDelete(bankBookDTO);
	}
	

}
