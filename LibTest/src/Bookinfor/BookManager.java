
package Bookinfor;
import Login.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;



public class BookManager {
	Scanner scan = new Scanner(System.in);
	Calendar now = Calendar.getInstance();
	String menuTitle = "[  1.������ü���    2.�����˻�    3.�����뿩    4.�����ݳ�     5.�α׾ƿ�     6.����   7.ó���޴��� ���ư��� ]";
	String adminTitle = "[  1.������ü���  2.�����߰�  3.��������  4.ȸ����ü���  5.ȸ���߰�  6.ȸ������  7.����  8.ó���޴��� ���ư��� ]";
	
	public BookManager() {
		
	}
	//�����ڷα��� or ����ڷα���	
	public void selectUser(){
		try {
			do {
				System.out.print("[1.������ 2.�Ϲݻ����] -> ");
				int num = Integer.parseInt(scan.nextLine());		
				switch(num) {		
				case 1:
					 adminStart();
					 break;
				case 2:
					 bookStart();
					 break;	
				default:
					System.out.println("�޴��� �߸������Ͽ����ϴ�. �ٽ� �Է��ϼ���");			
				}	
			}while(true);	
		}catch(NumberFormatException e) {
			System.out.println("�ٽ� �޴��� �����ϼ���");
			selectUser();
		}
	}	

	//�����ڷα���
	public void adminStart() {
		boolean logResult = false;
		String adminid;
		String adminpw;
		
		do{
			adminid = inData("������ id="); 
			adminpw = inData("������ pw="); 			
			
			Login log =new Login(); 
			logResult = log.loginCheck(adminid,adminpw);	
		}while(!logResult);
		
		
		BookDataSet.basicBoSet(); 
		Login.basicLoSet();
		adMINProcessStart();		//�����ڸ޴�
	}		
	
	// ������ �޴�
	public void adMINProcessStart() {
		
		do {	
			System.out.println("[ ������ �޴� ]");//7,8�����̳��߰�---->�����ϳ� "������"�� �޴��̸� �ٲٱ�
			String menu = inData(adminTitle);
			if (menu.equals("1")) {// ��ü�������
				allBookList(); //

			} else if (menu.equals("2")) {// �����߰�
				bookInsert();
				allBookList();
			} else if (menu.equals("3")) {// ��������
				bookDelete();
				allBookList();
			} else if (menu.equals("4")) {// ��üȸ�����
				 allUserPrint();
			} else if (menu.equals("5")) {// ȸ���߰�
				memberInsert();
				allUserPrint();
			}else if (menu.equals("6")) {// ȸ������
				 memberDelete();
				 allUserPrint();
			} else if (menu.equals("7")) {// ����
				System.exit(0);
							
			} else if (menu.equals("8")) {//�����ڷα׾ƿ�-ó�����ε��ư���
				
				selectUser();
			
			}else {
				System.out.println("�޴��� �߸������Ͽ����ϴ�. �ٽ� �Է��ϼ���");	
			}

		} while (true);
	}
	
	//�����߰�
	public void bookInsert() {
		
		BoVO vo = new BoVO();
		
		vo.setName(input("�߰��� å�̸��� �Է��Ͻÿ�="));
		vo.setWriter(input("�߰��� å�� ���ڸ��� �Է��Ͻÿ�="));
		
		vo.setCheck(inputCheck());//inData �Է¹ޱ����� 
		
		
		vo.setCate(input("�߰��� å�� û����ȣ�� �Է��Ͻÿ�="));
		vo.setDate(inData("�߰��� å�� �ݳ�������="));
		
		BookDataSet.boList.put(vo.getName(), vo); 
		System.out.println("������ ������Ͽ� �߰��Ǿ����ϴ�");
	}

	//����x�Է¸޼ҵ�
	public String input(String msg) {
		Boolean flog=false;
		String out;
		
		while(true) {
			out = inData(msg);
			if(out.length()<=0) {
				System.out.println("�ѱ��� �̻��Է����ּ���");
				flog = false;				
			}else {
				flog = true;	
				break;
			}		
		}return out;		
	}	
	//check�Է¹޴� �޼ҵ�--->���Ⱑ�� , ����Ұ��� �ܴ̿� x
	public String inputCheck(){		
		final String a="���Ⱑ��";
		final String b="����Ұ�";
		String data;
		Boolean flog=false;
		while(true){
			System.out.println("������ ���ɿ��θ� �Է����ּ���[���Ⱑ��,����Ұ�]=");
			data=scan.nextLine();
			if(data.equals(a))
			{
				data=a;
				flog = true;
				break;
			}
			else if(data.equals(b))
			{
				data=b;
				flog = true;
				break;
			}
			else
			{
				System.out.println("�߸��Է��ϼ̽��ϴ�");
				System.out.println("�ٽ� �Էº�Ź�帳�ϴ�");
				flog = false;
			}
				}
		return data;
	}	
 
	

