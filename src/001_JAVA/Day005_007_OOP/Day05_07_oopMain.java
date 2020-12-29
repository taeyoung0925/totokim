package com.lec.day05_07_OOP;

public class Day05_07_oopMain {

	public static void main(String[] args) {
		Day05_07_oop hong = new Day05_07_oop("110-1", "홍길동", 10000);
		Day05_07_oop hong1 = new Day05_07_oop("110-2", "홍일");
		Day05_07_oop hong2 = new Day05_07_oop();

		hong2.setAccountNo("110-9");
		hong2.setOwnerName("신길동");

		hong.deposit(10000);
		hong.info();

		hong1.withdraw(1);
		hong1.info();

		hong2.deposit(10000);
		hong2.withdraw(2000);
		hong2.info();

	}

}
