/*실습 예제 : 두수를 입력받아 두 수가 같은지 결과를 O나 X로 출력. 첫번째 수가 더 큰지 결과를 O나 X로 출력한다.*/

package com.lec.java;

import java.util.Scanner;

public class Day02_operator {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("첫번째 숫자를 입력해주세요: ");
		int i = scanner.nextInt();

		System.out.println("두번째 숫자를 입력해주세요: ");
		int j = scanner.nextInt();

		if (i != j) {
			System.out.println("두수는 다릅니다 : X");
		}
		if (i == j) {
			System.out.println("두수는 같습니다  : O");
		} else if (i > j) {
			System.out.println(i + "의 값이 " + j + "보다 큽니다.");
		} else {
			System.out.println(j + "의 값이 " + i + "보다 큽니다.");
		}
	}
}
