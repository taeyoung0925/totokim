/*<������ ����>
����, ����, �÷��� �����͸� ���� Rectangle Ŭ������ ������ ���ǿ� �°� �����Ͻÿ�

��	�Ű������� ���� �ʴ� ������ ȣ��� ���� 0, ���� 0, �÷��� ����
�Ű����� 3���� ���� ������ ȣ���  new Rectangle(���α���, ���α���, ��������)

��	���α���, ���α���, ������ ������ ���� ��ǥ������ true ���� �����ϰ� 
�׷��� ������ false�� �����ϴ� equals() ������
��	[���� Xcm, ���� Xcm�� ������ �簢��]�� �����ϴ� toString() ������
��	���� �� ������ ��� �����ִ� main()�Լ��� �����ϼ���
*/


package com.lec.ex04_Object;

public class Ex04_RectanleMain {
	public static void main(String[] args) {
		Rectanle[] rectanles = { new Rectanle(), new Rectanle(7, 7, "����"), new Rectanle(7, 7, "����"), new Rectanle(10, 16, "���") };

		for (Rectanle rectanle : rectanles) {
			System.out.println(rectanle);
		}

		for (int i = 0; i < rectanles.length-1; i++) {
			if (rectanles[i].equals(rectanles[i + 1])) {
				System.out.println(i + "��°��" + (i + 1) + "��°�� ���� �簢���̴�.");
			} else {
				System.out.println(i + "��°��" + (i + 1) + "��°�� �ٸ� �簢���̴�.");
			}
		} // for

	}// main
}// class
