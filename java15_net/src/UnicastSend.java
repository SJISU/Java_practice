import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UnicastSend {//보내는쪽 //소켓을 이용하여 받고 보내고
	
	DatagramSocket ds; //보내야하니간 소켓필요
	DatagramPacket dp;//보낼데이터 담아야하니깐 패킷필요
	InetAddress ia;
	
	public UnicastSend() {
		String data = "자바 통신프로그램 테스트 (DatagramSocket, DatagramPacket)";
		try {
			//보낼거니깐 소켓 필요
			ds = new DatagramSocket();//패킷을 주고받을수있는통로
			//DatagramPacket(byte[] buf, int length, intAddress address, int port)
			ia = InetAddress.getByName("172.16.101.227");
			//dp -> 데이터를 담는 바구니 //보내는쪽은 데이커가 있는 배열로 보내야함
			dp = new DatagramPacket(data.getBytes(),data.getBytes().length,ia,15000);
			
			ds.send(dp); // 보내고 끝
			System.out.println("보내기 완료....");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new UnicastSend();

	}
	
}
