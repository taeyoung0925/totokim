package com.lec.person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PersonMng {
	public static void main(String[] args) {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.1:1521:xe";

		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String fn;

		try {
			Class.forName(driver); // 1단계는 처음 한번만
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		do {
			System.out.println("(1) : 입력 | (2) : 직업별 출력 | (3) : 전체 출력  | 그외  : 종료");
			fn = scanner.next();
			switch (fn) {
			case "1": // 이름,직업명, 국어, 영어, 수학을 입력받아 insert
				System.out.println("추가입력할 이름 ? ");
				String name = scanner.next();
				System.out.println("추가입력할 직업명(배우,가수,MC) ? ");
				String jname = scanner.next();
				System.out.println("추가입력할 국어점수는 ? ");
				int kor = scanner.nextInt();
				System.out.println("추가입력할 영어점수는 ? ");
				int eng = scanner.nextInt();
				System.out.println("추가입력할 수학점수는 ? ");
				int math = scanner.nextInt();

				String sql1 = "INSERT INTO PERSON VALUES "
						+ "(PERSON_SEQ.NEXTVAL,?,(SELECT JNO FROM JOB WHERE JNAME = ?),?,?,?)";

				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql1);

					pstmt.setString(1, name);
					pstmt.setString(2, jname);
					pstmt.setInt(3, kor);
					pstmt.setInt(4, eng);
					pstmt.setInt(5, math);

					int result = pstmt.executeUpdate();
					System.out.println(result > 0 ? name + " 입력 성공" : name + " 입력 실패");

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

				break;

			case "2": // 직업명을 입력받아 직업명 출력 select
				System.out.println("출력하고자 하는 직업명은?(배우,가수,MC)");
				jname = scanner.next();

				String sql2 = "SELECT ROWNUM RANK, S.*" + 
						"    FROM (SELECT NAME||'('||NO||'번)' NAME, JNAME, KOR, ENG, MAT," + 
						"        KOR+ENG+MAT SUM " + 
						"    FROM PERSON P, JOB J" + 
						"    WHERE P.JNO=J.JNO AND JNAME=?" + 
						"    ORDER BY SUM DESC) S";

				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql2);
					pstmt.setString(1, jname);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						System.out.println("등수\t이름(NO)\t\t직업\t국어(kor)\t영어(eng)\t수학(mat)\t총점");
						do { // list 출력
							int rank = rs.getInt("rank");
							name = rs.getString("name");
							jname = rs.getString("jname");
							kor = rs.getInt("kor");
							eng = rs.getInt("eng");
							math = rs.getInt("mat");
							int sum = rs.getInt("sum");

							System.out.println(rank + "\t" + name + "\t" + jname + "\t" + kor + "\t" + eng + "\t" + math
									+ "\t" + sum);

						} while (rs.next());
					} else {
						System.out.println(jname + "의 직업명의 사람이 없습니다.");
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

				break;

			case "3": // 전제 Person 출력 select
				String sql3 = "SELECT ROWNUM RANK, S.*" + 
						"    FROM (SELECT NAME||'('||NO||'번)' NAME, JNAME, KOR, ENG, MAT," + 
						"        KOR+ENG+MAT SUM " + 
						"    FROM PERSON P, JOB J" + 
						"    WHERE P.JNO=J.JNO " + 
						"    ORDER BY SUM DESC) S";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql3);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						System.out.println("등수\t이름(NO)\t\t직업\t국어(kor)\t영어(eng)\t수학(mat)\t총점");
						do { // list 출력
							int rank = rs.getInt("rank");
							name = rs.getString("name");
							jname = rs.getString("jname");
							kor = rs.getInt("kor");
							eng = rs.getInt("eng");
							math = rs.getInt("mat");
							int sum = rs.getInt("sum");
						
							System.out.println(rank + "\t" + name + "\t" + jname + "\t" + kor + "\t" + eng + "\t" + math
									+ "\t" + sum);
						} while (rs.next());
					} else {
						System.out.println("사람이 없습니다.");
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

				break;
			}

		} while (fn.equals("1") || fn.equals("2") || fn.equals("3"));
		System.out.println("System Exit");

	}

}
