package com.lec.ex06toy;

public class Pooh implements IMoveArmLeg {

	// 생성자 만들기
	public Pooh() {
		System.out.println("곰돌이 푸입니다.");
		canMoveArmLeg();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

	@Override
	public void canMoveArmLeg() {
		System.out.println("팔다리를 움질일 수 있습니다.");

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "팔다리 움직이는 곰돌이 푸";
	}
	
	
}
