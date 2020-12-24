package com.lec.Day19_io;

public class Customer {

	// 데이터 선언
	private String name;
	private String phone;
	private String birthday;
	private String address;

	// 생성자 선언
	public Customer() {
	}

	public Customer(String name, String phone, String birthday, String address) {
		this.name = name;
		this.phone = phone;
		this.birthday = birthday;
		this.address = address;
	}

	// 메소드 선언
	@Override
	public String toString() {
		return name + "\t" + phone + "\t" + birthday + "\t" + address +"\n";
	}

	// getter&setter 선언
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
