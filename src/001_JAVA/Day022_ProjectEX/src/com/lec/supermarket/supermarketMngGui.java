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

		btnCIdSearch = new JButton("嬴檜蛤 匐儀");
		btnCTelSearch = new JButton("ア4濠葬(FULL) 匐儀");
		btnCNameSearch = new JButton("堅偌 檜葷 匐儀");
		btnBuyWithPoint = new JButton("ん檣お煎虜 掘衙");

		jpup.add(new JLabel(" 嬴 檜 蛤 ", (int) CENTER_ALIGNMENT));
		jpup.add(txtCId);
		jpup.add(btnCIdSearch);
		jpup.add(new JLabel("堅 偌 瞪 ��", (int) CENTER_ALIGNMENT));
		jpup.add(txtCTel);
		jpup.add(btnCTelSearch);
		jpup.add(new JLabel("堅 偌 檜 葷", (int) CENTER_ALIGNMENT));
		jpup.add(txtCName);
		jpup.add(btnCNameSearch);
		jpup.add(new JLabel("ん  檣  お", (int) CENTER_ALIGNMENT));
		jpup.add(txtCPoint);
		jpup.add(btnBuyWithPoint);
		jpup.add(new JLabel("掘 衙 旎 擋", (int) CENTER_ALIGNMENT));
		jpup.add(txtCAmount);
		jpup.add(new JLabel(""));// 綴 塭漣 蹺陛ж朝 睡碟
		jpup.add(new JLabel("堅 偌 蛔 晝", (int) CENTER_ALIGNMENT));
		jpup.add(comLevelName);

		btnBuy = new JButton("僭ヶ 掘衙");
		btnLevelNameOutput = new JButton("蛔晝滌轎溘");
		btnAllOutput = new JButton("瞪羹轎溘");
		btnInsert = new JButton("�蛾灠㊣�");
		btnCTelUpdate = new JButton("廓�ˉ鶬�");
		btnDelete = new JButton("�蛾躠酷�");
		btnExit = new JButton("釭陛晦");

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

		txtPool.setText("\t≠ ≠ ≠ 堅偌匐儀 �� 掘衙ж撮蹂 ≠ ≠ ≠");

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
			// -- 1. cId煎 匐儀 : public CustomerDto cIdGetCustomer(int cId)

			int cid = 0;
			try {
				cid = Integer.parseInt(txtCId.getText().trim());
			} catch (Exception e1) {
				txtPool.append("ID蒂 殮溘 �� 褻�裔媮祤撚�!");
				return;
			}
			SupermarketDto dto = dao.cIdGetCustomer(cid);
			if (dto != null) {
				txtPool.setText("ID\t瞪�苒t檜葷\tん檣お\t掘衙援瞳擋\t堅偌溯漣\t溯漣機擊 嬪и 蹺陛 掘衙й 旎擋\n");
				txtPool.append("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式\n");
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
				txtPool.setText(txtPool.getText() + "п渡 ID朝 嶸�褲狫� 彊蝗棲棻.");
			}
		} else if (e.getSource() == btnCTelSearch) {
			// -- 2. ア菴4濠葬(FULL) 匐儀 - CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, 溯漣機擊 嬪и 噩 絲
			// -- public ArrayList<CustomerDto> cTelGetCustomers(String cTel);
			String ctel = txtCTel.getText().trim();
			if (ctel.length() < 0) {
				txtPool.setText("瞳橫紫 4濠葬 檜鼻 殮溘ж衛堅 匐儀ж撮蹂");
				return;
			}

			ArrayList<SupermarketDto> supermarkets = dao.cTelGetCustomers(ctel);

			if (supermarkets.size() == 0) {
				txtCId.setText("");
				txtCTel.setText("");
				txtCName.setText("");
				txtCPoint.setText("");
				txtCAmount.setText("");
				txtPool.append("п渡 с萄ア廓�ㄣ� 襄營ж雖 彊蝗棲棻.�蛾灠㊣堌媮祤撚�");
			} else {
				txtPool.setText("ID\tс萄ア廓�αt檜葷\tん檣お\t掘衙援瞳旎擋 \t堅偌溯漣\t溯漣機擊 嬪и 蹺陛 掘衙й 旎擋\n");
				txtPool.append(
						"式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式\n");
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
			// -- 3. 堅偌檜葷匐儀 - CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, 溯漣機擊 嬪и 噩 絲
			// -- public ArrayList<CustomerDto> cNameGetCustomers(String cName);
			String cname = txtCName.getText().trim();
			if (cname.length() == 0) {
				txtCId.setText("");
				txtCTel.setText("");
				txtCName.setText("");
				txtCPoint.setText("");
				txtCAmount.setText("");
				txtPool.append("檜葷擊 殮溘 �� 褻�裔媮祤撚�!");
				return;
			}

			ArrayList<SupermarketDto> supermarkets = dao.cNameGetCustomers(cname);

			if (supermarkets.size() == 0) {
				txtCId.setText("");
				txtCTel.setText("");
				txtCName.setText("");
				txtCPoint.setText("");
				txtCAmount.setText("");
				txtPool.append("п渡 檜葷擎 襄營ж雖 彊蝗棲棻.");
			} else {
				txtPool.setText("ID\tс萄ア廓�αt檜葷\tん檣お\t掘衙援瞳旎擋 \t堅偌溯漣\t溯漣機擊 嬪и 蹺陛 掘衙й 旎擋\n");
				txtPool.append(
						"式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式\n");
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
			// -- 4. ん檣お煎虜 掘衙(1000錳瞼葬蒂 ん檣お煎虜 掘衙) : public int buyWithPoint(int cAmount,
			// intcId)
			int cid = 0;
			int camount = 0;
			int cpoint = 0;

			try {
				cid = Integer.parseInt(txtCId.getText().trim());
				camount = Integer.parseInt(txtCAmount.getText().trim());
				cpoint = Integer.parseInt(txtCPoint.getText().trim());
				if (cpoint < camount) {
					txtPool.setText("ん檣お陛 睡褶ж罹 ん檣お煎 掘衙 碳陛м棲棻");
					return;
				}
			} catch (Exception e1) {
				txtPool.setText("嶸�褲� 堅偌ID諦 掘衙旎擋擊 殮溘ж衛堅 嶸�褲� ん檣お煎 掘衙ж撮蹂");
				return;
			}

			int result = dao.buyWithPoint(camount, cid);
			if (result == SupermarketDao.SUCESS) {
				txtPool.setText("ん檣お煎 掘衙 撩奢");
				txtCPoint.setText(String.valueOf(cpoint - camount));
				txtCAmount.setText("");
			} else {
				txtPool.setText("堅偌 嬴檜蛤陛 嶸�褲狫� 彊蝗棲棻");
			}
		} else if (e.getSource() == btnBuy) {
			// -- 5. 僭ヶ掘衙 (1000000錳瞼葬蒂 掘衙й 唳辦. ん檣お朝 掘衙旎擋曖 5%)
			// -- 僭ヶ掘衙衛 UPDATE 2�� в蹂(掘衙援瞳旎擋 UPDATE諦 LEVELNO UPDATE)
			// -- public int buy(int cAmount, int cId)
			int cid = 0;
			int camount = 0;

			try {
				cid = Integer.parseInt(txtCId.getText().trim());
				camount = Integer.parseInt(txtCAmount.getText().trim());
			} catch (Exception e1) {
				txtPool.setText("掘衙 旎擋擊 薑�旅� 殮溘п輿撮蹂");
				return;
			}

			int result = dao.buy(camount, cid);
			if (result == SupermarketDao.SUCESS) {
				txtPool.setText("掘衙 撩奢");
				txtCId.setText("");
				txtCTel.setText("");
				txtCName.setText("");
				txtCPoint.setText("");
				txtCAmount.setText("");
			} else {
				txtPool.setText("堅偌 嬴檜蛤陛 嶸�褲狫� 彊蝗棲棻. ");
			}

		} else if (e.getSource() == btnLevelNameOutput) {
			// -- 6. 蛔晝滌轎溘 - CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, 溯漣機擊嬪и噩絲
			// -- public ArrayList<CustomerDto> levelNameGetCustomers(String levelName)
			
			String levelname = comLevelName.getSelectedItem().toString().trim();

			if (levelname.equals("")) {
				txtPool.setText("堅偌蛔晝擊 摹鷗ж堅 褻�裔媮祤撚�!");
				return;
			}

			ArrayList<SupermarketDto> dtos = dao.levelNameGetCustomers(levelname);
			if (dtos.size() == 0) {
				txtPool.setText(txtPool.getText() + "п渡 堅偌蛔晝曖 檣錳檜 橈蝗棲棻.");
			} else {
				txtPool.setText("ID\tс萄ア廓�αt檜葷\tん檣お\t掘衙援瞳旎擋 \t堅偌溯漣\t溯漣機擊 嬪и 蹺陛 掘衙й 旎擋\n");
				txtPool.append(
						"式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式\n");
				for (SupermarketDto s : dtos) {
					txtPool.append(s.toString() + "\n");
				}
				txtPool.append("[識 "+dtos.size()+"貲]");
			}
		} else if (e.getSource() == btnAllOutput) {
			// -- 7.瞪羹轎溘 - CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, 溯漣機擊嬪и噩絲
			// -- public ArrayList<CustomerDto> getCustomers()
			supermarket = dao.getCustomers();
			txtPool.setText("ID\tс萄ア廓�αt檜葷\tん檣お\t掘衙援瞳旎擋 \t堅偌溯漣\t溯漣機擊 嬪и 蹺陛 掘衙й 旎擋\n");
			txtPool.append(
					"式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式\n");

			if (supermarket.isEmpty()) {
				txtPool.setText(txtPool.getText() + "п渡 檣錳檜 橈蝗棲棻.");
			} else {
				for (SupermarketDto s : supermarket) {
					txtPool.append(s.toString() + "\n");
				}
				txtPool.append("[識 "+supermarket.size()+"貲]");
			}
		} else if (e.getSource() == btnInsert) {
			// -- 8. �蛾灠㊣�(堅偌瞪�倍� 堅偌檜葷擎 殮溘嫡嬴 INSERT)
			// -- public int insertCustomer(String cTel, String cName)
			String ctel = txtCTel.getText().trim();
			String cname = txtCName.getText().trim();

			if (ctel.equals("") || cname.equals("")) {
				txtPool.setText("賅萇 薑爾蒂 殮溘ж敷撿 殮溘諫猿陛 腌棲棻.");
			}

			int result = dao.insertCustomer(ctel, cname);
			if (result == SupermarketDao.SUCESS) {
				txtPool.setText(cname + "椒 �蛾灠㊣� 馬餌м棲棻. \nん檣お 1000薄擊 �蛾灠㊣埮措健� 萄董棲棻.");
				txtCId.setText("");
				txtCTel.setText("");
				txtCName.setText("");
				txtCPoint.setText("");
				txtCAmount.setText("");
			}
		} else if (e.getSource() == btnCTelUpdate) {
			// -- 9. 廓�ˉ鶬� : public int updateCustomer(String cTel, int cId)
			int cid = 0;
			String ctel;

			try {
				cid = Integer.parseInt(txtCId.getText().trim());
				ctel = txtCTel.getText().trim();
				if (ctel.equals("")) {
					txtPool.setText("滲唳й 瞪�食醽ㄧ� 殮溘ж敷撿 廓�ˉ鶬分� 陛棟м棲棻.");
					return;
				}
			} catch (Exception e2) {
				txtPool.setText("嶸�褲� 堅偌ID蒂 匐儀 �� 滲�ㄩ秣磍� ж撮蹂");
				return;
			}
			int result = dao.updateCustomer(ctel, cid);
			if (result == SupermarketDao.SUCESS) {
				txtPool.setText("嬴檜蛤 : " + cid + "椒曖 瞪�食醽ㄟ� 熱薑腎歷蝗棲棻");
				txtCId.setText("");
				txtCTel.setText("");
				txtCName.setText("");
				txtCPoint.setText("");
				txtCAmount.setText("");
			} else {
				txtPool.setText("嶸�褲� 堅偌ID蒂 匐儀 �� 滲�ㄩ秣磍� ж撮蹂");
			}

		} else if (e.getSource() == btnDelete) {
			// -- 10. �蛾躠酷� : public int deleteCustomer(String cTel)
			int cid = 0;

			try {
				cid = Integer.parseInt(txtCId.getText().trim());
			} catch (Exception e2) {
				txtPool.setText("驍黴й ID蒂 殮溘ж敷撿 陛棟м棲棻.");
				return;
			}

			int result = dao.deleteCustomer(cid);
			if (result == SupermarketDao.SUCESS) {
				txtPool.setText("嬴檜蛤 : " + cid + "椒檜 �蛾躠酷� 諫猿腎歷蝗棲棻");
				txtCId.setText("");
				txtCTel.setText("");
				txtCName.setText("");
				txtCPoint.setText("");
				txtCAmount.setText("");
			} else {
				txtPool.setText("嶸�褲� 堅偌ID蒂 匐儀 �� 滲�ㄩ秣磍� ж撮蹂");
			}

		} else if (e.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}

	}

	public static void main(String[] args) {
		new supermarketMngGui("蓬ぷ葆鰍 婦葬");
	}
}
