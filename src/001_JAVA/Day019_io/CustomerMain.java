package com.lec.Day19_io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CustomerMain {
	public static void main(String[] args) {

		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		String answer, name, phone, birthday, address;
		ArrayList<Customer> customers = new ArrayList<Customer>();
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String todaysdf = sdf.format(today);

		// 1. N(n)을 입력할때까지 회원정보를 arraylist에 받음(오늘 생일이면 축하메세지 출력하기)
		do {

			try {
				System.out.println("회원가입을 하시겠습니까?(Y/N)");
				answer = keyboard.readLine();
				if (answer.equalsIgnoreCase("N"))
					break;

				System.out.println("이름을 입력해주세요 : ");
				name = keyboard.readLine();

				System.out.println("전화번호를 입력해주세요 : ");
				phone = keyboard.readLine();

				System.out.println("생일(mm-dd)을 입력해주세요 : ");
				birthday = keyboard.readLine();
				if (birthday.equals(todaysdf)) {
					System.out.println(name + "님 생일축하합니다!");
				}

				System.out.println("주소를 입력해주세요 : ");
				address = keyboard.readLine();

				customers.add(new Customer(name, phone, birthday, address));

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		} while (true);
		// 2. arraylist 정보와 몇명 가입했는지 파일&콘솔 출력
		OutputStream os = null;

		try {
			os = new FileOutputStream("textFile/customer.txt", true);
			for (Customer c : customers) {
				byte[] bs = c.toString().getBytes();
				System.out.println(c);
				os.write(bs);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
		
			try {
				if (os != null)
					os.close();

				if (keyboard != null)
					keyboard.close();

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}
}
