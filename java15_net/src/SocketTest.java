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
		//InetAddress : 서버컴퓨터의 ip를 이용하여 생성한다.
		//port : 서버에서 open된 port번호를 이용한다.
		try {
			
			InetAddress ia =InetAddress.getByName("192.168.0.19"); //본인컴퓨터 ip
			Socket s = new Socket(ia,12000); //객체생성메소드 //객체를만드는순간 서버에 접속됨 
											//-> serveSocket이 접속을받음
		
			//서버에서 보낸문자 받을 InputStream객체를 생성
			InputStream is = s.getInputStream(); //한바이트만읽음
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			String inData = br.readLine(); // 한줄의 데이터가 들어오기까지 대기
			System.out.println("서버에서 받은 문자 -->"+inData);
			
			//클라이언트가 서버로 문자로 보내기
			OutputStream  os = s.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			PrintWriter pw = new PrintWriter(osw);
			
			pw.println("하이 난 클라이언트야....1234");
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
