package com.lec.ex10lib;

import com.lec.ex09lib.ILendable;

public class BookLib extends BookInfo implements ILendable {

	// 1.데이터 생성
	private String borrower; // 대출인
	private String checkOutDate; // 대출일
	private byte state; // 대출상태

	/*
	 * public int STATE_BORROWED = 1; // 대출중 
	 * public int STATE_NORMAL = 0; // 대출가능
	 */

	// 2. 생성자 생성
	public BookLib(String bookNo, String bookTitle, String writer) {
		super(bookNo, bookTitle, writer);
	}
	/*
	 * public BookLib(String bookNo, String bookTitle, String writer) {
	 * this.setBookNo(bookNo); this.setBookTitle(bookTitle); this.setWriter(writer);
	 * }
	 */
	

	// 3. 메소드 생성
	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if (state != STATE_NORMAL) { // 대출가능상태와 다른경우 대출이 불가함
			System.out.println("대출이 불가합니다. 확인부탁드립니다.");
		}
		// 대출처리로직
		this.borrower = borrower; // 대출인 초기화
		this.checkOutDate = checkOutDate; // 대출일 초기화
		state = STATE_BORROWED ;
		System.out.println("★ " + borrower + "님 " + getBookTitle() + "을 " + checkOutDate + "에 대출하셨습니다. ★");
	}

	@Override
	public void checkIn() { // 반납
		if (state != STATE_BORROWED) { // 대출중상태와 다른경우 반납이 불가함
			System.out.println("반납이 불가합니다. 확인부탁드립니다.");
		}
		// 반납처리로직
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println("★ " + borrower + "님" + getBookTitle() + "을 반납하셨습니다. ★");
	}

	@Override
	public void printState() { // 대출가능&대출중의 책상태 및 책정보 확인
		if (state == STATE_BORROWED) {
			System.out.printf("%s, %s저 - [대출중]\n", getBookTitle(), getWriter());
		} else if (state == STATE_NORMAL) {
			System.out.printf("%s, %s저 - [대출가능]\n", getBookTitle(), getWriter());
		} else {
			System.out.printf("%s, %s저 - [책상태확인불가]\n", getBookTitle(), getWriter());
		}

	}

	// 4. getter&setter생성
	public String getBorrower() {
		return borrower;
	}

	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public byte getState() {
		return state;
	}

	public void setState(byte state) {
		this.state = state;
	}

}
