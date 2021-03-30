package com.sw.s3.util;

public class Pager {
	
	private long curPage;	//현재 페이지
	private long startRow;	//페이지에서 첫글
	private long lastRow;	//페이지에서 마지막글
	
	private long startNum;	//블럭의 첫숫자
	private long lastNum;	//블럭의 마지막숫자
	private boolean pre;	//이전 block이 있으면 true 없으면 false
	private boolean next; 	//다음 block이 있으면 true 없으면 flase
	
	private String kind; 	//검색할 컬럼명		
	private String search;	//검색어
	
	
	

	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getSearch() {
		if(this.search==null) {
			this.search="";
		}
		return search;
	}
	public void setSearch(String search) {
		if(search==null) {
			search="";
		}
		this.search = search;
	}
	
	public boolean isPre() {
		return pre;
	}
	public void setPre(boolean pre) {
		this.pre = pre;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	
	
	public long getCurPage() {
		if(this.curPage<1) {
			this.curPage = 1;
		}
		return curPage;
	}
	public void setCurPage(long curPage) { //매개변수 curPage
		if(curPage<1) {
			curPage=1;
		}
		this.curPage = curPage;	//this.curPage ===> 멤버변수 curPage
	}
	
	
	public long getStartRow() {
		return startRow;
	}
	public void setStartRow(long startRow) {
		this.startRow = startRow;
	}
	public long getLastRow() {
		return lastRow;
	}
	public void setLastRow(long lastRow) {
		this.lastRow = lastRow;
	}
	

	public long getStartNum() {
		return startNum;
	}
	public void setStartNum(long startNum) {
		this.startNum = startNum;
	}
	public long getLastNum() {
		return lastNum;
	}
	public void setLastNum(long lastNum) {
		this.lastNum = lastNum;
	}
	
	
	
	
}
