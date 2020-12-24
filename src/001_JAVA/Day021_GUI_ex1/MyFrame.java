package com.lec.ex3;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener {

	private Container container;
	private JPanel jpUp, jpDown;
	private JTextField jtxtName, jtxtTel, jtxtAge;
	private ImageIcon icon;
	private JButton btnIn, btnOut;
	ArrayList<Person> persons;

	public MyFrame(String title) {
		super(title);
		persons = new ArrayList<Person>();
		setDefaultCloseOperation(EXIT_ON_CLOSE); // x��ư
		container = getContentPane();
		container.setLayout(new BorderLayout());
		jpUp = new JPanel(new GridLayout(3, 2));
		jpDown = new JPanel(new FlowLayout());
		jtxtTel = new JTextField();
		jtxtName = new JTextField();
		jtxtAge = new JTextField();
		icon = new ImageIcon("icon/inout.png");
		btnIn = new JButton("�Է�", icon);
		btnOut = new JButton("���", icon);

		jpUp.add(new JLabel("�� ��", (int) CENTER_ALIGNMENT));
		jpUp.add(jtxtName);
		jpUp.add(new JLabel("�� ȭ", (int) CENTER_ALIGNMENT));
		jpUp.add(jtxtTel);
		jpUp.add(new JLabel("�� ��", (int) CENTER_ALIGNMENT));
		jpUp.add(jtxtAge);
		jpDown.add(btnIn);
		jpDown.add(btnOut);

		container.add(jpUp, BorderLayout.CENTER);
		container.add(jpDown, BorderLayout.SOUTH);
		
		setBounds(100, 100, 400, 200);
		setVisible(true);
		btnOut.addActionListener(this);
		btnIn.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnIn) {
			// �Է¹�ư�� �������� �۾�
			// ����,��ȭ��ȣ,�̸� �߹��������� arraylist�� add�ϱ�
			String name = jtxtName.getText().trim();
			String tel = jtxtTel.getText().trim();
			int age;

			if (name.equals("") || tel.equals("")) {
				System.out.println("�̸��� ��ȭ��ȣ�� �ݵ�� �Է�");
				return;
			}

			try {
				age = Integer.parseInt(jtxtAge.getText());
			} catch (Exception e1) {
				age = -100;
			} // ���̸� �Է¹��� ���� intȭ ���� int���� �ƴ� �Է°��� -100���� ��ȯ

			String result = "name=" + name + ", tel=" + tel;
			if (age >= 0 && age < 130) {
				result += ", age=" + age;
			} else {
				result += "  ��ȿ���� ���� ���� �Է�";
			}
			//System.out.println(result);
			if( age >=0) {
			persons.add(new Person(name, tel, age));
			}//���̰� ����϶��� ����Ʈ�� �߰��ϱ�
			jtxtName.setText("");
			jtxtTel.setText("");
			jtxtAge.setText("");

		} // if btnin
		else if (e.getSource() == btnOut) {
			Writer writer = null;
			PrintWriter printwriter = null;
			
			try {
				writer = new FileWriter("textFile/person.txt",true);
				printwriter = new PrintWriter(writer);
				for (Person p : persons) {
					printwriter.println(p.toString());
				}

			}  catch (IOException e2) {
				System.out.println(e2.getMessage());

			} finally {
				try {
					if (printwriter != null)
						printwriter.close();
					if(writer != null)
						writer.close();
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}
			}

		}

	}

	public static void main(String[] args) {
		new MyFrame("20201222 ����");
	}

}
