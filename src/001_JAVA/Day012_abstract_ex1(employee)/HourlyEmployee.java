package com.lec.Day12employee;

public class HourlyEmployee extends Employee {

	//1. �����ͻ���
	private int hoursWorked; // �Ѵ޵��� ���� �ð�
	private int moneyPerHour; //�ð��� ����
	
	
	//2. ������ ����
	public HourlyEmployee() {
	}
	
	public HourlyEmployee(String name, int hoursWorked, int moneyPerHour) {
		super(name);
		this.hoursWorked = hoursWorked;
		this.moneyPerHour = moneyPerHour;
	}
	
	//3. �޼ҵ� ����
	@Override
	public int computePay() {
		return hoursWorked*moneyPerHour;
	}

	//4. getter&setter ����
	public int getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(int hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	public int getMoneyPerHour() {
		return moneyPerHour;
	}

	public void setMoneyPerHour(int moneyPerHour) {
		this.moneyPerHour = moneyPerHour;
	}

	

	

}
