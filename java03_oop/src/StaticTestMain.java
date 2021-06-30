import java.util.Calendar;

public class StaticTestMain {

	public StaticTestMain() {
		
	}

	public static void main(String[] args) {
		StaticTest ss = new StaticTest();
		StaticTest ss2 = new StaticTest();
		
		ss.setAddr("영등포구"); //마포구 데이터 대신 영등포구 들어감 ss2객체에서도 변경됨 -앞에 static 이 붙어있기대문에
		
		//String address = ss2.getAddr();
		//System.out.println("address="+address); //static이안붙어있었다면 마포구가 나왔을것이다
		System.out.println(ss2.getAddr());
		
		//static 멤버변수는 객체생성하지않고 사용할수잇다.
		System.out.println("name="+ StaticTest.addr);	//출력 -> name = 영등포구	
		
		Calendar now = Calendar.getInstance();
		System.out.println(now.get(Calendar.YEAR)); //year 앞에는 static이 붙어있기때문데 객체명.이어 가능한
		
	}

}







//ss 에는 변수3개 셋팅되어있음 -num=1234 name=홍길동 addr=마포구 setaddr getaddr -> 
//ss2에도 변수3개 셋팅되어있음 -num=1234 name=홍길동 addr=마포구 setaddr getaddr