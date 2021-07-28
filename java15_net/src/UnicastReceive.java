import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UnicastReceive {//�޴���

	DatagramSocket ds;
	DatagramPacket dp;
	
	public UnicastReceive() {
		try {
			
			//��Ʈ��ȣ����			
			ds = new DatagramSocket(15000); //���ϰ�ü����
			
			byte[] data = new byte[512];
			dp = new DatagramPacket(data,data.length); //�Ű������� byte��int
			System.out.println("�ޱ� �����.....");										//���ʿ��� ������ �����͸� �޾Ƽ� �迭�������� -> �������صд�
			//�ޱ� ��� //�����غ� -> �������� �����ϱ�
			ds.receive(dp); //������ ���������� �����....//�Ű������� ��Ŷ //readLine�� ���� ���
			
			//DatagramPacket��Ŷ���� ���۹��� �����͸� ������
			byte[] receiveData = dp.getData();
			//���۹��� byte�� ���ϱ�
			int byteCount = dp.getLength();			
			//�������ϴ� ��ġ�������� ���ڸ� �����
			String receiveStr = new String(receiveData,0,byteCount);
			//String receiveStr = new String(receiveData);//����Ϸ��� ��Ʈ������ �ٲ���Ѵ�
			System.out.println(receiveStr+"---------------"); //512����Ʈ�� ������ ���� �����鵵 ��µ�
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		new UnicastReceive();

	}

}
