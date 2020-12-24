package com.lec.Day12employee;

public class HourlyEmployee extends Employee {

	//1. 데이터생성
	private int hoursWorked; // 한달동안 일한 시간
	private int moneyPerHour; //시간당 페이
	
	
	//2. 생성자 생성
	public HourlyEmployee() {
	}
	
	public HourlyEmployee(String name, int hoursWorked, int moneyPerHour) {
		super(name);
		this.hoursWorked = hoursWorked;
		this.moneyPerHour = moneyPerHour;
	}
	
	//3. 메소드 생성
	@Override
	public int computePay() {
		return hoursWorked*moneyPerHour;
	}

	//4. getter&setter 생성
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
