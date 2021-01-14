package com.lec.student_GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SwingStudentMngGui extends JFrame implements ActionListener {

	private Container contenPane;
	private JPanel jpup, jpbtn;
	private JTextField txtSNo, txtSName, txtScore;
	private Vector<String> Mnames;
	private JComboBox<String> comMname;
	private JButton btnSNoSearch, btnSNameSearch, btnMNameSearch, btnInput, btnUpdate, btnStudentOut, btnExpelOut,
			btnExpel, btnExit;
	private JTextArea txtPool;
	private JScrollPane scrollPane;
	private StudentSwingDao dao = StudentSwingDao.getInstance();
	private ArrayList<StudentSwingDto> student;

	public SwingStudentMngGui(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane();
		contenPane.setLayout(new FlowLayout()); // ��üȭ��

		jpup = new JPanel(); // �й�, �̸�,����,���� �Է��ϴ¿���
		jpup.setLayout(new GridLayout(4, 3)); // 4�� 3��
		jpbtn = new JPanel(new FlowLayout());

		txtSNo = new JTextField(10);
		txtSName = new JTextField(10);
		Mnames = dao.mnamelist();
		comMname = new JComboBox<String>(Mnames);
		txtScore = new JTextField(10);

		btnSNoSearch = new JButton("�й��˻�");
		btnSNameSearch = new JButton("�̸��˻�");
		btnMNameSearch = new JButton("�����˻�");
		btnInput = new JButton("�л��Է�");
		btnUpdate = new JButton("�л�����");
		btnStudentOut = new JButton("�л����");
		btnExpelOut = new JButton("���������");
		btnExpel = new JButton("����ó��");
		btnExit = new JButton("����");

		txtPool = new JTextArea(10, 50);
		scrollPane = new JScrollPane(txtPool);

		jpup.add(new JLabel("�й�", (int) CENTER_ALIGNMENT));
		jpup.add(txtSNo);
		jpup.add(btnSNoSearch);

		jpup.add(new JLabel("�̸�", (int) CENTER_ALIGNMENT));
		jpup.add(txtSName);
		jpup.add(btnSNameSearch);

		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(comMname);
		jpup.add(btnMNameSearch);

		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(txtScore);

		jpbtn.add(btnInput);
		jpbtn.add(btnUpdate);
		jpbtn.add(btnStudentOut);
		jpbtn.add(btnExpelOut);
		jpbtn.add(btnExpel);
		jpbtn.add(btnExit);

		contenPane.add(jpup);
		contenPane.add(jpbtn);
		contenPane.add(scrollPane);

		setSize(new Dimension(700, 450));
		setLocation(200, 150);
		setVisible(true);

		btnSNoSearch.addActionListener(this);
		btnSNameSearch.addActionListener(this);
		btnMNameSearch.addActionListener(this);
		btnInput.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnStudentOut.addActionListener(this);
		btnExpelOut.addActionListener(this);
		btnExpel.addActionListener(this);
		btnExit.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSNoSearch) { // �й��˻�
			String sno = txtSNo.getText().trim();

			if (sno.equals("")) {
				txtSName.setText("");
				comMname.setSelectedItem("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
				txtPool.setText("�й��� �Է��� ��ȸ���ּ���!");
				return;
			}

			StudentSwingDto dto = dao.sNogetStudent(sno);
			if (dto == null) {
				txtSName.setText("");
				comMname.setSelectedItem("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
				txtPool.setText(txtPool.getText() + "�ش� �й��� ��ȿ���� �ʽ��ϴ�.");
			} else {
				txtSNo.setText(sno);
				txtSName.setText(dto.getSname());
				comMname.setSelectedItem(dto.getMname());
				txtScore.setText(String.valueOf(dto.getScore()));
				txtPool.setText(sno + "�й� �˻� �Ϸ�");

			}
		} else if (e.getSource() == btnSNameSearch) { // �̸��˻�
			String sname = txtSName.getText().trim();

			if (sname.length() == 0) {
				txtSName.setText("");
				comMname.setSelectedItem("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
				txtPool.setText("�̸��� �Է��� ��ȸ���ּ���!");
				return;
			}
			ArrayList<StudentSwingDto> students = dao.sNamegetStudent(sname);

			if (students.size() == 0) {
				txtSName.setText("");
				comMname.setSelectedItem("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
				txtPool.setText(txtPool.getText() + "�ش� �̸��� �������� �ʽ��ϴ�.");
			} else if (students.size() > 1) {
				txtPool.setText("�й�\t�̸�\t�а�\t����\n");
				txtPool.append("����������������������������������������������������������������������������\n");
				for (StudentSwingDto s : students) {
					txtPool.append(s.toString() + "\n");
					txtSNo.setText(s.getSno());
					comMname.setSelectedItem(s.getMname());
					txtScore.setText(String.valueOf(s.getScore()));
					txtPool.setText("�̸� �˻� �Ϸ�");
				}
			} else if (students.size() == 1) {
				txtSNo.setText(students.get(0).getSno());
				txtSName.setText(students.get(0).getSname());
				comMname.setSelectedItem(students.get(0).getMname());
				txtScore.setText(String.valueOf(students.get(0).getScore()));
				txtPool.setText(sname + "�� �̸� �˻� �Ϸ�");

			}
		} else if (e.getSource() == btnMNameSearch) { // �����˻�
			String mname = comMname.getSelectedItem().toString().trim();

			if (mname.equals("")) {
				txtPool.setText("�������� ���� �� ������ȸ���ּ���");
				return;
			}
			ArrayList<StudentSwingDto> students = dao.mNamegetStudent(mname);
			if (students.size() == 0) {
				txtPool.setText(txtPool.getText() + "�ش� ������ �л��� �����ϴ�.");
			} else {
				txtPool.setText("���\t�̸�(�й�)\t�а�\t����\n");
				txtPool.append("����������������������������������������������������������������������������\n");
				for (StudentSwingDto s : students) {
					txtPool.append(s.toString() + "\n");
				}
			}
		} else if (e.getSource() == btnInput) { // �л� �Է�
			String sname = txtSName.getText().trim();
			String mname = comMname.getSelectedItem().toString().trim();
			String scorestr = txtScore.getText().trim();

			if (sname.equals("") || scorestr.equals("")) {
				txtPool.setText("��� ������ �Է��ϼž� �Է¿Ϸᰡ �˴ϴ�.");
			}

			int score = Integer.parseInt(scorestr);

			StudentSwingDto newStudent = new StudentSwingDto(sname, mname, score);
			int result = dao.insertStudent(newStudent);
			if (result == StudentSwingDao.SUCESS) {
				txtPool.setText("��" + sname + "�� �Է� ���� ��");
				txtSName.setText("");
				comMname.setSelectedItem("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
			}
		} else if (e.getSource() == btnUpdate) { // �л� ����
			String sno = txtSNo.getText().trim();
			String sname = txtSName.getText().trim();
			String mname = comMname.getSelectedItem().toString().trim();
			String scorestr = txtScore.getText().trim();

			if (sno.equals("")||sname.equals("") || scorestr.equals("")) {
				txtPool.setText("��� ������ �Է��ϼž� �����Ϸᰡ �˴ϴ�.");
			}
			int score = Integer.parseInt(scorestr);
			StudentSwingDto updateStudent = new StudentSwingDto(sno, sname, mname, score);
			int result = dao.updateStudent(updateStudent);
			if (result == StudentSwingDao.SUCESS) {
				txtPool.setText("��" + sname + "�� ���� ���� ��");
				txtSName.setText("");
				comMname.setSelectedItem("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
			}

		} else if (e.getSource() == btnStudentOut) { // �л� ���
			student = dao.getStudents();
			txtPool.setText("���\t�̸�(�й�)\t\t�а�\t����\n");
			txtPool.append("����������������������������������������������������������������������������\n");

			if (student.isEmpty()) {
				txtPool.setText(txtPool.getText() + "�ش� �ο��� �����ϴ�.");
			} else {
				for (StudentSwingDto s : student) {
					txtPool.append(s.toString() + "\n");
				}
			}
		} else if (e.getSource() == btnExpelOut) { // ������ ���

			student = dao.getStudentsExpel();
			txtPool.setText("���\t�̸�(�й�)\t\t�а�\t����\n");
			txtPool.append("����������������������������������������������������������������������������\n");

			if (student.isEmpty()) {
				txtPool.setText(txtPool.getText() + "�ش� �ο��� �����ϴ�.");
			} else {
				for (StudentSwingDto s : student) {
					txtPool.append(s.toString() + "\n");
				}
			}

		} else if (e.getSource() == btnExpel) { // ����ó��

			String sno = txtSNo.getText().trim();
			String sname = txtSName.getText().trim();
			String mname = comMname.getSelectedItem().toString().trim();
			String scorestr = txtScore.getText().trim();

			if (sname.equals("") || scorestr.equals("")) {
				txtPool.setText("��� ������ �Է��ϼž� �����Ϸᰡ �˴ϴ�.");
			}
			int score = Integer.parseInt(scorestr);
			StudentSwingDto expelStudent = new StudentSwingDto(sno, sname, mname, score);
			int result = dao.sNoExpel(expelStudent);
			if (result == StudentSwingDao.SUCESS) {
				txtPool.setText(sname + "�� ����ó�� �Ϸ�");
				txtSName.setText("");
				comMname.setSelectedItem("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
			}
		} else if (e.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}

	}

	public static void main(String[] args) {
		new SwingStudentMngGui("�л����");
	}

}
