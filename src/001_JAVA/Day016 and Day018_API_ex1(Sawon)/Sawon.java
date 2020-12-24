package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Sawon {

	//������ ����
	private String num; //���
	private String name; // �̸�
	private String part; //�μ�
	private Date enterDate; // �Ի���

	//������ ����
	public Sawon(String num, String name, String part) {
		this.num = num;
		this.name = name;
		this.part = part;
		enterDate = new Date();
	}
	
	public Sawon(String num, String name, String part, int y, int m, int d) {
		this.num = num;
		this.name = name;
		this.part = part;
		enterDate = new Date(new GregorianCalendar(y, m-1, d).getTimeInMillis());
	}
	
	//�޼ҵ� ����
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		String result = "[���]"+num  + " [�̸�]" +name +
			      " [�μ�]"+part + " [�Ի���]"+sdf.format(enterDate);
		return result;
	}

	//getter&setter����
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public Date getEnterDate() {
		return enterDate;
	}

	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}
	
	
	
	
	
	
}
