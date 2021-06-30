
public class StaticTest2 {
	//Static
	//멤버변수의 데이터형 왼쪽 public static int a=100;
	//						    static int b =200; //생성되는 객체들이 공통으로 공유하게된다..
	//메소드의 반환형 왼쪽에 포기한다.
	//		public static void method(){}
	//			   static void method(){}
	
	//멤버영역에 실행문 표기 할수없다.
	//static{}에는 멤버영역에서도 실행문을 표기 할수 있다.-꼭 멤버영역에 써야한다면..
	
	// ***static{} 과 생성자 메소드는 static{}이 먼저 실행된다...***
	static {
		for(int i=1; i<=10; i++){
			System.out.println(i);
		}
	}
	
	
	public StaticTest2() {
		System.out.println("StaticTest2()메소드 실행됨");
	}
	
	public static void main(String a[]) {
		new StaticTest2();
	}
}
