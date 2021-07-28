import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UnicastReceive {//받는쪽

	DatagramSocket ds;
	DatagramPacket dp;
	
	public UnicastReceive() {
		try {
			
			//포트번호열기			
			ds = new DatagramSocket(15000); //소켓객체형성
			
			byte[] data = new byte[512];
			dp = new DatagramPacket(data,data.length); //매개변수로 byte와int
			System.out.println("받기 대기중.....");										//한쪽에서 보내는 데이터를 받아서 배열에담을것 -> 길이정해둔다
			//받기 대기 //받을준비 -> 보내야지 받으니깐
			ds.receive(dp); //데이터 받을때까지 대기모드....//매개변수로 패킷 //readLine과 같은 기능
			
			//DatagramPacket패킷에서 전송받은 데이터를 얻어오기
			byte[] receiveData = dp.getData();
			//전송받은 byte수 구하기
			int byteCount = dp.getLength();			
			//내가원하는 위치에서부터 문자를 만든다
			String receiveStr = new String(receiveData,0,byteCount);
			//String receiveStr = new String(receiveData);//출력하려면 스트링으로 바꿔야한다
			System.out.println(receiveStr+"---------------"); //512바이트의 공간중 남은 공간들도 출력됨
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		new UnicastReceive();

	}

}
