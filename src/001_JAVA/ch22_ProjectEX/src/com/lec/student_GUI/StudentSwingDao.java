package com.lec.student_GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class StudentSwingDao {

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.1:1521:xe";

	public static final int SUCESS = 1;
	public static final int FAIL = 0;

	private static StudentSwingDao INSTANCE;

	public static StudentSwingDao getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new StudentSwingDao();
		}

		return INSTANCE;
	}

	private StudentSwingDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage() + "����");
		}
	}

	// 1. �й��˻� DAO���� public StudentSwingDto sNogetStudent(String sNo)
	public StudentSwingDto sNogetStudent(String sno) {

		StudentSwingDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT SNO, SNAME,MNAME,SCORE FROM STUDENT S, MAJOR M " + " WHERE S.MNO = M.MNO "
				+ " AND SNO = ?";

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sno);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				// sno = rs.getString("sno");
				String sname = rs.getString("sname");
				String mname = rs.getString("mname");
				int score = rs.getInt("score");
				dto = new StudentSwingDto(sno, sname, mname, score);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "sql ���� 1");
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

	// 2. �̸� �˻� : DAO���� public ArrayList<StudentSwingDto> sNamegetStudent(String
	// sName)
	public ArrayList<StudentSwingDto> sNamegetStudent(String sname) {
		ArrayList<StudentSwingDto> dtos = new ArrayList<StudentSwingDto>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT SNO, SNAME, MNAME,SCORE FROM STUDENT S, MAJOR M" + " WHERE S.MNO = M.MNO "
				+ " AND SNAME = ?";

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sname);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String sno = rs.getString("sno");
				sname = rs.getString("sname");
				String mname = rs.getString("mname");
				int score = rs.getInt("score");
				dtos.add(new StudentSwingDto(sno, sname, mname, score));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "sql ���� 2");
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

	// 3. �����˻� : DAO���� public ArrayList<StudentSwingDto> mNamegetStudent(String
	// mName)
	public ArrayList<StudentSwingDto> mNamegetStudent(String mname) {
		ArrayList<StudentSwingDto> dtos = new ArrayList<StudentSwingDto>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM RANK ,SNAME, MNAME, SCORE  "
				+ " FROM (SELECT SNAME || '(' || SNO || ')' SNAME, MNAME || '(' || M.MNO || ')' MNAME ,SCORE FROM STUDENT S, MAJOR M "
				+ " WHERE S.MNO = M.MNO  " + " AND MNAME = ? " + " ORDER BY SCORE DESC)";

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mname);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int rank = rs.getInt("rank");
				String sname = rs.getString("sname");
				mname = rs.getString("mname"); // �Ķ���ͷ� �Էµ� mName�� �������� ��� ���⼭�� mName�� ������(1)
				int score = rs.getInt("score");
				dtos.add(new StudentSwingDto(rank, sname, mname, score));

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "sql ���� 3");
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

	// 4. �л��Է� : DAO���� public int insertStudent(String sName, String mName, int
	// score), DAO���� public int insertStudent(StudentSwingDto dto)
	public int insertStudent(StudentSwingDto dto) {

		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO STUDENT (SNO,SNAME,MNO,SCORE) VALUES ((TO_NUMBER(TO_CHAR(SYSDATE,'YYYY'))|| LPAD(STUDENT_SEQ.NEXTVAL,3,'0')),"
				+ " ?,(SELECT MNO FROM MAJOR WHERE MNAME = ?),? ) ";

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSname());
			pstmt.setString(2, dto.getMname());
			pstmt.setInt(3, dto.getScore());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "SQL ���� 4");
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

	// 5.�л����� : DAO���� public int updateStudent(StudentSwingDto dto)
	public int updateStudent(StudentSwingDto dto) {

		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE STUDENT SET SNAME = ? , "
				+ " MNO = (SELECT MNO FROM MAJOR WHERE MNAME = ?), SCORE = ? WHERE SNO = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSname());
			pstmt.setString(2, dto.getMname());
			pstmt.setInt(3, dto.getScore());
			pstmt.setString(4, dto.getSno());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "SQL ���� 5");
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

	// 6. �л���� : DAO���� public ArrayList<StudentSwingDto> getStudents()
	public ArrayList<StudentSwingDto> getStudents() {
		ArrayList<StudentSwingDto> dtos = new ArrayList<StudentSwingDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM RANK, SNAME, MNAME, SCORE FROM (SELECT SNAME || '(' || SNO || ')' SNAME, MNAME || '(' || M.MNO || ')' MNAME, SCORE FROM MAJOR M, STUDENT S"
				+ " WHERE M.MNO = S.MNO" + " AND SEXPEL = 0" + " ORDER BY SCORE DESC)";

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int rank = rs.getInt("rank");
				String sname = rs.getString("sname");
				String mname = rs.getString("mname");
				int score = rs.getInt("score");
				dtos.add(new StudentSwingDto(rank, sname, mname, score));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "SQL ���� 6");
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

	// 7. ��������� : DAO���� public ArrayList<StudentSwingDto> getStudentsExpel()
	public ArrayList<StudentSwingDto> getStudentsExpel() {
		ArrayList<StudentSwingDto> dtos = new ArrayList<StudentSwingDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM RANK, SNAME, MNAME, SCORE FROM (SELECT SNAME || '(' || SNO || ')' SNAME, MNAME || '(' || M.MNO || ')' MNAME, SCORE FROM MAJOR M, STUDENT S"
				+ " WHERE M.MNO = S.MNO" + " AND SEXPEL = 1" + " ORDER BY SCORE DESC)";

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int rank = rs.getInt("rank");
				String sname = rs.getString("sname");
				String mname = rs.getString("mname");
				int score = rs.getInt("score");
				dtos.add(new StudentSwingDto(rank, sname, mname, score));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "SQL ���� 7");
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

	// 8. ����ó�� : DAO���� public int sNoExpel(String sNo)
	public int sNoExpel(StudentSwingDto dto) {

		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE STUDENT SET SEXPEL = 1 WHERE SNO = ?";

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSno());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "SQL ���� 8");
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

	// comMname�� ���� �޼ҵ�
	public Vector<String> mnamelist() {
		Vector<String> mnames = new Vector<String>();

		// �۾� ����Ʈ���� mname�� add�ϱ�
		mnames.add("");
		String sql = "SELECT MNAME FROM MAJOR";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				mnames.add(rs.getString("mname"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
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

		return mnames;
	}

}
