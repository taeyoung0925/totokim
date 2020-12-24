package com.lec.Day12employee;

public class SalaryEmployee extends Employee {

	// 1. 单捞磐 积己
	private int annalSalary; // 楷豪

	// 2. 积己磊 积己
	public SalaryEmployee() {
	}

	public SalaryEmployee(String name, int annalSalary) {
		super(name);
		this.annalSalary = annalSalary;
	}

	// 3. 皋家靛 积己
	@Override
	public int computePay() {
		return annalSalary / 14;
	}

	// 4.getter&setter 积己
	public int getAnnalSalary() {
		return annalSalary;
	}

	public void setAnnalSalary(int annalSalary) {
		this.annalSalary = annalSalary;
	}

}
