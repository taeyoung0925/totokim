package com.lec.ex10lib;

public class BookInfo {

	// 1. 데이터생성
	private String bookNo; // 책청구번호
	private String bookTitle; // 책제목
	private String writer;// 책저자

	/*
	 * public int STATE_BORROWED = 1; // 대출중 
	 * public int STATE_NORMAL = 0; // 대출가능
	 */

	// 2. 생성자생성
	// Book b = new Book("89ㄱ-102나", "자바" ,"홍길동");
	public BookInfo() {
	}

	public BookInfo(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}

	// 3. getter&setter 생성
	public String getBookNo() {
		return bookNo;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

}
