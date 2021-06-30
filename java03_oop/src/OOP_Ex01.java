import java.util.Scanner;

public class OOP_Ex01 {

	public OOP_Ex01() { //생성자 // new로 객체만들면 실행되는것
		
		//int dan = danInput();
		//String result = gugudan(dan);
		//System.out.println(result);
		
		
		// System.out.println(gugudan(danInput())); //위의 세줄을 한줄로
	}
	//지역변수 scan gugu dan... 지역변수들은 스택에 저장됨...객체화를 시키면 oop라는 변수는...
	//
	
	//단입력받기
	int danInput() {
		Scanner scan = new Scanner(System.in);//scan은 지역변수 //ctrl+스페이스 누르면 import됨
		
		System.out.print("단입력=");
		return scan.nextInt(); //값을 리턴해줌 : 메소드 밖으로 나감
	}
	
	//구구단만들기
	String gugudan(int dan) {
		String gugu =""; //결과를 출력할 지역변수 gugu 선언
		for(int i=2; i<=9; i++) {
			gugu+=dan+"*"+i+"="+dan*i+"\n";
		}
		return gugu;
	}	
	
	void start() {
		int dan = danInput();		
		String result = gugudan(dan);
		System.out.println(result);  //System.out.println(gugudan(dan));
	}
	
	public static void main(String[] args) { //main은 같은 클래스 아님
		OOP_Ex01 oop = new OOP_Ex01(); //객체만듬 //메인메소드
		oop.start();
		//System.out.println(oop.gugudan(oop.danInput()));
		
	}

}
//콘솔에서 단을 입력받아 입력받은 구구단을 찍어라
