import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest {

	public SelectTest() {
	
		try {
			//1.JVM �� Jdbc ����̺� �ε�
			//��θ� class���Ŭ�����ȿ�forname�̶�¸޼ҵ�ȿ� -> ��ü������ �ڹٰ���ӽ����� �˷���
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException cnfe) {
			System.out.println("Jdbc ����̺� �ε� ����-->"+cnfe.getMessage());
		}
		
		try {
			//2.DB���� -> �����ϴ�Ŭ���� : DriveManagerŬ����- getConnection(db��������,id,pw)
			//								@������ �����ּ�(�����ip or localhost) : ��Ʈ��ȣ : ���������ͺ��̽�����
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";//db url	
			//											 (db��������,�����id,�����pw)
			Connection conn = DriverManager.getConnection(dbUrl,"c##scott","tiger");
			
			
			//3.�������� �����. "���ڿ�"�� �����...
			String sql = "select empno,ename,job,to_char(hiredate,'YYYY-MM-DD') hiredate,sal,comm,deptno "
					 + " from emp where sal>=? or job=? order by ename"; //��Ʈ������ +�� ������ �����ؾ���
			
			//4.�������� �̿��Ͽ� PrepareStatement ��ü����
			//java.sql��Ű�� Connection- PrepareStatement
			//-> statement�� ��ӹ޴� �������̽��� SQL������ �����Ű�� ����� ���� ��ü -> ���޿�Ȱ
			PreparedStatement  pstmt =conn.prepareStatement(sql); //�������̽� PreparedStatement
			// ?�� ����
			pstmt.setInt(1,3000); //ù��°����ǥ,3000
			pstmt.setString(2,"���ϸ�"); //�ι�°����ǥ,
			
			//5.�����ϱ�
			//executeUpdate() -> insert update delete
			//executeQuert -> ���� resultSet : ����Ʈ���� ���õȰ��� ����Ʈ�¿� ��䰡
			ResultSet rs =pstmt.executeQuery(); //����Ʈ�� ������(������)�� rs��ü�� ������ // �������̽� : ResultSet			
			
			//�����͵� �ϳ��� ������� �۾��ؾߵǴϱ� ResultSetŬ����(�������̽�)�� �޼ҵ�� ������ ������ ���´�..
			//first() 
			// next():����Ʈ�� �������� �Ѿ //previous():����Ʈ�� �������� �� ->���ΰ� �ִ����� �����͸� ��������
			while(rs.next()) { //���ڵ尡 ������ true
				//������ ���ڵ尡 ���� //�÷��� �������� ���������� �� �ٸ��� ������...get���δ� ���پ� �����ü�����-> ù��°�÷���1,�ι�°�÷���2
				int empno = rs.getInt(1); //rs.getInt("empno"); //index1�� ������ ������
				String ename = rs.getString(2); //re.getString("ename")//�ι�°�ʵ� ������
				String job =rs.getString("job");
				String hiredate = rs.getString(4); //��¥
				//double sal = rs.getDouble(5);
				int sal = rs.getInt(5);//double�̾ int�� ���� �����ü��ִ�.
				double comm =rs.getDouble(6);
				int deptno = rs.getInt(7);
				
				System.out.println(empno+","+ename+","+job+","+hiredate+","+sal+","+comm+","+deptno);
				//getint�� �ϸ� null�����Ͱ� 
			}
		
			rs.close();
			pstmt.close();
			conn.close();
		}catch(SQLException se) {
			System.out.println("DB���� ���� �߻�---> "+se.getMessage());
		}
		
	}

	public static void main(String[] args) {
		new SelectTest();
	}

}
