import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;



public class ServerSocketTest { //cmd로 보기

	public ServerSocketTest() {
		serverStart();
	}
	
	//서버가 실행되면 접속을 기다리는 기능
	public void serverStart() {
		try {
		
			// 0~65536 포트번호
			ServerSocket ss = new ServerSocket(12000);
			System.out.println("Server Start...."); // 기다리고있는중인지 확인하기 위해 출력해봄
			
			while(true) { //여러명이 접속자가 접속하기위해 while문을 반복
			System.out.println("접속대기중");
			Socket s =ss.accept(); // 클라이언트의 접속을 기다리는중
			System.out.println("클라이언트가 접속하였습니다..."); //SocketTest클래스를 이용하여 클라이언트가 접속하면발생
			InetAddress ia = s.getInetAddress(); //클라이언트의 ip
			System.out.println("접속자의 ip-->"+ia.getHostAddress());
			
			//접속자에게 문자 보내기 -> outputStream
			OutputStream os =s.getOutputStream(); //바이트단위
			OutputStreamWriter osw = new OutputStreamWriter(os); // 문자단위로
			PrintWriter pw = new PrintWriter(osw); //한줄씩
			
			pw.println("welcome~~~~안녕....."); //pw를 통해서 소켓으로 감 -> 대기상태
			pw.flush(); // 해줘야 데이터의 ??이 일어남
			
			//클라이언트가 보낸문자 받기
			InputStream  is = s.getInputStream();
			InputStreamReader  isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			String data = br.readLine(); //클라이언트가 문자를 보내기전까지 기다려
			System.out.println("서버가 받은 문자 -->"+data);//문자받으면 콘솔에 출력
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ServerSocketTest();

	}

}
