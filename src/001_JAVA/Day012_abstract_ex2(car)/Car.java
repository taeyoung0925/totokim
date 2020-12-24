package com.lec.ex07car;

public abstract class Car {

	//데이터 생성
	private String color; //차색상
	private String tire; //타이어
	private int displacement; //배기량
	private String handle; //핸들
	
	//생성자 선언
	public Car(String color, String tire, int displacement, String handle) {
		this.color = color;
		this.tire = tire;
		this.displacement = displacement;
		this.handle = handle;
	}
	
	//메소드 생성(추상메소드)
	public abstract void getSpec();

	
	//getter&setter 생성
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTire() {
		return tire;
	}

	public void setTire(String tire) {
		this.tire = tire;
	}

	public int getDisplacement() {
		return displacement;
	}

	public void setDisplacement(int displacement) {
		this.displacement = displacement;
	}

	public String getHandle() {
		return handle;
	}

	public void setHandle(String handle) {
		this.handle = handle;
	}
	
	
	
}
