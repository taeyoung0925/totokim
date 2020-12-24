package com.lec.ex2_map;
/*
 * �ǽ����� 
 * N(n)���� �Է��� ������ ȸ������ ����(�̸�, ��ȭ��ȣ, �ּ�)�� HashMap�� �ް�, 
"N(n)"�� �Է��� �ÿ� ������ ��� ȸ������ ������ �Ʒ��� ���� �ܼ�â�� ����Ѵ�
(��, HashMap�� Ű���� ��ȭ��ȣ, �����ʹ� ȸ�������� �Ѵ�)

ȫ�浿 010-9999-9999 ����� ��걸
�踶�� 010-8888-8888 ����� ���α�*/

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import com.lec.ex3_set.Customer;

public class CustomerMain {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String answer;
		String name = null, phone, address;
		HashMap<String, Customer> customers = new HashMap<String, Customer>();

		while (true) {
			System.out.println("ȸ�������� �����ϰڽ��ϱ�?(Y/N) ");
			answer = scanner.nextLine().trim();

			if (answer.equalsIgnoreCase("n")) {
				break;
			} else if (answer.equalsIgnoreCase("Y")) {
				System.out.println("�����Ͻ� ȸ�� ��ȭ��ȣ : ");
				phone = scanner.nextLine();

				System.out.println("�����Ͻ� ȸ�� �ּ� : ");
				address = scanner.nextLine();
				customers.put(phone, new Customer(name, phone, address));

			}
		}
		scanner.close();
		if (customers.isEmpty()) {
			System.out.println("������ ȸ���� �����ϴ�.");
		} else {
			System.out.println("������ ȸ�� ����Ʈ ���");
			Iterator<String> iterator = customers.keySet().iterator();
			while (iterator.hasNext()) {
				String key = iterator.next();
				System.out.println(customers.get(key));
			}
		}

	}
}
