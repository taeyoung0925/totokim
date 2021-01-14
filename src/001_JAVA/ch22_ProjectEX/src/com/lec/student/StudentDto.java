package com.lec.student;

public class StudentDto {

	private int rank;
	private String sno;
	private String sname;
	private String mname;
	private int score;
	private int sexpel;

	// insert 持失切
	public StudentDto(String sname, String mname,  int score, int sexpel) {

		this.sname = sname;
		this.mname = mname;
		this.score = score;
		this.sexpel = sexpel;
	}

	// select 持失切
	public StudentDto(int rank, String sno, String mname, int score) {
		super();
		this.rank = rank;
		this.sno = sno;
		this.mname = mname;
		this.score = score;

	}

	@Override
	public String toString() {
		return rank + "\t" + sno + "\t" +  mname + "\t" +  score ;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getSexpel() {
		return sexpel;
	}

	public void setSexpel(int sexpel) {
		this.sexpel = sexpel;
	}



}
