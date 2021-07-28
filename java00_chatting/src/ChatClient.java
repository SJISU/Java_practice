import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class ChatClient extends JFrame implements ActionListener , Runnable{
	//Frame Center
	JPanel centerPane = new JPanel(new BorderLayout());
		JPanel connPane = new JPanel(new BorderLayout());
			JTextField connTf = new JTextField("172.16.101.227");
			JButton connBtn = new JButton("접속");
		
		JTextArea msgTa = new JTextArea();
		JScrollPane  sp = new JScrollPane(msgTa);
	
		JPanel msgPane = new JPanel(new BorderLayout());
			JTextField msgTf = new JTextField();
			JButton sendBtn = new JButton("보내기");
	//Frame East
	JPanel eastPane = new JPanel(new BorderLayout());
		JLabel title = new JLabel("   접속자 리스트   ");
		
		DefaultListModel<String> connModel = new DefaultListModel<String>();
		JList<String> connList = new JList<String>(connModel);
		JScrollPane connSp = new JScrollPane(connList);
		
		JLabel count = new JLabel("현재 : 0명");
	//////////////////////////////////////////////////////////////
		Socket s;
		BufferedReader br; //입력
		PrintWriter pw;//출력
		
	
	
	public ChatClient() {
		add(centerPane);
		
		//center
		centerPane.add(BorderLayout.NORTH,connPane);
		connPane.add(connTf);
		connPane.add("East",connBtn);
		
		//all message
		centerPane.add(sp);
		msgTa.setBackground(new Color(176,209,209));
		//176.209.209
		//255.232.232
		
		
		//message send
		centerPane.add("South",msgPane);
		msgPane.add(msgTf);
		msgPane.add("East",sendBtn);
		
		//chat information
		add("East",eastPane);
		eastPane.add("North",title);
		connModel.addElement("						");
		eastPane.add(connSp);
		eastPane.add("South",count);
		
		setSize(400,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//이벤트 등록
		connTf.addActionListener(this);
		connBtn.addActionListener(this);
		msgTf.addActionListener(this);
		sendBtn.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae) {
		Object eventObj =  ae.getSource();
		if(eventObj == connTf || eventObj == connBtn) {
			setServerConnection(); //서버에 접속	//IO생성
		}else if(eventObj == msgTf || eventObj == sendBtn) { //4번 보내기
			sendMessage();
		}
		
	}
	//서버로 클라이언트가 문자 보내기
	public void sendMessage() {//내가간 메시지가 서버에갓다가 다시 오는
		String sendMsg = msgTf.getText();//보낼 문자 정보 가져오기
		if(!sendMsg.equals("")) {
			pw.println(sendMsg);
			pw.flush(); // 엔터
		}
	}
	
	public void setServerConnection() {//서버에 접속	//IO생성
		try {
			//서버에 접속 - 소켓객체 - 객체만 만들면 접속이됨
			InetAddress ia = InetAddress.getByName("172.16.101.227"); //ip객체
			s = new Socket(ia,13000);
			
			//IO생성
			br = new BufferedReader(new InputStreamReader(s.getInputStream())); //입력
			pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));//출력
			
			//접속하고나면 비활성화
			connTf.setEnabled(false);
			connBtn.setEnabled(false);
			
			//연결이 끝나면 start -> 서버에서 온 문자 받는다
			Thread t = new Thread(this);
			t.start();
			
			
		}catch(Exception e) {
			System.out.println("서버접속에러발생..."+e.getMessage());
		}
	}

	//서버에서 온 문자를 	받는 스레드
	//서버에서 언제 접속이 들어올지모르므로 inputstream을 thread로 구현해야함
	//그 다음 스레드는 대기모드....이 스레드가 끝나고 다음스레드가 실행되어야함
	public synchronized void run() {
		while(true) { //계속받아야하니깐 무한루ㅠㅡ
			try {
				String receiveData = br.readLine();
				if(receiveData !=null && !receiveData.equals("")) {
					//*받음
					//message
					if(receiveData.substring(0,4).equals("*MG$")) {
						msgTa.append(receiveData.substring(4)+"\n");
					}else if(receiveData.substring(0,4).equals("$CN#")) {//Count :접속자수
						count.setText("현재 : "+receiveData.substring(4)+"명"); //4번째글자만필요
					}else if(receiveData.substring(0,4).equals("@LI$")) {//접속자목록
						StringTokenizer st = new StringTokenizer(receiveData.substring(4),"/");
						connModel.removeAllElements();//모델의 모든 목록을 지운다
						
						while(st.hasMoreTokens()) {
							connModel.addElement(st.nextToken());
						}
					}
					
					
				}
			}catch(Exception e) {
				
			}
		}
	}
	
	public static void main(String[] args) {
		new ChatClient();
	}

}
//ip를 입력하고 접속누르면 접속
