package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOBase implements DAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public void getConn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/mit";
			conn = DriverManager.getConnection(url, "mit", "Qw12345678");
			System.out.println("DB연결성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB연결실패");
		}

	}

	public void closeConn() {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (pstmt != null) {
			pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn != null) {
				conn.close();
				System.out.println("DB연결종료");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
			
	}
	
	
	

}
