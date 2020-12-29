package com.lec.ex10lib;

import java.util.Scanner;

public class LibMain {

	public static void main(String[] args) {
		
		BookLib[] books = { new BookLib("a001-874c", "java", "park"), 
										new BookLib("a02-875c", "jsp", "kim"),
										new BookLib("a03-876c", "python", "yee"), 
										new BookLib("a04-878c", "mySQL", "oh"),
										new BookLib("a05-879c", "C++", "choi") };
		
		Scanner scanner = new Scanner(System.in);
		
		int fn=0;  // 기능번호(1:대출, 2:반납 등등)
		int idx=0; //인덱스(books의)
		
		String bTitle, borrower, checkOutDate; // 책제목, 대출인, 대출일

		do {
			System.out.println("1 : 대출 | 2 : 반납 | 3 :도서현황 | 0 : 종료 ");
			fn = scanner.nextInt();
			
			switch(fn) {
			
			case 1 : // 책이름 > 책조회 > 해당책의 상태 > 대출인,대출일 > 대출
				
				//(case1)책이름 입력하기
				System.out.println("대출하실 책이름을 입력해주세요 : ");
				bTitle = scanner.next();
				
				//(case1)책조회하기
				for(idx=0; idx<books.length; idx++) {
					if(bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				}//(case1)의 for문_책조회하기
				
				//(case1)책조회에서 책을 찾았는지의 여부를 판단하고 대출을 진행
				if(idx == books.length) {
					System.out.println("해당도서가 없어 대출이 불가합니다.");
				}else if(books[idx].getState() == ILendable.STATE_BORROWED) {
					System.out.println(bTitle+"도서는 대출중입니다.");
				}else {
					System.out.println("대출인의 성함을 입력해주세요 : ");
					borrower = scanner.next();
					System.out.println("대출일을 입력해주세요 : ");
					checkOutDate = scanner.next();
					books[idx].checkOut(borrower, checkOutDate); //입력받은 대출인과 대출일으로 해당책을 checkout실행
				}
				break;
				
			case 2 : // 책이름 > 책조회 > 반납처리
				
				//(case2)책이름입력하기
				System.out.println("반납할 책이름을 입력해주세요 : ");
				bTitle = scanner.next();
				
				//(case2)책조회하기
				for(idx =0; idx<books.length; idx++) {
					if(bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				}
				
				if(idx == books.length) {
					System.out.println("해당도서는 본도서관의 책이 아닙니다.");
				}else {
					books[idx].checkIn();
				}
				break;
				
			case 3 : // for문을 이용해서 도서상태 출력
				for(BookLib b : books) {
					b.printState();
				}
			}//switch
		}//do
		while(fn != 0);
		System.out.println("시스템 종료합니다.");
		
		
	}//main

}
