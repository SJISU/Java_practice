import java.util.Scanner;
class  DoWhileEx_2
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);

		do{
			//�ݾ�
			System.out.print("�ݾ��� �Է��ϼ���?");
			int money = scan.nextInt();
			
			//ȭ��
			int cnt = money/50000; //5����
			if(cnt>0){
				System.out.println("50000��="+cnt+"��");
				money = money-cnt*50000;
			}
			
			cnt = money/10000; //1����
			if(cnt>0){
				System.out.println("10000��="+cnt+"��");	
				money = money-cnt*10000;
			}

			cnt = money/5000; //5õ��
			if(cnt>0){
				System.out.println("5000��="+cnt+"��");
				money = money-cnt*5000;
			}

			cnt = money/1000;
			if(cnt>0){
				System.out.println("1000��"+cnt+"��");
				money= money-cnt*1000;
			}


			//����
			System.out.print("����Ͻðڽ��ϱ�(1.��, 2.�ƴϿ�)?");
			int status = scan.nextInt();
			if(status==2)
				break;

			
		}while(true);

		
			
	}
}


/*
����
�ݾ��� �Է��ϼ���.? 126300
50000�� = 2��
10000�� = 2��
5000�� = 1��
1000�� = 1��
100�� = 3��
�ٽ��Ͻðڽ��ϴ�(1.��, 2.�ƴϿ�)?

�ݾ��� �Է��ϼ���.?5435
5000�� = 1 ��
100�� = 4��
10��= 3��
1��=5��
�ٽ��Ͻðڽ��ϴ�(1.��, 2.�ƴϿ�)?

*/