package strategy3.modularization;

import strategy3.component.JobImpl;
import strategy3.component.MoneyImpl;

public class Person {

	// 데이터생성하기
	private JobImpl job;
	private MoneyImpl get;
	private String ID;
	private String name;
	/*
	 * private String subject; private String part;
	 */

	// 생성자 생성하기
	public Person(String ID, String name) {
		super();
		this.ID = ID;
		this.name = name;
	}

	// 메소드 생성하기
	public void job() {
		job.job();
	}

	public void get() {
		get.get();
	}

	public void print() {
		if (ID.length() <= 4) {
			System.out.print("[ID] : " + ID + "\t\t[이름] : " + name);
		} else {
			System.out.print("[ID] : " + ID + "\t[이름] : " + name);
		}

	}

	// getter&setter생성
	public JobImpl getJob() {
		return job;
	}

	public void setJob(JobImpl job) {
		this.job = job;
	}

	public MoneyImpl getGet() {
		return get;
	}

	public void setGet(MoneyImpl get) {
		this.get = get;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
