import java.sql.CallableStatement;
import java.sql.Types;

public class InsertProcedure extends DBConnection {
	
	
	public InsertProcedure(){
		try {
			//1.db연결
			dbConn();
			
			//쿼리문대신 프로시저호출 --> CallcableStatement
			//					username, tel, return data(가지고나오는데이터,,,)
			sql ="{call mem_insert(?,?,?)}";
			CallableStatement cstmt = con.prepareCall(sql);
			
			cstmt.setString(1,"김다나");
			cstmt.setString(2,"010-8888-1111");
			cstmt.registerOutParameter(3, Types.INTEGER);
			
			cstmt.executeUpdate(); //실행 --3번째?의 결과가 담겨져 있음
			
			if(cstmt.getInt(3)==1) {
				System.out.println("레코드가 추가되었습니다....");
			}else { //cstmt.getInt(3)==0
				System.out.println("레코드가 추가 실패되었습니다....");	
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
	}

	public static void main(String[] args) {
		new InsertProcedure();

	}

}
/*
 
create or replace procedure mem_insert(p_username in  member.username%type, p_tel in member.tel%type, p_result out number)
is   
begin
    -- 1:추가, 0:추가실패 
    p_result := 1;
    insert into member (mem_no,username,tel,write_date)
    values(mem_sq.nextval,p_username,p_tel,sysdate);
    
    -- 레코드 추가시 에러가 발생하면 오는곳....
    exception 
        when others then 
            p_result := 0;
end;


 */