package com.lec.ex2_map;
/*
 * 실습예제 
 * N(n)”을 입력할 때까지 회원가입 정보(이름, 전화번호, 주소)를 HashMap에 받고, 
"N(n)"을 입력할 시엔 가입한 모든 회원들의 정보를 아래와 같이 콘솔창에 출력한다
(단, HashMap의 키값은 전화번호, 데이터는 회원정보로 한다)

홍길동 010-9999-9999 서울시 용산구
김마동 010-8888-8888 서울시 종로구*/

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import com.lec.ex3_set.Customer;

public class CustomerMain {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String answer;
		String name = null, phone, address;
		HashMap<String, Customer> customers = new HashMap<String, Customer>();

		while (true) {
			System.out.println("회원가입을 진행하겠습니까?(Y/N) ");
			answer = scanner.nextLine().trim();

			if (answer.equalsIgnoreCase("n")) {
				break;
			} else if (answer.equalsIgnoreCase("Y")) {
				System.out.println("가입하실 회원 전화번호 : ");
				phone = scanner.nextLine();

				System.out.println("가입하실 회원 주소 : ");
				address = scanner.nextLine();
				customers.put(phone, new Customer(name, phone, address));

			}
		}
		scanner.close();
		if (customers.isEmpty()) {
			System.out.println("가입한 회원이 없습니다.");
		} else {
			System.out.println("가입한 회원 리스트 목록");
			Iterator<String> iterator = customers.keySet().iterator();
			while (iterator.hasNext()) {
				String key = iterator.next();
				System.out.println(customers.get(key));
			}
		}

	}
}
