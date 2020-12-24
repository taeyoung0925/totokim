/*실습예제2 : 정규직 3명과 아르바이트생2명인 조그만 회사의 월급명세서 출력 프로그램을 구현하시오.
1) Employee 
name : 이름
final int computeIncentive() ; 상여금 계산. 상여금은 월급이 200백만원이 넘는 사람에 한하여 10%로.
abstract int computePay();

2) SalaryEmployee 
annalSalary ; 연봉
computePay() ; 월급계산. 월급은 연봉/14로 한다. 

3) HourlyEmployee 
hoursWorked ; 한달동안 일한 시간
moneyPerHour ; 시간당 페이
computePay() ; 한달동안일한시간 * 시간당 페이
*/

package com.lec.Day12employee;

public abstract class Employee {

	// 1. 데이터 생성
	private String name; // 이름

	// 2. 생성자 생성
	public Employee() {

	}

	public Employee(String name) {
		this.name = name;
	}

	// 3. 메소드 생성
	public abstract int computePay(); // 월급 또는 한달동안일한시간*페이

	public final int computeIncentive() {
		int temp;
		temp = computePay();
		if (temp > 2000000) {
			return (int) (temp * 0.1);
		}
		return 0;

	}

	//4. getter&setter 생성
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
