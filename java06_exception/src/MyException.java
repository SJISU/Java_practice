// 1.���� Ŭ���� ������ �ݵ�� Exception Ŭ������ ��ӹ޾� �����Ѵ�..
public class MyException extends Exception{

	public MyException() {
		super("1~100������ ���̾�� �մϴ�."); //�����ǹ�....--����Ŭ������ ��Ʈ���Ű������� �Ѱ��������ִ� �����޼ҵ带 ȣ�����ָ鼭 ����
										  //���������Ͱ� ��µ�
	}
	
	public MyException(String message) {
			super(message); //�����������Ҷ� �־��� �޽����� ������ :�Ű������� ���� �޽����� ����
						//��ü���鶧���� �ٸ� ������
	}

}
