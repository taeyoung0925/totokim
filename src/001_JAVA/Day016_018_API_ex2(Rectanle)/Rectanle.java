package com.lec.ex04_Object;

public class Rectanle {

	//������ ����
	private int width;//����
	private int length;//����
	private String colors;// ����
	
	//������ ����
	public Rectanle(int width, int length, String colors) {
		this.width = width;
		this.length = length;
		this.colors = colors;
	}
	
	public Rectanle() {
		this.width = 0;
		this.length = 0;
		this.colors = "����";
	}
	
	//�޼ҵ� ����
	
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
		String temp = "[ ���� " + width + "cm, ���� " + length + "cm, " + colors +"�簢�� ]" ; //return���� �����ϱ� ���� �ӽ� ���� 
		return temp;
	}
	
	
	//getter&setter ����
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
