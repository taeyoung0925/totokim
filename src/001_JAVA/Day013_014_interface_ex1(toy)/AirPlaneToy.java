package com.lec.ex06toy;

public class AirPlaneToy implements IMissile, ILight {

	
	//생성자 만들기
	public AirPlaneToy() {
		System.out.println("비행기 장난감입니다.");
		canLight();
		canMissile();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	
	
	@Override
	public void canLight() {
		System.out.println("불빛반사를 할 수 있습니다.");

	}

	@Override
	public void canMissile() {
		System.out.println("미사일을 쏠 수 있습니다.");
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "불빛과 미사일 나가는 비행기";
	}
	
}
