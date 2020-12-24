package strategy3.modularization;

import strategy3.component.GetStudentPay;
import strategy3.component.JobStudy;

public class Student extends Person {

	
	//데이터 생성하기
	 private String ban; 
	 
	 //생성자 생성하기 
		public Student(String ID, String name, String ban) {
			super(ID, name);
			this.ban = ban;
			setJob(new JobStudy());
			setGet(new GetStudentPay());
		}
	
	//print 재정의 
	@Override
	public void print() {
		// TODO Auto-generated method stub
		super.print();
		System.out.print("\t[ 반 ] : " + getBan()+"\n");
	}



	//getter&setter 생성
	public String getBan() {
		return ban;
	}

	public void setBan(String ban) {
		this.ban = ban;
	}
	
}
