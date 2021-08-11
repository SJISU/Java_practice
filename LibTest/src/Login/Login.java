package Login;
import java.util.HashMap;
import java.util.Scanner;
import Bookinfor.*; 

public class Login {

	//������ id,pwd
	private final String ADMINID ="admin";
	private final String ADMINPW ="1234";
	
	
	Scanner scan = new Scanner(System.in);
	String menuTitle = "[  1.ȸ������	        2.�α���	        3.�α׾ƿ�	    4.����	    5.ó���޴��� ���ư��� ]";

	boolean flag = false;
	
	// �Ϲݻ���� ��������
	public static HashMap<String, LogVo> lo = new HashMap<String, LogVo>(); //value�� String�� LogVo�� ����

	public static void basicLoSet() {
		
		lo.put("asd1",new LogVo("asd1","1234","��ö��","6786"));
		lo.put("asd2",new LogVo("asd2","1234","�迵��","9854"));
		lo.put("asd3",new LogVo("asd3","1234","�����","1010"));
		lo.put("asd4",new LogVo("asd4","1234","������","0516"));
		lo.put("asd5",new LogVo("asd5","1234","�Ѽ���","1116"));
		
		
	}	
	
	public Login() {
	}

	//������ ���ý�
	//�α��� üũ ����(true : �α��μ���,false:�α��ν���)			
	public boolean loginCheck(String adminid,String adminpwd) {
				
		if(adminid.equals(ADMINID)){
			if(adminpwd.equals(ADMINPW)){
				System.out.println("---������ �α��� �Ǿ����ϴ�---");
				return true;
			}else if(!adminpwd.equals(ADMINPW)){ 
				System.out.println("��ϵ� ������pw�� �ƴմϴ�");
				return false;
			}
			else {
				return false;
			}	
		}else if(!adminid.equals(ADMINID)){
			System.out.println("��ϵ� ������id�� �ƴմϴ�");
			return false;
		}else {
			return false;
		}	
	}
	
	//�Ϲݻ���� ���ý�
	public void logStart() {
		boolean logResult = false;
		do {
			System.out.println("[�Ϲݻ���� �޴�]");
			String menu = inData(menuTitle);
			if (menu.equals("1")) {// ȸ������
				join();
			} else if (menu.equals("2")) {// �α���
				logResult=logIn();
				if(logResult==false)
				{
					logIn();
				}
			} else if (menu.equals("3")) {// �α׾ƿ�
				logout();
			} else if (menu.equals("4")) {// ����
				System.exit(0); 
				break;//???
			} else if (menu.equals("5")) {//ó������ ���ư���				
				BookManager bb = new BookManager();
				bb.selectUser();
			} else {
				System.out.println("�޴��� �߸������Ͽ����ϴ�. �ٽ� �Է��ϼ���");				
			}
		} while(!logResult);

	}

	//ȸ������	
	public void join() {		
		LogVo vo = new LogVo();
		
		String id =inputId();
		vo.setId(id);
		
		vo.setPwd(inputPw());		
		vo.setName(inputName());		
		vo.setTel(inputTel());
		System.out.println("---ȸ�������� �Ϸ�Ǿ����ϴ�---");								
		
		lo.put(id, vo);		
	}	

	// �α��θ޼ҵ�
		public boolean logIn() {
		
			String id = inData("id�� �Է��Ͻÿ�=");
			String pwd = inData("pw�� �Է��Ͻÿ�=");
			
			if(id.equals("")|| pwd.equals("")) {
				System.out.println("id�� password�� �Է��Ͻÿ�");
				return false;
			}else {
				if(lo.containsKey(id)) { //id�� �ִ°�쿡
					
					LogVo vo =Login.lo.get(id); 
					String pass =vo.getPwd(); 
				
				if(!pass.equals(pwd)) {//pwd�� �ٸ��� --������pwd�� �ԷµȰ�
					
					System.out.println("Ʋ����й�ȣ �ٽ� �α������ּ��� �Դϴ�");
					return true;
				}else {
					System.out.println("---�α��� �����Ͽ����ϴ�---");
					flag = true; //�α׾ƿ��޼ҵ忡�� ���
					return true;
					
				}				
			}else {//id�� ���°��
			System.out.println("�������� �ʴ� ���̵� �Դϴ�.");
			return false;
			}				
		}
}	

	// �α׾ƿ� �޼ҵ�
	public void logout() {
		if (!flag) {
			System.out.println("�α����� �Ǿ� ���� �ʽ��ϴ�"); 
			return; 
		}
		flag =false; 
		System.out.println("�α׾ƿ��մϴ�");

	}
	
//===========================================================================================
	//id�Է¸޼ҵ�
	public String inputId() {
		String newId;
		Boolean flog=false;
			while(true){	
				newId = inData("�Ϲݻ���� id�� �Է��Ͻÿ�(5���� ����)=");			
				if(newId.equals("")){
					System.out.println("�ѱ��� �̻��Է����ּ���");
					flog = false;				
				}
				else if(newId.length()<=5 && lo.containsKey(newId)){				
					System.out.println("�ߺ��� id�Դϴ�. �ٸ�id�� �Է��ϼ���.");					
					flog = false;				
				}else if(newId.length()>5){						
					System.out.println("�Է� ������ id ���� ���� �ʰ��Ͽ����ϴ�");
					flog = false;
				}
				else{
					flog = true;	
					break;
				}
			}		
			return newId;	
	}
	//pw�Է¸޼ҵ�
	public String inputPw() {
		String newPw;
		Boolean flog=false;
		
		while(true) {
			newPw = inData("�Ϲݻ���� pw�� �Է��Ͻÿ�(5��������)=");
			if(newPw.equals("")){
				System.out.println("�ѱ��� �̻��Է����ּ���");
				flog = false;				
						
			}else if(newPw.length()>5){						
				System.out.println("�Է� ������ pw ���� ���� �ʰ��Ͽ����ϴ�");
				flog = false;
			}
			else{
				
				flog = true;	
				break;
			}
		}		
		return newPw;	
			
	}
	//�̸��Է¹޴¸޼ҵ�	
	public String inputName() {
		String newName;
		Boolean flog=false;
		
		while(true) {
			newName = inData("�Ϲݻ���� �̸��� �Է��Ͻÿ�(2�����̻�)=");
			
			if(newName.length()==0){
				System.out.println("�Ϲݻ���� �̸��� �Է��Ͻÿ�=");
				flog = false;				
			}else if(newName.length()>0 && newName.length()<2){						
				System.out.println("2�����̻� �Է����ּ���");
				flog = false;
			}else {
			
				flog =true;	
				break;
			}
		}		
		return newName;				
		}
		
	//��ȭ��ȣ �޹�ȣ 4��
	public String inputTel() {
		String newTel;
		Boolean flog=false;
		
		while(true) {
			newTel = inData("�Ϲݻ���� �ڵ��� ���ڸ���ȣ 4���ڸ� �Է��Ͻÿ�=");
			if(newTel.length()==0){
				System.out.println("4���ڸ� �Է����ּ���");
				flog = false;	
			}else if(newTel.length()<4){						
				System.out.println("4���ڸ� �Է����ּ���");
				flog = false;
			}else if(newTel.length()>4){						
				System.out.println("�Է� ������ ���� ���� �ʰ��Ͽ����ϴ�");
				flog = false;	
			}else {				
				flog =true;	
				break;
			}
		}		
		return newTel;				
		
	}	

	public String inData(String msg) {
		System.out.print(msg);
		return scan.nextLine();
	}

}