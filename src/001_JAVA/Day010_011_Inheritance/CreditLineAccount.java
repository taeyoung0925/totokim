package com.lec.ex08_account;

public class CreditLineAccount extends CheckingAccount {

	private long creditLine;

	// ������ ����
	public CreditLineAccount(String accountNo, String ownerName, int balance, String cardNo, long creditLine) {
		super(accountNo, ownerName, balance, cardNo);
		this.creditLine = creditLine;
	}

	public CreditLineAccount(String accountNo, String ownerName, String cardNo, long creditLine) {
		super(accountNo, ownerName, cardNo);
		this.creditLine = creditLine;
	}

	// �޼ҵ� ����
	@Override
	public void pay(String cardNo, int amount) {
		if (this.getCardNo().equals(cardNo)) {

			if (creditLine < amount) {
				System.out.println("������ �ִ� �ѵ����� ���� ������ ��ǰ�� ������ �� �����ϴ�.");
			} else {
				creditLine = creditLine - amount;
				System.out.printf("ī���ȣ : %s \t �̸� : %s \t �����ѵ� : %d \n", cardNo, getOwnerName(), creditLine);
			}

		} else {
			System.out.println("ī���ȣ�� ��ġ���� �ʾ� �����Ұ��Դϴ�.");
		}
	}

	@Override
	public void printAccount() {
		super.printAccount();
		System.out.println(getOwnerName() + "���� ī�� �ѵ����� " + creditLine + "���Դϴ�.");
	}

	
	
	// getter&setter ����
	public long getCreditLine() {
		return creditLine;
	}

	public void setCreditLine(long creditLine) {
		this.creditLine = creditLine;
	}

}
