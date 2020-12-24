package com.lec.ex08_account;

public class CheckingAccount extends Account {

	private String cardNo;

	// ������ ����
	public CheckingAccount(String accountNo, String ownerName, int balance, String cardNo) {
		super(accountNo, ownerName, balance);
		this.setCardNo(cardNo);
	}

	public CheckingAccount(String accountNo, String ownerName, String cardNo) {
		super(accountNo, ownerName);
		this.setCardNo(cardNo);
	}

	// �޼ҵ� ����
	public void pay(String cardNo, int amount) {
		if (this.getCardNo().equals(cardNo)) {
			if (this.getBalance() >= amount) {
				setBalance(getBalance() - amount);
				System.out.printf("ī���ȣ : %s \t �̸� : %s \t �ܾ� : %d ���Դϴ�.\n", cardNo, getOwnerName(), getBalance());
			} else {
				System.out.println("�ܾ׺������� �����Ұ��Դϴ�.\n");
			}
		} else {
			System.out.println("ī���ȣ�� ��ġ���� �ʾ� �����Ұ��Դϴ�.\n");

		}
	}

	// getter&setter ����
	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

}
