import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLTest {

	public URLTest() {
		  // url�ּ�(protocol,host,port,filename)���� �̿��Ͽ� ��ü�� �����ϸ�
	      // �ش� ������ ���ҽ��� ���ü� �ִ�.
		
		
		try {
			// URL�ּ�(Protocol://host/port/filename)�� �̿��� ��ü�� �����ϸ� �ش� ������ ���ҽ��� ������ �� �ִ�.
			// https�� http�� ���� ������ �� ��ȭ�� ���������̶� https�� �� ���� ���δ�. 
			URL url = new URL("https://www.nate.com/"); // ��� ���� �������� file, path�� �ȳ���
			//URL url = new URL("https://sports.news.naver.com/news.nhn?oid=076&aid=0003756776"); // �̷� �ֵ�� ������ ����
			// ���� ���ؼ� ����
			String protocol = url.getProtocol();
			String host = url.getHost();
			int port = url.getPort();
			String file = url.getFile(); // ���+���ϸ�+������
			String path = url.getPath(); // ���+���ϸ�
			
			System.out.println("protocol-->" + protocol);
			System.out.println("host-->" + host);
			System.out.println("port-->" + port);
			System.out.println("file-->" + file);
			System.out.println("path-->" + path);
			
			
			// �� ģ������ �ѱ��� ǥ���ϱ� ���� � �����ڵ带 ������(���� UTF-8)�� �˾ƿ��� ���� �ڵ��̴�...
			// URLConnection ��ü�� �ش� �������� ��� ���� ���ϱ�
			URLConnection connection = url.openConnection();
			// connect()�� ���� ��� ä���� Ȯ���ؾ� ��� ������ ������ �� �ִ�.
			connection.connect();
			// ��� ������ getContentType() ��� �����´�.
			String type = connection.getContentType();
			System.out.println("Content-Type-->" + type); //����� �ڵ� Ÿ�� ���ϱ� ex) utf-8    
	         
			// �ڵ� ��������
			int idx = type.indexOf("charset=");
			String encode = type.substring(idx+8);
			System.out.println("encode-->" + encode);			
			System.out.println("==============================================================================");			
			
			// URL ��ü���� ���ҽ� ��������
			// �ڹٿ� ������(Input/Reader) ������ �ܼ�/����/��Ʈ��ũ(URL��ü)�̹Ƿ� URL ��ü�� ���ؼ��� �翬�� inputStream ��ü�� ���� �� �ִ�.
			// InputStream(1byte) > InputStreamReader(1����) > BufferedReader(1��)�� ���� �˳��ϰ� ���پ� �о����!
			// InputStream(1byte) > InputStreamReader(1����) �� ������ �ϴ� ������ �ѱ��� 2byte�� ������ �����̴�.... ����ϸ� ����� �ΰ��� ����...
			// �� �������� �ѱ��� ������ �ʵ��� �ϴ� InputStreamReader�� Constructor�� �ִܴ�. �� ��° �Ű������� UTF-8�� �����ϸ� �ȴ�.
			InputStream is = url.openStream();//inputStream �� ����
			InputStreamReader isr = new InputStreamReader(is, encode);//inputStream �� byte������ �о���⶧���� ���ڴ����� �ٲ�� �Ѵ�
			BufferedReader br = new BufferedReader(isr);//���ڴ����������ϱ� ���ٷ� �д� ���۷�
			// ���� �� �پ� �о�� �� �����Ƿ� ���� �о�� ������ �ݺ�����
			while(true) {
				String readData = br.readLine();
				if(readData == null) break;
				System.out.println(readData);
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new URLTest();
	}
}


// ��� �������� �����ϸ� .jsp / .asp / .php / .html ���� ������ ����ǰ� �츮�� �װ��� ���� ���̴�.
// �ٵ� ���ϸ��� �� ����? �³װ� ������ ���� �׷���.
// �������� �ٲ�� �������� ���ڱ� ���� �������.