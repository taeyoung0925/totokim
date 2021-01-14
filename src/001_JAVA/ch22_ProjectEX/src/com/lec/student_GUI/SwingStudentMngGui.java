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
		contenPane.setLayout(new FlowLayout()); // 전체화면

		jpup = new JPanel(); // 학번, 이름,전공,점수 입력하는영역
		jpup.setLayout(new GridLayout(4, 3)); // 4행 3열
		jpbtn = new JPanel(new FlowLayout());

		txtSNo = new JTextField(10);
		txtSName = new JTextField(10);
		Mnames = dao.mnamelist();
		comMname = new JComboBox<String>(Mnames);
		txtScore = new JTextField(10);

		btnSNoSearch = new JButton("학번검색");
		btnSNameSearch = new JButton("이름검색");
		btnMNameSearch = new JButton("전공검색");
		btnInput = new JButton("학생입력");
		btnUpdate = new JButton("학생수정");
		btnStudentOut = new JButton("학생출력");
		btnExpelOut = new JButton("제적자출력");
		btnExpel = new JButton("제적처리");
		btnExit = new JButton("종료");

		txtPool = new JTextArea(10, 50);
		scrollPane = new JScrollPane(txtPool);

		jpup.add(new JLabel("학번", (int) CENTER_ALIGNMENT));
		jpup.add(txtSNo);
		jpup.add(btnSNoSearch);

		jpup.add(new JLabel("이름", (int) CENTER_ALIGNMENT));
		jpup.add(txtSName);
		jpup.add(btnSNameSearch);

		jpup.add(new JLabel("전공", (int) CENTER_ALIGNMENT));
		jpup.add(comMname);
		jpup.add(btnMNameSearch);

		jpup.add(new JLabel("점수", (int) CENTER_ALIGNMENT));
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
		if (e.getSource() == btnSNoSearch) { // 학번검색
			String sno = txtSNo.getText().trim();

			if (sno.equals("")) {
				txtSName.setText("");
				comMname.setSelectedItem("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
				txtPool.setText("학번을 입력후 조회해주세요!");
				return;
			}

			StudentSwingDto dto = dao.sNogetStudent(sno);
			if (dto == null) {
				txtSName.setText("");
				comMname.setSelectedItem("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
				txtPool.setText(txtPool.getText() + "해당 학번은 유효하지 않습니다.");
			} else {
				txtSNo.setText(sno);
				txtSName.setText(dto.getSname());
				comMname.setSelectedItem(dto.getMname());
				txtScore.setText(String.valueOf(dto.getScore()));
				txtPool.setText(sno + "학번 검색 완료");

			}
		} else if (e.getSource() == btnSNameSearch) { // 이름검색
			String sname = txtSName.getText().trim();

			if (sname.length() == 0) {
				txtSName.setText("");
				comMname.setSelectedItem("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
				txtPool.setText("이름을 입력후 조회해주세요!");
				return;
			}
			ArrayList<StudentSwingDto> students = dao.sNamegetStudent(sname);

			if (students.size() == 0) {
				txtSName.setText("");
				comMname.setSelectedItem("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
				txtPool.setText(txtPool.getText() + "해당 이름은 존재하지 않습니다.");
			} else if (students.size() > 1) {
				txtPool.setText("학번\t이름\t학과\t점수\n");
				txtPool.append("──────────────────────────────────────\n");
				for (StudentSwingDto s : students) {
					txtPool.append(s.toString() + "\n");
					txtSNo.setText(s.getSno());
					comMname.setSelectedItem(s.getMname());
					txtScore.setText(String.valueOf(s.getScore()));
					txtPool.setText("이름 검색 완료");
				}
			} else if (students.size() == 1) {
				txtSNo.setText(students.get(0).getSno());
				txtSName.setText(students.get(0).getSname());
				comMname.setSelectedItem(students.get(0).getMname());
				txtScore.setText(String.valueOf(students.get(0).getScore()));
				txtPool.setText(sname + "님 이름 검색 완료");

			}
		} else if (e.getSource() == btnMNameSearch) { // 전공검색
			String mname = comMname.getSelectedItem().toString().trim();

			if (mname.equals("")) {
				txtPool.setText("전공명을 선택 후 전공조회해주세요");
				return;
			}
			ArrayList<StudentSwingDto> students = dao.mNamegetStudent(mname);
			if (students.size() == 0) {
				txtPool.setText(txtPool.getText() + "해당 전공의 학생이 없습니다.");
			} else {
				txtPool.setText("등수\t이름(학번)\t학과\t점수\n");
				txtPool.append("──────────────────────────────────────\n");
				for (StudentSwingDto s : students) {
					txtPool.append(s.toString() + "\n");
				}
			}
		} else if (e.getSource() == btnInput) { // 학생 입력
			String sname = txtSName.getText().trim();
			String mname = comMname.getSelectedItem().toString().trim();
			String scorestr = txtScore.getText().trim();

			if (sname.equals("") || scorestr.equals("")) {
				txtPool.setText("모든 정보를 입력하셔야 입력완료가 됩니다.");
			}

			int score = Integer.parseInt(scorestr);

			StudentSwingDto newStudent = new StudentSwingDto(sname, mname, score);
			int result = dao.insertStudent(newStudent);
			if (result == StudentSwingDao.SUCESS) {
				txtPool.setText("★" + sname + "님 입력 성공 ★");
				txtSName.setText("");
				comMname.setSelectedItem("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
			}
		} else if (e.getSource() == btnUpdate) { // 학생 수정
			String sno = txtSNo.getText().trim();
			String sname = txtSName.getText().trim();
			String mname = comMname.getSelectedItem().toString().trim();
			String scorestr = txtScore.getText().trim();

			if (sno.equals("")||sname.equals("") || scorestr.equals("")) {
				txtPool.setText("모든 정보를 입력하셔야 수정완료가 됩니다.");
			}
			int score = Integer.parseInt(scorestr);
			StudentSwingDto updateStudent = new StudentSwingDto(sno, sname, mname, score);
			int result = dao.updateStudent(updateStudent);
			if (result == StudentSwingDao.SUCESS) {
				txtPool.setText("★" + sname + "님 수정 성공 ★");
				txtSName.setText("");
				comMname.setSelectedItem("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
			}

		} else if (e.getSource() == btnStudentOut) { // 학생 출력
			student = dao.getStudents();
			txtPool.setText("등수\t이름(학번)\t\t학과\t점수\n");
			txtPool.append("──────────────────────────────────────\n");

			if (student.isEmpty()) {
				txtPool.setText(txtPool.getText() + "해당 인원이 없습니다.");
			} else {
				for (StudentSwingDto s : student) {
					txtPool.append(s.toString() + "\n");
				}
			}
		} else if (e.getSource() == btnExpelOut) { // 제적자 출력

			student = dao.getStudentsExpel();
			txtPool.setText("등수\t이름(학번)\t\t학과\t점수\n");
			txtPool.append("──────────────────────────────────────\n");

			if (student.isEmpty()) {
				txtPool.setText(txtPool.getText() + "해당 인원이 없습니다.");
			} else {
				for (StudentSwingDto s : student) {
					txtPool.append(s.toString() + "\n");
				}
			}

		} else if (e.getSource() == btnExpel) { // 제적처리

			String sno = txtSNo.getText().trim();
			String sname = txtSName.getText().trim();
			String mname = comMname.getSelectedItem().toString().trim();
			String scorestr = txtScore.getText().trim();

			if (sname.equals("") || scorestr.equals("")) {
				txtPool.setText("모든 정보를 입력하셔야 수정완료가 됩니다.");
			}
			int score = Integer.parseInt(scorestr);
			StudentSwingDto expelStudent = new StudentSwingDto(sno, sname, mname, score);
			int result = dao.sNoExpel(expelStudent);
			if (result == StudentSwingDao.SUCESS) {
				txtPool.setText(sname + "님 제적처리 완료");
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
		new SwingStudentMngGui("학사관리");
	}

}
