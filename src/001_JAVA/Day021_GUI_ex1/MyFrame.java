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
		setDefaultCloseOperation(EXIT_ON_CLOSE); // x버튼
		container = getContentPane();
		container.setLayout(new BorderLayout());
		jpUp = new JPanel(new GridLayout(3, 2));
		jpDown = new JPanel(new FlowLayout());
		jtxtTel = new JTextField();
		jtxtName = new JTextField();
		jtxtAge = new JTextField();
		icon = new ImageIcon("icon/inout.png");
		btnIn = new JButton("입력", icon);
		btnOut = new JButton("출력", icon);

		jpUp.add(new JLabel("이 름", (int) CENTER_ALIGNMENT));
		jpUp.add(jtxtName);
		jpUp.add(new JLabel("전 화", (int) CENTER_ALIGNMENT));
		jpUp.add(jtxtTel);
		jpUp.add(new JLabel("나 이", (int) CENTER_ALIGNMENT));
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
			// 입력버튼을 눌렀을때 작업
			// 나이,전화번호,이름 잘받은다음에 arraylist에 add하기
			String name = jtxtName.getText().trim();
			String tel = jtxtTel.getText().trim();
			int age;

			if (name.equals("") || tel.equals("")) {
				System.out.println("이름과 전화번호는 반드시 입력");
				return;
			}

			try {
				age = Integer.parseInt(jtxtAge.getText());
			} catch (Exception e1) {
				age = -100;
			} // 나이를 입력받은 값을 int화 진행 int절이 아닌 입력값은 -100으로 변환

			String result = "name=" + name + ", tel=" + tel;
			if (age >= 0 && age < 130) {
				result += ", age=" + age;
			} else {
				result += "  유효하지 않은 나이 입력";
			}
			//System.out.println(result);
			if( age >=0) {
			persons.add(new Person(name, tel, age));
			}//나이가 양수일때만 리스트에 추가하기
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
		new MyFrame("20201222 과제");
	}

}
