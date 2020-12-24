package strategy3.modularization;

import strategy3.component.GetSalary;
import strategy3.component.JobMng;

public class Staff extends Person {

	// ������ �����ϱ�
	private String part;

	// ������ �����ϱ�
	public Staff(String ID, String name, String part) {
		super(ID, name);
		this.part = part;
		setJob(new JobMng());
		setGet(new GetSalary());
	}

	// print ������
	@Override
	public void print() {
		// TODO Auto-generated method stub
		super.print();
		System.out.print("\t[�� ��] : " + getPart() + "\n");
	}

	// getter&setter ����
	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

}
