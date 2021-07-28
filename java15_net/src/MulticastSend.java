import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastSend { //공용ip를 이용해서 전달
	
	/*
	 * 	224.0.0.0 ~ 239.255.255.255
	 * 
	 *  225.0.0.15
	 */
	MulticastSocket  ms;
	DatagramPacket  dp;
	InetAddress ia;
	
	public MulticastSend() {
		
		try{
			ms= new MulticastSocket();
			ia = InetAddress.getByName("225.0.0.15");
			String data ="멀티캐스트 소켓을 이용한 데이터 전송";
			dp = new DatagramPacket(data.getBytes(),data.getBytes().length,ia,17000);
			
			ms.send(dp);
		}catch(Exception e) {
			
		}
		
	}

	public static void main(String[] args) {
		new MulticastSend();
	}

}
