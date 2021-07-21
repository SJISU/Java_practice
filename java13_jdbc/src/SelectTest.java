import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest {

	public SelectTest() {
	
		try {
			//1.JVM 에 Jdbc 드라이브 로딩
			//경로를 class라는클래스안에forname이라는메소드안에 -> 객체를만들어서 자바가상머신한테 알려줌
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException cnfe) {
			System.out.println("Jdbc 드라이브 로딩 실패-->"+cnfe.getMessage());
		}
		
		try {
			//2.DB연결 -> 연결하는클래스 : DriveManager클래스- getConnection(db서버정보,id,pw)
			//								@다음에 서버주소(사용자ip or localhost) : 포트번호 : 전역데이터베이스변수
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";//db url	
			//											 (db서버정보,사용자id,사용자pw)
			Connection conn = DriverManager.getConnection(dbUrl,"c##scott","tiger");
			
			
			//3.쿼리문을 만든다. "문자열"로 만든다...
			String sql = "select empno,ename,job,to_char(hiredate,'YYYY-MM-DD') hiredate,sal,comm,deptno "
					 + " from emp where sal>=? or job=? order by ename"; //스트링끼리 +로 묶으면 띄어쓰기해야함
			
			//4.쿼리문을 이용하여 PrepareStatement 객체생성
			//java.sql패키지 Connection- PrepareStatement
			//-> statement를 상속받는 인터페이스로 SQL구문을 실행시키는 기능을 갖는 객체 -> 전달역활
			PreparedStatement  pstmt =conn.prepareStatement(sql); //인터페이스 PreparedStatement
			// ?를 셋팅
			pstmt.setInt(1,3000); //첫번째물음표,3000
			pstmt.setString(2,"세일맨"); //두번째물음표,
			
			//5.실행하기
			//executeUpdate() -> insert update delete
			//executeQuert -> 리턴 resultSet : 셀렉트문에 선택된것이 리절트셋에 담긴가
			ResultSet rs =pstmt.executeQuery(); //셀렉트된 실행결과(데이터)가 rs객체에 들어가잇음 // 인터페이스 : ResultSet			
			
			//데이터들 하나씩 끄집어내서 작업해야되니깐 ResultSet클래스(인터페이스)의 메소드로 데이터 가지고 나온다..
			//first() 
			// next():포인트가 다음으로 넘어감 //previous():포인트가 이전으로 감 ->포인가 있는줄의 데이터를 가지고나옴
			while(rs.next()) { //레코드가 있으면 true
				//한줄의 레코드가 들어옴 //컬럼의 데이터의 데이터형이 다 다르기 때문에...get으로는 한줄씩 가져올수없음-> 첫번째컬럼은1,두번째컬럼은2
				int empno = rs.getInt(1); //rs.getInt("empno"); //index1의 데이터 가져옴
				String ename = rs.getString(2); //re.getString("ename")//두번째필드 가져옴
				String job =rs.getString("job");
				String hiredate = rs.getString(4); //날짜
				//double sal = rs.getDouble(5);
				int sal = rs.getInt(5);//double이어도 int로 값을 가져올수있다.
				double comm =rs.getDouble(6);
				int deptno = rs.getInt(7);
				
				System.out.println(empno+","+ename+","+job+","+hiredate+","+sal+","+comm+","+deptno);
				//getint를 하면 null데이터가 
			}
		
			rs.close();
			pstmt.close();
			conn.close();
		}catch(SQLException se) {
			System.out.println("DB연결 에러 발생---> "+se.getMessage());
		}
		
	}

	public static void main(String[] args) {
		new SelectTest();
	}

}
