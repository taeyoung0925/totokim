package com.lec.student_GUI;

public class StudentDto {

	private int rank;
	private String sno;
	private String sname;
	private String mname;
	private int score;
	private int sexpel;

	// INSERT
	public StudentDto(String sname, String mname, int score) {
		this.sname = sname;
		this.mname = mname;
		this.score = score;
	}

	// SELECT(1)
	public StudentDto(int rank, String sno, String sname, String mname, int score) {
		this.rank = rank;
		this.sno = sno;
		this.sname = sname;
		this.mname = mname;
		this.score = score;
	}

	// SELECT(2)
	public StudentDto(String sno, String sname, String mname, int score) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.mname = mname;
		this.score = score;
	}

}
