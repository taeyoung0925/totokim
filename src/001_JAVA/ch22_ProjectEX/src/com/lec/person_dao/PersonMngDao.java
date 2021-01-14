package com.lec.person_dao;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonMngDao {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		PersonDao dao = PersonDao.getInstance();
		String fn;
		ArrayList<PersonDto> person;

		do {
			System.out.println("(1)�Է� | (2) ������ ��� | (3) ��ü��� | �׿� ���� ");
			fn = scanner.next();
			switch (fn) {
			case "1":
				// �̸�, ������, ������ �Է¹޾� dao.insertPerson() ȣ��
				System.out.println("�߰��Է��� �̸� ? ");
				String name = scanner.next();

				System.out.println("�߰��Է��� ������ ? ");
				String jname = scanner.next();

				System.out.println("�߰��Է��� �������� ? ");
				int kor = scanner.nextInt();

				System.out.println("�߰��Է��� �������� ? ");
				int eng = scanner.nextInt();

				System.out.println("�߰��Է��� �������� ? ");
				int mat = scanner.nextInt();

				PersonDto newPerson = new PersonDto(name, jname, kor, eng, mat);
				int result = dao.insertPerson(newPerson); // �Է³�
				System.out.println(result == PersonDao.SUCESS ? name + "�Է¼���" : name + "�Է½���");
				break;

			case "2":
				// ������ �Է¹޾� dao.selectJname() ȣ���Ͽ� ��� ���
				System.out.println("��ȸ�� ������ ( ��� | ���� | MC ) ? ");
				jname = scanner.next();
				person = dao.selectJname(jname);
				if (person.size() != 0) {
					System.out.println("���\t �̸�\t ����\t ����\t ����\t ����\t ����");
					for (PersonDto p : person)
						System.out.println(p);
				} else {
					System.out.println("�ش� �������� �ο��� �����ϴ�.");
				}
				break;

			case "3":
				// dao.selectAll() ȣ���Ͽ� ��� ���
				person = dao.selectAll();
				if (person.size() != 0) {
					System.out.println("���\t �̸�\t ����\t ����\t ����\t ����\t ����");
					for (PersonDto p : person)
						System.out.println(p);
				} else {
					System.out.println("�ش� �������� �ο��� �����ϴ�.");
				}

				break;

			default:
				break;
			}
		} while (fn.equals("1") || fn.equals("2") || fn.equals("3"));
		System.out.println("Exit");

	}
}
