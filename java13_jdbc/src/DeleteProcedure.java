import java.sql.CallableStatement;
import java.sql.Types;

public class DeleteProcedure extends DBConnection {

	public DeleteProcedure() {
		try {
			dbConn();
			
			sql= "call mem_del(?,?)";
			CallableStatement cstmt = con.prepareCall(sql);
			cstmt.setString(1,"홍길동"); // 삭제할 회원이름
			cstmt.registerOutParameter(2,Types.INTEGER);//삭제될 데이터값을 받을 변수
			
			//실행
			cstmt.executeUpdate(); //실행하고 나면 두번째?에 결과가 담겨져 있다
			
			if(cstmt.getInt(2)==1) {
				System.out.println("회원을 삭제하였습니다");
			}else {
				System.out.println("삭제실패");
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();			
		}
		
	}

	
	public static void main(String[] args) {
		new DeleteProcedure();

	}

}

/*
-- 삭제
-- 이름을 입력받아 회원삭제하기
create or replace procedure mem_del(p_name in member.username%type, p_result out number)
is
begin
    p_result :=1;
    delete from member where username=p_name;
    
    exception 
     when others then
        p_result:=0;
end;
 */