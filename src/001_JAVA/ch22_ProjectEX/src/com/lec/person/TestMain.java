package com.lec.person;

import java.util.ArrayList;

import com.lec.person_dao.PersonDao;
import com.lec.person_dao.PersonDto;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("===1�� �׽�Ʈ===");
		PersonDto dto = new PersonDto("ȫ�浿", "MC", 99, 99, 99);
		PersonDao dao = PersonDao.getInstance();
		int result = dao.insertPerson(dto);
		System.out.println(result == PersonDao.SUCESS ? "�Է¼���" : "�Է½���");

		System.out.println("===2�� �׽�Ʈ===");
		ArrayList<PersonDto> dtos = dao.selectJname("���");

		if (dtos.size() == 0) {
			System.out.println("��찡 �����ϴ�.");
		} else {
			for (PersonDto d : dtos)
				System.out.println(d);
		}

		System.out.println("===3�� �׽�Ʈ===");
		dtos = dao.selectAll();
		if (dtos.isEmpty()) {
			System.out.println("��ϵ� ����� �����ϴ�.");
		} else {
			for (PersonDto d : dtos)
				System.out.println(d);
		}

	}

}
