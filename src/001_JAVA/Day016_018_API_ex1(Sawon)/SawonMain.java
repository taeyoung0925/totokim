/*
 * <�ǽ�����> : Sawon Ŭ������ main�Լ��� ����ִ� �κ��� �����Ͽ� ������
SawonŬ���� ����
������ : ���, �̸�, �μ�(COMPUTER, PLANNING, DESIGN, ACCOUNTING, HUMANRESOURCES), �Ի���.
������ : ���, �̸�, �μ�, �Ի����� ��ü���� ���Ϸ� �մϴ�
�޼ҵ�: infoString()�� �������� ������ �����ϴ�
[���]200121  [�̸�]ȫ�浿  [�μ�]COMPUTER  [�Ի���]2019��2��2��
main()�Լ����� Sawon ��ü ����� ȭ�鿡 print�� ������. ������ �Ի��� ����� ����մϴ�*/



package com.lec.ex2_date;

public class SawonMain {
public static void main(String[] args) {
	Sawon[] sawons = {new Sawon("200121","ȫ�浿", "COMPUTER"),
			new Sawon("200221","ȫ�浿", "COMPUTER",2000,10,16),
			new Sawon("200571","��̼�", "PLANNING"),
			new Sawon("201035","��   ȫ", "DESIGN"),
			new Sawon("201100","��  ��", "ACCOUNTING",2011,11,01),
			new Sawon("200471","��浿", "HUMANRESOURCES",2020,12,15)};
	
		for(Sawon s : sawons) {
			System.out.println(s.toString());
		}
}
}
