
public class AnonymousInner {

	public AnonymousInner() {
		
	}

	public void innerTest() {
		//익명의 내부 클래스 : 클래스명이 존재하지 않는다.
		//					다른 클래스를 객체화하는 과정에서 클래스를 수정하여 새로 만든다...
		//					클래스명이 존재하지 않으므로 변수를 선언할 수 없다.
		
		new Student() { //원래 있던것도 사용하면서 여기서 추가된것도 사용할수있다 //새로운클래스안만들고 객체만생성했기때문에 익명의내부클래스라고한다
						// 객체도 안만들어졌고 그래서 변수도 선언할수없다
			//클래스의 실행부
			String tel ="010-1234-8888";
			
			//student클래스의 print메소드를 오버라이딩
			public void print() {
				 System.out.println("num="+num); //원래클래스의정보
				 System.out.println("name="+name);
				 System.out.println("tel="+tel); //추가한 정보도 출력
			}

		}.print(); //*****13~25줄까지가 하나의 객체
	
	}
	
	
	public static void main(String[] args) {
		new AnonymousInner().innerTest(); //이클래스의 이너테스트 메소드를 실행하라..

	}

}
