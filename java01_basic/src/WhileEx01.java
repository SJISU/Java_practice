import java.util.Scanner;
class  WhileEx01
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);

		System.out.print("�����Է�=");
		int dataInt = scan.nextInt();

		
		int i =1;
		int sum=0, evensum=0 ,oddsum=0 ,threesum=0;
		
		while(i<=dataInt){
           
		   //��
		   sum = sum+i;
		   //¦����,Ȧ����
		   if(i%2==0){
				evensum= evensum+i;
		   }else {
				oddsum=oddsum+i;
		   }
		   //3�ǹ����
		   if(i%3==0){
				threesum+=i;
		   }

		   i++; // �ٽ� 15���� �ٷ�
			

		}
		System.out.printf("1~%d������ ���� %d\n",dataInt,sum);
		System.out.printf("1~%d������ Ȧ���� ����%d\n",dataInt,oddsum);
		System.out.printf("1~%d������ ¦���� ����%d\n",dataInt,evensum);
		System.out.printf("1~%d������ 3�ǹ���� ����%d\n",dataInt,threesum);
		System.out.println();
	}	
	
	}



/*
������ ��(����)�� �Է¹޾� �� ������ �հ�, ¦����,Ȧ����, 3�ǹ���� ���� ���Ͽ� ����϶�.
�ݵ�� �ݺ����� while���� Ȱ���϶�.

����
�����Է�=15
1~15������ ���� _____
1~15������ Ȧ���� ���� _____
1~15������ ¦���� ���� _____
1~15������ 3�� ����� ����_______


*/
