
public class MethodInner { //�޼ҵ峻�ǳ���Ŭ����

	String name ="�������";
	
	public MethodInner() {
		System.out.println("MethodInner");
	}

	public void start() { //***�޼ҵ�ȿ� ����Ŭ���� ����...	
		//����Ŭ������ �����޼ҵ尡 �ƴ� �޼ҵ� �� �����...���� ȣ���ؾ���
		class MethodInnerTest{
				int num=20;
				String email = "aaaaaaa@nate.com";
				
			MethodInnerTest(){ //MethodInnerTestŬ������ �����޼ҵ�
			}
			
			MethodInnerTest(int num){ //�Ű��������ִ� �����޼ҵ�
				this.num =num;
			}
			
			void emailOutput() {
				System.out.println("num="+num);
				System.out.println("email="+email);
				System.out.println("name="+name);
			}
		}
		
		//***����Ŭ���� ��ü�� ����
		MethodInnerTest mt = new MethodInnerTest(500);
		mt.emailOutput();
	
	}
	
	
	public static void main(String[] args) {
		MethodInner mi = new MethodInner(); //��ü�� ����� �����ڸ޼ҵ尡 �����..
		mi.start(); //�޼ҵ峻�� ����Ŭ������ ȣ��
	}

}
//37��°���� ����Ǿ� MethodInnerŬ������ �����޼ҵ尡 ������
//38��°�ٿ����� ���ٿ��� ���� ��ü�� start�޼ҵ带 ȣ���Ͽ� �޼ҵ峻�� ����Ŭ������ MethodInnerTest Ŭ������ ȣ��
//31��°�ٿ��� ����Ŭ������ MethodInnerTest�� ��ü�� �����ϰ� 32��°�ٿ��� ����Ŭ������ emailOutput�޼ҵ带 �����Ѵ�..