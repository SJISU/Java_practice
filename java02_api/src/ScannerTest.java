
import java.util.Scanner;

class  ScannerTest
{
	public static void main(String[] args) 
	{
		// Scanner : �ֿܼ��� ���� �Ǵ� ���� �Ǽ����� �Է¹޴� Ŭ����
		//1. ��ü�� ����
		//        ���۷�������
		Scanner scan = new Scanner(System.in); //scan�� ����,������Ÿ���� ��ĳ����, Ŭ������ ����Ǿ��ִº����� ���۷�������
                                               // new �� ��ü�� ����ƴ�,scan�� ��ü��

		//2. ���Է¹޴� �޼ҵ带 ȣ���Ѵ�.
		//   ��ü��.�޼ҵ�()
		//   nextInt(): ������ �Էµ�, nextDouble() : �Ǽ��� �Է�, next() : 1���� �ܾ ���ڿ��� �Է�
		//   nextLine() : ������ ���ڿ��� �Էµ�
		System.out.print("ù��° ����->");//System.out.println("ù��° ����->");
		int num =Integer.parseInt(scan.nextLine());//int num = scan.nextInt() ; //�ֿܼ��� ����ڰ� ����(������)�� �ް� �Է��ϱ���� ���缭 ���� ����ġ�� �����ٷ� ������ 

		System.out.print("�ι��� ����->");//System.out.println("�ι��� ����->");
		int num2 =Integer.parseInt(scan.nextLine());//int num2 = scan.nextInt();

		int sum = num + num2;
		int minus = num - num2;
		int multiple = num * num2;
		int devide = num / num2;
		System.out.println("sum="+sum);
		System.out.println("minus="+minus);
		System.out.println("multiole="+multiple);
		System.out.println("devide="+devide);
		
		System.out.print("�̸�");  //**���� ����� ���� scan.nextInt() ;  ->Integer.parseInt(scan.nextLine());
		String name = scan.nextLine();

	

	}
}
