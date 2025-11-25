package ch20.oracle.sec05;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BoardWithFileInsertExample {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//1. 드라이버 로드
			Class.forName("oracle.jdbc.OracleDriver");
			
			//2. 커넥션 객체 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","testuser","test1234");
			System.out.println("연결 성공");
			
			//3. Statement,preparedStatement 객체 생성
			
			//preparedStatement
			String sql = "INSERT INTO boards(bno,btitle,bcontent,bwriter,bdate,bfilename,bfiledata)";
			sql+=" VALUES(SEQ_BNO.NEXTVAL,?,?,?,SYSDATE,?,?)";
			
		    pstmt =conn.prepareStatement(sql,new String[] {"bno"});
			
		   
			pstmt.setString(1,"눈이오는날3");
			pstmt.setString(2,"함박눈이내려요.");
			pstmt.setString(3,"winter");
			pstmt.setString(4,"snow.jpg");
			pstmt.setBlob(5,BoardWithFileInsertExample.class.getResourceAsStream("snow.jpg"));
			
			//4. SQL 실행
			int result =  pstmt.executeUpdate(); 	
			System.out.println("result "+result);
			
			
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			//5. 자원해제
			try {pstmt.close();}catch(Exception e) {};
			if(conn!=null) {
				try {
					conn.close();
					System.out.println("연결 끊기");
				}catch(SQLException e) {}
				
				
				
			}
		}
	}
}