	//��������
	public void bookDelete() {	
		

		while(true) {
			
			String delName = inData("������ å�̸��� �Է��Ͻÿ�=");	
			
			if(!BookDataSet.boList.containsKey(delName)) {
				System.out.println("---�˻� ��� ������ �����ϴ�---");	
			}else if(delName.length()==0) {			
				System.out.println("�ѱ��� �̻��Է����ּ���");			
			}else {
				BookDataSet.boList.remove(delName);
				System.out.println("������ �����Ǿ����ϴ�");
				break;
			}		
		 }
	}
	
	
	//��üȸ�����
	public void allUserPrint(){
		
		Collection<LogVo> values =Login.lo.values();
		Iterator<LogVo> ii =values.iterator();
		
		LogVo.userTitlePrint();
		
		boolean falg = false;
		
		if(ii.hasNext()==falg){			
			System.out.println("��ϵ� ȸ�������� �����ϴ�");		
		}else{	
			while(ii.hasNext()) {
				LogVo vo = ii.next();				
				vo.userPrint();
			}		
		}
	}
	//ȸ���߰�
 	public void memberInsert(){
 		LogVo vo = new LogVo();
 		
		String id =inputId2();
		vo.setId(id);
		String pwd =inputPw2();
		vo.setPwd(pwd);
		String name =inputName2();
		vo.setName(name);
		String tel=inputTel2();
		vo.setTel(tel);
		System.out.println("---ȸ�������� �Ϸ�Ǿ����ϴ�---");								
		
		Login.lo.put(id, vo);
 	}
 	
