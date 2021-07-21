import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBCON {

	//드라이브로딩
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");//스트링을전달받으면 객체로만들어서 자바가상머신에 알려준다
		}catch(Exception e) {
			System.out.println("jdbc드라이브 로딩 실패");
			e.printStackTrace();
		}
	}
	//필요한변수들 선언
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String name = "c##scott";
	String pwd = "tiger";
	
	public DBCON() {
		
	}
	//db연결메소드
	public void dbConn() {
		try {
			conn = DriverManager.getConnection(url,name,pwd);			
		}catch(Exception e) {
			System.out.println("데이터베이스 연결 실패");
			e.printStackTrace();
		}
	}
	//db종료메소드
	public void dbClose() {
		
		try {			
			if(rs!=null) rs.close();
			if(pstmt!=null) conn.close();			
		}catch(Exception e) {
			System.out.println("데이터베이스 닫기 실패");
			e.printStackTrace();
		}
	}

}
