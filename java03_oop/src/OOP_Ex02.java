import java.util.Scanner;

public class OOP_Ex02 {
	//�������-heap�� �����
	int dan; //�Է¹��� ���� ������ ���� =0;
	String gugu =""; //�������� ������ ���� ��Ʈ���� �ʱⰪ�� null
 
	public OOP_Ex02() { //������ // new�� ��ü����� ����Ǵ°�
				
	}
	
		
	//���Է¹ޱ�
	int danInput() {
		Scanner scan = new Scanner(System.in);//scan�� �������� //ctrl+�����̽� ������ import��
		System.out.print("���Է�=");
		return scan.nextInt(); //���� �������� : �޼ҵ� ������ ����
	}
	
	//�����ܸ����
	void gugudan() {
		
		for(int i=2; i<=9; i++) {
			gugu=gugu+dan+"*"+i+"="+dan*i+"\n";
			}		
	}	
	
	void start() {
		dan = danInput();
		gugudan();
		System.out.println(gugu);
		
		
	}
	
	public static void main(String[] args) { //main�� ���� Ŭ���� �ƴ�
		OOP_Ex02 oop = new OOP_Ex02(); //��ü���� //���θ޼ҵ�     1.
		oop.start();                    //                    2.
		//System.out.println(oop.gugudan(oop.danInput()));
	}

}
//�ֿܼ��� ���� �Է¹޾� �Է¹��� �������� ����
