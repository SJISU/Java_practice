import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;



public class ServerSocketTest { //cmd�� ����

	public ServerSocketTest() {
		serverStart();
	}
	
	//������ ����Ǹ� ������ ��ٸ��� ���
	public void serverStart() {
		try {
		
			// 0~65536 ��Ʈ��ȣ
			ServerSocket ss = new ServerSocket(12000);
			System.out.println("Server Start...."); // ��ٸ����ִ������� Ȯ���ϱ� ���� ����غ�
			
			while(true) { //�������� �����ڰ� �����ϱ����� while���� �ݺ�
			System.out.println("���Ӵ����");
			Socket s =ss.accept(); // Ŭ���̾�Ʈ�� ������ ��ٸ�����
			System.out.println("Ŭ���̾�Ʈ�� �����Ͽ����ϴ�..."); //SocketTestŬ������ �̿��Ͽ� Ŭ���̾�Ʈ�� �����ϸ�߻�
			InetAddress ia = s.getInetAddress(); //Ŭ���̾�Ʈ�� ip
			System.out.println("�������� ip-->"+ia.getHostAddress());
			
			//�����ڿ��� ���� ������ -> outputStream
			OutputStream os =s.getOutputStream(); //����Ʈ����
			OutputStreamWriter osw = new OutputStreamWriter(os); // ���ڴ�����
			PrintWriter pw = new PrintWriter(osw); //���پ�
			
			pw.println("welcome~~~~�ȳ�....."); //pw�� ���ؼ� �������� �� -> ������
			pw.flush(); // ����� �������� ??�� �Ͼ
			
			//Ŭ���̾�Ʈ�� �������� �ޱ�
			InputStream  is = s.getInputStream();
			InputStreamReader  isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			String data = br.readLine(); //Ŭ���̾�Ʈ�� ���ڸ� ������������ ��ٷ�
			System.out.println("������ ���� ���� -->"+data);//���ڹ����� �ֿܼ� ���
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ServerSocketTest();

	}

}
