package com.lec.Day17_Exception;

public interface ILendable {

	//��� ����
	public byte STATE_BORROWED = 1; // ������
	public byte STATE_NORMAL = 0; //���� ����
	
	//�۾�������
	public void CheckIn() throws Exception ; //�ݳ�
	public void CheckOut(String borrowr) throws Exception; //����
	
}
