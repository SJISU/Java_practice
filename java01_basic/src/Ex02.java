import java.util.Scanner;
class Ex02 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� ���� �Է�=");
		int data = sc.nextInt();

		
		//String number = (n1>=100 && n1<=200)? "n1": "0" ;
		int result = (data>=100 && data<=200)? data : 0 ;
		
		System.out.println("result="+result);


		
	}
}
/*
������ ���� �Է¹޾� �Է¹��� ���� 100~200�����̸� �Է¹������� ����ϰ�
                          �ƴϸ� 0�� ����϶�.
						  */