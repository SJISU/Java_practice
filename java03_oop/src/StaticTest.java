
public class StaticTest {
		int num =1234;
		String name = "ȫ�浿";
		
		//����Ŭ������ ��簴ü���� 1���� �����Ѵ�.(���뺯���� ���)
		static String addr = "������"; //���뺯��
									// �տ� static�� ������ addr�� ���� �����
									// ���� ���� �������ִµ� ������ƽ�� ���̸� ��ü���� �������� �����͸� ������.
									//������ ����Ŭ������ ��ü���� ���������� �������̿��� ���� �����µ� static�� ���������������� �ϳ��� ������ �����ͷ� �����Ѵ�.
	public StaticTest() {
		
		}
		// �ּҸ� �����ϴ� �޼ҵ�
		void setAddr(String addr) {
			this.addr = addr; //addr�� �޾� ������ ���̾���� �ٲ۴�
		}
		String getAddr() {
			return addr;
		}
		
		
	
	
	
	
}


