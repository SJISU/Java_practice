import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;


public class SocketTest {

	public SocketTest() {
		//Socket(InetAddress,port)
		//InetAddress : ������ǻ���� ip�� �̿��Ͽ� �����Ѵ�.
		//port : �������� open�� port��ȣ�� �̿��Ѵ�.
		try {
			
			InetAddress ia =InetAddress.getByName("192.168.0.19"); //������ǻ�� ip
			Socket s = new Socket(ia,12000); //��ü�����޼ҵ� //��ü������¼��� ������ ���ӵ� 
											//-> serveSocket�� ����������
		
			//�������� �������� ���� InputStream��ü�� ����
			InputStream is = s.getInputStream(); //�ѹ���Ʈ������
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			String inData = br.readLine(); // ������ �����Ͱ� ��������� ���
			System.out.println("�������� ���� ���� -->"+inData);
			
			//Ŭ���̾�Ʈ�� ������ ���ڷ� ������
			OutputStream  os = s.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(osw);
			
			pw.println("���� �� Ŭ���̾�Ʈ��....1234");
			pw.flush();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void startClient() {
		
	}
	public static void main(String[] args) {
		new SocketTest().startClient();

	}

}
