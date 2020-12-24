package com.lec.ex07car;

public class LowGradeCar extends Car {

	// ������ ����
	private int tax = 50000;

	// ������ ����
	public LowGradeCar(String color, String tire, int displacement, String handle) {
		super(color, tire, displacement, handle);
		// TODO Auto-generated constructor stub
	}

	// �޼ҵ� ����
	@Override
	public void getSpec() { // ���� ��� (tax����)
		System.out.println("====================");
		System.out.println("��  �� : " + getColor());
		System.out.println("Ÿ�̾� : " + getTire());
		System.out.println("��ⷮ : " + getDisplacement());
		System.out.println("��   �� : " + getHandle());

		if (getDisplacement() > 1000) {
			tax = tax + (getDisplacement() - 1000) * 100;
		} //���� ���
		
		System.out.println("��  �� : " + tax);
		System.out.println("====================");
	}

}
