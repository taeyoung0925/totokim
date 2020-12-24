package com.lec.day08_static;

public class Student {

	//�����ͻ���
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private double avg;
	//�Ϸù�ȣ ������ ����
	private static int count = 0;
	private int no;
	
	//�����ڻ���
	public Student(String name, int kor, int eng, int mat) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		no = ++count;
		tot = kor+eng+mat;
		avg = (int)(tot/3.0);
	}
	
	public Student() {
	}
	

	//�޼ҵ� ����
	public void print(){
		System.out.println(no+"\t\t"+name+"\t\t"+kor+"\t\t"+eng+"\t\t"+mat+"\t\t"+tot+"\t\t"+avg);
	}

	public String infoprint(){
		return no+"\t\t"+name+"\t\t"+kor+"\t\t"+eng+"\t\t"+mat+"\t\t"+tot+"\t\t"+avg;
	}
	
	//getter&setter����
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}
	
	
	
}
