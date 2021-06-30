import java.util.Scanner;

public class MyExceptionTest {
	Scanner scan = new Scanner(System.in);
	public MyExceptionTest() {
		
	}

	public void start() {
		do {
			//임의의 정수(1~100)사이의 값을 입력받아 그수까지의 합을 구하여 출력하라
			try {
				System.out.print("정수를입력하세요(1~100)---->");
				int max =Integer.parseInt(scan.nextLine()); //문자열을 정수로 바꿔주는 메소드
															//NumberFormatException 예외
				//무조건 합 구하는거 x ---> 1~100 사이인지 확인--->아니면 마이입셉션이라는 예외 발생시킴
				if(max<1 || max>100) {
					//throw : 예외를 강제로 발생시킨다..--메소드에서는s붙어있었음
					throw new MyException(); //********MyException클래스의매개변수없는 생성메소드가 실행  
				}else {						 // ㄴ--->catch문 만들어줌
					sum(max);
				}
				
			}catch(NumberFormatException nfe) {
				System.out.println("숫자를 입력하세요.......");
			
			}catch(MyException me) {
				System.out.println(me.getMessage()); 
			}
		}while(true);
	}
	
	public void sum(int max) {
		int tot=0;
		for(int i=1; i<=max; i++) {
			tot+=i;
		}
		System.out.println("1~"+max+"까지의 합은"+tot);
	}
	
	
	public static void main(String[] args) {
		
		new MyExceptionTest().start(); //객체생성 후 start메소드 호출

	}

}
