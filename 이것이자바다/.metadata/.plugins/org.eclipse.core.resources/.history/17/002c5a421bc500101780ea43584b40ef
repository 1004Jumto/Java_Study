package ch20.oracle.sec05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class ConnectionExample {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			// 1. 드라이버 로드
			Class.forName("oracle.jdbc.OracleDriver");
			
			// 2. 커넥션객체 생성
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/xe", "testuser", "test1234");
			System.out.println("연결 성공");
			
			String userid = "winter3";
			String username = "한겨울";
			String userpassword = "12345";
			int userage = 25;
			String useremail = "winter@mycompany.com";
			
			// 3. Statement/PreparedStatement 객체 생성
			
			// Statement : 그냥 있는 그대로 실행
//			Statement stmt = conn.createStatement();
//			String sql = "INSERT INTO users (userid, username, userpassword, userage, useremail) ";
//			sql += " VALUES ('"+userid+"', '"+username+"', '"+userpassword+"', "+userage+", '"+useremail+"')";
//			System.out.println(sql);
//			int result = stmt.executeUpdate(sql); // 등록한 개수 리턴
//			if (result > 0) {
//				System.out.println("등록 성공");
//			} else {
//				System.out.println("등록 실패");
//			}
			
			// PreparedStatement : 먼저 준비시키고 나중에 실행
			String sql = "INSERT INTO users (userid, username, userpassword, userage, useremail) ";
			sql += " VALUES (?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql); // 미리 준비(실행X)
			// ? 자리에 값을 대입
			pstmt.setString(1, userid);
			pstmt.setString(2, username);
			pstmt.setString(3, userpassword);
			pstmt.setInt(4, userage);
			pstmt.setString(5, useremail);
			
			// 4. sql 실행
			int result = pstmt.executeUpdate(); // 실행(등록한 개수 리턴)
			System.out.println("result:"+result);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. 자원해제
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
