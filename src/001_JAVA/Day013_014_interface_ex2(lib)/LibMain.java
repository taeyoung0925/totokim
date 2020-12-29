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
		
		int fn=0;  // ��ɹ�ȣ(1:����, 2:�ݳ� ���)
		int idx=0; //�ε���(books��)
		
		String bTitle, borrower, checkOutDate; // å����, ������, ������

		do {
			System.out.println("1 : ���� | 2 : �ݳ� | 3 :������Ȳ | 0 : ���� ");
			fn = scanner.nextInt();
			
			switch(fn) {
			
			case 1 : // å�̸� > å��ȸ > �ش�å�� ���� > ������,������ > ����
				
				//(case1)å�̸� �Է��ϱ�
				System.out.println("�����Ͻ� å�̸��� �Է����ּ��� : ");
				bTitle = scanner.next();
				
				//(case1)å��ȸ�ϱ�
				for(idx=0; idx<books.length; idx++) {
					if(bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				}//(case1)�� for��_å��ȸ�ϱ�
				
				//(case1)å��ȸ���� å�� ã�Ҵ����� ���θ� �Ǵ��ϰ� ������ ����
				if(idx == books.length) {
					System.out.println("�ش絵���� ���� ������ �Ұ��մϴ�.");
				}else if(books[idx].getState() == ILendable.STATE_BORROWED) {
					System.out.println(bTitle+"������ �������Դϴ�.");
				}else {
					System.out.println("�������� ������ �Է����ּ��� : ");
					borrower = scanner.next();
					System.out.println("�������� �Է����ּ��� : ");
					checkOutDate = scanner.next();
					books[idx].checkOut(borrower, checkOutDate); //�Է¹��� �����ΰ� ���������� �ش�å�� checkout����
				}
				break;
				
			case 2 : // å�̸� > å��ȸ > �ݳ�ó��
				
				//(case2)å�̸��Է��ϱ�
				System.out.println("�ݳ��� å�̸��� �Է����ּ��� : ");
				bTitle = scanner.next();
				
				//(case2)å��ȸ�ϱ�
				for(idx =0; idx<books.length; idx++) {
					if(bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				}
				
				if(idx == books.length) {
					System.out.println("�ش絵���� ���������� å�� �ƴմϴ�.");
				}else {
					books[idx].checkIn();
				}
				break;
				
			case 3 : // for���� �̿��ؼ� �������� ���
				for(BookLib b : books) {
					b.printState();
				}
			}//switch
		}//do
		while(fn != 0);
		System.out.println("�ý��� �����մϴ�.");
		
		
	}//main

}
