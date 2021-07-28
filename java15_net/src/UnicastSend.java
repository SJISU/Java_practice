import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UnicastSend {//�������� //������ �̿��Ͽ� �ް� ������
	
	DatagramSocket ds; //�������ϴϰ� �����ʿ�
	DatagramPacket dp;//���������� ��ƾ��ϴϱ� ��Ŷ�ʿ�
	InetAddress ia;
	
	public UnicastSend() {
		String data = "�ڹ� ������α׷� �׽�Ʈ (DatagramSocket, DatagramPacket)";
		try {
			//�����Ŵϱ� ���� �ʿ�
			ds = new DatagramSocket();//��Ŷ�� �ְ�������ִ����
			//DatagramPacket(byte[] buf, int length, intAddress address, int port)
			ia = InetAddress.getByName("172.16.101.227");
			//dp -> �����͸� ��� �ٱ��� //���������� ����Ŀ�� �ִ� �迭�� ��������
			dp = new DatagramPacket(data.getBytes(),data.getBytes().length,ia,15000);
			
			ds.send(dp); // ������ ��
			System.out.println("������ �Ϸ�....");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new UnicastSend();

	}
	
}
