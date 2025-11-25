package ch20.oracle.sec09.exam02;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardSelectExample {

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
			String sql = "SELECT bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata FROM boards WHERE bwriter=?";
			pstmt = conn.prepareStatement(sql); // 미리 준비
			// ? 자리에 값을 대입
			pstmt.setString(1, "winter");
			rs = pstmt.executeQuery(); // 조회결과
			
			List<Board> list = new ArrayList<>();
			while (rs.next()) {
				Board b = new Board();
				b.setBno(rs.getInt("bno"));
				b.setBtitle(rs.getString("btitle"));
				b.setBcontent(rs.getString("bcontent"));
				b.setBwriter(rs.getString("bwriter"));
				b.setBdate(rs.getDate("bdate"));
				b.setBfilename(rs.getString("bfilename"));
				b.setBfiledata(rs.getBlob("bfiledata"));
				System.out.println(b);
				list.add(b);
				
				Blob blob = b.getBfiledata();
				if (blob != null) {
					InputStream is = blob.getBinaryStream();
					OutputStream os = new FileOutputStream("D:/temp/"+b.getBfilename());
					is.transferTo(os);
					os.flush();
					os.close();
					is.close();
				}
			}
			
			// 리스트 출력
			System.out.println(list);
			
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
