
public class OuterClass { //***�ϳ��� Ŭ���� ������ ����Ŭ���� �����- �޼ҵ常���-�޼ҵ�ȣ���ϸ� ���� Ŭ������

	int num =100;
	String name = "ȫ�浿";
		
	public OuterClass() { //OuterClass�� �����޼ҵ�
		System.out.println("OuterClass������ �޼ҵ� �����");
	}
	
	public void print() {
		System.out.println("num="+num);	
		System.out.println("name="+name);
		
		//�ܺ�Ŭ�������� ����Ŭ������ ��������� ���ٺҰ��ϴ�.
		//System.out.println("tel="+tel); // ��ü�� ���ؼ��� ����Ŭ������ �����Ҽ��ִ�...������ //��ü�����޼ҵ� ���� tel�� ����
	}
	
	
	public void createInner() {
		//***�ܺ�Ŭ���������� ����Ŭ���� ��ü �����ϱ�  --->ȣ���� �ܺο���
		InnerClass cc = new InnerClass();
		cc.tel = "010-9999-9999"; //��ü�� ���ؼ� ����Ŭ���� tel �� ����
	
		cc.output(); //��ü������ ���ؼ� ����Ŭ������ �޼ҵ� ȣ����..
	}
	
	
	//����Ŭ���� - �������, �����ڸ޼ҵ� ,�Ϲݸ޼ҵ� ������ ----> �������ϸ� ������ class������ ������
	class InnerClass{
		
		//�������
		String tel = "010-1234-5678";
		//�����ڸ޼ҵ�
		InnerClass(){
			System.out.println("InnerClass ������ �޼ҵ� �����");
		}
		//�Ϲݸ޼ҵ�
		public void output() {
			System.out.println("tel="+tel); //�ܺ�Ŭ������ ��������� ����Ŭ�������� �����Ҽ� �ִ�..
			
			System.out.println("num----->"+num); //����Ʈ ȣ���Ҷ� �߰���...�ܺο� �ִ� num �� name ����ߴ�..
			System.out.println("name----->"+name);
		}		
	}	
		
	
	public static void main(String[] args) { //***Ŭ�����ܺο��� ����Ŭ���� ����ϴ¹��......
		
//		OuterClass oc = new OuterClass();  //�ƿ���Ŭ������ �����ڸ޼ҵ常�����
//		oc.print();
		
		//****���� Ŭ���� ��ü �����ϱ�-----> 2���� ���
		
		//1.�ܺ�Ŭ������ü ����-> ����Ŭ���� ��ü ����
		InnerClass ic = new OuterClass().new InnerClass(); //outer���� inner�� ������
		//���������� ��������°� InnerŬ�����̱� ������ �̳�Ŭ������ ��ü�λ��� 
														//�ƿ���Ŭ���������ڸ޼ҵ����->����Ŭ���� �����ڸ޼ҵ����
		ic.output();
		//ic.createInner();
		
		//2.			�ܺ�Ŭ���� ��ü
		OuterClass oc2 = new OuterClass();  //�ܺ� �����ڸ޼ҵ�����
		InnerClass ic2 = oc2.new InnerClass(); //���� �����ڸ޼ҵ�����
		
		ic.output(); //...
		
		oc2.createInner(); //***Ŭ������ ���� �޼ҵ� ��������-����Ŭ�������� �����Ѱ�ü ����
		
		
	}

}
