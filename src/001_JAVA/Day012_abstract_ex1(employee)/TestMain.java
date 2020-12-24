package com.lec.Day12employee;

public class TestMain {

	public static void main(String[] args) {
		Employee[] employees = {
				new SalaryEmployee("홍길동", 24000000),
				new SalaryEmployee("강동원", 70000000),
				new SalaryEmployee("김고은", 12000000),
				new HourlyEmployee("홍길구", 100,7000),
				new HourlyEmployee("김길자", 120,8000)};
		
		
		for(Employee temp : employees) {
			System.out.println("======월급명세서======");
			System.out.println("성   함 : " +temp.getName() +"님");
			System.out.println("월   급 : " +temp.computePay()+"원");
			//상여급이 있는 사람만 상여급 표현
			int tempIncentive = temp.computeIncentive();
			if(tempIncentive != 0) {
				System.out.println("상여급: " +tempIncentive+"원");
			}
			System.out.println("수 고 하 셨 습 니 다");
		}

	}

}
