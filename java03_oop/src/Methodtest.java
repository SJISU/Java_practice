			//this - 현재클래쓰
//생성자 메소드를 여러개만들어서 객체형성
public class Methodtest {
	//멤버영역
	//   멤버변수
	int num = 12;
	String name = "홍길동";
	String tel; //null
	
	//생성자 메소드 : 생략시 자동 추가(JVM)
	//			  상속관계 아닐때 만 추가해준다.
	//	매개변수는 데이터형이 다르거나 변수의 갯수가 달라야 한다.
	Methodtest(){}
	
	Methodtest(String tel){
		System.out.println("연락처:"+tel);
	}
	// Methodtest(String name){} - 데이터타입과 그 형의 변수의 갯수가 같으면 사용불가
	
	Methodtest(int num){
		
	}			//지역번수 num
	
	Methodtest(int num, String name){
		// this : 현재객체(현재클래스)
		this.num =num; //오른쪽 num은 지역변수 num 100을 받음
		this.name = name;
		String tel ="12345";
		this.tel = "02-1234-1234"; 
		
	}
	
	Methodtest(String name, int num){
		//생성자 메소드에서 다른 생성자 메소드 호출하기 -위에 메소드와 같은기능구현할때 사용
		//생서자 메소드에서 다른생성자를 호출할때는 메소드명을 직접표기할수없다.
		//		this (매개변수)-위의 디스와 다름
		//Methodtest(num,name); -불가
		//this()이용하여 다른 생성자 메소들르 호출할때는 반드시 첫번째 실행문이어야 한다.
		//System.out.println("-----"); - 이줄이 있으면 첫번째 실행문이 있기때문에 this기능사용못함
		this(num,name); //현재클래스의 생성자가된다 //윗줄을 나타냄-23~26줄으 기능을한다
	}
	
}
