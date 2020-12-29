package com.lec.ex08_account;

public class CreditLineAccount extends CheckingAccount {

	private long creditLine;

	// 생성자 생성
	public CreditLineAccount(String accountNo, String ownerName, int balance, String cardNo, long creditLine) {
		super(accountNo, ownerName, balance, cardNo);
		this.creditLine = creditLine;
	}

	public CreditLineAccount(String accountNo, String ownerName, String cardNo, long creditLine) {
		super(accountNo, ownerName, cardNo);
		this.creditLine = creditLine;
	}

	// 메소드 생성
	@Override
	public void pay(String cardNo, int amount) {
		if (this.getCardNo().equals(cardNo)) {

			if (creditLine < amount) {
				System.out.println("가지고 있는 한도보다 높은 가격의 제품을 구매할 수 없습니다.");
			} else {
				creditLine = creditLine - amount;
				System.out.printf("카드번호 : %s \t 이름 : %s \t 남은한도 : %d \n", cardNo, getOwnerName(), creditLine);
			}

		} else {
			System.out.println("카드번호가 일치하지 않아 결제불가입니다.");
		}
	}

	@Override
	public void printAccount() {
		super.printAccount();
		System.out.println(getOwnerName() + "님의 카드 한도액은 " + creditLine + "원입니다.");
	}

	
	
	// getter&setter 생성
	public long getCreditLine() {
		return creditLine;
	}

	public void setCreditLine(long creditLine) {
		this.creditLine = creditLine;
	}

}
