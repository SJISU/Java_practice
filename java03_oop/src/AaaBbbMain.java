
public class AaaBbbMain  {

	public AaaBbbMain() {
		
	}

	public static void main(String[] args) {
		BBB b = new BBB();
		b.output();
		
		//하위클래스로 객체를 생성하면 상위클래스에 대입이 된다.
		AAA a= new BBB(); //객체는 BBB에 만들고 상위클래스 AAA에 대입시킴
		a.output(); //오버라이딩된 BBB의 메소드가 실행된
		
		System.out.println("b.tel="+b.tel);
		//System.out.println("a.tel="+a.tel); //a.output할땐 나왔으나 변수에 접근하려고하니 안됨
											//메소드를 통하지않으면 하위클래스의 변수에접근할수없다...
		System.out.println("a.name="+a.name); //name은 상위클래스에만 있는것
		
		//num은 두개의 클래스에 다있다..뭐가 남아있는지확인
		System.out.println("a.num="+a.num); //상위클래스에있는데이터가 살아있다...
		
		// AAA - a b
		// BBB - a   c
		//양쪽에 다있는 변수는 a만 살아남아있다..상위클래스 b는 살아있으나 하위클래스에만있는 c는 살아있지않다.
		//메소드는 다르다- 오버로딩된 하위클래스의 메소드가 살아있다...B안에는 A가 있다..
		
		//상속관계일때 클래스의 형변환,,,
		BBB c =(BBB)a;//B로만든객체를 A에넣은걸 다시 하위클래스인B에 넣는다..다시원래대로 있던곳으로 돌린다
		c.output(); //B에 있음...B의메소드가실행됨...
		
		
		Object obj= new BBB();// obj를 BBB에 만들고 상위클래스인 Object에 대입시킴...
		BBB d =(BBB) obj; //다시 하위클래스인 B에 넣는다...
		d.output(); //B의 메소드가 실행됨
	
//10번째출 출력됨 그다음 14번째줄	그다음 16번째줄 출력 19..22..31...
		
	}
	
	

}
