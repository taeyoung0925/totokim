package com.lec.student_Console;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentMngDao {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		StudentDao dao = StudentDao.getInstance();
		String fn;
		ArrayList<StudentDto> student;

		do {
			System.out.println("(1)�Է� | (2) �а��� ��� | (3) ���� X ��ü��� | (4) ���� O ��ü��� | �׿� ���� ");
			fn = scanner.next();

			switch (fn) {
			case "1":
				// insertStudent(StudentDto dto)
				System.out.println("�߰��Է��� �̸� ? ");
				String sname = scanner.next();

				System.out.println("�߰��Է��� �а��� ? ( �������� | �濵������ | ��ǻ�Ͱ��� | ����Ʈ���� | �ΰ������� ) ");
				String mname = scanner.next();

				System.out.println("�߰��Է��� ���� ? ");
				int score = scanner.nextInt();

				System.out.println("�������� (0 : ����X | 1 : ����O) ? ");
				int sexpel = scanner.nextInt();

				StudentDto newstudent = new StudentDto(sname, mname, score, sexpel);
				int result = dao.insertStudent(newstudent);
				System.out.println(result == StudentDao.SUCESS ? sname + "�Է¼���" : sname + "�Է½���");
				break;

			case "2":
				// selectMname(String Mname)
				System.out.println("��ȸ�� �а��� ( �������� | �濵������ | ��ǻ�Ͱ��� | ����Ʈ���� | �ΰ������� ) ? ");
				mname = scanner.next().trim();
				student = dao.selectMname(mname);
				if (student.size() != 0) {
					System.out.println("���\t�̸�\t\t�а�\t����");
					for (StudentDto s : student)
						System.out.println(s);
				} else {
					System.out.println("�ش� �а����� �ο��� �����ϴ�.");
				}
				break;

			case "3":
				// selectsexpel0()
				student = dao.selectsexpel0();
				if (student.size() != 0) {
					System.out.println("���\t�̸�\t\t�а�\t����");
					for (StudentDto s : student)
						System.out.println(s);
				} else {
					System.out.println("�ش� �а����� �ο��� �����ϴ�.");
				}
				break;
			case "4":
				// selectsexpel1()
				student = dao.selectsexpel1();
				if (student.size() != 0) {
					System.out.println("���\t�̸�\t\t�а�\t����");
					for (StudentDto s : student)
						System.out.println(s);
				} else {
					System.out.println("�ش� �а����� �ο��� �����ϴ�.");
				}
				break;
			default:
				break;
			}

		} while (fn.equals("1") || fn.equals("2") || fn.equals("3") || fn.equals("4"));
		System.out.println("Exit");

	}

}
