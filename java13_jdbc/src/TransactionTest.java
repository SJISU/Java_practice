
public class TransactionTest extends DBConnection {

	public TransactionTest() {
		
		// a_bank:5000출금 b_bank:5000입금
		
		try {
			dbConn(); //db연결
			
			//자동 commit 해제 : 트렌젝션커밋해제 //데이터베이스랑 연결되어있는변수 con에서 해제
			con.setAutoCommit(false); //true : 자동커밋, false: 자동커밋해제 //->커밋해줘야 데이터변경됨
			
			int abank= -5000; //a뱅크에서 출금할 금액
			int bbank = 5000;
			
			//출금
			sql = "insert into a_bank (num,money) values(a_number.nextval,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,abank);			
			int cnt = pstmt.executeUpdate();
			if(cnt>0) {
				System.out.println(Math.abs(abank)+"원이 출금되었습니다"); //-없애주기 위해서 절대값으로 변환
			}else {
				System.out.println(Math.abs(abank)+"원이 출금이 실패하였습니다");
			}
			//*****
			if(cnt>0) throw new Exception(); //0보다클때는 insert가 된다 -> 에러가 생기면 아래 catch쪽으로가서 입금기능이 실행안됨
			// -> 이경우에 입금기능이 안됫으니깐 출금기능한것을 롤백 해야한다....
			
			//입금
			sql = "insert into b_bank(num,money) values (b_number.nextval,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,bbank);
			int cnt2 = pstmt.executeUpdate();
			if(cnt2>0) {
				System.out.println(bbank+"원이 입금되었습니다");
			}else {
				System.out.println(bbank+"원이 입금 실패하였습니다");
			}
			
			
			con.commit(); //문제없이 실행되면 오는곳
		}catch(Exception e) {
			e.printStackTrace();
			try {	
				//rollback ->con 을 통해서
				con.rollback(); //문제가 생기면 롤백
			}catch(Exception ee) {}
		}finally {
			dbClose();
		}
	}

	public static void main(String[] args) {
		new TransactionTest();
	}

}
