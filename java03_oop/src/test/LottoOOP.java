package test;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class LottoOOP {
	Random random = new Random();
	Scanner scan = new Scanner(System.in);
	public LottoOOP() {
		
	}
	//1���� �����
	//���ʽ�����,�ߺ�üũ ���⼭
	public int[] lottoCreate() {
		int lotto[] = new int[7]; //�̹迭�� �ζ�ũ���� �޼ҵ� �ȿ��� ���������� ����
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
			System.out.print("����Ͻðڽ��ϱ�(y:�� , n:�ƴϿ�)?");
			String qa =  scan.nextLine();
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
			System.out.print("���Ӽ�=");
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
		}while(true);
	}
	
	
	
	public static void main(String[] args) {
		LottoOOP oop = new LottoOOP();
		oop.lottoStart();
		
	}

}

//1���Ӹ޼ҵ常��� -> �ߺ��˻�޼ҵ常��� -> �ٽð��Ӹ޼ҵ�οͼ� �ߺ��˻�޼ҵ忡������� i�� �ֱ�..
//��� -> ��ӿ���Ȯ�� ->lottostart���� ���Ӽ��Է¹޾� �����ϴ°� �����

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
