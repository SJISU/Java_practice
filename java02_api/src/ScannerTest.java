
import java.util.Scanner;

class  ScannerTest
{
	public static void main(String[] args) 
	{
		// Scanner : 콘솔에서 정수 또는 문자 실수등을 입력받는 클래스
		//1. 객체를 생성
		//        레퍼런스변수
		Scanner scan = new Scanner(System.in); //scan은 변수,데이터타입이 스캐너형, 클래스로 선언되어있는변수는 래퍼런스변수
                                               // new 가 객체를 만든걱다,scan이 객체명

		//2. 값입력받는 메소드를 호출한다.
		//   객체명.메소드()
		//   nextInt(): 정수가 입력됨, nextDouble() : 실수가 입력, next() : 1개의 단어가 문자열로 입력
		//   nextLine() : 한줄이 문자열로 입력됨
		System.out.print("첫번째 정수->");//System.out.println("첫번째 정수->");
		int num =Integer.parseInt(scan.nextLine());//int num = scan.nextInt() ; //콘솔에서 사용자가 정수(데이터)를 받고 입력하기까지 멈춰서 있음 엔터치면 다음줄로 내려감 

		System.out.print("두번재 정수->");//System.out.println("두번재 정수->");
		int num2 =Integer.parseInt(scan.nextLine());//int num2 = scan.nextInt();

		int sum = num + num2;
		int minus = num - num2;
		int multiple = num * num2;
		int devide = num / num2;
		System.out.println("sum="+sum);
		System.out.println("minus="+minus);
		System.out.println("multiole="+multiple);
		System.out.println("devide="+devide);
		
		System.out.print("이름");  //**문자 생기면 위에 scan.nextInt() ;  ->Integer.parseInt(scan.nextLine());
		String name = scan.nextLine();

	

	}
}
