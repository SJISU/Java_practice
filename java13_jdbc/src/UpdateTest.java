import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateTest { //수정,
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	Connection  conn;
	PreparedStatement pstmt;
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	String userid = "c##scott";
	String pwd = "tiger";

	public UpdateTest() {
		try {
			//부서번호가 30번인 사원들의 급여를 10% 인상하여 수정
			conn = DriverManager.getConnection(dbUrl,userid,pwd); //연결
			String sql = "update emp set sal=sal*1.1 where deptno=30 "; 
			pstmt = conn.prepareStatement(sql);
			int cnt = pstmt.executeUpdate(); //레코드 몇개 수정했는지 인트값 리턴
			if(cnt>0) {
				System.out.println(cnt+"개의 레코드가 수정되었습니다");
			}else {
				System.out.println("수정된 데이터가 없습니다");
			}			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception ee) {
				ee.printStackTrace();
			}			
		}		
		
	}
	public static void main(String[] args) {
		new UpdateTest();
	}
}
