package com.sw.s3.account;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
	
	@Autowired
	private AccountDAO accountDAO;
	
	public int setInsert(AccountDTO accountDTO) throws Exception {
		//1. Random
		//2. Time
		//3. Java API
		//return accountDAO.setInsert(accountDTO);
		Calendar ca = Calendar.getInstance(); //추상클래스라 객체를 이렇게 만들어!
		long time = ca.getTimeInMillis();
		System.out.println(time);
		
		String t = time+"";
		t = String.valueOf(time); // primitive -> reference : substring으로 자를 수 있게
		
		String result = t.substring(0, 4) + "-"; //1616-
		result = result + t.substring(4, 8) + "-"; //1616-7207-
		result = result + t.substring(8); //1616-7207-44094
		System.out.println(result);
		
		
		//SimpleDateFormat
		SimpleDateFormat sd = new SimpleDateFormat("ddyyyyMM-HHmmss-S");
		String r = sd.format(ca.getTime());
		System.out.println(r);
		
		String name = UUID.randomUUID().toString();
		System.out.println(name);
		
		
		
		accountDTO.setAccountNumber(r);
		return accountDAO.setInsert(accountDTO);
	}
	
	
	
	public List<AccountDTO> getList(AccountDTO accountDTO) throws Exception {
		return accountDAO.getList(accountDTO);     //로그인한 사람의 id가 있어야 그사람 것을 받아옴
	}
	
	
	

}
