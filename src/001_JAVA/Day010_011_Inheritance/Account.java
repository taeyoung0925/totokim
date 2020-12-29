// 2020-12-06 ~ 2020-12-07
//�ǽ����� : ���¹�ȣ, ������ �ܾ�, �ſ�ī���ȣ, üũī���ȣ�� �޾� ������ ���ҹ������ ����
package com.lec.ex08_account;

public class Account {
	// ������ �ֱ�(���¹�ȣ, ������, �ܾ�)
	private String accountNo;
	private String ownerName;
	private int balance;

	// ����Ʈ ������
	public Account() {
	}

	// ������ ����(1)
	public Account(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
	}

	// ������ ����(2)
	public Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.setBalance(balance);
	}

	// �޼ҽ� ����(1)_����
	public void deposit(int amount) { // ������ ������
		setBalance(getBalance() + amount);
	} // ������ ���ҽÿ��� void�� �ٿ������

	
	
	// �޼ҽ� ����(2)_���
	public void withdraw(int amount) { // �ܾ׺����� "����"���
		if (getBalance() >= amount) {
			setBalance(getBalance() - amount);
		} else {
			System.out.println("�ܾ׺����Դϴ�.");
			System.out.println();
		}

	}

	// �޼ҽ� ����(3)_����
	public void printAccount() {
		System.out.println("���¹�ȣ : " + accountNo + "," + ownerName + "���� �ܾ��� " + getBalance() + "���Դϴ�.");
	}

	// getter&setter �����
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
