import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBCON {

	//����̺�ε�
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");//��Ʈ�������޹����� ��ü�θ��� �ڹٰ���ӽſ� �˷��ش�
		}catch(Exception e) {
			System.out.println("jdbc����̺� �ε� ����");
			e.printStackTrace();
		}
	}
	//�ʿ��Ѻ����� ����
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String name = "c##scott";
	String pwd = "tiger";
	
	public DBCON() {
		
	}
	//db����޼ҵ�
	public void dbConn() {
		try {
			conn = DriverManager.getConnection(url,name,pwd);			
		}catch(Exception e) {
			System.out.println("�����ͺ��̽� ���� ����");
			e.printStackTrace();
		}
	}
	//db����޼ҵ�
	public void dbClose() {
		
		try {			
			if(rs!=null) rs.close();
			if(pstmt!=null) conn.close();			
		}catch(Exception e) {
			System.out.println("�����ͺ��̽� �ݱ� ����");
			e.printStackTrace();
		}
	}

}
