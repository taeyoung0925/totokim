package com.lec.ex07car;

public abstract class Car {

	//������ ����
	private String color; //������
	private String tire; //Ÿ�̾�
	private int displacement; //��ⷮ
	private String handle; //�ڵ�
	
	//������ ����
	public Car(String color, String tire, int displacement, String handle) {
		this.color = color;
		this.tire = tire;
		this.displacement = displacement;
		this.handle = handle;
	}
	
	//�޼ҵ� ����(�߻�޼ҵ�)
	public abstract void getSpec();

	
	//getter&setter ����
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
