
//numOutput �޼ҵ带 ��������� �߻�Ŭ�����̱⶧���� ������ �ƴ϶� ��ӹ޾ƾ���
//							�߻�Ŭ���� ���
public class AbstractMain extends AbstractTest{

	public AbstractMain() {
		
	}

	//��ӹ��� �߻�Ŭ�������� ��� �߻�޼ҵ带 �������̵� �Ѵ�.
	
	public void print() { //��ӹ��� Ŭ�������� ��ɱ�������
		System.out.println("num="+num +",name="+name);
	}
						//��������,������ ���ƾ��ϰ� �������� �޶󵵵�
	public void setData(int num , String name) {
		this.num = num; //super.num = num; //����Ŭ������ �̸�����ȣ�����ϱ� ������
		this.name =name;// super.name=name;
	}

	
	
	public void start() {
		numOutput();
		setData(5000,"�̼���");
		print();
	}
	
	
	public static void main(String[] args) {
	
		AbstractMain am = new AbstractMain(); //��Ŭ����������ϱ����� ��ü�����
		am.start(); //�޼ҵ� ȣ��
	}
	
	
}

//29,30��°��---21,22,23����

