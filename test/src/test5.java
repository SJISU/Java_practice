class Test8{}
public class test5 extends Test8{

	public test5() {
		
	}

	public static void main(String[] args) {
		Test8 t1 = new Test8(); // t1�� Ŭ�����׽�Ʈ�ǰ���[
		test5 e1 = new test5();
		test5 e2 = (test5)t1; //ex�� Ŭ�����׽��� ��ӹ޾ұ⶧���� ����ȯ �����ϴ�
		Object o1 = (Object)t1; //���Ŭ������ ������Ʈ�� ��ӹ޾ұ� ������ t1�������ϴ�
		//String s1 = (String)t1; 
		Test8 t2 = (Test8)e1;
		System.out.println(t2);

	}

}
