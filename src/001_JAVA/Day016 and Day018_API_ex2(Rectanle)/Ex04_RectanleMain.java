/*<오늘의 문제>
가로, 세로, 컬러를 데이터를 갖는 Rectangle 클래스를 다음의 조건에 맞게 구현하시오

①	매개변수를 갖지 않는 생성자 호출시 가로 0, 세로 0, 컬러는 검정
매개변수 3개를 갖는 생성자 호출시  new Rectangle(가로길이, 세로길이, “빨강”)

②	가로길이, 세로길이, 색상값이 같으면 같은 좌표값으로 true 값을 리턴하고 
그렇지 않으면 false를 리턴하는 equals() 재정의
③	[가로 Xcm, 세로 Xcm의 빨강색 사각형]을 리턴하는 toString() 재정의
④	위의 세 조건을 모두 보여주는 main()함수를 구현하세요
*/


package com.lec.ex04_Object;

public class Ex04_RectanleMain {
	public static void main(String[] args) {
		Rectanle[] rectanles = { new Rectanle(), new Rectanle(7, 7, "빨강"), new Rectanle(7, 7, "빨강"), new Rectanle(10, 16, "노랑") };

		for (Rectanle rectanle : rectanles) {
			System.out.println(rectanle);
		}

		for (int i = 0; i < rectanles.length-1; i++) {
			if (rectanles[i].equals(rectanles[i + 1])) {
				System.out.println(i + "번째와" + (i + 1) + "번째는 같은 사각형이다.");
			} else {
				System.out.println(i + "번째와" + (i + 1) + "번째는 다른 사각형이다.");
			}
		} // for

	}// main
}// class
