package com.lec.student_GUI;

public class StudentSwingDto {

	private int rank;
	private String sno;
	private String sname;
	private String mname;
	private int score;
	private int sexpel;

	// INSERT
	public StudentSwingDto(String sname, String mname, int score) {
		this.sname = sname;
		this.mname = mname;
		this.score = score;
	}

	// SELECT(1)

	public StudentSwingDto(int rank, String sname, String mname, int score) {
		this.rank = rank;
		this.sname = sname;
		this.mname = mname;
		this.score = score;
	}

	// SELECT(2)
	public StudentSwingDto(String sno, String sname, String mname, int score) {
		this.sno = sno;
		this.sname = sname;
		this.mname = mname;
		this.score = score;
	}

	@Override
	public String toString() {
		if(rank !=0) {
			return rank + "µî\t" + sname + "\t" + mname + "\t" + score;
		} else {
			return sno + "\t" + sname + "\t" + mname + "\t" + score;
		}
		
	}

	// GETTER & SETTER
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
