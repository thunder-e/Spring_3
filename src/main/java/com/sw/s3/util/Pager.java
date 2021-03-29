package com.sw.s3.util;

public class Pager {
	
	private long curPage;
	private long startRow;
	private long lastRow;
	
	private long startNum;
	private long lastNum;
	
	

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
