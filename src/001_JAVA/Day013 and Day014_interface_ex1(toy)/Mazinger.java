package com.lec.ex06toy;

public class Mazinger implements IMissile, IMoveArmLeg {

	// ������ �����
	public Mazinger() {
		System.out.println("��¡�� �峭���Դϴ�.");
		canMoveArmLeg();
		canMissile();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

	@Override
	public void canMoveArmLeg() {
		System.out.println("�ȴٸ��� ������ �� �ֽ��ϴ�.");

	}

	@Override
	public void canMissile() {
		System.out.println("�̻����� �� �� �ֽ��ϴ�.");
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "�̻��Ͻ�� �ȴٸ� �����̴� ��¡�� �峭��";
	}
}
