import java.util.Scanner;
class  DoWhileEx2
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);

		do{
			//�ݾ�
			System.out.print("�ݾ��� �Է��ϼ���?");
			int money = scan.nextInt(); ///4535120
			
			//ȭ��
			int won = 50000, divide = 5;

			while(money>0){
				int cnt = money/won; //ȭ���� ����
				if(cnt>0){
					System.out.print(won+"��="+cnt);
					if(won>=1000){
						System.out.println("��");
					}else{
						System.out.println("��");
					}
					money=money-cnt*won ;
				}
					won = won / divide; //���� ȭ�����
					// ����ȭ������� ����� ���ؼ� ������ �ϴ°��� �ٲ�ߵ�
					//���� ȭ����� ������ �������� �ٲ���� �Ѵ�.
					if(divide ==5 ){
						divide=2;
					}else{
						divide=5;
					}
					// if(divide==5) divide=2;
					// else divide=5;

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