package com.lec.ex04_Object;

public class Rectanle {

	//데이터 생성
	private int width;//가로
	private int length;//세로
	private String colors;// 색깔
	
	//생성자 생성
	public Rectanle(int width, int length, String colors) {
		this.width = width;
		this.length = length;
		this.colors = colors;
	}
	
	public Rectanle() {
		this.width = 0;
		this.length = 0;
		this.colors = "검정";
	}
	
	//메소드 생성
	
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Rectanle) {
			return width == ((Rectanle)obj).width && length == ((Rectanle)obj).length && colors.equals(((Rectanle)obj).colors);
		} else {
			return false;
		}
		
	}
	
	
	@Override
	public String toString() {
		String temp = "[ 가로 " + width + "cm, 세로 " + length + "cm, " + colors +"사각형 ]" ; //return값을 선언하기 위한 임시 변수 
		return temp;
	}
	
	
	//getter&setter 생성
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getColors() {
		return colors;
	}

	public void setColors(String colors) {
		this.colors = colors;
	}
	
	
	
	
	
}