 	//===========================================================================================
 		//id�Է¸޼ҵ�
 		public String inputId2() {
 			String newId;
 			Boolean flog=false;
 			while(true){
 				
 				newId = inData("�߰��� ����� id�� �Է��Ͻÿ�(5���� ����)=");			
 				if(newId.equals("")){
 					System.out.println("�ѱ��� �̻��Է����ּ���");
 					flog = false;				
 				}
 				else if(newId.length()<=5 && Login.lo.containsKey(newId)){				
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
 		public String inputPw2() {
 			String newPw;
 			Boolean flog=false; 			
 			while(true) {
 				newPw = inData("�߰��� ����� pw�� �Է��Ͻÿ�(5��������)=");
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
 		public String inputName2() {
 			String newName;
 			Boolean flog=false; 			
 			while(true) {
 				newName = inData("�߰��� ����� �̸��� �Է��Ͻÿ�(2�����̻�)="); 				
 				if(newName.length()==0){
 					System.out.println("2�����̻� �Է����ּ���");
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
 			
 		//��ȭ��ȣ �޹�ȣ 4�ڸ�
 		public String inputTel2() {
 			String newTel;
 			Boolean flog=false; 			
 			while(true) {
 				newTel = inData("�߰��� ����� �ڵ��� ���ڸ���ȣ 4���ڸ� �Է��Ͻÿ�=");
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

	//ȸ������
	public void memberDelete() {
		while(true) {
			String memId = inData("������ �Ϲݻ���� id�� �Է��Ͻÿ�=");
			if(!Login.lo.containsKey(memId)) {
				System.out.println("��ϵ� id�� �����ϴ�.");
				
			}else if(Login.lo.containsKey(memId)){
				 		
				Login.lo.remove(memId);
				System.out.println("---ȸ������ �Ϸ�Ǿ����ϴ�.---");
				break;
			}		
		}			
	}

	//�Ϲݻ���ڼ��� - ȸ������,�α���
	public void bookStart() {
		Login.basicLoSet(); 
		Login b = new Login();					
		b.logStart(); //�α��θ޴����̽���			
				
		BookDataSet.basicBoSet();
		
		BoProcessStart();//�Ϲݻ���� �޴���Ϻҷ���
	}
	

	//�Ϲݻ���� �޴�
	public void BoProcessStart() {  //========5,6,7����---> �����ϳ� "������"�� �޴��̸� �ٲٱ�
		
		do {
			System.out.println("[�Ϲݻ���� �޴�]");
			String menu = inData(menuTitle);
			if (menu.equals("1")) {// ��ü�������
				allBookList(); //

			} else if (menu.equals("2")) {// �����˻�
				bookSearch();
			} else if (menu.equals("3")) {// �����뿩
				bookBorrow();
			} else if (menu.equals("4")) {// �����ݳ�
				bookBack();
			} else if (menu.equals("5")) {//�α׾ƿ�
				bookStart();							
			} else if (menu.equals("6")) {//����
				System.exit(0);			
			}else if (menu.equals("7")) {//ó�����γ�����
				selectUser();
			}else {
					System.out.println("�޴��� �߸������Ͽ����ϴ�. �ٽ� �Է��ϼ���");	
			}				
		} while (true);
	}
	
	// ������ü��� ���
	public void allBookList() {
		
		BoVO.titlePrint();

		Collection<BoVO> list = BookDataSet.boList.values();
		Iterator<BoVO> ii = list.iterator();
		
		while (ii.hasNext()) {
			BoVO vo = ii.next();
			
			BoVO.boVOPrint(vo);
		}
	}
	

	// �����˻�
	public void bookSearch() {
		do {			
			try {
				
				String b1 = inData("�˻��� å�̸�="); 				
				BoVO b2 = BookDataSet.boList.get(b1); 
				System.out.println(b2.toString());
				break; 
			}catch(Exception e) {
				System.out.println("---�˻� ��� ������ �����ϴ�---");
				//break; 
			}			
		}while(true);	
	}

	// �����뿩
	public void bookBorrow() {
		do {				
			try {			
				String b1 = inData("�뿩�� å �̸�=");
				// key���� b1�ǵ�����check =����Ұ��̸� å ������-> �Ұ��Ѵٴ� �޽��� �߰���
				// ���Ⱑ���̸� å ���������� -> �뿩�Ϸ� ��� �޽��� �߰���				
				
				BoVO b2 = BookDataSet.boList.get(b1);
				String b3 = b2.getCheck();
			
				if (b3.equals("����Ұ�")) {
					System.out.println("�뿩 �Ұ��� å �Դϴ�");
					//break; 
				} else {
					System.out.println("---�뿩�� �Ϸ�Ǿ����ϴ�---");
					checkUpdate(b1); //�뿩�ϰ� ���� check ���� ����Ұ��� �ٲ��..
					dateUpdate(b1); //�뿩�ϰ� ���� ���Ⱑ�ɳ�¥�ٲ��...
					break;				
				} 
			}catch(Exception e) {
				System.out.println("---�˻� ��� ������ �����ϴ�---");
				//break;
			}
		}while(true);	
			
	}
	
	//------------> �ϳ��� �޼ҵ�� ������...............
		//check-������¼���
		public void checkUpdate(String name) {
			String check = "����Ұ�";
			
			BoVO vo = BookDataSet.boList.get(name);
			vo.setCheck(check);
		}
		//check-������¼���
		public void checkUpdate2(String name) {
			String check = "���Ⱑ��";
			
			BoVO vo = BookDataSet.boList.get(name);
			vo.setCheck(check);
		}
		//check-������ �뿩���ɳ�¥����
		public void dateUpdate(String name){			
			Date date = new Date();
			now.setTime(new Date()); //���糯¥�ҷ���
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); //��¥���Ĺٲ���
			
			now.add(Calendar.DATE, +14); //���÷κ��� 14��������
			
			String da=df.format(now.getTime());
			
			BoVO vo = BookDataSet.boList.get(name);
						vo.setDate(da);
		}
		//check-�ݳ��� �뿩���ɳ�¥����
		public void dateUpdate2(String name) {
			String check = "";
			
			BoVO vo = BookDataSet.boList.get(name);
			vo.setDate(check);
		}
	

	//�����ݳ�
	public void bookBack() {
		do {	
			try {
				String b1 = inData("�ݳ��� å �̸�=");
				BoVO b2 = BookDataSet.boList.get(b1); 
				String b3 = b2.getCheck();
				
				if (b3.equals("����Ұ�")) {
					System.out.println("---�ݳ��� �Ϸ�Ǿ����ϴ�---");
					checkUpdate2(b1); //�ݳ��Ϸ��ϰ����� check���� �����Ǿ����...
					dateUpdate2(b1); //�ݳ��Ϸ��ϸ� �뿩���ɳ�¥����
					break;		
				} else if(b3.equals("���Ⱑ��")){
					System.out.println("�ݳ��Ұ��� å�Դϴ�");	
					
					//break;		
				} 
			}catch(Exception e) {
				System.out.println("---�˻� ��� ������ �����ϴ�---");
				//break; 
			}
		}while(true);
	}

	// �ֿܼ��� ���ڿ� �Է¹޴� �޼ҵ�
	public String inData(String msg) {
		System.out.print(msg);
		return scan.nextLine();
	}

}