
// 추상메소드를 1개이상 포함하는 클래스는 추상클래스 이다.
// 추상클래스는 class키워드왼쪽에 abstract를 표기하여야 한다. //두번째할일
// 추상클래스는 반드시 상속받아 모든 추상메소드를 오버라이딩 하여야한다 //세번째...
public abstract class AbstractTest {
	
	int num=100;
	String name ="홍길동";

	public AbstractTest() {
		
	}
	
	public void numOutput() {
		System.out.println("num="+num);
	}
	//실행부가 없는 메소드는 추상메소드 이다.
	//추상메소드는 반환형 왼쪽에 abstract키워드를 표기하여하 한다.  //첫번째할일
	public abstract void print(); //추상메소드
	
	public abstract void setData(int num , String name);

}
