import java.util.Scanner;

public class OOP_Ex02 {
	//멤버변수-heap에 저장됨
	int dan; //입력받은 단을 저장할 변수 =0;
	String gugu =""; //구구단을 저장할 변수 스트링은 초기값이 null
 
	public OOP_Ex02() { //생성자 // new로 객체만들면 실행되는것
				
	}
	
		
	//단입력받기
	int danInput() {
		Scanner scan = new Scanner(System.in);//scan은 지역변수 //ctrl+스페이스 누르면 import됨
		System.out.print("단입력=");
		return scan.nextInt(); //값을 리턴해줌 : 메소드 밖으로 나감
	}
	
	//구구단만들기
	void gugudan() {
		
		for(int i=2; i<=9; i++) {
			gugu=gugu+dan+"*"+i+"="+dan*i+"\n";
			}		
	}	
	
	void start() {
		dan = danInput();
		gugudan();
		System.out.println(gugu);
		
		
	}
	
	public static void main(String[] args) { //main은 같은 클래스 아님
		OOP_Ex02 oop = new OOP_Ex02(); //객체만듬 //메인메소드     1.
		oop.start();                    //                    2.
		//System.out.println(oop.gugudan(oop.danInput()));
	}

}
//콘솔에서 단을 입력받아 입력받은 구구단을 찍어라
