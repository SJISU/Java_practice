
public class AnonymousInner {

	public AnonymousInner() {
		
	}

	public void innerTest() {
		//�͸��� ���� Ŭ���� : Ŭ�������� �������� �ʴ´�.
		//					�ٸ� Ŭ������ ��üȭ�ϴ� �������� Ŭ������ �����Ͽ� ���� �����...
		//					Ŭ�������� �������� �����Ƿ� ������ ������ �� ����.
		
		new Student() { //���� �ִ��͵� ����ϸ鼭 ���⼭ �߰��Ȱ͵� ����Ҽ��ִ� //���ο�Ŭ�����ȸ���� ��ü�������߱⶧���� �͸��ǳ���Ŭ��������Ѵ�
						// ��ü�� �ȸ�������� �׷��� ������ �����Ҽ�����
			//Ŭ������ �����
			String tel ="010-1234-8888";
			
			//studentŬ������ print�޼ҵ带 �������̵�
			public void print() {
				 System.out.println("num="+num); //����Ŭ����������
				 System.out.println("name="+name);
				 System.out.println("tel="+tel); //�߰��� ������ ���
			}

		}.print(); //*****13~25�ٱ����� �ϳ��� ��ü
	
	}
	
	
	public static void main(String[] args) {
		new AnonymousInner().innerTest(); //��Ŭ������ �̳��׽�Ʈ �޼ҵ带 �����϶�..

	}

}
