/*�ǽ�����2 : ������ 3��� �Ƹ�����Ʈ��2���� ���׸� ȸ���� ���޸��� ��� ���α׷��� �����Ͻÿ�.
1) Employee 
name : �̸�
final int computeIncentive() ; �󿩱� ���. �󿩱��� ������ 200�鸸���� �Ѵ� ����� ���Ͽ� 10%��.
abstract int computePay();

2) SalaryEmployee 
annalSalary ; ����
computePay() ; ���ް��. ������ ����/14�� �Ѵ�. 

3) HourlyEmployee 
hoursWorked ; �Ѵ޵��� ���� �ð�
moneyPerHour ; �ð��� ����
computePay() ; �Ѵ޵������ѽð� * �ð��� ����
*/

package com.lec.Day12employee;

public abstract class Employee {

	// 1. ������ ����
	private String name; // �̸�

	// 2. ������ ����
	public Employee() {

	}

	public Employee(String name) {
		this.name = name;
	}

	// 3. �޼ҵ� ����
	public abstract int computePay(); // ���� �Ǵ� �Ѵ޵������ѽð�*����

	public final int computeIncentive() {
		int temp;
		temp = computePay();
		if (temp > 2000000) {
			return (int) (temp * 0.1);
		}
		return 0;

	}

	//4. getter&setter ����
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
