/*실습예제 :　국어, 영어, 수학 점수를 변수에 할당하고 각 점수를 출력하고 총점, 평균 출력하는 프로그램을 구현 하시오*/

package com.lec.java;

import java.util.Scanner;

public class Day01_variable {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); // 인스턴스 생성(자료값받기)

		int korea; // 국어변수선언(1)
		int English; // 영어변수선언(2)
		int math; // 수학변수선언(3)

		int sum = 0;// 총합변수선언
		float average = 0; // 평균변수 선언

		System.out.print("국어점수를 입력하시오 : ");
		korea = sc.nextInt();

		System.out.print("영어점수를 입력하시오 : ");
		English = sc.nextInt();

		System.out.print("수학점수를 입력하시오 : ");
		math = sc.nextInt();

		sum = korea + English + math; // 총합구하기
		average = sum / 3; // 평균구하기

		System.out.println("세과목의 합 : " + sum);
		System.out.println("세과목의 평균: " + average);

	}
}
