
public class WrapperTest {

	public WrapperTest() {
		//Wrapper 클래스는 기본데이터형의 정보를 객체로 변경시키는 클래스이다
		//Byte , Short ,Intger ,Long
		//Float, Double
		//Character 들을 총칭해서 Wrappwer 클래스라고 부른다
		
		
		int a =1234;
		
	
		Integer i = Integer.valueOf(a); //new Integer(a); //인트를 넣어주면 인터저가 반환된다..
										//String 을 Integer 로 변경하기 위해 사용하는 메소드
										//valueOf() :다양한 형태의 변수를 문자열 형태로 바꾸어야 할때 String 에는 valueof라는 메서드를 제공하고있다..
										// valueOf 리턴값Wrapper 클래스타입에서는 
										//valueOf(): Integer 래퍼(wrapper)객체를 반환
		
		System.out.println(a);
		System.out.println(i); //int와intger라 확연히 다른것이지만 같은값이 나온다 //참조와 객체...
	
	
		//오토박싱
		Object obj = a;
		Object obj2 = i;
		System.out.println(obj);
		System.out.println(obj2);
		
		
		int x = i; //오토언박싱
		System.out.println(x);
	
	}
	
		

	public static void main(String[] args) {
		new WrapperTest();

	}

}


