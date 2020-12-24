package com.lec.ex2_map;

public class Customer {

	// 汽戚斗持失
	private String name;
	private String phone;
	private String address;

	// 持失切 持失
	public Customer(String name, String phone, String address) {
		this.name = name;
		this.phone = phone;
		this.address = address;
	}

	public Customer() {
	}

	// 五社球 持失
	@Override
	public String toString() {
		String temp = "[ " + name + "\t" + phone + "\t" + address + " ]";
		return temp;
	}

	// getter&setter持失
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public static char[] get(String key) {
		// TODO Auto-generated method stub
		return null;
	}
}
