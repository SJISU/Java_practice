import java.util.Scanner;

public class DeleteTest extends DBConnection{ //삭제
	
	public DeleteTest() {
		try {	
			//콘솔에서 사원명을 입력받아 입력받은 사원 삭제한다.
			Scanner scan = new Scanner(System.in);
			System.out.print("삭제할사원명=");
			String name =scan.nextLine();
			
			//DB연결
			dbConn(); //상속받은클래스의 메소드
			
			sql = "delete from emp where ename=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			
			int result = pstmt.executeUpdate(); //몇개삭제되었는지알수있다
			System.out.println(result+"개의 레코드가 삭제되었습니다");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose(); //상속받은클래스의 메소드
		}
	}

	public static void main(String[] args) {
		new DeleteTest();

	}

}
