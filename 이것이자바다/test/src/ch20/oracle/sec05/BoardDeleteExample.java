package ch20.oracle.sec05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class BoardDeleteExample {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 드라이버 로드
			Class.forName("oracle.jdbc.OracleDriver");
			
			// 커넥션객체 생성
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/xe", "testuser", "test1234");
			System.out.println("연결 성공");
			
			// PreparedStatement
			String sql = "DELETE FROM boards WHERE bwriter=?";
			pstmt = conn.prepareStatement(sql); // 미리 준비
			// ? 자리에 값을 대입
			pstmt.setString(1, "winter");
			int result = pstmt.executeUpdate(); // 실행(삭제된 개수 리턴)
			System.out.println("result:"+result);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {rs.close();}catch(Exception e) {}
			try {pstmt.close();}catch(Exception e) {}
			if (conn != null) {
				try {
					conn.close();
					System.out.println("연결 끊기");
				} catch (Exception e) {}
			}
		}
	}

}
