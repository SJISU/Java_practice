
public class Login {
	
	private final String USERID ="admin";
	private final String USERPWD ="1234";
	
	public Login() {
		//�����ڴ� ���̵�� ����� ������ �������� �޾ƾߵ�->������ ���ȭ
		
	}
	
	//�α��� üũ ����(true : �α��μ���,false:�α��ν���)
	public boolean loginCheck(String userid,String userpwd) {
		if(userid.equals(USERID) && userpwd.equals(USERPWD)) {
			return true;
		}else {
			return false;
		}		
	}
	

}