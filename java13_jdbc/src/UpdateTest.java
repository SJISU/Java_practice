import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateTest { //����,
	
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
			//�μ���ȣ�� 30���� ������� �޿��� 10% �λ��Ͽ� ����
			conn = DriverManager.getConnection(dbUrl,userid,pwd); //����
			String sql = "update emp set sal=sal*1.1 where deptno=30 "; 
			pstmt = conn.prepareStatement(sql);
			int cnt = pstmt.executeUpdate(); //���ڵ� � �����ߴ��� ��Ʈ�� ����
			if(cnt>0) {
				System.out.println(cnt+"���� ���ڵ尡 �����Ǿ����ϴ�");
			}else {
				System.out.println("������ �����Ͱ� �����ϴ�");
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
