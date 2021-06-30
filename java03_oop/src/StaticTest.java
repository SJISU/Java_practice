
public class StaticTest {
		int num =1234;
		String name = "홍길동";
		
		//현재클래스의 모든객체에서 1개만 존재한다.(공통변수로 사용)
		static String addr = "마포구"; //공통변수
									// 앞에 static을 넣으면 addr은 따로 저장됨
									// 원래 각자 가지고있는데 스테이틱을 붙이면 객체들이 공통으로 데이터를 가진다.
									//원래는 같은클래스의 객체들은 같은내용의 데이터이여도 각자 가지는데 static이 붙은전역변수들은 하나의 정보의 데이터로 공유한다.
	public StaticTest() {
		
		}
		// 주소를 변경하는 메소드
		void setAddr(String addr) {
			this.addr = addr; //addr을 받아 마포구 데이어내용을 바꾼다
		}
		String getAddr() {
			return addr;
		}
		
		
	
	
	
	
}


