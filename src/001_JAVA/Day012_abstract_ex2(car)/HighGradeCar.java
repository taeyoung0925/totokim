package com.lec.ex07car;

public class HighGradeCar extends Car {

	// 데이터 생성
	private int tax = 100000;

	// 생성자 선언
	public HighGradeCar(String color, String tire, int displacement, String handle) {
		super(color, tire, displacement, handle);
		// TODO Auto-generated constructor stub
	}

	// 메소드 선언
	@Override
	public void getSpec() { // 스펙출력 (tax포함)
		System.out.println("====================");
		System.out.println("색  상 : " + getColor());
		System.out.println("타이어 : " + getTire());
		System.out.println("배기량 : " + getDisplacement());
		System.out.println("핸   들 : " + getHandle());

		if (getDisplacement() > 1600) {
			tax = tax + (getDisplacement() - 1500) * 200;
		} //세금 계산
		
		System.out.println("세  금 : " + tax);
		System.out.println("====================");
	}

}
