// 1.예외 클래스 생성시 반드시 Exception 클래스를 상속받아 생성한다..
public class MyException extends Exception{

	public MyException() {
		super("1~100사이의 값이어야 합니다."); //무슨의미....--상위클래스의 스트링매개변수를 한개가지고있는 생성메소드를 호출해주면서 실행
										  //고정데이터가 출력됨
	}
	
	public MyException(String message) {
			super(message); //데이터형성할때 넣어준 메시지로 생성됨 :매개변수로 넣은 메시지가 나옴
						//객체만들때마다 다른 데이터
	}

}
