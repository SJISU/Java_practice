import java.util.Scanner;
class  Ex01
{
	public static void main(String[] args) 
	{
		//1. 데이터 얻어오기
		Scanner input = new Scanner(System.in); //스캐너를 쓰려면 패키지가 다르기때문에 import 해줘야한다.
		
		System.out.print("정수=");
		int n1 = input.nextInt();
		System.out.print("정수=");
		int n2 = input.nextInt();


		//2.계산 : 누가 큰지 알아야 하니깐-비교연산자이용
        int result = (n1>n2)? n1 : n2;
		
		//3.출력
		System.out.println(n1+"과"+n2+"중에 큰값은"+result+"입니다");
	   
		
	}
}
/*
   문제만들기 :  두수를 입력받아 큰값을 출력하라.
*/