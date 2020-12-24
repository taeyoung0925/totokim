package strategy3.modularization;

import strategy3.component.GetSalary;
import strategy3.component.JobLec;

public class Lecturer extends Person {

	// 데이터 생성하기
	private String subject;

	// 생성자 생성하기
	public Lecturer(String ID, String name, String subject) {
		super(ID, name);
		this.subject = subject;
		setJob(new JobLec());
		setGet(new GetSalary());

	}

	// print 재정의
	@Override
	public void print() {
		// TODO Auto-generated method stub
		super.print();
		System.out.print("\t[강의과목] : " + getSubject() + "\n");
	}

	// getter&setter 생성
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
