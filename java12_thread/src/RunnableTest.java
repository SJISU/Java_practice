//1.interface ���
public class RunnableTest implements Runnable { //ä���Ҷ� �ʼ��� ���

	String msg;
	
	public RunnableTest() {
		
	}
	
	public RunnableTest(String msg) {
		this.msg = msg;
	}
	
	//2. Thread ���������� run()�޼ҵ忡 �������̵�
	public void run() {
		int i=1;
		while(true) {
			System.out.println(msg+"="+i);
		}
		
	}
	
	
	
	public static void main(String[] args) {
		RunnableTest rt1 = new RunnableTest("ù��°������");
		RunnableTest rt2 = new RunnableTest("�ι�°������");
		
		//3.thread�� ��ü�� �������Ѵ�
		Thread t1 = new Thread(rt1);
		Thread t2 = new Thread(rt2); // ���� ��ŸƮ �޼ҵ� ����
		
		t1.start();
		t2.start();
		
		
	}

}
