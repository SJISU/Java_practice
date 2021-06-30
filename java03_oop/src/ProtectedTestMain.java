import test.ProtectedTest2; //패키지가 다른 클래스 임포트하여 메소드사용 -getInstance메소드사용하기위해

public class ProtectedTestMain extends ProtectedTest2 {
	//패키지가 다른데 프로텍디드된 메소드를 사용하고싶을때는 상속
	
	ProtectedTestMain(){//같은패키지 내의 다른클래스는 default처럼 사용가능
		//같은패키지 내의 다른클래스는 default처럼 사용가능
		ProtectedTest pt = new ProtectedTest();
		System.out.println("pt.num="+pt.num);
		pt.print();
		
		//다른패키지의 클래스는 객체를 생성할 수 없다.--객체만들수없으니 변수도 사용못함
		//ProtectedTest2 pt2 = new protectedTest2 pt2(); 
		
		//protected접근제한자는 다른 패키지일 경우 상속받아 사용한다,
		System.out.println("tel="+tel); //상속받았으니깐 객체생성안해두됨 //test2의 메소드
		telOutput();
	}
	
	public static void main(String []a) {
		new ProtectedTestMain(); //상위클래스의 생성메소드먼저실행된후 --> 하위클래스의 생성메소드실행
		
		ProtectedTest2 ppt =ProtectedTest2.getInstance();
		// 같은패키지가 아니고 상속관계가 아닌데 메소드를 호출하고싶을때는 
		//	-static메소드를 이용하여 객체를생성하는 메소드를만들어 호출한다..
		//static이 붙어있기때문에 클래스명.메소드로 객체를생ㅇ성하는 메소드를 불러서
		//사용 그런데 이 변수들을 담아줘야하니깐 피피티 에 담아줌
		System.out.println(ppt.gettel()); //test2의 메소드
	}

}

//본인의 클래스를 객체생성하여 불러주는 메소드...getInstance...

//상속을 받아서 ....pt의 생성자메소드가 실행되기전에 상속받은 test2의 생성메소드가 먼저실행됨..../.

// 21번째줄에서 객체를 생성하면 상위클래스인 생성자메소드가 실행된후 하위클래스의 생성자메소드가 실행..
//8번째줄에서 pt객체 생성 객체의 생성메소드 실행..
//9번째줄 10번째줄...첫번째줄에서
//ProtectedTest2 클래스를 상속받아서 16,17번째줄이 가능해짐.
//23번째줄에서 ???? 상속받앗으니깐 상속클래스의 메소드를 호출가능하여..
//객체를 만드는 메소드인 ProtectedTest2가 실행되어 ProtectedTest2의 생성자메소드가 실행되고
//26번째줄도 실행됨.....