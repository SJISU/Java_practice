import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

import Boinfor.BoDataSet;
import Boinfor.BooVO;

public class BoManager {
	Scanner scan = new Scanner(System.in);
	String menuTitle ="�޴�[1.������ü���, 2.�����˻�, 3.�����뿩, 4.�����ݳ�, 5.����]";
	
	public BoManager() {
		
	}

	public void BoProcessStart() {
		allBooList();
		do {
			//�޴��Է¹���
			String menu= inData(menuTitle); //1~5�߿� �ϳ� �Է�
			if(menu.equals("1")) {//��ü�������
				allBooList(); //
				
			}else if (menu.equals("2")){//�����˻�
				allBooList();
			}else if(menu.equals("3")) {//�����뿩
				allBooList();
			}else if(menu.equals("4")) {//�����ݳ�
				allBooList();
			}else if(menu.equals("5")) {//����
				System.exit(0); // �̰� ������ ���α׷� ����...
			}else {
				System.out.println("�޴��� �߸������Ͽ����ϴ�. �ٽ� �Է��ϼ���");
				
			}			
			
		}while(true);
	}

	
	
	
	
	
	
	
	
	//������ü������
	public void allBooList() { //���� �޼ҵ忡�� �̸޼ҵ� �ҷ���
		//�������
		BooVO.titlePrint();//������
		
		Collection<BooVO> list =BoDataSet.booList.values();
		Iterator<BooVO> ii =list.iterator();
		while(ii.hasNext()) {
			BooVO vo = ii.next();
			vo.BooPrint();
		}
	}
	
	
	
	
	
	
	public String inData(String msg) {
		System.out.println(msg+"->");
		return scan.nextLine();
	}	
	
}