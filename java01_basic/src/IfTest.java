import java.util.Scanner;
class IfTest 
{
	public static void main(String[] args) 
	{
		// ����� �Է¹޾� ¦���϶� ��� �ƴϸ� ����������ƶ�
		 //����� �Է¹޾� 3�ǹ���϶� ��� �ƴϸ� ����������ƶ�
	   Scanner scan = new Scanner(System.in);
       
	   System.out.print("0���� ū ������ �Է��ϼ���...");
	   int num = scan.nextInt();

	   //if(num%2 == 0){
	   //if(num/2 == num/2.0){
	   if(num%3 == 0){ //3�ǹ��
		// if(num/3 != num/3.0){ //3�ǹ���� �ƴҶ�
		  
		  //System.out.printf("%d�� ¦���Դϴ�.\n", num);
		    System.out.printf("%d�� 3�� ��� �Դϴ�.\n", num);


	   }

	   System.out.println("End....");



		
		
		//int a = 100+200;
		//if(true){ //if(a>0)
		//System.out.printf("���ǹ� ���� ������ �����..."); // if(a+b) : ������ �ƴϱ� ������ ����
		//}

	}
}


/*

   if��
   ���ǹ��� �ݵ�� ����(��,����)������� �Ѵ�.

   if(���ǹ� or ���� or ���� or ���){
	   ���϶� ������ ���๮;
	   ���๮;
	   ���๮;

    }

	*/