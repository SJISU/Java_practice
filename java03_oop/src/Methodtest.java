			//this - ����Ŭ����
//������ �޼ҵ带 ���������� ��ü����
public class Methodtest {
	//�������
	//   �������
	int num = 12;
	String name = "ȫ�浿";
	String tel; //null
	
	//������ �޼ҵ� : ������ �ڵ� �߰�(JVM)
	//			  ��Ӱ��� �ƴҶ� �� �߰����ش�.
	//	�Ű������� ���������� �ٸ��ų� ������ ������ �޶�� �Ѵ�.
	Methodtest(){}
	
	Methodtest(String tel){
		System.out.println("����ó:"+tel);
	}
	// Methodtest(String name){} - ������Ÿ�԰� �� ���� ������ ������ ������ ���Ұ�
	
	Methodtest(int num){
		
	}			//�������� num
	
	Methodtest(int num, String name){
		// this : ���簴ü(����Ŭ����)
		this.num =num; //������ num�� �������� num 100�� ����
		this.name = name;
		String tel ="12345";
		this.tel = "02-1234-1234"; 
		
	}
	
	Methodtest(String name, int num){
		//������ �޼ҵ忡�� �ٸ� ������ �޼ҵ� ȣ���ϱ� -���� �޼ҵ�� ������ɱ����Ҷ� ���
		//������ �޼ҵ忡�� �ٸ������ڸ� ȣ���Ҷ��� �޼ҵ���� ����ǥ���Ҽ�����.
		//		this (�Ű�����)-���� �𽺿� �ٸ�
		//Methodtest(num,name); -�Ұ�
		//this()�̿��Ͽ� �ٸ� ������ �޼ҵ鸣 ȣ���Ҷ��� �ݵ�� ù��° ���๮�̾�� �Ѵ�.
		//System.out.println("-----"); - ������ ������ ù��° ���๮�� �ֱ⶧���� this��ɻ�����
		this(num,name); //����Ŭ������ �����ڰ��ȴ� //������ ��Ÿ��-23~26���� ������Ѵ�
	}
	
}
