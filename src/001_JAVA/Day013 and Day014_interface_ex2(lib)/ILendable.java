package com.lec.ex10lib;

public interface ILendable {

	// ������ ����
	public int STATE_BORROWED = 1; // ������
	public int STATE_NORMAL = 0; // ���Ⱑ��

	// �޼ҵ� ����
	public void checkOut(String borrower, String checkOutDate); // ����(������,������)

	public void checkIn(); // �ݳ�

	public void printState(); // ����&�ݳ� ���� > ���� ���� ��� _�ڹ�: ȫ�浿�� ���Ⱑ�� or "�ڹ�" ȫ�浿�� ������

}
