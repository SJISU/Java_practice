import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest {
	Scanner scan = new Scanner(System.in);
	
	public ExceptionTest() {		
	}

	public void start() {
		do {
			try {
				//두수를 입력받아 사칙연산하여 출력하라
				System.out.print("첫번째수=");				//String을 넣어주면 int로 출력...
				int n1 = Integer.parseInt(scan.nextLine()); //-----------------------------------------
				System.out.print("두번째수=");
				int n2 = Integer.parseInt(scan.nextLine());//-----------------------------------------          
											//콘솔에서 int가 아닌 데이터를 입력하면 에러가 난다....
				
				int plus = n1+n2;
				int minus = n1-n2;
				int mul = n1*n2;
				int devide = n1/n2;//=========== // Runtime-컴파일에서는 오류가 없으나 실행시에 오류날수있음...
												 //에러가 날수도있고 안날수도있다..컴퓨터는 0으로 나누는것을 만나면 에러가난다..:0를 넣으면 에러가난다
				
				System.out.println(n1+"+"+n2+"="+plus);
				System.out.println(n1+"-"+n2+"="+minus);
				System.out.println(n1+"*"+n2+"="+mul);
				System.out.println(n1+"/"+n2+"="+devide);	
			
				String names[] = {"홍길동","김길동"}; //runtime 예외
				for(int i=0; i<=names.length; i++) {
					System.out.println("names["+i+"]="+names[i]);
				}
				
				
			}catch(InputMismatchException imie) { //임포트해야함,,//정수입력에서 오류난것을 imie에 담아줌--같은오류가 발생하면 다 여기로온다... 
													// 뭐가 에러나는지 궁금하면 변수imie 를 찍어본다...//imie는 익셉션 상속받고있다
													//catch 안에서 모든명령어 실행가능한
					System.out.println("정수를 입력하야여합니다.");
					//imie.printStackTrace(); //에러메시지 찍어줌 
					System.out.println(imie.getMessage()); //윗줄 대신에 getMessage 사용할수도있다-String으로 return해줌
					
			}catch(ArithmeticException ae) { 	
					
					System.out.println("0으로 나눌수 없습니다.");
					//ae.printStackTrace();
					System.out.println(ae.getMessage());//by zero가 찍히긴함
				
			}catch(ArrayIndexOutOfBoundsException aioo) {
					
					System.out.println("배열의 점차값이 잘못되었습니다.");
					System.out.println(aioo.getMessage());
			}catch(NumberFormatException nfe) {
				System.out.println("숫자를 입력하여야 합니다...");
					
			
			}finally {
					//예외발생과 상관없이 무조건 실행됨.
					System.out.println("final이 실행됨...");
			}
		}while(true);
	//catch문 끝남
	//System.out.println("프로그램종료"); //do-while문을 추가한후 쓸모없어짐
	}
	
	
	
	
	public static void main(String[] args) {
		ExceptionTest et = new ExceptionTest();
		et.start();
		//프로그램종료메시지출력후 이곳으로 내려옴 		
	}

}
/*
  		에러 : 하드웨어 에러 처럼 프로그램에서 제어할수 없는 에러를 말한다.
  		예외처리 : 프로그램에서 제어할수있는 에러를 Exception이라고 한다.
  		
  		//1.방법
  		 try{ 
  		 		실행문;
  		 		예외발생할 가능이 있는 명령어 또는 예외발생할 가능성이 없는 명령어를 모두 표기할수 있다.  		 
  		 }catch(예외종류){
  		 		예외가 발생하면 실행할 실행문
  		 }catch(예외종류){
  		 		예외가 발생하면 실행할 실행문
  		 }
  		 :
  		 :
  		 finally{
  		 		예외가 발생하든 안하든 무조건 실행되는 실행문;
  		 		-생략가능하다.
  		 }
  		 
 */

