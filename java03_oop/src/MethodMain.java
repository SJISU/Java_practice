
public class MethodMain {

	public static void main(String[] args) {
		//			��ä��=instance=reference����
		//					�����ڸ޼ҵ�
		//���� Ŭ������ �޾� ��������� �� ��ü �� �޴´� �׷��� �Ѿȿ��ִ°��� ���� ������ �ƴ�
		Methodtest mt = new Methodtest();
		Methodtest mt2 =new Methodtest("010-1134-5555");
		
		//��ü���� ��������� ������ �ٸ� �����ͷ� �����ϱ�
		mt.name ="�̼���"; //mt��ü���� name �����͸� ȫ�浿���� �̼������� ����
		System.out.println("mt.name="+mt.name);
		System.out.println("mt2.name="+mt2.name); //mt2�� ����Ŭ�������� �������� ȫ�浿�� ��µ�
		
		//
		Methodtest mt3 = new Methodtest(100,"�������");
		System.out.println("mt3.num="+mt3.num); //100
		System.out.println("mt3.name="+mt3.name); //�������
		System.out.println("mt3.tel="+mt3.tel); //02-1234-1234
		
		Methodtest mt4 = new Methodtest("�念��",200);
		System.out.println("mt4.num="+mt4.num); //200
 		System.out.println("mt4.name="+mt4.name);//�念��
		System.out.println("mt4.tel="+mt4.tel); //02-1234-1234
	}

}
