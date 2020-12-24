package com.lec.Day12employee;

public class SalaryEmployee extends Employee {

	// 1. ������ ����
	private int annalSalary; // ����

	// 2. ������ ����
	public SalaryEmployee() {
	}

	public SalaryEmployee(String name, int annalSalary) {
		super(name);
		this.annalSalary = annalSalary;
	}

	// 3. �޼ҵ� ����
	@Override
	public int computePay() {
		return annalSalary / 14;
	}

	// 4.getter&setter ����
	public int getAnnalSalary() {
		return annalSalary;
	}

	public void setAnnalSalary(int annalSalary) {
		this.annalSalary = annalSalary;
	}

}
