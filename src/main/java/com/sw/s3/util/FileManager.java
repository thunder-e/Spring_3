package com.sw.s3.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	
	public boolean delete(String name, String fileName, HttpSession session) throws Exception { 	//session - 경로 받아와야 하니까, 실제 파일이름 fileName
		//1. 경로 설정
		String path = session.getServletContext().getRealPath("resources/upload/"+name);
		File file = new File(path, fileName);
		boolean check = false;
		
		if(file.exists()) {				//있으나없으나 상관없음
			check = file.delete();
		}
		
		return check;
	}
	
	
	
	
	public String save(String name, MultipartFile multipartFile, HttpSession session) throws Exception {
		//1. 경로 설정
		String path = session.getServletContext().getRealPath("resources/upload/" + name);
		System.out.println(path);

		File file = new File(path);

		if(!file.exists()) {
			file.mkdirs();
		}
		
		//2. 저장할 파일명 - 중복된 이름이 있을 수 있으니까 
		String fileName = "";
		
		//	a. 시간
		//Calendar ca = Calendar.getInstance();
		//long time = ca.getTimeInMillis();
		//fileName = time + "_" + multipartFile.getOriginalFilename();
		
		//	b. API	- Java가 제공하는 
		fileName = UUID.randomUUID().toString() + "_" + multipartFile.getOriginalFilename();
		
		//3. HDD에 저장
		file = new File(file, fileName);
		
		//	a. FileCopyUtils
		//FileCopyUtils.copy(multipartFile.getBytes(), file);
		
		//	b. MultipartFile
		multipartFile.transferTo(file);
		
		return fileName;
	}
	
	
//밑에는 안쓸꺼지만 ------------------------------------------------------------------------------------	
	
	
	public void saveUseTransfer(MultipartFile multipartFile, File file) throws Exception {
		multipartFile.transferTo(file);
	}
	
	public void saveUseCopy(MultipartFile multipartFile, File file) throws Exception {
		FileCopyUtils.copy(multipartFile.getBytes(), file);
	}
	
	
	
	//4. 저장할 파일명 생성
	public String makeTimeFileName() throws Exception {
		Calendar ca = Calendar.getInstance();
		long time = ca.getTimeInMillis();
		return String.valueOf(time);
	}
	
	
	public String makeUUIDFileName() throws Exception {
		return UUID.randomUUID().toString();
	}
	
	
	

	public File makePath(HttpSession session) throws Exception {
		//1. 저장할 폴더 지정 /resources/upload/member
		//2. os에서 인식할 수 있는 실제 경로 찾기
		//jsp : application - server : ServletContext		//객체이름이 다름
		String path = session.getServletContext().getRealPath("resources/upload/member");
		System.out.println(path);

		//3. 실제 경로에 폴더가 없으면 파일 저장시 에러 발생
		File file = new File(path);

		if(!file.exists()) {
			file.mkdirs();
		}
		
		return file;
	}

	
	
	
	



}
