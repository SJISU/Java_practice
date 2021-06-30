
public class StringBufferTest {

	public StringBufferTest() {
		start();
	}
	public void start() {
		StringBuffer sb1 = new StringBuffer(); //�⺻���� 16���� ���ڸ� ������ �� �ִ� ũ��
		StringBuffer sb2 = new StringBuffer(100); //��ü�ΰ����� -��ü�����ÿ� �޸� Ȯ����
		
		// append() : ���ڿ��߰� - �˾Ƽ� ������ �� Ȯ����...
		sb1.append("Buffer append Test..");
		sb1.append(123456); //������ �־������..������ ���볡�� ���ڿ��� �ٿ���...
		
		//insert() : index��ġ ���� ����
		sb1.insert(5, "(��Ʈ������)"); //��ġ�� ���ڻ����ϰ� �������ڴ� �ڷ� �з���
		sb1.insert(15, 23234.21342554);
		
		//deleteCharAt() : 
		//0123456 7
		//Buffe(��Ʈ������)r a23234.21342554ppend Test..123456 : ���絥����..
		sb1.deleteCharAt(6); // '��'������
		
		sb1.delete(1,4); // index 1���� 4�ձ��� �����
		
		//replace()
		//0123 45 67
		//Be(Ʈ������)r a23234.21342554ppend Test..123456 :���絥����
		sb1.replace(1, 3, "(�ڹ�)"); //index 1���� 3�ձ����� "(�ڹ�)"�� ġȯ
		
		//reverse() : �ݴ��������...
		sb1.reverse();

		
		
		//Ȯ���� ���� Ȯ���ϱ�
		System.out.println("sb1.capacity="+sb1.capacity()); //16byte -�������ϸ�
		System.out.println("sb2.capacity="+sb2.capacity()); //100byte
		System.out.println(sb1);
	}
	

	public static void main(String[] args) {
		new StringBufferTest(); //���θ޼ҵ忡���� ��ü����� �����ڸ޼ҵ忡�� ����
	}

}
