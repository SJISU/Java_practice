import java.util.Scanner;

public class OOP_Ex01 {

	public OOP_Ex01() { //������ // new�� ��ü����� ����Ǵ°�
		
		//int dan = danInput();
		//String result = gugudan(dan);
		//System.out.println(result);
		
		
		// System.out.println(gugudan(danInput())); //���� ������ ���ٷ�
	}
	//�������� scan gugu dan... ������������ ���ÿ� �����...��üȭ�� ��Ű�� oop��� ������...
	//
	
	//���Է¹ޱ�
	int danInput() {
		Scanner scan = new Scanner(System.in);//scan�� �������� //ctrl+�����̽� ������ import��
		
		System.out.print("���Է�=");
		return scan.nextInt(); //���� �������� : �޼ҵ� ������ ����
	}
	
	//�����ܸ����
	String gugudan(int dan) {
		String gugu =""; //����� ����� �������� gugu ����
		for(int i=2; i<=9; i++) {
			gugu+=dan+"*"+i+"="+dan*i+"\n";
		}
		return gugu;
	}	
	
	void start() {
		int dan = danInput();		
		String result = gugudan(dan);
		System.out.println(result);  //System.out.println(gugudan(dan));
	}
	
	public static void main(String[] args) { //main�� ���� Ŭ���� �ƴ�
		OOP_Ex01 oop = new OOP_Ex01(); //��ü���� //���θ޼ҵ�
		oop.start();
		//System.out.println(oop.gugudan(oop.danInput()));
		
	}

}
//�ֿܼ��� ���� �Է¹޾� �Է¹��� �������� ����
