
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class LottoOOPException2 {
	Random random = new Random();
	Scanner scan = new Scanner(System.in);
	
	public LottoOOPException2() {
		
	}
	
	public int[] lottoCreate() {
		int lotto[] = new int[7]; 										
		for(int i=0; i<lotto.length; i++ ){
			//�ζǹ�ȣ����
			lotto[i]=random.nextInt(45)+1;
			//�ߺ��˻� ȣ��
			i = doubleCheck(lotto,i);
		}
		return lotto;
	}
	
	//�ߺ��˻�
	public int doubleCheck(int lotto[], int i) { //���޹��� ��ġ i            
		for(int j=0; j<i; j++) {			
			if(lotto[i]==lotto[j]) {
				i--;
				break;
			}
		}
		return i;
	}
	
	//���
	public void  lottoPrint(int cnt,int lotto[]) {//�Ű������� ���ĵȷζǹ�ȣ�ʿ�...�� �ζǾȿ��� ���ʽ�������
		System.out.print(cnt+"����");
		System.out.print( Arrays.toString(Arrays.copyOfRange(lotto,0,6)));//��ȣ
		System.out.println(",bonus"+lotto[6]);
	}
	
	//��ӿ���Ȯ��
	public boolean yesNo() {
		do {
			try {
				System.out.print("����Ͻðڽ��ϱ�(y:�� , n:�ƴϿ�)?");														//************��Ʈ���̾ƴ϶� �ٸ��ŵ��������Է¿���
				String qa =  scan.nextLine();
				// y:����ϰڴ�(true) n: �����ϰڴ�(false),�׿� �ٽ�--->3����		
				if(qa.equalsIgnoreCase("y") ){ //qa�� ����ִ°��� ��ҹ��ڱ��о��� y�̸�
					return true;
				}else if (qa.equalsIgnoreCase("n")){//qa�� ����ִ°��� ��ҹ��ڱ��о��� n�̸�
					return false;
				}
			}catch(Exception e) {
				System.out.println("Exception--->"+e.getMessage());
			}
		}while(true); 
	}
	
	//���ο��� ��ü������ ������ų �޼ҵ�..
	public void lottoStart() {
		do {
			try {	
				System.out.print("���Ӽ�=");																			//*****int�ƴ϶� �ٸ��� �������� �Է�
				int game = Integer.parseInt(scan.nextLine());
				//����
				for(int i=1; i<=game; i++) {
					int lotto[]=lottoCreate();  //**lottoCreate() �޼ҵ�
					Arrays.sort(lotto,0,6); //���� ** �޼ҵ�ȸ���� ����...
					lottoPrint(i,lotto);//��� -�޼ҵ� //**lottoPrint()�޼ҵ�
					
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
	
	
	
	public static void main(String[] args) {
		LottoOOPException2 oop = new LottoOOPException2();
		oop.lottoStart();
		
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
