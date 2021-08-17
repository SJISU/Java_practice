import java.sql.CallableStatement;
import java.sql.ResultSet;

import oracle.jdbc.internal.OracleTypes;

public class SelectAllProcedure extends DBConnection {

	public SelectAllProcedure() {
		
	}
	
	public void start() {
		try {
			dbConn();
			
			sql ="{call mem_all_select(?)}";
			
			CallableStatement cstmt = con.prepareCall(sql);
			
			cstmt.registerOutParameter(1,OracleTypes.CURSOR);
			
			//실행ㅇ
			cstmt.executeLargeUpdate();
			
			//out되는 ?에 담겨져있는 데이터를 가져와야한다
			rs= (ResultSet)cstmt.getObject(1);
			
			while(rs.next()) {
				System.out.printf(" %d, %s, %s, %s, %s, %s\n", 
						rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6));
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
	}

	public static void main(String[] args) {
		new SelectAllProcedure().start();
	}

}

/*
-- 테이블의 모든 레코드를 선택하는 프로시저
-- 번호순으로 정렬
create or replace procedure mem_all_select(p_result out sys_refcursor) -- out만있음,셀렉트한걸 p_result에 담음
is
begin
    open p_result for
    select mem_no,username,tel,email,addr,write_date from member order by mem_no;
end;
 */
