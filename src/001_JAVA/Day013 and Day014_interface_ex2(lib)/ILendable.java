package com.lec.ex10lib;

public interface ILendable {

	// 데이터 선언
	public int STATE_BORROWED = 1; // 대출중
	public int STATE_NORMAL = 0; // 대출가능

	// 메소드 선언
	public void checkOut(String borrower, String checkOutDate); // 대출(대출인,대출일)

	public void checkIn(); // 반납

	public void printState(); // 대출&반납 상태 > 상태 제출 모양 _자바: 홍길동저 대출가능 or "자바" 홍길동저 대출중

}
