package com.lec.ex4;

public class Customer {

	// ������ ����
	private String phone;
	private String name;
	private int point = 1000; // ����Ʈ�� �⺻���� 1000�� ����

	// ������ ����
	public Customer(String phone, String name, int point) {
		this.phone = phone;
		this.name = name;
		this.point = point;
	}

	public Customer() {
	}

	// �޼ҵ� ����
	@Override
	public String toString() {
		return "����ȣ=" + phone + ", ��  ��=" + name + ", ����Ʈ=" + point +"\r\n";
	}

	// getter&setter����
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

}
