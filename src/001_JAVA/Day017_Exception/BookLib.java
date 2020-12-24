package com.lec.Day17_Exception;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BookLib implements ILendable {

	// ������ ����
	private String bookNo; // å û�� ��ȣ
	private String bookTitle; // å ����
	private String writer; // ����
	private String borrower; // ������(�Է�)
	private Date checkoutDate; // ������
	private byte state; // �������

	// STATE_BORROWED =1 : ������
	// STATE_NORMAL = 0 : ���Ⱑ��

	// ������ ����
	public BookLib(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
		borrower = null;
		checkoutDate = null;
		state = STATE_NORMAL;
	}

	public BookLib() {
	}

	// �޼ҵ� ����
	@Override
	public void CheckIn() throws Exception { // �ݳ� & ��ü��
		// �������� ���°� �ƴϸ� �������� ������ �ƴմϴ� ǥ��
		if (state != STATE_BORROWED) {
			throw new Exception("���� ���� ������ �ƴմϴ�.");
		}

		// �ݳ�ó�� ���� ����
		Date now = new Date(); // ����ð� ����
		long diff = now.getTime() - checkoutDate.getTime(); // ����ð� - �����ýð�
		long day = diff / (24 * 60 * 60 * 1000);// ���� �и������� �������� ���

		if (day > 14) {
			System.out.println("��ü��� ���� 500���� �ΰ��մϴ�.");
			day = day - 14; // ��ü�Ǵ� �� ���
			System.out.println("��ü��" + (day * 500) + "�� �����̳���?(Y/N)");
			Scanner scanner = new Scanner(System.in);
			String yesorno = scanner.next();
			if (!yesorno.equalsIgnoreCase("Y")) {
				System.out.println("��ü�Ḧ ���ž� �ݳ�ó���� �����մϴ�. ");
			}
		}

		borrower = null;
		checkoutDate = null;
		state = STATE_NORMAL;
		// �ݳ�ó�������� �Ϸ� �� ������,������,���� �ʱ�ȭ

		System.out.println("[" + bookTitle + "] ������ <�� ��> �Ǿ����ϴ�.");

	}

	@Override
	public void CheckOut(String borrowr) throws Exception { // ����
		// ���Ⱑ�ɻ��°� �ƴϸ� �������� �����Դϴ� ǥ��
		if (state != STATE_NORMAL) {
			throw new Exception("�������� �����Դϴ�.");
		}

		// ����ó�� ���� ����
		this.borrower = borrower;
		checkoutDate = new Date(); // ���� �ð��� �����ϱ�
		state = STATE_BORROWED; // ���¸� ���������� ����
		System.out.println("[" + bookTitle + "] ������ <�� ��> �Ǿ����ϴ�.");
		System.out.println("[ ������ ] :" + borrower);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// ���� �ð��� yyyy-mm-dd���� ���ĺ���
		System.out.println("[ ������ ] : " + sdf.format(checkoutDate));

	}

	@Override
	public String toString() {
		String temp = null;

		if (state == STATE_NORMAL) {
			temp = "BookLib ���Ⱑ�� [å��ȣ=" + bookNo + ", å�̸�=" + bookTitle + ", å����=" + writer + "]";

		} else if (state == STATE_BORROWED) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E)");
			temp = "BookLib �� �� �� [å��ȣ=" + bookNo + ", å�̸�=" + bookTitle + ", å����=" + writer + ", ������="
					+ sdf.format(checkoutDate) + "]";
		}
		return temp;
	}

	// getter&setter ����
	public String getBookNo() {
		return bookNo;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getBorrower() {
		return borrower;
	}

	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}

	public Date getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public byte getState() {
		return state;
	}

	public void setState(byte state) {
		this.state = state;
	}

}
