import java.util.Scanner;
class Ex04_if
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
        
		//1.점수입력
		int kor=0, eng=0, math=0;
		System.out.print("국어=");
		kor = scan.nextInt();
		System.out.print("영어=");
		eng = scan.nextInt();
		System.out.print("수학=");
		math = scan.nextInt();

		//2.계산

		int add = kor+eng+math;
		System.out.printf("총점=%d\n",add);
		double ave =add/3.;             
		System.out.printf("평균=%.2f\n", ave);     
        
		// String,char
		double a = 0;
		if(ave>=90 && ave<100){
			System.out.println("학점=A");
		}else if(ave>=80 && ave<89){
			System.out.println("학점=B");

		}else if(ave>=70 && ave<79){
			System.out.println("학점=C");

		}else if(ave>=60 && ave<69){
			
			System.out.println("학점=D");
		}else if(ave >=0 && ave<59){
			
			System.out.println("학점=F");
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
		
		System.out.printf("총점=%d\n평균=%2f\n학점=%c\n", total,avg,grade);
*/
			
/*
           국어,영어,수학점수를 입력받아 총점,평균,학점을 구하여 출력하라.
		   각과목의 점수는 0~100점 사이의 값이다.
		   평균은 실수를 구한다.


		   학점
		   90~100 A
		   80~89 B
		   70~79 C
		   60~69 D
		   0~59  F

		   실행
		   국어=
		   영어=
		   수학=
		   ===================
		   총점=
		   평균=
		   학점=

*/
