package com.lec.person_dao;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PersonMngGui extends JFrame implements ActionListener {

	private Container contenPane;
	private JPanel jpup, jpbtn;
	private JTextField txtName, txtKor, txtEng, txtMat;
	private Vector<String> jnames;
	private JComboBox<String> comJob;
	private JButton btnInput, btnSearch, btnOutput, btnExit;
	private JTextArea txtPool;
	private JScrollPane scrollPane;
	private PersonDao dao = PersonDao.getInstance();
	private ArrayList<PersonDto> person;

	public PersonMngGui(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane(); // ��ü ȭ��
		contenPane.setLayout(new FlowLayout());

		jpup = new JPanel(); // �̸�,����,����,����,���� �Է��ϴ� ����
		jpup.setLayout(new GridLayout(5, 2)); // 5��2��
		// jpup = new JPanel(new GridLayout());
		jpbtn = new JPanel(new FlowLayout());
		txtName = new JTextField(20);
		jnames = dao.jnamelist();
		comJob = new JComboBox<String>(jnames);
		txtKor = new JTextField(20);
		txtEng = new JTextField(20);
		txtMat = new JTextField(20);
		ImageIcon icon1 = new ImageIcon("icon/write.gif");
		btnInput = new JButton("�Է�", icon1);
		ImageIcon icon2 = new ImageIcon("icon/hot.gif");
		btnSearch = new JButton("������ȸ", icon2);
		btnOutput = new JButton("��ü���");
		btnExit = new JButton("����");
		txtPool = new JTextArea(10, 60);// 10�� 60��
		scrollPane = new JScrollPane(txtPool);
		jpup.add(new JLabel("�̸�", (int) CENTER_ALIGNMENT));
		jpup.add(txtName); // 1�� �̸� txtname
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(comJob);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(txtKor);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(txtEng);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(txtMat); // jpup�ϼ�
		jpbtn.add(btnInput);
		jpbtn.add(btnSearch);
		jpbtn.add(btnOutput);
		jpbtn.add(btnExit);
		contenPane.add(jpup);
		contenPane.add(jpbtn);
		contenPane.add(scrollPane); // ��üȭ�鿡 �߰�
		setSize(new Dimension(700, 450));
		setLocation(200, 150);
		setVisible(true);

		btnInput.addActionListener(this);
		btnSearch.addActionListener(this);
		btnOutput.addActionListener(this);
		btnExit.addActionListener(this); // �̺�Ʈ ó���� ���� ����

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnInput) {
			// �̸�, ������, ������ �޾ƿͼ� dao.insert ȣ��
			String name = txtName.getText().trim();
			String jname = comJob.getSelectedItem().toString().trim();
			String korstr = txtKor.getText().trim();
			String engstr = txtEng.getText().trim();
			String matstr = txtMat.getText().trim();

			if (name.equals("") || jname.equals("") || korstr.equals("") || engstr.equals("") || matstr.equals("")) {
				txtPool.setText("�̸�, ����, ����, ����, ���� ��� �Է��ϼž� �Է��� ����");
			}
			int kor = Integer.parseInt(korstr);
			int eng = Integer.parseInt(engstr);
			int mat = Integer.parseInt(matstr); // str > int ȭ

			PersonDto newPerson = new PersonDto(name, jname, kor, eng, mat);
			int result = dao.insertPerson(newPerson);
			if (result == PersonDao.SUCESS) {
				txtPool.setText("��" + name + "�� �Է� ���� ��");
				txtName.setText(""); // �Է� �� �󿵿����� �ʱ�ȭ
				comJob.setSelectedIndex(0); // �޺��ڽ� 0��°�� �ʱ�ȭ
				txtKor.setText("");
				txtEng.setText("");
				txtMat.setText("");
			}

		} else if (e.getSource() == btnSearch) {
			// ���������� dao.selectJname ȣ��
			String jname = comJob.getSelectedItem().toString().trim();
			if(jname.equals("")) {
				txtPool.setText("������ ���� �� ������ȸ�ؼ�����");
				return;
			}
			person = dao.selectJname(jname);
			txtPool.setText("���\t�̸�\t����\t����\t����\t����\t����\n");
			if(person.isEmpty()) {
				txtPool.setText(txtPool.getText() + "�ش� �������� �ο��� �����ϴ�.");
			} else {
				for(PersonDto p :person) {
					txtPool.append(p.toString()+"\n");
				}
			}
		} else if (e.getSource() == btnOutput) {
			// dao.selectAll���� ȣ��
			person = dao.selectAll();
			txtPool.setText("���\t�̸�\t����\t����\t����\t����\t����\n");
			if(person.isEmpty()) {
				txtPool.setText(txtPool.getText() + "�ش� �������� �ο��� �����ϴ�.");
			} else {
				for(PersonDto p :person) {
					txtPool.append(p.toString()+"\n");
				}
			}
		} else if (e.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new PersonMngGui("������ ���� ����");
	}

}
