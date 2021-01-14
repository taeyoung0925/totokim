package com.lec.student_Console;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDao {

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.1:1521:xe";

	public static final int SUCESS = 1;
	public static final int FAIL = 0;

	private static StudentDao INSTANCE;

	public static StudentDao getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new StudentDao();
		}
		return INSTANCE;
	}

	private StudentDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	// 1번 insertStudent
	public int insertStudent(StudentDto dto) {

		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO STUDENT VALUES "
				+ "((TO_NUMBER(TO_CHAR(SYSDATE,'YYYY'))|| LPAD(STUDENT_SEQ.NEXTVAL,3,'0')),"
				+ " ?,(SELECT MNO FROM MAJOR WHERE MNAME = ?),?,? )";

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSname());
			pstmt.setString(2, dto.getMname());
			pstmt.setInt(3, dto.getScore());
			pstmt.setInt(4, dto.getSexpel());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "SQL 오류");
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

	// 2번 select Mname(String Mname)
	public ArrayList<StudentDto> selectMname(String mname) {
		ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();

		// mname 작업인 리스트 dtos에 add하기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM RANK, SNO, MNAME, SCORE FROM "
				   + " (SELECT SNAME || '(' || SNO || ')' SNO, MNAME, SCORE FROM MAJOR M, STUDENT S WHERE M.MNO = S.MNO AND MNAME = ? ORDER BY SCORE DESC)";
		
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mname);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int rank = rs.getInt("rank");
				String sno = rs.getString("sno");
				mname = rs.getString("mname");
				int score = rs.getInt("score");
				dtos.add(new StudentDto(rank, sno, mname, score));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "sql 오류");
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
		return dtos;
	}

	// 3번 제적여부(sEXPEL) = 0 select (제적 X 사람)
	public ArrayList<StudentDto> selectsexpel0() {
		ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM RANK, SNO, MNAME, SCORE FROM (SELECT SNAME || '(' || SNO || ')' SNO, MNAME, SCORE FROM MAJOR M, STUDENT S "
			     	+ " WHERE M.MNO = S.MNO AND SEXPEL = 0 ORDER BY SCORE DESC)";
		

		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int rank = rs.getInt("rank");
				String sno = rs.getString("sno");
				String mname = rs.getString("mname");
				int score = rs.getInt("score");
				dtos.add(new StudentDto(rank, sno, mname, score));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage() + "sql 오류");
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
		return dtos;
	}

	// 4번 제적여부(sEXPEL) = 1 select (제적 O 사람)
	public ArrayList<StudentDto> selectsexpel1() {
		ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql =  "SELECT ROWNUM RANK, SNO, MNAME, SCORE FROM (SELECT SNAME || '(' || SNO || ')' SNO, MNAME, SCORE FROM MAJOR M, STUDENT S "
		     	+ " WHERE M.MNO = S.MNO AND SEXPEL = 1 ORDER BY SCORE DESC)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int rank = rs.getInt("rank");
				String sno = rs.getString("sno");
				String mname = rs.getString("mname");
				int score = rs.getInt("score");
				dtos.add(new StudentDto(rank, sno, mname, score));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
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
		return dtos;
	}

}
