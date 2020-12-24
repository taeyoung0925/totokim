package com.lec.ex3;

public class Person {

	//������ ����
	private String name;
	private String tel;
	private int age;

	
	//������ ����
	public Person(String name, String tel, int age) {
		this.name = name;
		this.tel = tel;
		this.age = age;
	}

	public Person() {
	}

	//�޼ҵ� ����
	@Override
	public String toString() {
		return "[name=" + name + ", tel=" + tel + ", age=" + age + "]\r\n";
	}
	
	// getter&setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
