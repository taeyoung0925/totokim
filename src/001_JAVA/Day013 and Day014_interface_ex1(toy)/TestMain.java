package com.lec.ex06toy;

public class TestMain {

	public static void main(String[] args) {
		
		IToy[] toy = {new Pooh(), new Mazinger(), new AirPlaneToy()};
		
		for(IToy toys : toy) {
			System.out.println(toys.getClass().getName());//toys�� ��ü�� Ŭ���� �̸� ���
			System.out.println(toys); //toys.toString ȣ��
			System.out.println("~~~~~~~~~~~~~~~~~~");
			
		}
	}
	
}
