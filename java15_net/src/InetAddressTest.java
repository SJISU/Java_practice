import java.net.InetAddress;

public class InetAddressTest {//생성메소드x-> 메소드를이용하여 IneAddress객체만들수있다
							  //개발자가 프로그램개발후 사용자컴퓨터에서도 실행되어야한다

	public InetAddressTest() {		
		
		try {
			
			//현재 내컴퓨터의 ip를 이용한 InetAddress객체 생성하기
			InetAddress ia1 = InetAddress.getLocalHost(); // 이 객체가 있으면 통신이 가능하다
			
			// getHostAddress -> 내컴퓨터의 ip가 맞나 확인			
			String hostAddr1 = ia1.getHostAddress();
			String hostName1 = ia1.getHostName();
			
			System.out.println("hostAddr1-> "+hostAddr1); // 컴퓨터의 ip
			System.out.println("hostName1-> "+hostName1); //도메인없어서 컴퓨터 이름 나온다
			System.out.println("==============================================");
			
			//url 주소로 InetAddress객체를 생성하면 ip,url정보를 객체가 가지고 있다.
			InetAddress nate = InetAddress.getByName("www.nate.com"); //도메인을 이용해서 객체를 만들면 ip를 얻을수있다 
			System.out.println("nate->address---> "+nate.getHostAddress()); //네이트 서버의 ip
			System.out.println("nate->Name---> "+nate.getHostName()); //도메인
			System.out.println("==============================================");
			
			//ip로 객체를 만들면 도메인을 구할수 있나?: 이건불가능
			InetAddress nateIp = InetAddress.getByName("120.50.131.112"); //nate ip
			System.out.println("nateIp->address---> "+nateIp.getHostAddress());
			System.out.println("nateIp->Name---> "+nateIp.getHostName()); //도메인은 안나온다 - ip가 출력됨
			System.out.println("==============================================");
			
			//InetAddress전체 객체 구하기- ip가 여러개인 사이트가 있다.
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
