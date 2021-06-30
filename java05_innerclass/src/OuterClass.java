
public class OuterClass { //***하나의 클래스 내에서 내부클래스 사용방법- 메소드만든다-메소드호출하면 이제 클래스가

	int num =100;
	String name = "홍길동";
		
	public OuterClass() { //OuterClass의 생성메소드
		System.out.println("OuterClass생성자 메소드 실행됨");
	}
	
	public void print() {
		System.out.println("num="+num);	
		System.out.println("name="+name);
		
		//외부클래스에서 내부클래스의 멤버변수는 접근불가하다.
		//System.out.println("tel="+tel); // 객체를 통해서만 내부클래스에 접근할수있다...오류뜸 //객체생성메소드 에서 tel에 접근
	}
	
	
	public void createInner() {
		//***외부클래스내에서 내부클래스 객체 생성하기  --->호출은 외부에서
		InnerClass cc = new InnerClass();
		cc.tel = "010-9999-9999"; //객체를 통해서 내부클래스 tel 에 접근
	
		cc.output(); //객체생성을 통해서 내부클래스의 메소드 호출함..
	}
	
	
	//내부클래스 - 멤버변수, 생성자메소드 ,일반메소드 존재함 ----> 컴파일하면 별도의 class파일이 생성됨
	class InnerClass{
		
		//멤버변수
		String tel = "010-1234-5678";
		//생성자메소드
		InnerClass(){
			System.out.println("InnerClass 생성자 메소드 실행됨");
		}
		//일반메소드
		public void output() {
			System.out.println("tel="+tel); //외부클래스의 멤버변수는 내부클래스에서 접근할수 있다..
			
			System.out.println("num----->"+num); //프린트 호출할때 추가됨...외부에 있는 num 과 name 사용했다..
			System.out.println("name----->"+name);
		}		
	}	
		
	
	public static void main(String[] args) { //***클래스외부에서 내부클래스 사용하는방법......
		
//		OuterClass oc = new OuterClass();  //아우터클래스의 생성자메소드만실행됨
//		oc.print();
		
		//****내부 클래스 객체 생성하기-----> 2가지 방법
		
		//1.외부클래스객체 생성-> 내부클래스 객체 생성
		InnerClass ic = new OuterClass().new InnerClass(); //outer안의 inner만 가져온
		//최종적으로 만들어지는건 Inner클래스이기 때문에 이너클래스의 객체로생성 
														//아우터클래스생성자메소드실행->내부클래스 생성자메소드실행
		ic.output();
		//ic.createInner();
		
		//2.			외부클래스 객체
		OuterClass oc2 = new OuterClass();  //외부 생성자메소드실행됨
		InnerClass ic2 = oc2.new InnerClass(); //내부 생성자메소드실행됨
		
		ic.output(); //...
		
		oc2.createInner(); //***클래스에 만든 메소드 실행해줌-내부클래스에서 구현한객체 찍힘
		
		
	}

}
