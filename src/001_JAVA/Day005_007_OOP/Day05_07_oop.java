/*실습예제 : 은행계좌(Account) 클래스 설계하시오.
데이터(속성) : 계좌번호(accountNo:String), 예금주(ownerName:String), 잔액(balance:int)
기능(메소드) : 예금하다(void deposit(int)). 인출하다(int withdraw(int)), 정보출력(void info())*/

package com.lec.day05_07_OOP;

public class Day05_07_oop {

	// step1.데이터 생성
	private String accountNo; // 계좌번호
	private String ownerName; // 예금주
	private int balance; // 잔액

	// step2.생성자 생성
	public Day05_07_oop() {
	}

	public Day05_07_oop(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}

	public Day05_07_oop(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
	}

	// step3. 메소드 생성
	public void deposit(int money) { // 예금 메소드
		balance += money;
	}

	public void withdraw(int money) { // 출금 메소드
		if (money > balance) {
			System.out.println("잔액이 부족하여 출금할 수 없습니다.");
		} else {
			balance = balance - money;
		}
	}

	public void info() { // 정보출력 메소드
		System.out.println("계좌번호 : " + accountNo + "," + ownerName + "님의 잔액은 " + balance + "입니다.");
	}

	// step4. getter & setter 생성
	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

}
