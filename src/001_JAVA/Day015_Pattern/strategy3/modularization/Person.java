package strategy3.modularization;

import strategy3.component.JobImpl;
import strategy3.component.MoneyImpl;

public class Person {

	// �����ͻ����ϱ�
	private JobImpl job;
	private MoneyImpl get;
	private String ID;
	private String name;
	/*
	 * private String subject; private String part;
	 */

	// ������ �����ϱ�
	public Person(String ID, String name) {
		super();
		this.ID = ID;
		this.name = name;
	}

	// �޼ҵ� �����ϱ�
	public void job() {
		job.job();
	}

	public void get() {
		get.get();
	}

	public void print() {
		if (ID.length() <= 4) {
			System.out.print("[ID] : " + ID + "\t\t[�̸�] : " + name);
		} else {
			System.out.print("[ID] : " + ID + "\t[�̸�] : " + name);
		}

	}

	// getter&setter����
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
