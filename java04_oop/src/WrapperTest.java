
public class WrapperTest {

	public WrapperTest() {
		//Wrapper Ŭ������ �⺻���������� ������ ��ü�� �����Ű�� Ŭ�����̴�
		//Byte , Short ,Intger ,Long
		//Float, Double
		//Character ���� ��Ī�ؼ� Wrappwer Ŭ������� �θ���
		
		
		int a =1234;
		
	
		Integer i = Integer.valueOf(a); //new Integer(a); //��Ʈ�� �־��ָ� �������� ��ȯ�ȴ�..
										//String �� Integer �� �����ϱ� ���� ����ϴ� �޼ҵ�
										//valueOf() :�پ��� ������ ������ ���ڿ� ���·� �ٲپ�� �Ҷ� String ���� valueof��� �޼��带 �����ϰ��ִ�..
										// valueOf ���ϰ�Wrapper Ŭ����Ÿ�Կ����� 
										//valueOf(): Integer ����(wrapper)��ü�� ��ȯ
		
		System.out.println(a);
		System.out.println(i); //int��intger�� Ȯ���� �ٸ��������� �������� ���´� //������ ��ü...
	
	
		//����ڽ�
		Object obj = a;
		Object obj2 = i;
		System.out.println(obj);
		System.out.println(obj2);
		
		
		int x = i; //�����ڽ�
		System.out.println(x);
	
	}
	
		

	public static void main(String[] args) {
		new WrapperTest();

	}

}


