import java.util.Scanner;
class Ex04_if
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
        
		//1.�����Է�
		int kor=0, eng=0, math=0;
		System.out.print("����=");
		kor = scan.nextInt();
		System.out.print("����=");
		eng = scan.nextInt();
		System.out.print("����=");
		math = scan.nextInt();

		//2.���

		int add = kor+eng+math;
		System.out.printf("����=%d\n",add);
		double ave =add/3.;             
		System.out.printf("���=%.2f\n", ave);     
        
		// String,char
		double a = 0;
		if(ave>=90 && ave<100){
			System.out.println("����=A");
		}else if(ave>=80 && ave<89){
			System.out.println("����=B");

		}else if(ave>=70 && ave<79){
			System.out.println("����=C");

		}else if(ave>=60 && ave<69){
			
			System.out.println("����=D");
		}else if(ave >=0 && ave<59){
			
			System.out.println("����=F");
		}
	}
}

/*
        int total = kor + eng +math
		double avg = total/3


        char grade ='F'; 
		if(avg>=90){
		     grade ='A';
		}else if(avg>=80){
			 grade='B';
		}else if(avg>=70){
			grade='C';
		}else if(avg>=60){
			 grade='D';
		}
		
		System.out.printf("����=%d\n���=%2f\n����=%c\n", total,avg,grade);
*/
			
/*
           ����,����,���������� �Է¹޾� ����,���,������ ���Ͽ� ����϶�.
		   �������� ������ 0~100�� ������ ���̴�.
		   ����� �Ǽ��� ���Ѵ�.


		   ����
		   90~100 A
		   80~89 B
		   70~79 C
		   60~69 D
		   0~59  F

		   ����
		   ����=
		   ����=
		   ����=
		   ===================
		   ����=
		   ���=
		   ����=

*/
