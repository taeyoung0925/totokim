package com.lec.Day17_Exception;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BookLib implements ILendable {

	// 데이터 생성
	private String bookNo; // 책 청구 번호
	private String bookTitle; // 책 제목
	private String writer; // 저자
	private String borrower; // 대출인(입력)
	private Date checkoutDate; // 대출일
	private byte state; // 대출상태

	// STATE_BORROWED =1 : 대출중
	// STATE_NORMAL = 0 : 대출가능

	// 생성자 생성
	public BookLib(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
		borrower = null;
		checkoutDate = null;
		state = STATE_NORMAL;
	}

	public BookLib() {
	}

	// 메소드 생성
	@Override
	public void CheckIn() throws Exception { // 반납 & 연체료
		// 대출중의 상태가 아니면 대출중인 도서가 아닙니다 표출
		if (state != STATE_BORROWED) {
			throw new Exception("대출 중인 도서가 아닙니다.");
		}

		// 반납처리 로직 생성
		Date now = new Date(); // 현재시간 선언
		long diff = now.getTime() - checkoutDate.getTime(); // 현재시간 - 대출당시시간
		long day = diff / (24 * 60 * 60 * 1000);// 빌린 밀리세컨을 빌린날로 계산

		if (day > 14) {
			System.out.println("연체료는 일일 500원씩 부과합니다.");
			day = day - 14; // 연체되는 날 계산
			System.out.println("연체료" + (day * 500) + "을 받으셨나요?(Y/N)");
			Scanner scanner = new Scanner(System.in);
			String yesorno = scanner.next();
			if (!yesorno.equalsIgnoreCase("Y")) {
				System.out.println("연체료를 내셔야 반납처리가 가능합니다. ");
			}
		}

		borrower = null;
		checkoutDate = null;
		state = STATE_NORMAL;
		// 반납처리로직을 완료 후 대출인,대출일,상태 초기화

		System.out.println("[" + bookTitle + "] 도서가 <반 납> 되었습니다.");

	}

	@Override
	public void CheckOut(String borrowr) throws Exception { // 대출
		// 대출가능상태가 아니면 대출중인 도서입니다 표출
		if (state != STATE_NORMAL) {
			throw new Exception("대출중인 도서입니다.");
		}

		// 대출처리 로직 생성
		this.borrower = borrower;
		checkoutDate = new Date(); // 빌린 시간을 대입하기
		state = STATE_BORROWED; // 상태를 대출중으로 변경
		System.out.println("[" + bookTitle + "] 도서가 <대 출> 되었습니다.");
		System.out.println("[ 대출인 ] :" + borrower);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 현재 시간을 yyyy-mm-dd으로 서식변경
		System.out.println("[ 대출일 ] : " + sdf.format(checkoutDate));

	}

	@Override
	public String toString() {
		String temp = null;

		if (state == STATE_NORMAL) {
			temp = "BookLib 대출가능 [책번호=" + bookNo + ", 책이름=" + bookTitle + ", 책저자=" + writer + "]";

		} else if (state == STATE_BORROWED) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E)");
			temp = "BookLib 대 출 중 [책번호=" + bookNo + ", 책이름=" + bookTitle + ", 책저자=" + writer + ", 대출일="
					+ sdf.format(checkoutDate) + "]";
		}
		return temp;
	}

	// getter&setter 생성
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

	public String getBorrower() {
		return borrower;
	}

	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}

	public Date getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public byte getState() {
		return state;
	}

	public void setState(byte state) {
		this.state = state;
	}

}
