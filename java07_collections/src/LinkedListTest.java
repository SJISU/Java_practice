import java.util.LinkedList;

public class LinkedListTest {

	public LinkedListTest() {
		start();
	}

	public void start() {
		//LinkedList => List, Deque,Queue ��ӹް�����
		//			   Queue�϶� �Է¼����� ���� ����� ���� �Էµ� ��ü�� ��µȴ�.
		//			   ��µ� ��ü�� �÷��ǿ��� ��������.
		//			   Deque �϶��� ���ʿ��� ��ü�� �Է¶Ǵ� ����Ҽ� �ִ�.
		
		LinkedList<String> ll = new LinkedList<String>();
		
		//��ü�߰�
		// offer() - �����ͳֱ�
		ll.offer("ȫ�浿");
		ll.offer(new String("�������"));
		ll.offer(String.valueOf(1234)); //1234�� int���̱⶧���� ���������� ����ȭ ������Ѵ�. //StringŬ������valueof���
		ll.offer(5678+""); // "" �� ���Ͽ� ���ڿ��� �ٲ���
		
		System.out.println("size->"+ll.size()); //������ִ� ��ü�� ���ϱ� //4
		
		/*
			//��ü ������
			//pop() - ���������
			
			String data = ll.pop(); // ���Ͼտ� �ִ� ��ü�� ������� �÷��ǿ����� ��������.
			System.out.println("data="+data); //���Ͼտ��ִ� ȫ�浿�� �������..//������ ��������		
			//�����ִ� ��ü�� ���ϱ�
			//size() �̿��Ͽ� Ȯ��
			System.out.println("size--->"+ll.size()); //3 // ����������� �������� ������ �������� Ȯ���Ҽ��ִ�
		*/
		
		
		//��ü�� �����ִ��� Ȯ�����ִ�
		//isEmpty()->AbstractCollection Ŭ������ ����
		//true : �÷��ǿ� ��ü�� ����. false:�÷��ǿ� �����ִ� ��ü�� �ִ�.-->��ü�� ������ pop�Ҥ�����
		while(!ll.isEmpty()) { //��ü�� �������� �ۼ��Ұ��� ->
			String data = ll.pop(); //������ ������� //ll�� ��������:String
			int cnt = ll.size(); //������ü��
			System.out.println(data+",������ü��="+cnt); //�����������,���������ͼ�
			
		}
		
		
	}
	
	
	public static void main(String[] args) {
		
		new LinkedListTest();
	}

}