
public class Login {
	
	private final String USERID ="admin";
	private final String USERPWD ="1234";
	
	public Login() {
		//관리자는 아이디와 비번이 뭔지를 누구한테 받아야됨->위에서 상수화
		
	}
	
	//로그인 체크 구현(true : 로그인성공,false:로그인실패)
	public boolean loginCheck(String userid,String userpwd) {
		if(userid.equals(USERID) && userpwd.equals(USERPWD)) {
			return true;
		}else {
			return false;
		}		
	}
	

}
