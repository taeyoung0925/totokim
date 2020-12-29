package com.lec.ex06toy;

public class Mazinger implements IMissile, IMoveArmLeg {

	// 생성자 만들기
	public Mazinger() {
		System.out.println("마징가 장난감입니다.");
		canMoveArmLeg();
		canMissile();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

	@Override
	public void canMoveArmLeg() {
		System.out.println("팔다리를 움직일 수 있습니다.");

	}

	@Override
	public void canMissile() {
		System.out.println("미사일을 쏠 수 있습니다.");
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "미사일쏘고 팔다리 움직이는 마징가 장난감";
	}
}
