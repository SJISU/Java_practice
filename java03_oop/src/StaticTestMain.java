import java.util.Calendar;

public class StaticTestMain {

	public StaticTestMain() {
		
	}

	public static void main(String[] args) {
		StaticTest ss = new StaticTest();
		StaticTest ss2 = new StaticTest();
		
		ss.setAddr("��������"); //������ ������ ��� �������� �� ss2��ü������ ����� -�տ� static �� �پ��ֱ�빮��
		
		//String address = ss2.getAddr();
		//System.out.println("address="+address); //static�̾Ⱥپ��־��ٸ� �������� ���������̴�
		System.out.println(ss2.getAddr());
		
		//static ��������� ��ü���������ʰ� ����Ҽ��մ�.
		System.out.println("name="+ StaticTest.addr);	//��� -> name = ��������	
		
		Calendar now = Calendar.getInstance();
		System.out.println(now.get(Calendar.YEAR)); //year �տ��� static�� �پ��ֱ⶧���� ��ü��.�̾� ������
		
	}

}







//ss ���� ����3�� ���õǾ����� -num=1234 name=ȫ�浿 addr=������ setaddr getaddr -> 
//ss2���� ����3�� ���õǾ����� -num=1234 name=ȫ�浿 addr=������ setaddr getaddr