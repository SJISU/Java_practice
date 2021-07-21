import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class InsertTest {
	
	static{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException c) {
			System.out.println("드라이브로딩에러..");
		}		
	}
	
	Connection conn;
	PreparedStatement  pstmt;

	public InsertTest() {
		//사원번호,사원명,급여를 입력받아 레코드추가->INPUTSTREAM으로 입력받아서
		//입사일은 현재 날짜로 지정한다.
		
		//데이터 BufferedReader 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //br에서 한줄씩 읽을수 있다.

		try {
		
			System.out.print("사원번호="); //숫자형데이터를원함 -> 콘솔에서받은문자를 숫자로 바꿔야함
			int empno = Integer.parseInt(br.readLine());
			
			System.out.print("사원명=");
			String ename = br.readLine();
			
			System.out.print("급여=");
			int sal = Integer.parseInt(br.readLine());
			
			//DB에 저장
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##scott","tiger");
			String sql = "insert into emp(empno, ename, sal, hiredate) values(?,?,?,sysdate)";  //sysdate -> 오라클에서 현재날짜구하는 
			pstmt = conn.prepareStatement(sql);
			// ?의 값 셋팅
			pstmt.setInt(1,empno); //(물음표순서,들어갈데이터)
			pstmt.setString(2,ename);
			pstmt.setInt(3, sal);
			
			//db안의 데이터가 변경됨->executeUpdate 호출 -> 레코드를 추가하고나면 그값이 넘어온다...//insert 못하면 :0 
			int cnt = pstmt.executeUpdate();
			if(cnt>0) {
				System.out.println("레코드가 추가 되었습니다");
			}else {
				System.out.println("레코드 추가 실패하였습니다");
			}
		
		}catch(IOException ie) {
			System.out.println("데이터 입력에러 발생--->"+ie.getMessage());
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

	public static void main(String[] args) {
		new InsertTest();
	}

}
