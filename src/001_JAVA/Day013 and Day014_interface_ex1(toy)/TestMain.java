package com.lec.ex06toy;

public class TestMain {

	public static void main(String[] args) {
		
		IToy[] toy = {new Pooh(), new Mazinger(), new AirPlaneToy()};
		
		for(IToy toys : toy) {
			System.out.println(toys.getClass().getName());//toys의 객체의 클래스 이름 출력
			System.out.println(toys); //toys.toString 호출
			System.out.println("~~~~~~~~~~~~~~~~~~");
			
		}
	}
	
}
