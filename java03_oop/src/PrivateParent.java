
public class PrivateParent {
	//private ���������ڴ� �ٸ� Ŭ�������� ��ü�� ���Ͽ� �����Ҽ�����...
	private int num = 200;  //ĸ��ȭ
							//�տ� �ƹ��͵� ������ ���������� : dafalut �� �����Ǿ� �ִ»���..
							//        privaet�̸� ���ο��� ���x
	//������ �޼ҵ忡 private ���� �����ڴ� ��ü�� �����Ҽ�����.
//	private PrivateParent() {
//		
//	}
//	
	PrivateParent(){
		
	}
	//��ü�� ���ؼ� ���ٺҰ�
	//��Ӿ���...
	private void getData() {
		System.out.println("��ȣ="+num); //private - ����Ŭ���������»�밡�� �ܺο���x
	}

}
