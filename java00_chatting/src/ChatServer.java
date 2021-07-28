import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

//�޽���,���Ӹ���Ʈ,��������ӵǾ�����




public class ChatServer extends Thread{
	ServerSocket ss;
	//��� �����ڸ� ChatService��ü�� ����� ������ �÷���
	List<ChatService> connList = new ArrayList<ChatService>(); //��Ʈ���񽻰�ü��´�

	public ChatServer() {
		this.start(); ////Ŭ������ü�����Ǹ� �ٷ� run�޼ҵ� ����
	}

	//������ ����ϴ� ������
	public void run() {
		try {
			ss = new ServerSocket(13000); 
			while(true) {
				System.out.println("���Ӵ����....");
				Socket s = ss.accept(); //������ ��ٸ��� ���� //������ ������������ ��ٸ��� �ִٰ�
							// �������� ������ ���� ��ü�� ���� ������ ����
							//ip�� ���� ���ӹ�ư�� ��������
				//������ ������.....
				ChatService service= new ChatService(s); //s��ü�� �Ʒ��� ������
				connList.add(service); //1.���⿡ ������ ������ �������� �׿���
				
				//*����
				//���Ӿȳ��޽��� - �������忡�� output 
				service.allMessageSend("*MG$"+service.id+"���� �����Ͽ����ϴ�"); //������ ������ ���Ŭ���̾�Ʈ���� ���� �����޴��� �޽�������
				//�����ڼ� 
				service.allMessageSend("$CN#"+connList.size());
				//��ü�����ڸ���Ʈ ������
				service.allUserListSend();
				
				service.start();//���ڸ� �ޱ����� thread
				
				
			}
		}catch(Exception e) {
			System.out.println("ServerSocket ��ü ���� �����߻�...");
			e.printStackTrace();
		}
	}
	
	
	//1.������ ������ ���� ��ü
	class ChatService extends Thread{
		Socket s;
		String id; //ip
		BufferedReader br; //������ input ////�������� ���� ������ �������𸣹Ƿ� inputstream�� thread�� �����ؾ���
		PrintWriter pw; // ������ output
		
		
		ChatService(){}
		ChatService(Socket s){
			this.s=s;
			id =s.getInetAddress().getHostAddress(); //ip�� id���Ѵ�
			try {
				//Ŭ���̾�Ʈ�� �������ڸ� �޴°�ü
				br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				//�������� Ŭ���̾�Ʈ ���� ������ ��ü
				pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
			}catch(Exception e) {
				System.out.println("ChatService ������ �޼ҵ� ����..");
				
			}		
		}	
		
		//4.Ŭ���̾�Ʈ�� ������ ������ ���� �ޱ�-- *INPUT
		public void run() {//�������� ���� ������ �������𸣹Ƿ� inputstream�� thread�� �����ؾ���
			// ������ ������ �ϸ� aŬ���̾�Ʈ�� ������ arraylist �� bŬ���̾�Ʈ�� ������ araaylist�� �������
			//�ڱ��ϰ� ����Ǿ��ִ� ���Ͽ� �޽����� ������ �ڽ��� �����Ѵٸ�������� �޽��� ������:output
			//���� ���ڰ� ������ ��������ڿ��� output : �������� ��� �����ھƤİ� ���ں�����
			while(true){	
				try {
					
					String msg= br.readLine(); //��ٸ��� �ִٰ� �����Ͱ� ������ ������ ������
					if(msg!=null && !msg.equals("")) {
						allMessageSend("*MG$"+id+"��: "+msg); // ���� ���� ���͸� ġ�� ���´�-> ������������ �˾ƾ��Ѵ�-> �տ��� id�ٿ��ش�
					}
								
				
				}catch(Exception e) {
					
				}
			}
		}
		//2.��� �����ڿ��� ���� ������
		public void allMessageSend(String msg) {
			//����
			//				�����ڼ�
			for(int i=0; i<connList.size(); i++) {
				ChatService cs = connList.get(i);
				
				try {	//�������� �������� ������ ������ ���ܰ� �߻��� -> ����ó��
					
					cs.pw.println(msg);
					cs.pw.flush(); // ����ġ�°Ŷ�� �����ϸ��
				
				}catch(Exception e) {
					//Ŭ���̾�Ʈ���� output�� ���ܰ� �߻��ϸ� �ش� Ŭ���̾�Ʈ�� ������ �����..
					//�����߻� -> ���Ӳ��� ������ ������
					connList.remove(i);
					i--; // arraylist�� �ε������������� ������ ���ܹ�����
				}
			}
		}
		//3.�������� Ŭ���̾�Ʈ���� ��ü ������ ����Ʈ ������
		public void allUserListSend() {
			String user = "@LI$*";
			for(int i=0; i<connList.size(); i++) { //������ ������ �ִ� ��ü�� ���ؼ� ���ڿ��� �����
				user+=connList.get(i).id+"/";
				
			}
			//��ü�����ڿ��� ������ //�޼����� -> user
			allMessageSend(user);
			
			
		}
	}
	
	public static void main(String[] args) {
		new ChatServer();
	}

}
