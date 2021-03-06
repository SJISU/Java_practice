import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class primarykey extends JFrame implements ActionListener{
	JPanel formPane =new JPanel(new BorderLayout());
		JPanel formWestPane= new JPanel(new GridLayout(4,1));
			String str1[]= {" 전 공 번 호  "," 전 공 "," 전 공 전화 번호 "," 전공 사무실 "};
		JPanel formCenter = new JPanel(new GridLayout(4,1,5,5));
			JTextField tf1 = new JTextField(5);
			JTextField tf2 = new JTextField(50);
			JTextField tf3 = new JTextField(10);
			JTextField tf4 = new JTextField(30);
			
		JPanel centerPane = new JPanel(new BorderLayout());
			JPanel btnList = new JPanel(new GridLayout(1,0,3,3));	
				JButton[]btn = {new JButton("목록"), new JButton("추가"), new JButton("수정"), new JButton("삭제")};
		
		
				JTable table;	
				DefaultTableModel model;
				String title[]= {" 전 공 번 호  "," 전 공 "," 전 공 전화 번호 "," 전공 사무실 "};
				JScrollPane sp;
				
	int MajoradminNumber,MajorPhone;//입력받은데이터 저장할 변수
	String Major_Name,Major_Office;
	
	//db연결
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");			
		}catch(ClassNotFoundException c) {
			System.out.println("드라이브로딩에러..");
		}		
	}
		
	Connection conn;
	PreparedStatement pstmt;

	
	public primarykey() {
		
		super("pk키 입력");
		
		//Frame - North
		setForm();
		//Frame - Center
		setButtonTable();
		
		//Frame - South
		//setTableFrame(); //테이블 데이터 목록
		model = new DefaultTableModel(title,0);		
		table = new JTable();
		table.setModel(model); //new JTable(model) //한줄로		
		sp = new JScrollPane(table);		
		centerPane.add(sp);
		
		setSize(1024,768);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	public void setForm() {
		
		add(BorderLayout.NORTH,formPane);
			formPane.add(BorderLayout.WEST,formWestPane);
				for(int i=0; i<str1.length; i++) {
					JLabel lb1 = new JLabel(str1[i]);
					formWestPane.add(lb1);
				}
			formPane.add(BorderLayout.CENTER,formCenter);
//				for(int i=0; i<Tf.length; i++) {
//					JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT)); //왼쪽정렬
//					p.add(Tf[i]);					
//					formCenter.add(p);
//				}
			JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT)); //왼쪽정렬
			p.add(tf1);	
			JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			p2.add(tf2);
			JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			p3.add(tf3);
			JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			p4.add(tf4);			
			
			formCenter.add(p);	
			formCenter.add(p2);	
			formCenter.add(p3);	
			formCenter.add(p4);	
	}
	
	//Frame - Center
	public void setButtonTable() {
		
		add(centerPane);
		centerPane.add(BorderLayout.NORTH,btnList);
			for(int i=0; i<btn.length; i++) {
				btnList.add(btn[i]);
				//이벤트등록
				btn[i].addActionListener(this); // 목록 추가 수정 삭제
			}
	}
	
	//추가 메소드
	public void majorOutputdata() {		
		
		MajoradminNumber = Integer.parseInt(tf1.getText());
		Major_Name = tf2.getText();
		MajorPhone = Integer.parseInt(tf3.getText());
		Major_Office = tf4.getText();
		
		try {
			//db연결
			//db저장
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##scott","tiger");
			String sql = "insert into Major(Major_number,Major,Major_Phone,Major_Location) values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, MajoradminNumber);
			pstmt.setString(2, Major_Name);
			pstmt.setInt(3, MajorPhone);
			pstmt.setString(4, Major_Office);
			
			int cnt = pstmt.executeUpdate();
			if(cnt>0) {
				System.out.println("레코드가 추가 되었습니다");
			}else {
				System.out.println("레코드 추가 실패하였습니다");
			}		
		}catch(SQLException s) {
			System.out.println("데이터베이스 연결 에러 발생--->"+s.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();			
			}catch(Exception e) {
				System.out.println("닫기 에러...");
			}
		}
	
	}
	
	//수정메소드
//	public void update() {
//		
//		//새로입력된정보들
//		MajoradminNumber = Integer.parseInt(tf1.getText());
//		Major_Name = tf2.getText();//
//		MajorPhone = Integer.parseInt(tf3.getText());
//		Major_Office = tf4.getText();
//		
//		try {
//
//		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##scott","tiger");
//		String sql ="update major set Major_Phone=?,Major_Location=? where MajoradminNumber=?"
//		pstmt = conn.prepareStatement(sql);
//		pstmt.setInt(1, MajorPhone);
//		pstmt.setString(2, Major_Office);
//		
//		}catch(Exception eee) {
//			System.out.println("수정오류"+eee.getMessage());
//		}
//	}
	
	//삭제메소드
//	public void delete() {
//		try {
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##scott","tiger");
//			String sql = "delete from major where Major_number=?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, MajoradminNumber);
//			
//			int result = pstmt.executeUpdate(); //몇개삭제되었는지알수있다
//			System.out.println(result+"개의 레코드가 삭제되었습니다");
//			
//		}catch(Exception eee) {
//			System.out.println("수정오류"+eee.getMessage());
//		}
//	}
	
	
	//리셋메소드
	public void resetData() {

		tf2.setText(" ");
		tf3.setText(" ");
		tf4.setText(" ");
		
	}
	//이벤트등록
	public void actionPerformed(ActionEvent ae) {
		JButton event= (JButton)ae.getSource(); 
		String btnLb1 = event.getText(); 
		
		switch(event.getText()) {
		
		case "목록" :
			setTableFrame();
			break;
			
		case "추가" :
			majorOutputdata();
			resetData();
			break;
		
//		case "수정" :
//			//update();
//			resetData();
		
		}
	}
	//테이블 데이터 목록
	public void setTableFrame() {
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##scott","tiger");
			String sql ="select Major_number,Major,Major_Phone,Major_Location from major";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(); //rs에 선택된 레코드가 담겨있음
			while(rs.next()) {
				Object[]emp= {rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)};
				model.addRow(emp);
			}
		}catch(Exception ee) {
			ee.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
		new primarykey();
		

	}

}
