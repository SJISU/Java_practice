import java.util.Scanner;
class  Ex01
{
	public static void main(String[] args) 
	{
		//1. ������ ������
		Scanner input = new Scanner(System.in); //��ĳ�ʸ� ������ ��Ű���� �ٸ��⶧���� import ������Ѵ�.
		
		System.out.print("����=");
		int n1 = input.nextInt();
		System.out.print("����=");
		int n2 = input.nextInt();


		//2.��� : ���� ū�� �˾ƾ� �ϴϱ�-�񱳿������̿�
        int result = (n1>n2)? n1 : n2;
		
		//3.���
		System.out.println(n1+"��"+n2+"�߿� ū����"+result+"�Դϴ�");
	   
		
	}
}
/*
   ��������� :  �μ��� �Է¹޾� ū���� ����϶�.
*/