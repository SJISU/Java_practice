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
	String title[]= {"사원명","급여","보너스","입사일"};
	JScrollPane sp;
	
	static {
		//멤버영역이이지만 실행문을 표기할수 있는 영역이 됨
		//1.드라이브 로딩->멤버영역에 staic안에 실행문작성->호출하지않아도 불러짐
		//Class.forName("");
		try {			
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException  cnfe) {
			System.out.println("jdbc드라이브 로딩 에러 발생...");
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
		table.setModel(model); //new JTable(model) //한줄로
		
		sp = new JScrollPane(table);
		
		add(sp);
		
		setSize(500,400);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		empAllselect(); //호출
		
	}
	
	public void empAllselect() {
		//1.드라이브 로딩->멤버영역에 staic안에 실행문작성->호출하지않아도 불러짐
		//Class.forName("");		
		try {
			//2.DB연결		
			conn = DriverManager.getConnection(dbUrl,username,password);
			//3.Statement 생성(SQL문)
			String sql = "select ename,sal,comm,to_char(hiredate,'YYYY-MM-DD') from emp order by hiredate";
			pstmt = conn.prepareStatement(sql);
			//4.실행
			rs = pstmt.executeQuery(); //rs에 선택된 레코드가 담겨있음
			while(rs.next()) {
				Object[]emp= {rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getString(4)};
				model.addRow(emp);
			}
			//5.닫기
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			
		}finally{ // 예외 발생유무와 상관없이 두가지다 여기로 온다...
			try {
				//객체 존재하는지 물어보고 삭제한다
				if(rs!=null) rs.close();
				if(pstmt !=null) pstmt.close();
				if(conn !=null) conn.close();
			}catch(SQLException s) {
				System.out.println("닫힘 예외 발생");
			}
		}
		
		
	}

	public static void main(String[] args) {
		new JTableEmpList();

	}

}
