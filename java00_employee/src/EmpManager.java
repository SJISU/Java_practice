import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

import Empinfor.EmpDataSet;
import Empinfor.EmpVO;

public class EmpManager { //��������ϴ�Ŭ����
	Scanner scan = new Scanner(System.in);
	String menuTitle ="�޴�[1.�����ü���, 2.����߰�, 3.�������, 4.�������, 5.����]";
	
	public EmpManager() {
		
	}
	
	public void employeeStart() {
		
		boolean logResult = false;
		do{//�α���-���н� �ٽý���
			String userid = inData("���̵�"); //
			String userpwd = inData("��й�ȣ"); // �״��� ����������� �������ִ� �����ͿͰ����� Ȯ���Ͽ� �α��ν�����
											   //loginŬ������ ���� ������ ���̵����� �´��� Ȯ�ε�
			Login log =new Login(); //�޼ҵ� �������ؼ� ��ü����
			logResult = log.loginCheck(userid,userpwd);	
		}while(!logResult);
		
		//�α��� �����ϸ� ���°�
		//System.out.println("�α��μ���");
		//����� �⺻���� ����
		EmpDataSet.basicEmpSet(); //��ĳ���� �ٸ��� ����Ʈ
		
		allEmpList(); //�����ü������	
		EmpProcessStart();//�޴���� �ҷ���....
	}	
	
	//�޴�
	public void EmpProcessStart() {
		do {
			//�޴��Է¹���
			String menu= inData(menuTitle); //1~5�߿� �ϳ� �Է�
			if(menu.equals("1")) {//��ü������
				allEmpList(); //
				
			}else if (menu.equals("2")){//����߰�->��������Է¹޾ƾ���...->�Է¹޾Ƽ� EmpVO�� ��´�...->list���߰�
				empInsert();
				allEmpList(); //�߰������Ȯ��
			}else if(menu.equals("3")) {//�������
				empUpdate();
				allEmpList(); //���������Ȯ��
			}else if(menu.equals("4")) {//�������
				empDelete();
				allEmpList();
			}else if(menu.equals("5")) {//����
				System.exit(0); // �̰� ������ ���α׷� ����...
			}else {
				System.out.println("�޴��� �߸������Ͽ����ϴ�. �ٽ� �Է��ϼ���");
				
			}			
			
		}while(true);
	}
	
	//����߰�->������
	public void empInsert() {
		//1���� ��������� ������ VO��ü �����ϱ�
		EmpVO vo = new EmpVO();
		
		//�����ȣ �Է¹޾Ƽ� vo ������ �ִ´�
		vo.setEmpNo(inData("�����ȣ"));//�����ȣ 
		vo.setEmpName(inData("�����"));
		vo.setTel(inData("����ó"));
		
		do {
			boolean falg = true;
			try {
				vo.setSal(Integer.parseInt(inData("�޿�"))); //-------���ܹ߻����ɼ�
			}catch(NumberFormatException nfe){
				//������ �߻��Ҷ��� ���°�
				falg = false;
				System.out.println("�޿��� ���ڷ� �Է��ϼ���..");
			}
			  //�߻��ϵ���ϵ� �����ǿ��°�
			if(falg) break; 
		}while(true);
		
		vo.setHiredate(inData("�Ի���"));
		
		EmpDataSet.empList.put(vo.getEmpName(), vo);//empListdp�߰�
	}
	
	//�������-����ó,�޿��� ��������
	public void empUpdate() {
		//������ ������ Ȯ��
		String editName = inData("������ ������Է�"); //������������
		
		String editMenu = inData("������ �ǵ弱��[1.����ó, 2.�޿�]");
		if(editMenu.equals("1")) {
			telUpdate(editName); //�޼ҵ忡 �����һ���̸��־ ȣ��
		}else if(editMenu.equals("2")) {
			salUpdate(editName);
		}else {
			System.out.println("�޴��� �߸������Ͽ����ϴ�.");
		}
		///
	}
	//����ó����
	public void telUpdate(String username) {
		String tel = inData("������ ����ó�Է�"); //�����ʹ� empList�� ������ �ű⿡�ԷµǾ��մ� ������ ����//�̸�(key)�� ã�Ƽ� value���� �������´�.
		EmpVO vo= EmpDataSet.empList.get(username); //�� ����� EmpVO�� �ҷ��ͼ� vo�� ����ش�
		vo.setTel(tel);//�Է¹��� tel�� �ٽ� ����
	}	
	//�޿�����
	public void salUpdate(String username) {
		int sal = Integer.parseInt(inData("������ �޿� �Է�"));
		EmpVO vo= EmpDataSet.empList.get(username);
		vo.setSal(sal);
	}
	
	//�������->key�� �������� ����,�����ȣ�������
	public void empDelete() {
		String delName = inData("������ �����");//�����һ�����Է�
		EmpDataSet.empList.remove(delName);		
	}
		
	//�����ü��� ����ϱ�
	public void allEmpList() { //���� �޼ҵ忡�� �̸޼ҵ� �ҷ���
		//�������
		EmpVO.titlePrint();//������
		
		Collection<EmpVO> list =EmpDataSet.empList.values();
		Iterator<EmpVO> ii =list.iterator();
		while(ii.hasNext()) {
			EmpVO vo = ii.next();
			vo.empPrint();
		}
	}
	
	
	//�ֿܼ��� ���ڿ��Է¹޴� �޼ҵ�
	public String inData(String msg) {
		System.out.println(msg+"->");
		return scan.nextLine();
	}



}

//�ֿܼ����Է¹޴� �޼ҵ�-> �����ü������->�޴���ϸ����->����߰�,������� ->
