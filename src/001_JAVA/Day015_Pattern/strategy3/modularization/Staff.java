package strategy3.modularization;

import strategy3.component.GetSalary;
import strategy3.component.JobMng;

public class Staff extends Person {

	// 데이터 생성하기
	private String part;

	// 생성자 생성하기
	public Staff(String ID, String name, String part) {
		super(ID, name);
		this.part = part;
		setJob(new JobMng());
		setGet(new GetSalary());
	}

	// print 재정의
	@Override
	public void print() {
		// TODO Auto-generated method stub
		super.print();
		System.out.print("\t[스 탭] : " + getPart() + "\n");
	}

	// getter&setter 생성
	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

}
