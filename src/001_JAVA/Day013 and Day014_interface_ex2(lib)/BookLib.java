package com.lec.ex10lib;

import com.lec.ex09lib.ILendable;

public class BookLib extends BookInfo implements ILendable {

	// 1.������ ����
	private String borrower; // ������
	private String checkOutDate; // ������
	private byte state; // �������

	/*
	 * public int STATE_BORROWED = 1; // ������ 
	 * public int STATE_NORMAL = 0; // ���Ⱑ��
	 */

	// 2. ������ ����
	public BookLib(String bookNo, String bookTitle, String writer) {
		super(bookNo, bookTitle, writer);
	}
	/*
	 * public BookLib(String bookNo, String bookTitle, String writer) {
	 * this.setBookNo(bookNo); this.setBookTitle(bookTitle); this.setWriter(writer);
	 * }
	 */
	

	// 3. �޼ҵ� ����
	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if (state != STATE_NORMAL) { // ���Ⱑ�ɻ��¿� �ٸ���� ������ �Ұ���
			System.out.println("������ �Ұ��մϴ�. Ȯ�κ�Ź�帳�ϴ�.");
		}
		// ����ó������
		this.borrower = borrower; // ������ �ʱ�ȭ
		this.checkOutDate = checkOutDate; // ������ �ʱ�ȭ
		state = STATE_BORROWED ;
		System.out.println("�� " + borrower + "�� " + getBookTitle() + "�� " + checkOutDate + "�� �����ϼ̽��ϴ�. ��");
	}

	@Override
	public void checkIn() { // �ݳ�
		if (state != STATE_BORROWED) { // �����߻��¿� �ٸ���� �ݳ��� �Ұ���
			System.out.println("�ݳ��� �Ұ��մϴ�. Ȯ�κ�Ź�帳�ϴ�.");
		}
		// �ݳ�ó������
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println("�� " + borrower + "��" + getBookTitle() + "�� �ݳ��ϼ̽��ϴ�. ��");
	}

	@Override
	public void printState() { // ���Ⱑ��&�������� å���� �� å���� Ȯ��
		if (state == STATE_BORROWED) {
			System.out.printf("%s, %s�� - [������]\n", getBookTitle(), getWriter());
		} else if (state == STATE_NORMAL) {
			System.out.printf("%s, %s�� - [���Ⱑ��]\n", getBookTitle(), getWriter());
		} else {
			System.out.printf("%s, %s�� - [å����Ȯ�κҰ�]\n", getBookTitle(), getWriter());
		}

	}

	// 4. getter&setter����
	public String getBorrower() {
		return borrower;
	}

	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public byte getState() {
		return state;
	}

	public void setState(byte state) {
		this.state = state;
	}

}
