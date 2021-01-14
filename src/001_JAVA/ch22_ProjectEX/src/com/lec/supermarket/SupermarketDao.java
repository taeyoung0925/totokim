package com.lec.supermarket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class SupermarketDao {

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.1:1521:xe";

	public static final int SUCESS = 1;
	public static final int FAIL = 0;

	public static SupermarketDao INSTANCE;

	public static SupermarketDao getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new SupermarketDao();
		}
		return INSTANCE;
	}

	private SupermarketDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage() + "에러");
		}
	}

	// -- 0. 레벨이름들 검색 : public Vector<String> getLevelNames()
	public Vector<String> getLevelNames() {
		Vector<String> levelnames = new Vector<String>();

		levelnames.add("");
		String sql = "SELECT LEVELNAME FROM CUS_LEVEL ORDER BY LEVELNO";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				levelnames.add(rs.getString("levelname"));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage() + "sql 오류 : 0");
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		return levelnames;
	}

	// -- 1. cId로 검색 : public CustomerDto cIdGetCustomer(int cId)
	public SupermarketDto cIdGetCustomer(int cid) {

		SupermarketDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT  CID, CTEL, CNAME, CPOINT,CAMOUNT,LEVELNAME,HIGH - CAMOUNT+1  FORLEVELUP"
				+ " FROM CUSTOMER C , CUS_LEVEL L" + " WHERE C.LEVELNO = L.LEVELNO" + " AND CID = ?";

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cid);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String ctel = rs.getString("ctel");
				String cname = rs.getString("cname");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				String levelname = rs.getString("levelname");
				int forlevelup = rs.getInt("forlevelup");
				dto = new SupermarketDto(cid, ctel, cname, cpoint, camount, levelname, forlevelup);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage() + "sql 오류 : 1");
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dto;
	}
	// -- 2. 폰뒤4자리(FULL) 검색 - CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, 레벨업을 위한 쓸 돈
	// -- public ArrayList<CustomerDto> cTelGetCustomers(String cTel);

	public ArrayList<SupermarketDto> cTelGetCustomers(String ctel) {
		ArrayList<SupermarketDto> dtos = new ArrayList<SupermarketDto>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT  CID, CTEL, CNAME, CPOINT,CAMOUNT,LEVELNAME,(SELECT HIGH-CAMOUNT+1 FROM CUSTOMER WHERE CID =  C.CID AND LEVELNO !=5)  FORLEVELUP"
				+ " FROM CUSTOMER C , CUS_LEVEL L" + " WHERE C.LEVELNO = L.LEVELNO" + " AND CTEL LIKE '%'||?";

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ctel);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int cid = rs.getInt("cid");
				String cname = rs.getString("cname");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				String levelname = rs.getString("levelname");
				int forlevelup = rs.getInt("forlevelup");
				dtos.add(new SupermarketDto(cid, ctel, cname, cpoint, camount, levelname, forlevelup));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "sql 오류 : 2");
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;
	}

	// -- 3. 고객이름검색 - CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, 레벨업을 위한 쓸 돈
	// -- public ArrayList<CustomerDto> cNameGetCustomers(String cName);
	public ArrayList<SupermarketDto> cNameGetCustomers(String cname) {
		ArrayList<SupermarketDto> dtos = new ArrayList<SupermarketDto>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT  CID, CTEL, CNAME, CPOINT,CAMOUNT, LEVELNAME,(SELECT HIGH-CAMOUNT+1 FROM CUSTOMER WHERE CID =  C.CID AND LEVELNO !=5)  FORLEVELUP"
				+ " FROM CUSTOMER C , CUS_LEVEL L" + " WHERE C.LEVELNO = L.LEVELNO" + " AND CNAME = ?";

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cname);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int cid = rs.getInt("cid");
				String ctel = rs.getString("ctel");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				String levelname = rs.getString("levelname");
				int forlevelup = rs.getInt("forlevelup");
				dtos.add(new SupermarketDto(cid, ctel, cname, cpoint,camount, levelname, forlevelup));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage() + "sql 오류 : 3");
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;

	}

	// -- 4. 포인트로만 구매(1000원짜리를 포인트로만 구매) : public int buyWithPoint(int cAmount, int
	// cId)
	public int buyWithPoint(int camount, int cid) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER SET CPOINT  = CPOINT - ? WHERE CID = ?";

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, camount);
			pstmt.setInt(2, cid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "sql 오류 : 4");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}

	// -- 5. 물품구매 (1000000원짜리를 구매할 경우. 포인트는 구매금액의 5%)
	// -- 물품구매시 UPDATE 2회 필요(구매누적금액 UPDATE와 LEVELNO UPDATE)
	// -- public int buy(int cAmount, int cId)
	public int buy(int camount, int cid) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER SET CPOINT = CPOINT + ?*0.05, CAMOUNT = CAMOUNT + ?, "
				+ " LEVELNO = (SELECT L.LEVELNO FROM CUSTOMER C , CUS_LEVEL L"
				+ " WHERE CAMOUNT+? BETWEEN LOW AND HIGH AND CID = ?) WHERE CID = ?";

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, camount);
			pstmt.setInt(2, camount);
			pstmt.setInt(3, camount);
			pstmt.setInt(4, cid);
			pstmt.setInt(5, cid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "sql 오류 : 5");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}

	// -- 6. 등급별출력 - CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, 레벨업을위한쓸돈
	// -- public ArrayList<CustomerDto> levelNameGetCustomers(String levelName)
	public ArrayList<SupermarketDto> levelNameGetCustomers(String levelname) {
		ArrayList<SupermarketDto> dtos = new ArrayList<SupermarketDto>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME," + 
				"        (SELECT HIGH-CAMOUNT+1 FROM CUSTOMER WHERE CID=C.CID AND LEVELNO!=5) forLEVELUP" + 
				"    FROM CUSTOMER C, CUS_LEVEL L" + 
				"    WHERE C.LEVELNO=L.LEVELNO AND LEVELNAME=?"+
				"    ORDER BY CAMOUNT DESC";

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, levelname);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int cid = rs.getInt("cid");
				String ctel = rs.getString("ctel");
				String cname = rs.getString("cname");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				int forlevelup = rs.getInt("forlevelup");
				dtos.add(new SupermarketDto(cid, ctel, cname, cpoint, camount, levelname, forlevelup));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "sql 오류 : 6");
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;

	}

	// -- 7.전체출력 - CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, 레벨업을위한쓸돈
	// -- public ArrayList<CustomerDto> getCustomers()
	public ArrayList<SupermarketDto> getCustomers() {
		ArrayList<SupermarketDto> dtos = new ArrayList<SupermarketDto>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT  CID, CTEL, CNAME, CPOINT,CAMOUNT,LEVELNAME,(SELECT HIGH-CAMOUNT+1 FROM CUSTOMER WHERE CID =  C.CID AND LEVELNO !=5)  FORLEVELUP"
				+ " FROM CUSTOMER C , CUS_LEVEL L" + " WHERE C.LEVELNO = L.LEVELNO" + " ORDER BY CAMOUNT DESC";

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int cid = rs.getInt("cid");
				String ctel = rs.getString("ctel");
				String cname = rs.getString("cname");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				String levelname = rs.getString("levelname");
				int forlevelup = rs.getInt("forlevelup");
				dtos.add(new SupermarketDto(cid, ctel, cname, cpoint,camount, levelname, forlevelup));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "sql 오류 : 7");
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return dtos;

	}

	// -- 8. 회원가입(고객전화와 고객이름은 입력받아 INSERT)
	// -- public int insertCustomer(String cTel, String cName)
	public int insertCustomer(String ctel, String cname) {

		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO CUSTOMER (CID, CTEL,CNAME) VALUES (CUSTOMER_SEQ.NEXTVAL,?,?)";

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ctel);
			pstmt.setString(2, cname);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "sql 오류 : 8");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;

	}

	// -- 9. 번호수정 : public int updateCustomer(String cTel, int cId)
	public int updateCustomer(String ctel, int cid) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER SET CTEL = ? WHERE CID = ? ";

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ctel);
			pstmt.setInt(2, cid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "sql 오류 : 9");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}

	// -- 10. 회원탈퇴 : public int deleteCustomer(String cTel)
	public int deleteCustomer(int cid) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM CUSTOMER WHERE CID = ?";

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "sql 오류 : 10");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
}
