package com.lec.ex06toy;

public class AirPlaneToy implements IMissile, ILight {

	
	//������ �����
	public AirPlaneToy() {
		System.out.println("����� �峭���Դϴ�.");
		canLight();
		canMissile();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	
	
	@Override
	public void canLight() {
		System.out.println("�Һ��ݻ縦 �� �� �ֽ��ϴ�.");

	}

	@Override
	public void canMissile() {
		System.out.println("�̻����� �� �� �ֽ��ϴ�.");
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "�Һ��� �̻��� ������ �����";
	}
	
}
