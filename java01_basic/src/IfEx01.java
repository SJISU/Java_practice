import java.util.Scanner;
class IfEx01 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);

		//1.�������Է� 
		// int first=0, second=0, add=0,minus=0,mul=0,divide=0; ��� �س����� �ڿ� int �Ⱥ��̰� 
		System.out.print("ù��° ����=");
		int num1 = scan.nextInt();
		System.out.print("�ι�° ����=");
		int num2 = scan.nextInt();
        
		 //2.���
		if(num1>0 && num2>0){

			int add = num1 + num2;
			int minus = num1-num2;
			int multiple= num1*num2;
			int divide= num1/num2;
			//3. ���
			System.out.println("add="+add); //printf("%5d+%5d=%5d\n",num1,num2,add)
			System.out.println("minus="+minus); //printf(%5d-%5d=%5d\n",num1,num2,minus)
			System.out.println("multiple="+multiple);//printf
			System.out.println("divide="+divide); //printf
		
		}else{
			System.out.println("�����͸� �߸��Է��Ͽ����ϴ�.");

		}
		}

	
		
}
/*
   �μ��� �Է¹޾� �Է¹��� ��� ���� ����϶��� ��Ģ������ �� ����� ����ϰ�
   �μ� ��� ����� �ƴҶ��� "�����͸� �߸��Է��Ͽ����ϴ�."��� �޼����� ����϶�
*/