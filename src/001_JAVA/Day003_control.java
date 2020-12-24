// 실습예제 : 컴퓨터와 가위바위보 게임을 당신이 이길 때까지 무한반복하는 게임을 작성하시오.(단, 가위대신 0, 바위대신 1, 보대신 2)

package com.lec.java;

import java.util.Scanner;

public class Day03_control {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);

		int human;
		int com;

		do {
			System.out.println("※사람이 이길때까지 무한반복하는 게임입니다.※\n 가위(0), 바위(1), 보(2)를 내주세요 : ");
			human = scanner.nextInt();

			com = (int) (Math.random() * 3);

			if (human <= -1 || human >= 3) {
				System.out.println("잘못입력하셨습니다. 다시 입력해주세요");

			} else if ((human == 0 && com == 2) || (human == 1 && com == 0) || (human == 2 && com == 1)) {
				System.out.println("축하합니다 사용자님이 이기셨습니다.");
				System.out.println("(참고사항)" + "\n" + "사용자님 : " + human + " 컴퓨터 : " + com);
				break; // 단 이길시 break를 사용하여 while문 빠져나가게 함

			} else if ((com == 0 && human == 2) || (com == 1 && human == 0) || (com == 2 && human == 1)) {
				System.out.println("죄송합니다 사용자님이 지셨습니다.");
				System.out.println("(참고사항)" + "\n" + "사용자님 : " + human + " 컴퓨터 : " + com);

			} else if ((com == 0 && human == 0) || (com == 1 && human == 1) || (com == 2 && human == 2)) {
				System.out.println("사용자와 컴퓨터가 비겼습니다.");
				System.out.println("(참고사항)" + "\n" + "사용자님 : " + human + " 컴퓨터 : " + com);
			}
		}

		while (true);

	}
}
