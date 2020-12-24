package com.lec.Day17_Exception;

public interface ILendable {

	//상수 선언
	public byte STATE_BORROWED = 1; // 대출중
	public byte STATE_NORMAL = 0; //대출 가능
	
	//작업명세선언
	public void CheckIn() throws Exception ; //반납
	public void CheckOut(String borrowr) throws Exception; //대출
	
}
