
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

public class LottoOOP_TreeSet {
	Random random = new Random();
	Scanner scan = new Scanner(System.in);
	
	public LottoOOP_TreeSet() {
		
	}
	//1���� ����� + ���ʽ�����, �ߺ��˻�
	public  void lottoCreate(int i ) { //���Ӽ� i����
		//�ߺ����� , ����
		TreeSet<Integer> lotto = new TreeSet<Integer>();  //--->6�� ---> ������ 1
		
		int num=0; //--->1�� --->������2
		while(lotto.size()<7) {
			//�ζǹ�ȣ����
			num= random.nextInt(45)+1;
			lotto.add(num);
		}	
			//lotto TreeSet��ȣ 7���� �ְ� ,num���� ���������� �����ȣ�� �ִ�
			//���Ե� bonus��ȣ�� �ζǹ�ȣ���� �����. -> TressSet��ȣ 6���� �ִ�.
			lotto.remove(num); //--->lotto����ҿ� �ִ°� �Ѱ� �����...
			
			lottoPrint(i,lotto.toString(),num); // �迭.toString() : �迭���� ���			
		
	}
	

	
	//���
	public void  lottoPrint(int cnt,String lotto, int bonus) {//�Ű������� ���ĵȷζǹ�ȣ�ʿ�...�� �ζǾȿ��� ���ʽ�������
		System.out.print(cnt+"����=");
		System.out.print( lotto);//��ȣ
		System.out.println(", bonus="+bonus);
	}
	
	//��ӿ���Ȯ��
	public boolean yesNo() {
		do {
		
				System.out.print("����Ͻðڽ��ϱ�(y:�� , n:�ƴϿ�)?");														//************��Ʈ���̾ƴ϶� �ٸ��ŵ��������Է¿���
				String qa =  scan.nextLine(); // �Էµ� y,n�� �־��ش�...
				// y:����ϰڴ�(true) n: �����ϰڴ�(false),�׿� �ٽ�--->3����		
				if(qa.equalsIgnoreCase("y") ){ //qa�� ����ִ°��� ��ҹ��ڱ��о��� y�̸�
					return true;
				}else if (qa.equalsIgnoreCase("n")){//qa�� ����ִ°��� ��ҹ��ڱ��о��� n�̸�
					return false;
				}
			
		}while(true); 
	}
	
	//���ο��� ��ü������ ������ų �޼ҵ�..
	public void lottoStart() {
		do {
			try {	
				System.out.print("���Ӽ�=");																			//*****int�ƴ϶� �ٸ��� �������� �Է�
				int game = Integer.parseInt(scan.nextLine());//. Integer ��ü�� ������ �޾Ƽ� int ������ �Ҵ��ϸ� �ڵ����� ����ȯ
				//����
				for(int i=1; i<=game; i++) {
					lottoCreate(i);  //****�Է¹��� ���Ӽ���ŭ �ζ� ����
					
					
				}
				//��ӿ���
				if(!yesNo()) {  //**yesNo()�޼ҵ�
					break;
				}
			}catch(Exception d) {
			System.out.println("Exception~~~>"+d.getMessage());
			}	
		}while(true);
	}
	
	
	
}	

/*
�ζ�	��ȣ :1~45���� ��ȣ6��
		���ʽ� 1��
		
����
���ӽ� = 3
1���� = 5,13,26,32,33,45,���ʽ� 11
2���� = 11,23,26,32,35,41, ���ʽ� 9
3���� = 15,13,26,37,38,42, ���ʽ�23
����Ͻðڽ��ϱ�(1.�� , 2.�ƴϿ�)? 1
���Ӽ� = 5
1���� = 5,13,26,32,33,45,���ʽ� 11
2���� = 11,23,26,32,35,41, ���ʽ� 9
3���� = 15,13,26,37,38,42, ���ʽ�23
1���� = 5,13,26,32,33,45,���ʽ� 11
2���� = 1,23,26,32,35,41, ���ʽ� 27
3���� = 9,13,26,37,38,42, ���ʽ�45
����Ͻðڽ��ϱ�(1.�� , 2.�ƴϿ�)?2
*/
