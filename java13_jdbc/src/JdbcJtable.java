import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JdbcJtable extends JFrame{

	JTable table;
	JScrollPane sp;
	DefaultTableModel model;
	
	String title[] = {"사원명","급여","보너스","입사일"}; //ename,sal,comm,hiredate
	Object[][] data = {};	
	
	

	
	public JdbcJtable() {
		
		model = new DefaultTableModel(data,title);
		table = new JTable(model);
		sp = new JScrollPane(table);
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException cnfe) {
			System.out.println("Jdbc 드라이브 로딩 실패-->"+cnfe.getMessage());
		}
		
		try {
			String dbUrl ="jdbc:oracle:thin:@localhost:1521:xe";
			Connection conn = DriverManager.getConnection(dbUrl,"c##scott","tiger");
			
			String sql = "select ename,sal,comm,to_char(hiredate,'YYYY-MM-DD') from emp";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			
	        while(rs.next()) {
	         
	            String ename = rs.getString(1);
	            int sal = rs.getInt(2);
	            double comm = rs.getDouble(3); 
	            String hiredate = rs.getString(4);
	            
	            
	         Object [] row = {ename,sal,comm,hiredate};
	         model.addRow(row);   
	            
	         }
	         rs.close();
	         pstmt.close();
	         conn.close();

			
		}catch(SQLException se) {
			
		}
	
		add(sp); //스클로 기능이 있는 테이블
		
		setSize(500,400);
	    setVisible(true);
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		new JdbcJtable();

	}

}
