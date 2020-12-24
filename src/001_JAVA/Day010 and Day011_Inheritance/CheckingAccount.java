package com.lec.ex08_account;

public class CheckingAccount extends Account {

	private String cardNo;

	// 생성자 생성
	public CheckingAccount(String accountNo, String ownerName, int balance, String cardNo) {
		super(accountNo, ownerName, balance);
		this.setCardNo(cardNo);
	}

	public CheckingAccount(String accountNo, String ownerName, String cardNo) {
		super(accountNo, ownerName);
		this.setCardNo(cardNo);
	}

	// 메소드 생성
	public void pay(String cardNo, int amount) {
		if (this.getCardNo().equals(cardNo)) {
			if (this.getBalance() >= amount) {
				setBalance(getBalance() - amount);
				System.out.printf("카드번호 : %s \t 이름 : %s \t 잔액 : %d 원입니다.\n", cardNo, getOwnerName(), getBalance());
			} else {
				System.out.println("잔액부족으로 결제불가입니다.\n");
			}
		} else {
			System.out.println("카드번호가 일치하지 않아 결제불가입니다.\n");

		}
	}

	// getter&setter 생성
	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

}
