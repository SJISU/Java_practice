import test.ProtectedTest2; //��Ű���� �ٸ� Ŭ���� ����Ʈ�Ͽ� �޼ҵ��� -getInstance�޼ҵ����ϱ�����

public class ProtectedTestMain extends ProtectedTest2 {
	//��Ű���� �ٸ��� �����ص��� �޼ҵ带 ����ϰ�������� ���
	
	ProtectedTestMain(){//������Ű�� ���� �ٸ�Ŭ������ defaultó�� ��밡��
		//������Ű�� ���� �ٸ�Ŭ������ defaultó�� ��밡��
		ProtectedTest pt = new ProtectedTest();
		System.out.println("pt.num="+pt.num);
		pt.print();
		
		//�ٸ���Ű���� Ŭ������ ��ü�� ������ �� ����.--��ü����������� ������ ������
		//ProtectedTest2 pt2 = new protectedTest2 pt2(); 
		
		//protected���������ڴ� �ٸ� ��Ű���� ��� ��ӹ޾� ����Ѵ�,
		System.out.println("tel="+tel); //��ӹ޾����ϱ� ��ü�������صε� //test2�� �޼ҵ�
		telOutput();
	}
	
	public static void main(String []a) {
		new ProtectedTestMain(); //����Ŭ������ �����޼ҵ����������� --> ����Ŭ������ �����޼ҵ����
		
		ProtectedTest2 ppt =ProtectedTest2.getInstance();
		// ������Ű���� �ƴϰ� ��Ӱ��谡 �ƴѵ� �޼ҵ带 ȣ���ϰ�������� 
		//	-static�޼ҵ带 �̿��Ͽ� ��ü�������ϴ� �޼ҵ带����� ȣ���Ѵ�..
		//static�� �پ��ֱ⶧���� Ŭ������.�޼ҵ�� ��ü���������ϴ� �޼ҵ带 �ҷ���
		//��� �׷��� �� �������� �������ϴϱ� ����Ƽ �� �����
		System.out.println(ppt.gettel()); //test2�� �޼ҵ�
	}

}

//������ Ŭ������ ��ü�����Ͽ� �ҷ��ִ� �޼ҵ�...getInstance...

//����� �޾Ƽ� ....pt�� �����ڸ޼ҵ尡 ����Ǳ����� ��ӹ��� test2�� �����޼ҵ尡 ���������..../.

// 21��°�ٿ��� ��ü�� �����ϸ� ����Ŭ������ �����ڸ޼ҵ尡 ������� ����Ŭ������ �����ڸ޼ҵ尡 ����..
//8��°�ٿ��� pt��ü ���� ��ü�� �����޼ҵ� ����..
//9��°�� 10��°��...ù��°�ٿ���
//ProtectedTest2 Ŭ������ ��ӹ޾Ƽ� 16,17��°���� ��������.
//23��°�ٿ��� ???? ��ӹ޾����ϱ� ���Ŭ������ �޼ҵ带 ȣ�Ⱑ���Ͽ�..
//��ü�� ����� �޼ҵ��� ProtectedTest2�� ����Ǿ� ProtectedTest2�� �����ڸ޼ҵ尡 ����ǰ�
//26��°�ٵ� �����.....