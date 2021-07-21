import java.util.ArrayList;
import java.util.List;



public class MemberDAO extends DBCON {

	public MemberDAO() {
		
	}
	//회원전체선택
	public List<MemberVO> allRecord() {//컬렉션에 담아서 컬렉션을 반환형으로 리턴해준다 -> arrayList-List사용
		List<MemberVO> list	= new ArrayList<MemberVO>();
		try {
			//1.db연결
			dbConn();
			//쿼리문
//			String sql = "select mem_no,username,tel,email,addr "
//			+"to_char(write_date,'YYYY-MM-DD') write_date from member order by username asc ";
			String sql = "select mem_no, username, tel, email, addr, "
		               + "to_char(write_date,'YYYY-MM-DD') write_date from member order by username asc";
			//2. prepatedStatement생성
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setMem_no(rs.getInt(1)); //vo에 번호담음 
				vo.setUsername(rs.getString(2));
				vo.setTel(rs.getString(3));
				vo.setEmail(rs.getString(4));
				vo.setAddr(rs.getString(5));
				vo.setWrite_date(rs.getString(6));
				list.add(vo); // 한명의 정보를vo에 담고 그 vo를 list저장소에 담는다 --> 반복해서 여러명의 정보가 담긴다
			}
			
		}catch(Exception e){
			System.out.println("전체회원선택 에러 발생....");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return list; //정보를 담은 저장소를 반환해줌
		
	}
	//회원추가
	public int insertRecord(MemberVO vo){
		//추가등록후에 데이터베이스에도 추가되어야하고 제이테이블회원목록에도 추가된 회원이 출력되어야한다..
		int cnt=0;
		try {
			dbConn(); //디비연결
			String sql = "insert into member(mem_no,username,tel,email,addr) values(mem_sq.nextval, ?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,vo.getUsername() );
			pstmt.setString(2,vo.getTel());
			pstmt.setString(3,vo.getEmail() );
			pstmt.setString(4,vo.getAddr() );
			
			cnt= pstmt.executeUpdate(); //몇개의 레코드가 추가되었는지.....
			
		}catch(Exception e) {
			System.out.println("회원추가에러 발생...");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
	}
	//회원수정              - 번호,연락처,이메일,주소
	public int updateRecord(MemberVO vo) {
		//수정이 됫는지 안됬는지의 정보를 보내준다 
		//쿼리문을 싱행하면 실행하는명령어가 리턴해주는 데이터가 있다 -> pstmt.executeUpdate()
		int cnt =0;
		try {
			dbConn();
			String sql = "update member set tel=?,email=?,addr=? where mem_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTel());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getAddr());
			pstmt.setInt(4, vo.getMem_no());
			
			cnt = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("회원수정 에러 발생...");
			e.printStackTrace();
		}
		return cnt;
	}
	//회원삭제
	public int deleteRecord(int mem_no) { //누구를삭제할건지 매개변수받아서 처리-db에서 삭제후 삭제결과를 보내줘야함
		int cnt=0;
		try {
			dbConn();
			String sql = "delete from member where mem_no=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,mem_no);
			
			cnt = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("사원삭제 에러 발생");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;			
	}
	
	//회원검색
	public List<MemberVO> searchRecord(String search,String fieldName) {
		
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			dbConn();
			String sql = "select mem_no,username,tel,email,addr,to_char(write_date, 'YYYY-MM-DD')"
					+ " from member where "+fieldName+" like ? order by username asc";
			System.out.println("sql"+sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"%"+search+"%"); // %김%
			rs =pstmt.executeQuery(); //선택된레코드의 정보가 들어가잇음:셀렉트된정보
			
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setMem_no(rs.getInt(1));
				vo.setUsername(rs.getString(2));
				vo.setTel(rs.getString(3));
				vo.setEmail(rs.getString(4));
				vo.setAddr(rs.getString(5));
				vo.setWrite_date(rs.getString(6));
				
				list.add(vo);
			}
			
		}catch(Exception e) {
			System.out.println("회원검색에러 발생.......");
			e.printStackTrace();
		}finally {
			
		}
		return list;
	}
}
