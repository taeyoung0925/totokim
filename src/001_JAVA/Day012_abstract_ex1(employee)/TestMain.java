package com.lec.Day12employee;

public class TestMain {

	public static void main(String[] args) {
		Employee[] employees = {
				new SalaryEmployee("ȫ�浿", 24000000),
				new SalaryEmployee("������", 70000000),
				new SalaryEmployee("�����", 12000000),
				new HourlyEmployee("ȫ�汸", 100,7000),
				new HourlyEmployee("�����", 120,8000)};
		
		
		for(Employee temp : employees) {
			System.out.println("======���޸���======");
			System.out.println("��   �� : " +temp.getName() +"��");
			System.out.println("��   �� : " +temp.computePay()+"��");
			//�󿩱��� �ִ� ����� �󿩱� ǥ��
			int tempIncentive = temp.computeIncentive();
			if(tempIncentive != 0) {
				System.out.println("�󿩱�: " +tempIncentive+"��");
			}
			System.out.println("�� �� �� �� �� �� ��");
		}

	}

}
