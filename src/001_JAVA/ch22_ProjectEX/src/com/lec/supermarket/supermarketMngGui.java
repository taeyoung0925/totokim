package com.lec.supermarket;

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

public class supermarketMngGui extends JFrame implements ActionListener {

	private Container container;
	private JPanel jpup, jpbtn;
	private JTextField txtCId, txtCTel, txtCName, txtCPoint, txtCAmount;
	private Vector<String> levelNames;
	private JComboBox<String> comLevelName;
	private JButton btnCIdSearch, btnCTelSearch, btnCNameSearch, btnBuyWithPoint, btnBuy, btnLevelNameOutput,
			btnAllOutput, btnInsert, btnCTelUpdate, btnDelete, btnExit;
	private JTextArea txtPool;
	private JScrollPane scrollPane;
	private SupermarketDao dao = SupermarketDao.getInstance();
	private ArrayList<SupermarketDto> supermarket;

	public supermarketMngGui(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		container = getContentPane();
		container.setLayout(new FlowLayout());

		jpup = new JPanel(new GridLayout(6, 3));
		jpbtn = new JPanel();
		txtCId = new JTextField(20);
		txtCTel = new JTextField(20);
		txtCName = new JTextField(20);
		txtCPoint = new JTextField(20);
		txtCAmount = new JTextField(20);

		levelNames = dao.getLevelNames();
		comLevelName = new JComboBox<String>(levelNames);

		btnCIdSearch = new JButton("아이디 검색");
		btnCTelSearch = new JButton("폰4자리(FULL) 검색");
		btnCNameSearch = new JButton("고객 이름 검색");
		btnBuyWithPoint = new JButton("포인트로만 구매");

		jpup.add(new JLabel(" 아 이 디 ", (int) CENTER_ALIGNMENT));
		jpup.add(txtCId);
		jpup.add(btnCIdSearch);
		jpup.add(new JLabel("고 객 전 화", (int) CENTER_ALIGNMENT));
		jpup.add(txtCTel);
		jpup.add(btnCTelSearch);
		jpup.add(new JLabel("고 객 이 름", (int) CENTER_ALIGNMENT));
		jpup.add(txtCName);
		jpup.add(btnCNameSearch);
		jpup.add(new JLabel("포  인  트", (int) CENTER_ALIGNMENT));
		jpup.add(txtCPoint);
		jpup.add(btnBuyWithPoint);
		jpup.add(new JLabel("구 매 금 액", (int) CENTER_ALIGNMENT));
		jpup.add(txtCAmount);
		jpup.add(new JLabel(""));// 빈 라벨 추가하는 부분
		jpup.add(new JLabel("고 객 등 급", (int) CENTER_ALIGNMENT));
		jpup.add(comLevelName);

		btnBuy = new JButton("물품 구매");
		btnLevelNameOutput = new JButton("등급별출력");
		btnAllOutput = new JButton("전체출력");
		btnInsert = new JButton("회원가입");
		btnCTelUpdate = new JButton("번호수정");
		btnDelete = new JButton("회원탈퇴");
		btnExit = new JButton("나가기");

		jpbtn.add(btnBuy);
		jpbtn.add(btnLevelNameOutput);
		jpbtn.add(btnAllOutput);
		jpbtn.add(btnInsert);
		jpbtn.add(btnCTelUpdate);
		jpbtn.add(btnDelete);
		jpbtn.add(btnExit);

		txtPool = new JTextArea(6, 70);
		scrollPane = new JScrollPane(txtPool);
		container.add(jpup);
		container.add(jpbtn);
		container.add(scrollPane);

		setSize(new Dimension(800, 400));
		setLocation(200, 200);
		setVisible(true);

		txtPool.setText("\t★ ★ ★ 고객검색 후 구매하세요 ★ ★ ★");

		btnCIdSearch.addActionListener(this);
		btnCTelSearch.addActionListener(this);
		btnCNameSearch.addActionListener(this);
		btnBuyWithPoint.addActionListener(this);
		btnBuy.addActionListener(this);
		btnLevelNameOutput.addActionListener(this);
		btnAllOutput.addActionListener(this);
		btnInsert.addActionListener(this);
		btnCTelUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		btnExit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCIdSearch) {
			// -- 1. cId로 검색 : public CustomerDto cIdGetCustomer(int cId)

			int cid = 0;
			try {
				cid = Integer.parseInt(txtCId.getText().trim());
			} catch (Exception e1) {
				txtPool.append("ID를 입력 후 조회해주세요!");
				return;
			}
			SupermarketDto dto = dao.cIdGetCustomer(cid);
			if (dto != null) {
				txtPool.setText("ID\t전화\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을 위한 추가 구매할 금액\n");
				txtPool.append("────────────────────────────────────────────────────────\n");
				txtPool.append(dto.toString() + "\n");
				txtCTel.setText(dto.getCtel());
				txtCName.setText(dto.getCname());
				txtCPoint.setText(String.valueOf(dto.getCpoint()));
				txtCAmount.setText(String.valueOf(dto.getCmount()));
				comLevelName.setSelectedItem(dto.getLevelname());
			} else {
				txtCId.setText("");
				txtCTel.setText("");
				txtCName.setText("");
				txtCPoint.setText("");
				txtCAmount.setText("");
				txtPool.setText(txtPool.getText() + "해당 ID는 유효하지 않습니다.");
			}
		} else if (e.getSource() == btnCTelSearch) {
			// -- 2. 폰뒤4자리(FULL) 검색 - CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, 레벨업을 위한 쓸 돈
			// -- public ArrayList<CustomerDto> cTelGetCustomers(String cTel);
			String ctel = txtCTel.getText().trim();
			if (ctel.length() < 0) {
				txtPool.setText("적어도 4자리 이상 입력하시고 검색하세요");
				return;
			}

			ArrayList<SupermarketDto> supermarkets = dao.cTelGetCustomers(ctel);

			if (supermarkets.size() == 0) {
				txtCId.setText("");
				txtCTel.setText("");
				txtCName.setText("");
				txtCPoint.setText("");
				txtCAmount.setText("");
				txtPool.append("해당 핸드폰번호는 존재하지 않습니다.회원가입해주세요");
			} else {
				txtPool.setText("ID\t핸드폰번호\t이름\t포인트\t구매누적금액 \t고객레벨\t레벨업을 위한 추가 구매할 금액\n");
				txtPool.append(
						"──────────────────────────────────────────────────────────────────────────────────────────────────────\n");
				for (SupermarketDto s : supermarkets) {
					txtPool.append(s.toString() + "\n");
					txtCId.setText("");
					txtCTel.setText("");
					txtCName.setText("");
					txtCPoint.setText("");
					txtCAmount.setText("");
				}
			}
		} else if (e.getSource() == btnCNameSearch) {
			// -- 3. 고객이름검색 - CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, 레벨업을 위한 쓸 돈
			// -- public ArrayList<CustomerDto> cNameGetCustomers(String cName);
			String cname = txtCName.getText().trim();
			if (cname.length() == 0) {
				txtCId.setText("");
				txtCTel.setText("");
				txtCName.setText("");
				txtCPoint.setText("");
				txtCAmount.setText("");
				txtPool.append("이름을 입력 후 조회해주세요!");
				return;
			}

			ArrayList<SupermarketDto> supermarkets = dao.cNameGetCustomers(cname);

			if (supermarkets.size() == 0) {
				txtCId.setText("");
				txtCTel.setText("");
				txtCName.setText("");
				txtCPoint.setText("");
				txtCAmount.setText("");
				txtPool.append("해당 이름은 존재하지 않습니다.");
			} else {
				txtPool.setText("ID\t핸드폰번호\t이름\t포인트\t구매누적금액 \t고객레벨\t레벨업을 위한 추가 구매할 금액\n");
				txtPool.append(
						"──────────────────────────────────────────────────────────────────────────────────────────────────────\n");
				for (SupermarketDto s : supermarkets) {
					txtPool.append(s.toString() + "\n");
					txtCId.setText("");
					txtCTel.setText("");
					txtCName.setText("");
					txtCPoint.setText("");
					txtCAmount.setText("");
				}
			}
		} else if (e.getSource() == btnBuyWithPoint) {
			// -- 4. 포인트로만 구매(1000원짜리를 포인트로만 구매) : public int buyWithPoint(int cAmount,
			// intcId)
			int cid = 0;
			int camount = 0;
			int cpoint = 0;

			try {
				cid = Integer.parseInt(txtCId.getText().trim());
				camount = Integer.parseInt(txtCAmount.getText().trim());
				cpoint = Integer.parseInt(txtCPoint.getText().trim());
				if (cpoint < camount) {
					txtPool.setText("포인트가 부족하여 포인트로 구매 불가합니다");
					return;
				}
			} catch (Exception e1) {
				txtPool.setText("유효한 고객ID와 구매금액을 입력하시고 유효한 포인트로 구매하세요");
				return;
			}

			int result = dao.buyWithPoint(camount, cid);
			if (result == SupermarketDao.SUCESS) {
				txtPool.setText("포인트로 구매 성공");
				txtCPoint.setText(String.valueOf(cpoint - camount));
				txtCAmount.setText("");
			} else {
				txtPool.setText("고객 아이디가 유효하지 않습니다");
			}
		} else if (e.getSource() == btnBuy) {
			// -- 5. 물품구매 (1000000원짜리를 구매할 경우. 포인트는 구매금액의 5%)
			// -- 물품구매시 UPDATE 2회 필요(구매누적금액 UPDATE와 LEVELNO UPDATE)
			// -- public int buy(int cAmount, int cId)
			int cid = 0;
			int camount = 0;

			try {
				cid = Integer.parseInt(txtCId.getText().trim());
				camount = Integer.parseInt(txtCAmount.getText().trim());
			} catch (Exception e1) {
				txtPool.setText("구매 금액을 정확히 입력해주세요");
				return;
			}

			int result = dao.buy(camount, cid);
			if (result == SupermarketDao.SUCESS) {
				txtPool.setText("구매 성공");
				txtCId.setText("");
				txtCTel.setText("");
				txtCName.setText("");
				txtCPoint.setText("");
				txtCAmount.setText("");
			} else {
				txtPool.setText("고객 아이디가 유효하지 않습니다. ");
			}

		} else if (e.getSource() == btnLevelNameOutput) {
			// -- 6. 등급별출력 - CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, 레벨업을위한쓸돈
			// -- public ArrayList<CustomerDto> levelNameGetCustomers(String levelName)
			
			String levelname = comLevelName.getSelectedItem().toString().trim();

			if (levelname.equals("")) {
				txtPool.setText("고객등급을 선택하고 조회해주세요!");
				return;
			}

			ArrayList<SupermarketDto> dtos = dao.levelNameGetCustomers(levelname);
			if (dtos.size() == 0) {
				txtPool.setText(txtPool.getText() + "해당 고객등급의 인원이 없습니다.");
			} else {
				txtPool.setText("ID\t핸드폰번호\t이름\t포인트\t구매누적금액 \t고객레벨\t레벨업을 위한 추가 구매할 금액\n");
				txtPool.append(
						"──────────────────────────────────────────────────────────────────────────────────────────────────────\n");
				for (SupermarketDto s : dtos) {
					txtPool.append(s.toString() + "\n");
				}
				txtPool.append("[총 "+dtos.size()+"명]");
			}
		} else if (e.getSource() == btnAllOutput) {
			// -- 7.전체출력 - CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, 레벨업을위한쓸돈
			// -- public ArrayList<CustomerDto> getCustomers()
			supermarket = dao.getCustomers();
			txtPool.setText("ID\t핸드폰번호\t이름\t포인트\t구매누적금액 \t고객레벨\t레벨업을 위한 추가 구매할 금액\n");
			txtPool.append(
					"──────────────────────────────────────────────────────────────────────────────────────────────────────\n");

			if (supermarket.isEmpty()) {
				txtPool.setText(txtPool.getText() + "해당 인원이 없습니다.");
			} else {
				for (SupermarketDto s : supermarket) {
					txtPool.append(s.toString() + "\n");
				}
				txtPool.append("[총 "+supermarket.size()+"명]");
			}
		} else if (e.getSource() == btnInsert) {
			// -- 8. 회원가입(고객전화와 고객이름은 입력받아 INSERT)
			// -- public int insertCustomer(String cTel, String cName)
			String ctel = txtCTel.getText().trim();
			String cname = txtCName.getText().trim();

			if (ctel.equals("") || cname.equals("")) {
				txtPool.setText("모든 정보를 입력하셔야 입력완료가 됩니다.");
			}

			int result = dao.insertCustomer(ctel, cname);
			if (result == SupermarketDao.SUCESS) {
				txtPool.setText(cname + "님 회원가입 감사합니다. \n포인트 1000점을 회원가입선물로 드립니다.");
				txtCId.setText("");
				txtCTel.setText("");
				txtCName.setText("");
				txtCPoint.setText("");
				txtCAmount.setText("");
			}
		} else if (e.getSource() == btnCTelUpdate) {
			// -- 9. 번호수정 : public int updateCustomer(String cTel, int cId)
			int cid = 0;
			String ctel;

			try {
				cid = Integer.parseInt(txtCId.getText().trim());
				ctel = txtCTel.getText().trim();
				if (ctel.equals("")) {
					txtPool.setText("변경할 전화번호를 입력하셔야 번호수정이 가능합니다.");
					return;
				}
			} catch (Exception e2) {
				txtPool.setText("유효한 고객ID를 검색 후 변호변경을 하세요");
				return;
			}
			int result = dao.updateCustomer(ctel, cid);
			if (result == SupermarketDao.SUCESS) {
				txtPool.setText("아이디 : " + cid + "님의 전화번호가 수정되었습니다");
				txtCId.setText("");
				txtCTel.setText("");
				txtCName.setText("");
				txtCPoint.setText("");
				txtCAmount.setText("");
			} else {
				txtPool.setText("유효한 고객ID를 검색 후 변호변경을 하세요");
			}

		} else if (e.getSource() == btnDelete) {
			// -- 10. 회원탈퇴 : public int deleteCustomer(String cTel)
			int cid = 0;

			try {
				cid = Integer.parseInt(txtCId.getText().trim());
			} catch (Exception e2) {
				txtPool.setText("탈퇴할 ID를 입력하셔야 가능합니다.");
				return;
			}

			int result = dao.deleteCustomer(cid);
			if (result == SupermarketDao.SUCESS) {
				txtPool.setText("아이디 : " + cid + "님이 회원탈퇴 완료되었습니다");
				txtCId.setText("");
				txtCTel.setText("");
				txtCName.setText("");
				txtCPoint.setText("");
				txtCAmount.setText("");
			} else {
				txtPool.setText("유효한 고객ID를 검색 후 변호변경을 하세요");
			}

		} else if (e.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}

	}

	public static void main(String[] args) {
		new supermarketMngGui("슈퍼마켓 관리");
	}
}
