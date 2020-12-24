package com.lec.day08_static;

public class StudentMain {

	public static void main(String[] args) {
		Student[] students = { new Student("���켺", 90, 91, 91), new Student("���ϴ�", 100, 80, 95),
										   new Student("Ȳ����", 95, 80, 90), new Student("������", 95, 90, 99), 
										   new Student("������", 90, 90, 80), };

		
		// ���� ��� �� �հ踦 ���ϱ� ���� �迭 ����
		int[] tot = new int[5];
		int[] avg = new int[tot.length];

		
		System.out.println("����������������������������������������������������������������������������");
		System.out.println("\t\t\t\t��     ��     ǥ\t\t\t\t");
		System.out.println("---------------------------------------------------------------------------------------");
	
		System.out.println(
				"��ȣ" + "\t\t" + "�̸�" + "\t\t" + "����" + "\t\t" + "����" + "\t\t" + "����" + "\t\t" + "�հ�" + "\t\t" + "���");
	
		System.out.println("---------------------------------------------------------------------------------------");
		
		
		
		for (Student student : students) {
			System.out.println(student.infoprint());
			tot[0] += student.getKor(); //�������� ���� ���ϱ� 
			tot[1] += student.getEng();
			tot[2] += student.getMat();
			tot[3] += student.getTot();
			tot[4] += student.getAvg();
		}
		
		
		System.out.println("---------------------------------------------------------------------------------------");

		
		System.out.print("\t" + "��             ��" + "\t"); //���� �������ϱ�
		for (int t : tot) {
			String temp = "" + t;
			if (temp.length() >= 4) {
				System.out.print(t + "\t");
			} else {
				System.out.print(t + "\t\t");
			}
		}

		System.out.println();

		for (int i = 0; i < avg.length; i++) { // ���� ��� ���ϱ� 
			avg[i] = tot[i] / students.length;
		}
		
		System.out.print("\t" + "��             ��" + "\t");
		for (int a : avg) {
			System.out.print(a + "\t\t");
		}
		System.out.println();
		System.out.println("����������������������������������������������������������������������������");

	}

}
