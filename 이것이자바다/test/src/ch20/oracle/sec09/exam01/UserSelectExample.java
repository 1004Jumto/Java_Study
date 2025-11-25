package ch20.oracle.sec09.exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserSelectExample {

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
			String sql = "SELECT userid, username, userpassword, userage, useremail FROM users WHERE userid=?";
			pstmt = conn.prepareStatement(sql); // 미리 준비
			// ? 자리에 값을 대입
			pstmt.setString(1, "winter");
			rs = pstmt.executeQuery(); // 조회결과
			if (rs.next()) {
				User user = new User();
				user.setUserId(rs.getString("userid"));
				user.setUserName(rs.getString("username"));
				user.setUserPassword(rs.getString("userpassword"));
				user.setUserAge(rs.getInt(4));
				user.setUserEmail(rs.getString(5));
				System.out.println(user);
			} else {
				System.out.println("사용자 아이디가 존재하지 않음");
			}
			
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
