import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import oracle.jdbc.OracleTypes;

public class SelectSearchProcedure extends DBConnection {

	Scanner scan = new Scanner(System.in);
	public SelectSearchProcedure() {
		
		try {
			dbConn();
			
			System.out.print("검색어 입력=");
			String searchWord = scan.nextLine();
			
			sql ="{call mem_search(?,?)}";
			CallableStatement cstmt = con.prepareCall(sql);
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.setString(2, searchWord);
			
			cstmt.executeLargeUpdate();
			rs=(ResultSet)cstmt.getObject(1);
			
			while(rs.next()) {
				System.out.printf("%d,%s,%s\n",rs.getInt("mem_no"),rs.getString(2),rs.getString(3));
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
			
			
		}
		
	}

	public static void main(String[] args) {
		new SelectSearchProcedure ();

	}

}

/*
-- 검색어를 가지고 셀렉트
-- 이름의 일부를 입력받아 문자가 포함된 경우 레코드 선택하기
create or replace procedure mem_search(p_result out sys_refcursor,p_name in member.username%type)
is
begin   
    open p_result for --p_result에 담을거다
    select mem_no,username,tel from member where username 
    like '%'||p_name||'%' order by username asc;
end;
 */