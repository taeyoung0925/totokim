package com.lec.ex4;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Homework extends JFrame implements ActionListener {

	private Container container;
	private JPanel jpUp, jpDown;
	private JTextField jtxtPhone, jtxtName, jtxtPoint;
	private JButton btnjoin, btnsearch, btnprint, btnexit;
	private JTextArea jta;
	private JScrollPane scrollPane;
	HashMap<String, Customer> customers = new HashMap<String, Customer>();
	private FileWriter writer;

	public Homework(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		container = getContentPane();
		container.setLayout(new FlowLayout());

		jpUp = new JPanel(new GridLayout(3, 2));
		jpDown = new JPanel(new FlowLayout());
		jtxtPhone = new JTextField(15);
		jtxtName = new JTextField(15);
		jtxtPoint = new JTextField("1000", 15);
		btnjoin = new JButton("����");
		btnsearch = new JButton("����ȸ");
		btnprint = new JButton("���");
		btnexit = new JButton("����");
		jta = new JTextArea(15, 30);
		scrollPane = new JScrollPane(jta);

		jpUp.add(new JLabel("����ȣ", (int) CENTER_ALIGNMENT));
		jpUp.add(jtxtPhone);
		jpUp.add(new JLabel("��   ��", (int) CENTER_ALIGNMENT));
		jpUp.add(jtxtName);
		jpUp.add(new JLabel("����Ʈ", (int) CENTER_ALIGNMENT));
		jpUp.add(jtxtPoint);
		jpDown.add(btnjoin);
		jpDown.add(btnsearch);
		jpDown.add(btnprint);
		jpDown.add(btnexit);

		container.add(jpUp);
		container.add(jpDown);
		container.add(scrollPane);

		setVisible(true);
		setBounds(300, 300, 400, 450);

		btnjoin.addActionListener(this);
		btnsearch.addActionListener(this);
		btnprint.addActionListener(this);
		btnexit.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnjoin) {
			// ���Թ�ư ������ �� �۾�
			// ����ȣ,�̸�,����Ʈ �߹��������� hashmap�� �����ϱ�
			String phone = jtxtPhone.getText().trim();
			String name = jtxtName.getText().trim();
			int point = 1000;
			try {
				point = Integer.parseInt(jtxtPhone.getText());
			} catch (Exception e2) {
			}

			int preIdx = phone.indexOf("-");
			int postIdx = phone.indexOf("-");

			if (name.equals("") || phone.equals("") || preIdx < postIdx) {
				System.out.println("�̸��� ��ȭ��ȣ�� �Է��ؾ��� ������ �˴ϴ�.");
				return;
			}
			customers.put(phone, new Customer(phone, name, point));
			String result = "[����ȣ=" + phone + ", ��  ��=" + name + ", ����Ʈ=" + point + "]";
			jta.append(result + "\n");
			jtxtPhone.setText("");
			jtxtName.setText("");
			jtxtPoint.setText("1000");
			
		} else if (e.getSource() == btnsearch) {
			// ����ȸ��ư ������ �� �۾�
			// �� ��4�ڸ��� �Է� > ����ȸ�� �������� ȭ�� ǥ��
			String lastphone = jtxtPhone.getText().trim();

			int cnt = 0;
			Iterator<String> iterator = customers.keySet().iterator();
			while (iterator.hasNext()) {
				String phone = iterator.next();
				String postphone = phone.substring(phone.lastIndexOf('-') + 1);
				if (postphone.equals(lastphone)) {
					jtxtPhone.setText(customers.get(phone).getPhone());
					jtxtName.setText(customers.get(phone).getName());
					jtxtPoint.setText(String.valueOf(customers.get(phone).getPoint()));
				}

			}

		} else if (e.getSource() == btnprint) {
			// ��¹�ư ������ �� �۾�
			// �ؽ�Ʈ���Ͽ� ����Ǿ ǥ��
			writer = null;
			PrintWriter printwriter = null;

			try {
				writer = new FileWriter("textFile/customer.txt", true);
				printwriter = new PrintWriter(writer);
				Iterator<String> iterator = customers.keySet().iterator();
				while (iterator.hasNext()) {
					String k = iterator.next();
					System.out.println(customers.get(k));
					printwriter.println(customers.get(k).toString());
				}

			} catch (IOException e1) {
				System.out.println(e1.getMessage());
			} finally {
				try {
					if (printwriter != null)
						printwriter.close();
					if (writer != null)
						writer.close();
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
			}

		} else if (e.getSource() == btnexit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}

	}

	public static void main(String[] args) {
		new Homework("20201222 ����2");
	}
}
