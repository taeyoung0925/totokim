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

		btnCIdSearch = new JButton("���̵� �˻�");
		btnCTelSearch = new JButton("��4�ڸ�(FULL) �˻�");
		btnCNameSearch = new JButton("�� �̸� �˻�");
		btnBuyWithPoint = new JButton("����Ʈ�θ� ����");

		jpup.add(new JLabel(" �� �� �� ", (int) CENTER_ALIGNMENT));
		jpup.add(txtCId);
		jpup.add(btnCIdSearch);
		jpup.add(new JLabel("�� �� �� ȭ", (int) CENTER_ALIGNMENT));
		jpup.add(txtCTel);
		jpup.add(btnCTelSearch);
		jpup.add(new JLabel("�� �� �� ��", (int) CENTER_ALIGNMENT));
		jpup.add(txtCName);
		jpup.add(btnCNameSearch);
		jpup.add(new JLabel("��  ��  Ʈ", (int) CENTER_ALIGNMENT));
		jpup.add(txtCPoint);
		jpup.add(btnBuyWithPoint);
		jpup.add(new JLabel("�� �� �� ��", (int) CENTER_ALIGNMENT));
		jpup.add(txtCAmount);
		jpup.add(new JLabel(""));// �� �� �߰��ϴ� �κ�
		jpup.add(new JLabel("�� �� �� ��", (int) CENTER_ALIGNMENT));
		jpup.add(comLevelName);

		btnBuy = new JButton("��ǰ ����");
		btnLevelNameOutput = new JButton("��޺����");
		btnAllOutput = new JButton("��ü���");
		btnInsert = new JButton("ȸ������");
		btnCTelUpdate = new JButton("��ȣ����");
		btnDelete = new JButton("ȸ��Ż��");
		btnExit = new JButton("������");

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

		txtPool.setText("\t�� �� �� ���˻� �� �����ϼ��� �� �� ��");

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
			// -- 1. cId�� �˻� : public CustomerDto cIdGetCustomer(int cId)

			int cid = 0;
			try {
				cid = Integer.parseInt(txtCId.getText().trim());
			} catch (Exception e1) {
				txtPool.append("ID�� �Է� �� ��ȸ���ּ���!");
				return;
			}
			SupermarketDto dto = dao.cIdGetCustomer(cid);
			if (dto != null) {
				txtPool.setText("ID\t��ȭ\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������� ���� �߰� ������ �ݾ�\n");
				txtPool.append("����������������������������������������������������������������������������������������������������������������\n");
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
				txtPool.setText(txtPool.getText() + "�ش� ID�� ��ȿ���� �ʽ��ϴ�.");
			}
		} else if (e.getSource() == btnCTelSearch) {
			// -- 2. ����4�ڸ�(FULL) �˻� - CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, �������� ���� �� ��
			// -- public ArrayList<CustomerDto> cTelGetCustomers(String cTel);
			String ctel = txtCTel.getText().trim();
			if (ctel.length() < 0) {
				txtPool.setText("��� 4�ڸ� �̻� �Է��Ͻð� �˻��ϼ���");
				return;
			}

			ArrayList<SupermarketDto> supermarkets = dao.cTelGetCustomers(ctel);

			if (supermarkets.size() == 0) {
				txtCId.setText("");
				txtCTel.setText("");
				txtCName.setText("");
				txtCPoint.setText("");
				txtCAmount.setText("");
				txtPool.append("�ش� �ڵ�����ȣ�� �������� �ʽ��ϴ�.ȸ���������ּ���");
			} else {
				txtPool.setText("ID\t�ڵ�����ȣ\t�̸�\t����Ʈ\t���Ŵ����ݾ� \t������\t�������� ���� �߰� ������ �ݾ�\n");
				txtPool.append(
						"������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������\n");
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
			// -- 3. ���̸��˻� - CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, �������� ���� �� ��
			// -- public ArrayList<CustomerDto> cNameGetCustomers(String cName);
			String cname = txtCName.getText().trim();
			if (cname.length() == 0) {
				txtCId.setText("");
				txtCTel.setText("");
				txtCName.setText("");
				txtCPoint.setText("");
				txtCAmount.setText("");
				txtPool.append("�̸��� �Է� �� ��ȸ���ּ���!");
				return;
			}

			ArrayList<SupermarketDto> supermarkets = dao.cNameGetCustomers(cname);

			if (supermarkets.size() == 0) {
				txtCId.setText("");
				txtCTel.setText("");
				txtCName.setText("");
				txtCPoint.setText("");
				txtCAmount.setText("");
				txtPool.append("�ش� �̸��� �������� �ʽ��ϴ�.");
			} else {
				txtPool.setText("ID\t�ڵ�����ȣ\t�̸�\t����Ʈ\t���Ŵ����ݾ� \t������\t�������� ���� �߰� ������ �ݾ�\n");
				txtPool.append(
						"������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������\n");
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
			// -- 4. ����Ʈ�θ� ����(1000��¥���� ����Ʈ�θ� ����) : public int buyWithPoint(int cAmount,
			// intcId)
			int cid = 0;
			int camount = 0;
			int cpoint = 0;

			try {
				cid = Integer.parseInt(txtCId.getText().trim());
				camount = Integer.parseInt(txtCAmount.getText().trim());
				cpoint = Integer.parseInt(txtCPoint.getText().trim());
				if (cpoint < camount) {
					txtPool.setText("����Ʈ�� �����Ͽ� ����Ʈ�� ���� �Ұ��մϴ�");
					return;
				}
			} catch (Exception e1) {
				txtPool.setText("��ȿ�� ��ID�� ���űݾ��� �Է��Ͻð� ��ȿ�� ����Ʈ�� �����ϼ���");
				return;
			}

			int result = dao.buyWithPoint(camount, cid);
			if (result == SupermarketDao.SUCESS) {
				txtPool.setText("����Ʈ�� ���� ����");
				txtCPoint.setText(String.valueOf(cpoint - camount));
				txtCAmount.setText("");
			} else {
				txtPool.setText("�� ���̵� ��ȿ���� �ʽ��ϴ�");
			}
		} else if (e.getSource() == btnBuy) {
			// -- 5. ��ǰ���� (1000000��¥���� ������ ���. ����Ʈ�� ���űݾ��� 5%)
			// -- ��ǰ���Ž� UPDATE 2ȸ �ʿ�(���Ŵ����ݾ� UPDATE�� LEVELNO UPDATE)
			// -- public int buy(int cAmount, int cId)
			int cid = 0;
			int camount = 0;

			try {
				cid = Integer.parseInt(txtCId.getText().trim());
				camount = Integer.parseInt(txtCAmount.getText().trim());
			} catch (Exception e1) {
				txtPool.setText("���� �ݾ��� ��Ȯ�� �Է����ּ���");
				return;
			}

			int result = dao.buy(camount, cid);
			if (result == SupermarketDao.SUCESS) {
				txtPool.setText("���� ����");
				txtCId.setText("");
				txtCTel.setText("");
				txtCName.setText("");
				txtCPoint.setText("");
				txtCAmount.setText("");
			} else {
				txtPool.setText("�� ���̵� ��ȿ���� �ʽ��ϴ�. ");
			}

		} else if (e.getSource() == btnLevelNameOutput) {
			// -- 6. ��޺���� - CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, �����������Ѿ���
			// -- public ArrayList<CustomerDto> levelNameGetCustomers(String levelName)
			
			String levelname = comLevelName.getSelectedItem().toString().trim();

			if (levelname.equals("")) {
				txtPool.setText("������� �����ϰ� ��ȸ���ּ���!");
				return;
			}

			ArrayList<SupermarketDto> dtos = dao.levelNameGetCustomers(levelname);
			if (dtos.size() == 0) {
				txtPool.setText(txtPool.getText() + "�ش� ������� �ο��� �����ϴ�.");
			} else {
				txtPool.setText("ID\t�ڵ�����ȣ\t�̸�\t����Ʈ\t���Ŵ����ݾ� \t������\t�������� ���� �߰� ������ �ݾ�\n");
				txtPool.append(
						"������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������\n");
				for (SupermarketDto s : dtos) {
					txtPool.append(s.toString() + "\n");
				}
				txtPool.append("[�� "+dtos.size()+"��]");
			}
		} else if (e.getSource() == btnAllOutput) {
			// -- 7.��ü��� - CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, �����������Ѿ���
			// -- public ArrayList<CustomerDto> getCustomers()
			supermarket = dao.getCustomers();
			txtPool.setText("ID\t�ڵ�����ȣ\t�̸�\t����Ʈ\t���Ŵ����ݾ� \t������\t�������� ���� �߰� ������ �ݾ�\n");
			txtPool.append(
					"������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������\n");

			if (supermarket.isEmpty()) {
				txtPool.setText(txtPool.getText() + "�ش� �ο��� �����ϴ�.");
			} else {
				for (SupermarketDto s : supermarket) {
					txtPool.append(s.toString() + "\n");
				}
				txtPool.append("[�� "+supermarket.size()+"��]");
			}
		} else if (e.getSource() == btnInsert) {
			// -- 8. ȸ������(����ȭ�� ���̸��� �Է¹޾� INSERT)
			// -- public int insertCustomer(String cTel, String cName)
			String ctel = txtCTel.getText().trim();
			String cname = txtCName.getText().trim();

			if (ctel.equals("") || cname.equals("")) {
				txtPool.setText("��� ������ �Է��ϼž� �Է¿Ϸᰡ �˴ϴ�.");
			}

			int result = dao.insertCustomer(ctel, cname);
			if (result == SupermarketDao.SUCESS) {
				txtPool.setText(cname + "�� ȸ������ �����մϴ�. \n����Ʈ 1000���� ȸ�����Լ����� �帳�ϴ�.");
				txtCId.setText("");
				txtCTel.setText("");
				txtCName.setText("");
				txtCPoint.setText("");
				txtCAmount.setText("");
			}
		} else if (e.getSource() == btnCTelUpdate) {
			// -- 9. ��ȣ���� : public int updateCustomer(String cTel, int cId)
			int cid = 0;
			String ctel;

			try {
				cid = Integer.parseInt(txtCId.getText().trim());
				ctel = txtCTel.getText().trim();
				if (ctel.equals("")) {
					txtPool.setText("������ ��ȭ��ȣ�� �Է��ϼž� ��ȣ������ �����մϴ�.");
					return;
				}
			} catch (Exception e2) {
				txtPool.setText("��ȿ�� ��ID�� �˻� �� ��ȣ������ �ϼ���");
				return;
			}
			int result = dao.updateCustomer(ctel, cid);
			if (result == SupermarketDao.SUCESS) {
				txtPool.setText("���̵� : " + cid + "���� ��ȭ��ȣ�� �����Ǿ����ϴ�");
				txtCId.setText("");
				txtCTel.setText("");
				txtCName.setText("");
				txtCPoint.setText("");
				txtCAmount.setText("");
			} else {
				txtPool.setText("��ȿ�� ��ID�� �˻� �� ��ȣ������ �ϼ���");
			}

		} else if (e.getSource() == btnDelete) {
			// -- 10. ȸ��Ż�� : public int deleteCustomer(String cTel)
			int cid = 0;

			try {
				cid = Integer.parseInt(txtCId.getText().trim());
			} catch (Exception e2) {
				txtPool.setText("Ż���� ID�� �Է��ϼž� �����մϴ�.");
				return;
			}

			int result = dao.deleteCustomer(cid);
			if (result == SupermarketDao.SUCESS) {
				txtPool.setText("���̵� : " + cid + "���� ȸ��Ż�� �Ϸ�Ǿ����ϴ�");
				txtCId.setText("");
				txtCTel.setText("");
				txtCName.setText("");
				txtCPoint.setText("");
				txtCAmount.setText("");
			} else {
				txtPool.setText("��ȿ�� ��ID�� �˻� �� ��ȣ������ �ϼ���");
			}

		} else if (e.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}

	}

	public static void main(String[] args) {
		new supermarketMngGui("���۸��� ����");
	}
}
