package Login;
import java.util.HashMap;
import java.util.Scanner;

public class Login {

	Scanner scan = new Scanner(System.in);
	String menuTitle = "�޴�[1.ȸ������, 2.�α���, 3.�α׾ƿ�]";

	boolean flag = false;

	static HashMap<String, LogVo> lo = new HashMap<String, LogVo>();// ȸ����������

	public Login() {
	}
	public void logStart() {

		do {
			String menu = inData(menuTitle);
			if (menu.equals("1")) {// ȸ������
				// enter();

			} else if (menu.equals("2")) {// �α���
				// logIn();
			} else if (menu.equals("3")) {// �α׾ƿ�
				// logout();
			} else if (menu.equals("4")) {// ���� ...��?
				System.exit(0);
			} else {

			}

		} while (true);

	}
	// id�Է¹���\
//	String io;
//	while(true) { //->break
//	io =inData("id=");
//		boolean a = lo.containsKey(lo.get(io)); //id������ ������ true
//		if(a==true) {
//			System.out.println("�ߺ��� id�Դϴ�. �ٸ�id�� �Է��ϼ���.");
//		}else  break;
//	}
//	//pwd�Է¹���
	// ȸ�����������Է��ϴ¸޼ҵ�
//	public void enter() {
//		//�̸��Է¹���
//		String name = inData("�̸� �Է�="); 
//		String pw = inData("password=");
//		
//		
//		lo.put("������", new LogSet(,io,pw)); //LogSetŬ������...
//	}
//	
//		//�α��� �޼ҵ�
//		public void logIn(String id, String pwd) {
//			
//			if(lo.containsKey(id)) {
//				if(!lo.get(id).equals(pwd)) {
//					System.out.println("Ʋ����й�ȣ�Դϴ�");
//				}else {				
//					System.out.println("�α��� ����");
//					//flag = true; 				
//				}
//			}else {
//				System.out.println("�������� �ʴ� ���̵� �Դϴ�.");
//			}
//		}

	// �α��θ޼ҵ�
//	public boolean logIn() {
//		if(id==""|| pwd =="") {
//			System.out.println("id�� password�� �Է��Ͻÿ�");
//			return false;
//		}else {
//			if(lo.containsKey(id)) { //id�� �ִ°�쿡
//				if(!lo.get(id).equals(pwd)) {//pwd�� �ٸ���
//					System.out.println("Ʋ����й�ȣ�Դϴ�");
//					return true;
//				}else {
//					System.out.println("�α��� ����");
//					return true;			
//				}				
//			}else {
//			System.out.println("�������� �ʴ� ���̵� �Դϴ�.");
//			return false;
//		}	
//		
//		}
//	}	
//	
	// �α׾ƿ� �޼ҵ�
//	public void logout() {
//		if (!flag) {
//			System.out.println("�α����� �Ǿ� ���� �ʽ��ϴ�"); // ---->
//			return; /// ��.......
//		}
//		// flag =false; //���� ��...
//		System.out.println("�α׾ƿ��մϴ�");
//
//	}

	// �α��� üũ ����(true:�α��μ��� ,false : �α��ν���)

	public String inData(String msg) {
		System.out.println(msg + "->");
		return scan.nextLine();
	}

}
