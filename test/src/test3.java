import java.net.InetAddress;

public class test3 {

	
	public test3() {
		
	try{
		//현재 내컴퓨터의 ip를 이용하여 InetAddress 생성하기
		InetAddress ia1 = InetAddress.getLocalHost();
		
		String hostAddr1 = ia1.getHostAddress();
		String hodtName = ia1.getHostName();
		
	}catch(Exception e ) {
		e.printStackTrace();
	}
		
	}

	public static void main(String[] args) {
	 
	}

}
