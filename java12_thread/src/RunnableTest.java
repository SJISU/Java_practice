//1.interface 상속
public class RunnableTest implements Runnable { //채팅할때 필수로 사용

	String msg;
	
	public RunnableTest() {
		
	}
	
	public RunnableTest(String msg) {
		this.msg = msg;
	}
	
	//2. Thread 구현영역을 run()메소드에 오버라이딩
	public void run() {
		int i=1;
		while(true) {
			System.out.println(msg+"="+i);
		}
		
	}
	
	
	
	public static void main(String[] args) {
		RunnableTest rt1 = new RunnableTest("첫번째스레드");
		RunnableTest rt2 = new RunnableTest("두번째스레드");
		
		//3.thread를 객체로 만들어야한다
		Thread t1 = new Thread(rt1);
		Thread t2 = new Thread(rt2); // 이제 스타트 메소드 있음
		
		t1.start();
		t2.start();
		
		
	}

}
