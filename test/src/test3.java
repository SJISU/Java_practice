import java.net.InetAddress;

public class test3 {

	
	public test3() {
		
	try{
		//���� ����ǻ���� ip�� �̿��Ͽ� InetAddress �����ϱ�
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
