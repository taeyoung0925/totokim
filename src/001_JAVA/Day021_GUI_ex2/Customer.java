package com.lec.ex4;

public class Customer {

	// 데이터 선언
	private String phone;
	private String name;
	private int point = 1000; // 포인트는 기본으로 1000점 시작

	// 생성자 선언
	public Customer(String phone, String name, int point) {
		this.phone = phone;
		this.name = name;
		this.point = point;
	}

	public Customer() {
	}

	// 메소드 선언
	@Override
	public String toString() {
		return "폰번호=" + phone + ", 이  름=" + name + ", 포인트=" + point +"\r\n";
	}

	// getter&setter선언
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
