package com.lec.ex10lib;

public class BookInfo {

	// 1. �����ͻ���
	private String bookNo; // åû����ȣ
	private String bookTitle; // å����
	private String writer;// å����

	/*
	 * public int STATE_BORROWED = 1; // ������ 
	 * public int STATE_NORMAL = 0; // ���Ⱑ��
	 */

	// 2. �����ڻ���
	// Book b = new Book("89��-102��", "�ڹ�" ,"ȫ�浿");
	public BookInfo() {
	}

	public BookInfo(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}

	// 3. getter&setter ����
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
