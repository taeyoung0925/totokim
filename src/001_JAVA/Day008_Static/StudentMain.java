package com.lec.day08_static;

public class StudentMain {

	public static void main(String[] args) {
		Student[] students = { new Student("정우성", 90, 91, 91), new Student("김하늘", 100, 80, 95),
										   new Student("황정민", 95, 80, 90), new Student("강동원", 95, 90, 99), 
										   new Student("유아인", 90, 90, 80), };

		
		// 과목별 평균 및 합계를 구하기 위한 배열 생성
		int[] tot = new int[5];
		int[] avg = new int[tot.length];

		
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t\t\t\t성     적     표\t\t\t\t");
		System.out.println("---------------------------------------------------------------------------------------");
	
		System.out.println(
				"번호" + "\t\t" + "이름" + "\t\t" + "국어" + "\t\t" + "영어" + "\t\t" + "수학" + "\t\t" + "합계" + "\t\t" + "평균");
	
		System.out.println("---------------------------------------------------------------------------------------");
		
		
		
		for (Student student : students) {
			System.out.println(student.infoprint());
			tot[0] += student.getKor(); //각과목의 합을 구하기 
			tot[1] += student.getEng();
			tot[2] += student.getMat();
			tot[3] += student.getTot();
			tot[4] += student.getAvg();
		}
		
		
		System.out.println("---------------------------------------------------------------------------------------");

		
		System.out.print("\t" + "총             점" + "\t"); //과목별 총점구하기
		for (int t : tot) {
			String temp = "" + t;
			if (temp.length() >= 4) {
				System.out.print(t + "\t");
			} else {
				System.out.print(t + "\t\t");
			}
		}

		System.out.println();

		for (int i = 0; i < avg.length; i++) { // 과목별 평균 구하기 
			avg[i] = tot[i] / students.length;
		}
		
		System.out.print("\t" + "평             균" + "\t");
		for (int a : avg) {
			System.out.print(a + "\t\t");
		}
		System.out.println();
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");

	}

}
