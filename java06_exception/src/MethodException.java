import java.util.Scanner;

public class MethodException {

	public MethodException() throws ArithmeticException , NumberFormatException{
		start();
	}
	
	public void start() throws ArithmeticException , NumberFormatException{
		Scanner scan = new Scanner(System.in);
		System.out.print("정수입력=");
		int n = Integer.parseInt(scan.nextLine()); //----인트로 바꿀때 오류날수있다...//j-> n->0 예외
		plus(150,n);
	}
	
	public void plus (int i, int j) throws ArithmeticException {
		int result = i+j;
		System.out.println(i+"+"+j+"="+result);
		devide(i,j); 								
	}
	
	public void devide(int i,int j) throws ArithmeticException  { //******** 예외가 발생하면 여기로오고 throw는 메소드밖으로 던져버림
																 // int i.j가 오류이면 19줄{ devide(i,j) }이 문제---->저 메소드에는 써야함
																//여기먼저 throw쓰고 그다음 위에 메소드가 쓰고잇으믈 위에 메소드에도 throws써준다....
																//쭉죽 위에 써주고 아래 메인에도 써준다
		int result=i/j;						//-----------0이오면예외				
		System.out.println(i+"/"+j+"="+result);
	}
	

	public static void main(String[] args)  {
		try {	
		MethodException me = new MethodException();
		
	}catch(Exception e) {
		System.out.println("에러가 발생하였습니다----->"+e.getMessage());
	}
	}

}
