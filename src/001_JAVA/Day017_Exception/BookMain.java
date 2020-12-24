package com.lec.Day17_Exception;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.lec.ex5_lib.BookLib;

public class BookMain {
	public static void main(String[] args) {

		BookLib[] books = { new BookLib("890��-01", "java", "ȫ�浿"), new BookLib("890��-02", "dbms", "ȫ����"),
				new BookLib("890��-03", "html", "�����"), new BookLib("890��-04", "hadoop", "�̸���"),
				new BookLib("890��-05", "python", "����") };

		Scanner scanner = new Scanner(System.in);

		int fn;
		// ��ɹ�ȣ(0: ��ü ���⿩�� ���� ����, 1:����, 2:�ݳ�, �׿ܹ������� ����
		int idx;
		// �����̳� �ݳ��� ó���� å�� index
		String bTitle, borrower, checkOutDate;
		// å����, ������, ������

		do {

			System.out.println("0 : ��ü ���⿩�� ���� ���� | 1 : ���� | 2 : �ݳ� | �� ��(��������) : ����");

			try {
				fn = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("0,1,2�� ������ ���ڸ� �Է��ϸ� ���α׷��� ����˴ϴ�.");
				break;
			}
			switch (fn) {
			case 0:
				for (BookLib book : books) {
					System.out.println(book);
				}

			case 1:
				// å�̸� > å��ȸ > �ش�å�� ���� > ������,������ > ����

				// å�̸� �Է�
				System.out.println("������ å�� �̸��� �����ΰ��� ? ");
				bTitle = scanner.next();

				// å��ȸ�ϱ�
				for (idx = 0; idx < books.length; idx++) {
					if (bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				}

				// å ��ȸ���� å�� ã�Ҵ����� ���θ� ���� ������ ����
				if (idx == books.length) {
					System.out.println("�ش� ������ ���� ������ �Ұ����մϴ�.");
				} else {
					if (books[idx].getState() == BookLib.STATE_BORROWED) {
						System.out.println("���� �������� �����Դϴ�.");
					} else {
						System.out.println("�������� ������ �˷��ּ��� : ");
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
				// �ݳ�ó�� : å�̸� > å�˻� > �ݳ�ó��

				// å�̸�
				System.out.println("�ݳ��� å�� �̸��� �����ΰ���?");
				scanner.nextLine();
				bTitle = scanner.nextLine();

				// å ��ȸ�ϱ�
				for (idx = 0; idx < books.length; idx++) {
					if (books[idx].getBookTitle().equals(bTitle)) {
						break;
					}
				}

				// å ��ȸ���� å�� ã�Ҵ��� Ȯ���� �ݳ�ó��
				if (idx == books.length) {
					System.out.println("�ش� ������ ���������� ����å�� �ƴմϴ�.");
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
		System.out.println("0,1,2 �� �� ���ڸ� �Է��ϸ� ���α׷��� ����˴ϴ�.");

	}
}
