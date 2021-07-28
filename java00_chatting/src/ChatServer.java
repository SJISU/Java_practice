import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

//메시지,접속리스트,몇명이접속되었는지




public class ChatServer extends Thread{
	ServerSocket ss;
	//모든 접속자를 ChatService객체로 만들어 보관할 컬렉션
	List<ChatService> connList = new ArrayList<ChatService>(); //차트서비슥개체담는다

	public ChatServer() {
		this.start(); ////클래스객체생성되면 바로 run메소드 실행
	}

	//접속을 대기하는 스레드
	public void run() {
		try {
			ss = new ServerSocket(13000); 
			while(true) {
				System.out.println("접속대기중....");
				Socket s = ss.accept(); //접속자 기다리고 있음 //누군가 들어오기전까지 기다리고 있다가
							// 누군가가 들어오면 소켓 객체를 만들어서 리턴을 해줌
							//ip를 쓰고 접속버튼을 눌렀을때
				//서버에 접속함.....
				ChatService service= new ChatService(s); //s객체가 아래로 내려감
				connList.add(service); //1.여기에 접속자 정보가 차곡차곡 쌓여감
				
				//*보냄
				//접속안내메시지 - 서버입장에서 output 
				service.allMessageSend("*MG$"+service.id+"님이 접속하였습니다"); //접속을 받으면 모든클라이언트에게 누가 접속햇는지 메시지보냄
				//접속자수 
				service.allMessageSend("$CN#"+connList.size());
				//전체접속자리스트 보내기
				service.allUserListSend();
				
				service.start();//문자를 받기위한 thread
				
				
			}
		}catch(Exception e) {
			System.out.println("ServerSocket 객체 생성 에러발생...");
			e.printStackTrace();
		}
	}
	
	
	//1.접속자 정보를 가질 객체
	class ChatService extends Thread{
		Socket s;
		String id; //ip
		BufferedReader br; //소켓의 input ////서버에서 언제 접속이 들어올지모르므로 inputstream을 thread로 구현해야함
		PrintWriter pw; // 소켓의 output
		
		
		ChatService(){}
		ChatService(Socket s){
			this.s=s;
			id =s.getInetAddress().getHostAddress(); //ip를 id로한다
			try {
				//클라이언트가 보낸문자를 받는객체
				br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				//서버에서 클라이언트 문자 보내는 객체
				pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
			}catch(Exception e) {
				System.out.println("ChatService 생성자 메소드 에러..");
				
			}		
		}	
		
		//4.클라이언트가 서버로 보내는 문자 받기-- *INPUT
		public void run() {//서버에서 언제 접속이 들어올지모르므로 inputstream을 thread로 구현해야함
			// 서버에 접속을 하면 a클라이언트의 정보가 arraylist 에 b클라이언트의 정보도 araaylist에 담아진다
			//자기하고 연결되어있는 소켓에 메시지를 보내고 자신을 포함한다른사람에게 메시지 보낸다:output
			//받은 문자가 있으면 모든접속자에게 output : 서버에서 모든 접속자아ㅔ게 문자보내기
			while(true){	
				try {
					
					String msg= br.readLine(); //기다리고 있다가 데이터가 들어오면 밑으로 내려감
					if(msg!=null && !msg.equals("")) {
						allMessageSend("*MG$"+id+"님: "+msg); // 값을 쓰고 엔터를 치면 나온다-> 누가보내는지 알아야한다-> 앞에다 id붙여준다
					}
								
				
				}catch(Exception e) {
					
				}
			}
		}
		//2.모든 접속자에게 문자 보내기
		public void allMessageSend(String msg) {
			//쓰기
			//				접속자수
			for(int i=0; i<connList.size(); i++) {
				ChatService cs = connList.get(i);
				
				try {	//접속자중 누군가가 접속을 끊으면 예외가 발생함 -> 예외처리
					
					cs.pw.println(msg);
					cs.pw.flush(); // 엔터치는거라고 생각하면됨
				
				}catch(Exception e) {
					//클라이언트에게 output중 예외가 발생하면 해당 클라이언트는 접속이 종료됨..
					//에러발생 -> 접속끊긴 접속자 지우면됌
					connList.remove(i);
					i--; // arraylist는 인덱스가없어지면 앞으로 땡겨버리게
				}
			}
		}
		//3.서버에서 클라이언트에게 전체 접속자 리스트 보내기
		public void allUserListSend() {
			String user = "@LI$*";
			for(int i=0; i<connList.size(); i++) { //접속자 정보가 있는 객체를 구해서 문자열로 만든다
				user+=connList.get(i).id+"/";
				
			}
			//전체접속자에게 보낸다 //메세지는 -> user
			allMessageSend(user);
			
			
		}
	}
	
	public static void main(String[] args) {
		new ChatServer();
	}

}
