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
			System.out.println("(1)입력 | (2) 학과별 출력 | (3) 제적 X 전체출력 | (4) 제적 O 전체출력 | 그외 종료 ");
			fn = scanner.next();

			switch (fn) {
			case "1":
				// insertStudent(StudentDto dto)
				System.out.println("추가입력할 이름 ? ");
				String sname = scanner.next();

				System.out.println("추가입력할 학과명 ? ( 빅데이터학 | 경영정보학 | 컴퓨터공학 | 소프트웨어 | 인공지능학 ) ");
				String mname = scanner.next();

				System.out.println("추가입력할 점수 ? ");
				int score = scanner.nextInt();

				System.out.println("제적여부 (0 : 제적X | 1 : 제적O) ? ");
				int sexpel = scanner.nextInt();

				StudentDto newstudent = new StudentDto(sname, mname, score, sexpel);
				int result = dao.insertStudent(newstudent);
				System.out.println(result == StudentDao.SUCESS ? sname + "입력성공" : sname + "입력실패");
				break;

			case "2":
				// selectMname(String Mname)
				System.out.println("조회할 학과명 ( 빅데이터학 | 경영정보학 | 컴퓨터공학 | 소프트웨어 | 인공지능학 ) ? ");
				mname = scanner.next().trim();
				student = dao.selectMname(mname);
				if (student.size() != 0) {
					System.out.println("등수\t이름\t\t학과\t점수");
					for (StudentDto s : student)
						System.out.println(s);
				} else {
					System.out.println("해당 학과명의 인원이 없습니다.");
				}
				break;

			case "3":
				// selectsexpel0()
				student = dao.selectsexpel0();
				if (student.size() != 0) {
					System.out.println("등수\t이름\t\t학과\t점수");
					for (StudentDto s : student)
						System.out.println(s);
				} else {
					System.out.println("해당 학과명의 인원이 없습니다.");
				}
				break;
			case "4":
				// selectsexpel1()
				student = dao.selectsexpel1();
				if (student.size() != 0) {
					System.out.println("등수\t이름\t\t학과\t점수");
					for (StudentDto s : student)
						System.out.println(s);
				} else {
					System.out.println("해당 학과명의 인원이 없습니다.");
				}
				break;
			default:
				break;
			}

		} while (fn.equals("1") || fn.equals("2") || fn.equals("3") || fn.equals("4"));
		System.out.println("Exit");

	}

}
