//Ŭ�������� interface�� ��ӹ��� ��� implementsŰ���带 �̿��Ѵ�..
//		interface�� ������ ��ӹ��� �� �ִ�. ����������x
//		��ӹ��� ��� �߻�޼ҵ�� �������̵��� �ؾ��Ѵ�
public class InterfaceMain implements InterfaceTest1 ,InterfaceTest2 { //1,2�� sum�ְ� 3�� ��¸޼ҵ�����..-->1,2�� ��ӹ޾ƾߵ�

	public InterfaceMain() {
		
	}
	
	//�߻�޼ҵ� �������̵�
	public void output() {} //���Ͼ�� �������̵� �������
	
	public int sum() {
		return 5050;
		
	}
	
	public void oddSum() { 
		int sum =0;
		for(int i=1; i<=MAX; i+=2) {
			sum+=i;
		}
		System.out.println("1~"+MAX+"������ ����="+sum);
	}
	
	public int evenSum() { 
		int sum =0;
		for(int i=2; i<=MAX; i+=2) {
			sum+=i;
		}
		return sum;
	}
	
	
	public void resultPrint(int data) {
		System.out.println("�������"+data);
	}
	
	
		
	public void start() {
		
		resultPrint(sum()); //��1~100 �������5050
							//sum�ǰ���� ���Ϲ޾Ƽ� �ٷ����
		oddSum(); //1~100������ Ȧ���� �� 2500
		resultPrint(evenSum()); //������� =2550 	
								//return���ΰ��� �����⶧���� ������ִ� �޼ҵ� �̿���
							
		
		
	}
	
	
	public static void main(String[] args) {
		
		new InterfaceMain().start();
	}

}

//1,2�� sum�ְ� 3�� ��¸޼ҵ�����..-->1,2�� ��ӹ޾ƾߵ�--4��°�ٿ��� ��ӹ���
