import java.util.Scanner;
class  DoWhileEx
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int option=0;
			do{
			System.out.print("�ݾ��� �Է��ϼ���.?");
			int data = scan.nextInt();
		
			while(true){
			
			int a = data/50000 ;
			System.out.println("50000�� ="+a+"��");

			int b = data-a ;
			int c = b/10000 ;
			System.out.println("10000��="+c+"��");

			int d =data-50000*a-10000*c;
			int e = d/5000;
			System.out.println("5000��="+e+"��");

			int f = data-50000*a-10000*c-5000*e;
			int g = f/1000;
			System.out.println("1000��="+g+"��");

			int h = f-1000*g;
			int i = h/100 ;
			System.out.println("10��="+i+"��");

			int j = h-100*i;
			int k =j/10;
			System.out.println("10��="+k+"��");

			if(data==0)
				break;
			}
		System.out.print("�ٽ� �Ͻðڽ��ϱ�?(1.��, 2.�ƴϿ�)");
		option = scan.nextInt();
		}while(option==2);

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