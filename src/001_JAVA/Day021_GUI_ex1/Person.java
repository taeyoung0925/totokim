package com.lec.ex3;

public class Person {

	//데이터 선언
	private String name;
	private String tel;
	private int age;

	
	//생성자 선언
	public Person(String name, String tel, int age) {
		this.name = name;
		this.tel = tel;
		this.age = age;
	}

	public Person() {
	}

	//메소드 선언
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
