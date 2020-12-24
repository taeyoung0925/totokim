package strategy3.modularization;

import strategy3.component.GetSalary;
import strategy3.component.JobLec;

public class Lecturer extends Person {

	// ������ �����ϱ�
	private String subject;

	// ������ �����ϱ�
	public Lecturer(String ID, String name, String subject) {
		super(ID, name);
		this.subject = subject;
		setJob(new JobLec());
		setGet(new GetSalary());

	}

	// print ������
	@Override
	public void print() {
		// TODO Auto-generated method stub
		super.print();
		System.out.print("\t[���ǰ���] : " + getSubject() + "\n");
	}

	// getter&setter ����
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
