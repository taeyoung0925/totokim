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
			System.out.println(e.getMessage() + "에러");
		}
	}

	// 1. 학번검색 DAO에서 public StudentSwingDto sNogetStudent(String sNo)
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
			System.out.println(e.getMessage() + "sql 오류 1");
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

	// 2. 이름 검색 : DAO에서 public ArrayList<StudentSwingDto> sNamegetStudent(String
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
			System.out.println(e.getMessage() + "sql 오류 2");
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

	// 3. 전공검색 : DAO에서 public ArrayList<StudentSwingDto> mNamegetStudent(String
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
				mname = rs.getString("mname"); // 파라미터로 입력된 mName이 빅데이터의 경우 여기서의 mName은 빅데이터(1)
				int score = rs.getInt("score");
				dtos.add(new StudentSwingDto(rank, sname, mname, score));

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "sql 오류 3");
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

	// 4. 학생입력 : DAO에서 public int insertStudent(String sName, String mName, int
	// score), DAO에서 public int insertStudent(StudentSwingDto dto)
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
			System.out.println(e.getMessage() + "SQL 오류 4");
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

	// 5.학생수정 : DAO에서 public int updateStudent(StudentSwingDto dto)
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
			System.out.println(e.getMessage() + "SQL 오류 5");
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

	// 6. 학생출력 : DAO에서 public ArrayList<StudentSwingDto> getStudents()
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
			System.out.println(e.getMessage() + "SQL 오류 6");
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

	// 7. 제적자출력 : DAO에서 public ArrayList<StudentSwingDto> getStudentsExpel()
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
			System.out.println(e.getMessage() + "SQL 오류 7");
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

	// 8. 제적처리 : DAO에서 public int sNoExpel(String sNo)
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
			System.out.println(e.getMessage() + "SQL 오류 8");
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

	// comMname에 넣을 메소드
	public Vector<String> mnamelist() {
		Vector<String> mnames = new Vector<String>();

		// 작업 리스트들을 mname에 add하기
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
