package ch20.oracle.sec10;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class FunctionCallExample {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		CallableStatement cstmt = null;
		try {
			//1. 드라이버 로드 
			Class.forName("oracle.jdbc.OracleDriver");
			
			//2. 커넥션객체 생성 
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/xe",
					"testuser", //사용자명
					"test1234"); //비밀번호
			
			System.out.println("연결 성공");
			
			//프로시저로 값 삽입 -> 삽입 로직이 user_create에 있음!  
			String sql  = "{ ? = call user_login (?,?)}";
			cstmt = conn.prepareCall(sql);

			// ? 자리에 값을 대입. 
			cstmt.registerOutParameter(1, Types.INTEGER);
			cstmt.setString(2, "winter");
			cstmt.setString(3, "12345");
			
			//4. sql 실행
			cstmt.executeUpdate();
			int result = cstmt.getInt(1); //실행. 등록된 개수를 리턴
			
			String message = switch(result) {
			case 0 -> "로그인 성공";
			case 1 -> "비밀번호가 틀림";
			default-> "아이디가 존재하지 않음.";
			};
			System.out.println("result : " + message);

			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try { cstmt.close(); } catch (Exception e) { e.printStackTrace();}
			try { rs.close(); } catch (Exception e) { }
			try { pstmt.close(); } catch (Exception e) {}
			if(conn != null) {
				try {
					conn.close();
					System.out.println("연결 끊기");
				} catch (Exception e2) {
				
				}
			}
		}
		
		
	}

}
