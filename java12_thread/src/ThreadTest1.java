//1.Thread Ŭ���� ���
public class ThreadTest1 extends Thread{ //���ÿ� �� for���� �����ϰ�ʹ� -> �� for���� ���� ����ǰ�...-> ��for���� thread�� ���� �����ϸ� �����ϴ�.
	String msg;
	
	public ThreadTest1() {
		
	}
	
	public ThreadTest1(String msg) {
		this.msg = msg;
	}
	
	
	//2.Thread ���� �ڵ带 run()�޼ҵ忡 �������̵� �Ѵ�.
	public void run() {		
		for(int i=1; ; i++) {			
			System.out.println(msg+"="+i);			
		}		
	}
	

	public static void main(String[] args) {
		ThreadTest1 tt1 = new ThreadTest1("ù��°������"); //msg�ȿ� "ù��°������"�־���
		//3.������ �����ϱ� ���ؼ��� start()�޼ҵ� ȣ�� 
		tt1.start(); //Thread���� start()�޼ҵ� ȣ�� 
		
		ThreadTest1 tt2 = new ThreadTest1("�ι�°������");
		tt2.start();
		
		ThreadTest1 tt3 = new ThreadTest1("����°������");
		tt3.start();
	}

}
