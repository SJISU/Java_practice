import java.io.File;
import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UnicastFileReceive {

	DatagramSocket ds;
	DatagramPacket dp;
	
	public UnicastFileReceive() {
		//1. ���Ϲޱ� ->�������޾ƾ���
		receiveStart();
	}
	
	public void receiveStart() {// ���Ϲޱ� ->�������޾ƾ���
		try {
			
			ds = new DatagramSocket(16000); //��ü����-��Ʈ��ȣ������
			byte []data = new byte[512];
			dp = new DatagramPacket(data,data.length); //512byte�� �ƽ��� ����
			//���ϻ��� - ���Ϲ޾Ƽ� ���Ͼ��� outputStream
			FileOutputStream fos = null; //ó���� null / ���ϸ��������� ��ü����
			
			//���������� -> �ݺ�
			while(true) {
				//�ޱ���
				System.out.println("�ޱ� ��� ��....");
				ds.receive(dp); //�ޱ��� �޼ҵ�..�����Ͱ������� �Ʒ��� �����´�
			
				//������ ������ ���ϸ�,���ϳ���,������ ǥ������ Ȯ��
				byte[] receiveData = dp.getData(); //�迭������
				int len = dp.getLength();
				String part = new String(receiveData,0,4);
				if(part.equals("FN##")) {//1.���ϸ� //�Ѿ�µ����Ͱ� ���ϸ��̴�
					String filename = new String(receiveData,4,len-4);//index�� 4���� ������ ���ھ�ιٲ���
					System.out.println("filename-->"+filename);
					
					//outputstream
					fos = new FileOutputStream(new File("C://Users/jisu/Downloads",filename)); // ���ϰ�ü(���ϰ��,���ϸ�)
					System.out.println("IO��ü ������");
				}else if(part.equals("$%#$")) {//2.���ϳ���
					//������ �����϶�				
					if(fos!=null) {	//���ϰ�ü�� ���������Ѵ�
						fos.write(receiveData,4,len-4);//����:outputStream-write
					}
				}else if(part.equals("^%#$")) {
					fos.close();
					fos = null;
					System.out.println("���ϹޱⰡ �Ϸ��......");
				}
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new UnicastFileReceive();

	}

}
