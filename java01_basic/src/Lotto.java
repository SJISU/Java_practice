import java.util.Scanner;
public class Lotto {
	public static void main(String[] args) {
		//�ζ� ��ȣ ������
		Scanner scan = new Scanner(System.in);
		
		do {			
		    System.out.print("���Ӽ�=");
			int data = scan.nextInt();
			
			int[] Lotto = new int[6];
			for(int i =0; i<Lotto.length;i++) {
				int LottoRan = (int)(Math.random()*45)+1;
				Lotto[i]= LottoRan;
				
				/*
				for(int a=0; a<Lotto.length; i++) {
					if(Lotto[a] == Lotto[a+1]){
						Lotto[a] = Lotto[a]+1;					
					}
				}
				*/				
			}
			
			int[] Bonus = new int[1];
			for(int i =0; i<Bonus.length;i++) {
				int BonusRan = (int)(Math.random()*45)+1;
				Bonus[i]= BonusRan;			
			}
			
			for(int a =1; a<=data; a++ ){
				System.out.print(a+"����=");
					
					for(int i=0; i<Lotto.length; i++) {
						System.out.print(Lotto[i]+",");						
					}   System.out.print("���ʽ�"+Bonus[0]);
						System.out.println();				
			}				 				
			
			System.out.print("����Ͻðڽ��ϱ�(1.�� , 2.�ƴϿ�)?");
			int status = scan.nextInt();
			if(status==2)
				break;
		
		
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
