// E : element 
// k : key
// v : value
public class GenericTest<E> {
	private E username;
	public GenericTest() {
		
	//E�� ���ԵǴ� ������ Ÿ�Կ� ���� �ٸ��� ����	
	//�پ��� �������� ����
	//�׶��׶� ������ �ٲ�
		
	}
	
	public GenericTest(E username) {
		this.username = username;
	}

	//private������ getter-setter ��������
	public E getUsername() {
		return username;
	}
	public void setUsername(E username) {
		this.username = username;
	}
	
}
