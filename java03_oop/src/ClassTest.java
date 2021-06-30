//package

//필요한 클래스의 위치(패키지명과 클래스명을 정의한다.)
import java.util.Scanner;
import java.lang.String; //compiler가 컴파일과정(자바가상머신)에서 자동으로 import해준다. - 생략가능
import java.util.Random;
import java.util.*; //util안에 있는 모든클래스사용가능하나 권장하지않음

public class ClassTest {
	//멤버영역
	//멤버변수 = 전역변수  -클래서바로밑에 // 지역변수는 메소드안에있는것
	int a = 100;
	String name ="홍길동"; //여기까지 보면 변수가 두개인 클래스,,,
	//멤버변수는 초기값이 자동으로 설정된다.
	//정수(byte, short, int, long) : 0
	//실수 (float,double) : 0.0
	//논리 (boolean) :false
	//문자(char) : 
	//String, Scanner ,Random = null    //객체를 넣은것이 아니고 멤버에서 변수를선언하면 null 이 초기값임
 	int b;
	double c;
	String nameStr; //null
	Scanner scan; //null
	Random ran; //null
	//멤버 영역에서
	//객체생성가능
	Scanner scanner = new Scanner(System.in);
	//실행문은 멤버에서 사용불가
	//System.out.print("콘솔문자 출력하기");
	int k = 100+500; //연산식이라 된것
	// int[]dd=new int[10]; -불가능한
	//dd[3]=200; -불가능한
	
	//생성자 메소드 : 객체를 생성할때 한번 실행되는 메소드
	//				메소드명이 반드시 클래스명과 같아야 한다.
	//				객체 생성시 객체의 데이터를 초기화할수 있다.
	//		 생성자메소드를 구현하지않으면 컴파일시 컴파일러가 
	//		  매개변수가 없는 생성자메소드를 자동으로 추가 해준다.
	//		  ClassTest(){}
	ClassTest(){ //매개변수없음
		b = 1234; //처음에 0으로 만들어졌다가 실행되면 1234로 바뀜
		//실행문
		System.out.println("생성자 메소드가 실행됨........");
	}
	ClassTest(int a){ //매개변수는 int a
		System.out.println(a+"메소드 실행~~~~~~~~~~");		
	} // 여기까지보면 생성자 메소드가 두개가 있는 클래스
	//메소드 : 하나의 실행단위
	//		 클래스를 객체 생성후 메소드를 호출하여야 실행된다.
	// 반환형 메소드명(매개변수,매개변수..){
	// }
	// 메소드명 생성 규칙 :
	//				소문자로 시작한다. 합성어 일때는 두번째 단어에서 부터 첫번째 글자를 대문자로 
	void sum() { //sum이라는 메소드 만든것
		//실행부
		System.out.println("sum()메소드가 실행됨");
	}
	void total(int a, int b) {
		System.out.println("합은"+(a+b));
	}
	//내부클래스도 만들수있다.
	
}
