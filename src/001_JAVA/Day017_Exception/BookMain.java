package com.lec.Day17_Exception;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.lec.ex5_lib.BookLib;

public class BookMain {
	public static void main(String[] args) {

		BookLib[] books = { new BookLib("890ㄱ-01", "java", "홍길동"), new BookLib("890ㄱ-02", "dbms", "홍신촌"),
				new BookLib("890ㄱ-03", "html", "김신춘"), new BookLib("890ㄱ-04", "hadoop", "이마포"),
				new BookLib("890ㅍ-05", "python", "노고산") };

		Scanner scanner = new Scanner(System.in);

		int fn;
		// 기능번호(0: 전체 대출여부 상태 열람, 1:대출, 2:반납, 그외문자포함 종료
		int idx;
		// 대출이나 반납을 처리할 책의 index
		String bTitle, borrower, checkOutDate;
		// 책제목, 대출인, 대출일

		do {

			System.out.println("0 : 전체 대출여부 상태 열람 | 1 : 대출 | 2 : 반납 | 그 외(문자포함) : 종료");

			try {
				fn = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("0,1,2를 제외한 문자를 입력하면 프로그램이 종료됩니다.");
				break;
			}
			switch (fn) {
			case 0:
				for (BookLib book : books) {
					System.out.println(book);
				}

			case 1:
				// 책이름 > 책조회 > 해당책의 상태 > 대출인,대출일 > 대출

				// 책이름 입력
				System.out.println("대출할 책의 이름은 무엇인가요 ? ");
				bTitle = scanner.next();

				// 책조회하기
				for (idx = 0; idx < books.length; idx++) {
					if (bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				}

				// 책 조회에서 책을 찾았는지의 여부를 보고 대출을 진행
				if (idx == books.length) {
					System.out.println("해당 도서가 없어 대출이 불가능합니다.");
				} else {
					if (books[idx].getState() == BookLib.STATE_BORROWED) {
						System.out.println("현재 대출중인 도서입니다.");
					} else {
						System.out.println("대출인의 성함을 알려주세요 : ");
						borrower = scanner.next();

						try {
							books[idx].checkOut(borrower);
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}

					}
				} // case1
				break;

			case 2:
				// 반납처리 : 책이름 > 책검색 > 반납처리

				// 책이름
				System.out.println("반납할 책의 이름은 무엇인가요?");
				scanner.nextLine();
				bTitle = scanner.nextLine();

				// 책 조회하기
				for (idx = 0; idx < books.length; idx++) {
					if (books[idx].getBookTitle().equals(bTitle)) {
						break;
					}
				}

				// 책 조회에서 책을 찾았는지 확인후 반납처리
				if (idx == books.length) {
					System.out.println("해당 도서는 본도서관의 보유책이 아닙니다.");
				} else {
					try {
						books[idx].checkIn();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				} // case2
				break;

			}

		} while (fn == 0 || fn == 1 || fn == 2);
		System.out.println("0,1,2 그 외 문자를 입력하면 프로그램이 종료됩니다.");

	}
}
