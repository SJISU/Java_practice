//1.Thread 클래스 상속
public class ThreadTest1 extends Thread{ //동시에 두 for문을 실행하고싶다 -> 두 for문이 따로 실행되게...-> 각for문을 thread로 만들어서 실행하면 가능하다.
	String msg;
	
	public ThreadTest1() {
		
	}
	
	public ThreadTest1(String msg) {
		this.msg = msg;
	}
	
	
	//2.Thread 구현 코드를 run()메소드에 오버라이딩 한다.
	public void run() {		
		for(int i=1; ; i++) {			
			System.out.println(msg+"="+i);			
		}		
	}
	

	public static void main(String[] args) {
		ThreadTest1 tt1 = new ThreadTest1("첫번째스레드"); //msg안에 "첫번째스레드"넣어줌
		//3.스레드 시작하기 위해서는 start()메소드 호출 
		tt1.start(); //Thread안의 start()메소드 호출 
		
		ThreadTest1 tt2 = new ThreadTest1("두번째스레드");
		tt2.start();
		
		ThreadTest1 tt3 = new ThreadTest1("세번째스레드");
		tt3.start();
	}

}
