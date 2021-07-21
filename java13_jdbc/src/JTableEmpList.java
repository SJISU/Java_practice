import java.awt.ScrollPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableEmpList extends JFrame{

	JTable table;
	DefaultTableModel  model;
	String title[]= {"�����","�޿�","���ʽ�","�Ի���"};
	JScrollPane sp;
	
	static {
		//��������������� ���๮�� ǥ���Ҽ� �ִ� ������ ��
		//1.����̺� �ε�->��������� staic�ȿ� ���๮�ۼ�->ȣ�������ʾƵ� �ҷ���
		//Class.forName("");
		try {			
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException  cnfe) {
			System.out.println("jdbc����̺� �ε� ���� �߻�...");
			cnfe.printStackTrace();
		}		
	}
	
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	String username ="c##scott";
	String password="tiger";
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public JTableEmpList() {
		
		model = new DefaultTableModel(title,0);
		
		table = new JTable();
		table.setModel(model); //new JTable(model) //���ٷ�
		
		sp = new JScrollPane(table);
		
		add(sp);
		
		setSize(500,400);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		empAllselect(); //ȣ��
		
	}
	
	public void empAllselect() {
		//1.����̺� �ε�->��������� staic�ȿ� ���๮�ۼ�->ȣ�������ʾƵ� �ҷ���
		//Class.forName("");		
		try {
			//2.DB����		
			conn = DriverManager.getConnection(dbUrl,username,password);
			//3.Statement ����(SQL��)
			String sql = "select ename,sal,comm,to_char(hiredate,'YYYY-MM-DD') from emp order by hiredate";
			pstmt = conn.prepareStatement(sql);
			//4.����
			rs = pstmt.executeQuery(); //rs�� ���õ� ���ڵ尡 �������
			while(rs.next()) {
				Object[]emp= {rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getString(4)};
				model.addRow(emp);
			}
			//5.�ݱ�
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			
		}finally{ // ���� �߻������� ������� �ΰ����� ����� �´�...
			try {
				//��ü �����ϴ��� ����� �����Ѵ�
				if(rs!=null) rs.close();
				if(pstmt !=null) pstmt.close();
				if(conn !=null) conn.close();
			}catch(SQLException s) {
				System.out.println("���� ���� �߻�");
			}
		}
		
		
	}

	public static void main(String[] args) {
		new JTableEmpList();

	}

}
