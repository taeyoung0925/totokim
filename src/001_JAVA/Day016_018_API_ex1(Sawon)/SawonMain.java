/*
 * <실습예제> : Sawon 클래스와 main함수가 들어있는 부분을 구현하여 보세요
Sawon클래스 내용
데이터 : 사번, 이름, 부서(COMPUTER, PLANNING, DESIGN, ACCOUNTING, HUMANRESOURCES), 입사일.
생성자 : 사번, 이름, 부서, 입사일은 객체생성 당일로 합니다
메소드: infoString()의 실행결과는 다음과 같습니다
[사번]200121  [이름]홍길동  [부서]COMPUTER  [입사일]2019년2월2일
main()함수에서 Sawon 객체 만들어 화면에 print해 보세요. 오늘이 입사한 사원도 출력합니다*/



package com.lec.ex2_date;

public class SawonMain {
public static void main(String[] args) {
	Sawon[] sawons = {new Sawon("200121","홍길동", "COMPUTER"),
			new Sawon("200221","홍길동", "COMPUTER",2000,10,16),
			new Sawon("200571","김미숙", "PLANNING"),
			new Sawon("201035","최   홍", "DESIGN"),
			new Sawon("201100","박  동", "ACCOUNTING",2011,11,01),
			new Sawon("200471","김길동", "HUMANRESOURCES",2020,12,15)};
	
		for(Sawon s : sawons) {
			System.out.println(s.toString());
		}
}
}
