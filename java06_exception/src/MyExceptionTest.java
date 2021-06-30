import java.util.Scanner;

public class MyExceptionTest {
	Scanner scan = new Scanner(System.in);
	public MyExceptionTest() {
		
	}

	public void start() {
		do {
			//������ ����(1~100)������ ���� �Է¹޾� �׼������� ���� ���Ͽ� ����϶�
			try {
				System.out.print("�������Է��ϼ���(1~100)---->");
				int max =Integer.parseInt(scan.nextLine()); //���ڿ��� ������ �ٲ��ִ� �޼ҵ�
															//NumberFormatException ����
				//������ �� ���ϴ°� x ---> 1~100 �������� Ȯ��--->�ƴϸ� �����Լ����̶�� ���� �߻���Ŵ
				if(max<1 || max>100) {
					//throw : ���ܸ� ������ �߻���Ų��..--�޼ҵ忡����s�پ��־���
					throw new MyException(); //********MyExceptionŬ�����ǸŰ��������� �����޼ҵ尡 ����  
				}else {						 // ��--->catch�� �������
					sum(max);
				}
				
			}catch(NumberFormatException nfe) {
				System.out.println("���ڸ� �Է��ϼ���.......");
			
			}catch(MyException me) {
				System.out.println(me.getMessage()); 
			}
		}while(true);
	}
	
	public void sum(int max) {
		int tot=0;
		for(int i=1; i<=max; i++) {
			tot+=i;
		}
		System.out.println("1~"+max+"������ ����"+tot);
	}
	
	
	public static void main(String[] args) {
		
		new MyExceptionTest().start(); //��ü���� �� start�޼ҵ� ȣ��

	}

}
