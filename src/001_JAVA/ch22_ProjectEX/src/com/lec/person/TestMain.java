package com.lec.person;

import java.util.ArrayList;

import com.lec.person_dao.PersonDao;
import com.lec.person_dao.PersonDto;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("===1번 테스트===");
		PersonDto dto = new PersonDto("홍길동", "MC", 99, 99, 99);
		PersonDao dao = PersonDao.getInstance();
		int result = dao.insertPerson(dto);
		System.out.println(result == PersonDao.SUCESS ? "입력성공" : "입력실패");

		System.out.println("===2번 테스트===");
		ArrayList<PersonDto> dtos = dao.selectJname("배우");

		if (dtos.size() == 0) {
			System.out.println("배우가 없습니다.");
		} else {
			for (PersonDto d : dtos)
				System.out.println(d);
		}

		System.out.println("===3번 테스트===");
		dtos = dao.selectAll();
		if (dtos.isEmpty()) {
			System.out.println("등록된 사람이 없습니다.");
		} else {
			for (PersonDto d : dtos)
				System.out.println(d);
		}

	}

}
