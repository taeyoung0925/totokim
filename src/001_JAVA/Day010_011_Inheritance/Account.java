// 2020-12-06 ~ 2020-12-07
//실습예제 : 계좌번호, 예금주 잔액, 신용카드번호, 체크카드번호를 받아 각각의 지불방법으로 결제
package com.lec.ex08_account;

public class Account {
	// 데이터 넣기(계좌번호, 예금주, 잔액)
	private String accountNo;
	private String ownerName;
	private int balance;

	// 디폴트 생성자
	public Account() {
	}

	// 생성자 생성(1)
	public Account(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
	}

	// 생성자 생성(2)
	public Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.setBalance(balance);
	}

	// 메소스 생성(1)_예금
	public void deposit(int amount) { // 예금은 무조건
		setBalance(getBalance() + amount);
	} // 리턴을 안할시에는 void를 붙여줘야함

	
	
	// 메소스 생성(2)_출금
	public void withdraw(int amount) { // 잔액부족시 "주의"출력
		if (getBalance() >= amount) {
			setBalance(getBalance() - amount);
		} else {
			System.out.println("잔액부족입니다.");
			System.out.println();
		}

	}

	// 메소스 생성(3)_정보
	public void printAccount() {
		System.out.println("계좌번호 : " + accountNo + "," + ownerName + "님의 잔액은 " + getBalance() + "원입니다.");
	}

	// getter&setter 만들기
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
