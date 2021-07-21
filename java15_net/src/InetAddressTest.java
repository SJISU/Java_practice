import java.net.InetAddress;

public class InetAddressTest {//�����޼ҵ�x-> �޼ҵ带�̿��Ͽ� IneAddress��ü������ִ�
							  //�����ڰ� ���α׷������� �������ǻ�Ϳ����� ����Ǿ���Ѵ�

	public InetAddressTest() {		
		
		try {
			
			//���� ����ǻ���� ip�� �̿��� InetAddress��ü �����ϱ�
			InetAddress ia1 = InetAddress.getLocalHost(); // �� ��ü�� ������ ����� �����ϴ�
			
			// getHostAddress -> ����ǻ���� ip�� �³� Ȯ��			
			String hostAddr1 = ia1.getHostAddress();
			String hostName1 = ia1.getHostName();
			
			System.out.println("hostAddr1-> "+hostAddr1); // ��ǻ���� ip
			System.out.println("hostName1-> "+hostName1); //�����ξ�� ��ǻ�� �̸� ���´�
			System.out.println("==============================================");
			
			//url �ּҷ� InetAddress��ü�� �����ϸ� ip,url������ ��ü�� ������ �ִ�.
			InetAddress nate = InetAddress.getByName("www.nate.com"); //�������� �̿��ؼ� ��ü�� ����� ip�� �������ִ� 
			System.out.println("nate->address---> "+nate.getHostAddress()); //����Ʈ ������ ip
			System.out.println("nate->Name---> "+nate.getHostName()); //������
			System.out.println("==============================================");
			
			//ip�� ��ü�� ����� �������� ���Ҽ� �ֳ�?: �̰ǺҰ���
			InetAddress nateIp = InetAddress.getByName("120.50.131.112"); //nate ip
			System.out.println("nateIp->address---> "+nateIp.getHostAddress());
			System.out.println("nateIp->Name---> "+nateIp.getHostName()); //�������� �ȳ��´� - ip�� ��µ�
			System.out.println("==============================================");
			
			//InetAddress��ü ��ü ���ϱ�- ip�� �������� ����Ʈ�� �ִ�.
			InetAddress[] ip= InetAddress.getAllByName("www.naver.com");			
			for(InetAddress ia:ip) {
				System.out.println("address---> " + ia.getHostAddress());
				System.out.println("name---> " + ia.getHostName()+"\n==============================================");				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		new InetAddressTest();
	}

}
