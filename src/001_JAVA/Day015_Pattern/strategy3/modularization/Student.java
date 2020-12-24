package strategy3.modularization;

import strategy3.component.GetStudentPay;
import strategy3.component.JobStudy;

public class Student extends Person {

	
	//������ �����ϱ�
	 private String ban; 
	 
	 //������ �����ϱ� 
		public Student(String ID, String name, String ban) {
			super(ID, name);
			this.ban = ban;
			setJob(new JobStudy());
			setGet(new GetStudentPay());
		}
	
	//print ������ 
	@Override
	public void print() {
		// TODO Auto-generated method stub
		super.print();
		System.out.print("\t[ �� ] : " + getBan()+"\n");
	}



	//getter&setter ����
	public String getBan() {
		return ban;
	}

	public void setBan(String ban) {
		this.ban = ban;
	}
	
}
