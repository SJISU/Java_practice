import java.util.Calendar;

public class GenericMain {

	public GenericMain() {
		String data = "����� ������ �����";
		GenericTest gt = new GenericTest();
		gt.setUsername(data);
		//System.out.println(gt.getUsername());
		
		GenericTest gt2 = new GenericTest();
				
		
		GenericTest<MemberVO> gt3 = new GenericTest<MemberVO>();
		gt3.setUsername(new MemberVO("ȫ","��ȹ��","2021-01-21",8000)); //���ʸ��׽�Ʈ�� ����Ǿ��ٰ� ���°�

		MemberVO vo = gt3.getUsername();		
		System.out.println(vo.toString());
		
		Calendar now = Calendar.getInstance();
		GenericTest<Calendar> gt4 = new GenericTest<Calendar>(now); //(now)�Ѱ� setUsername�޼ҵ�� ���ϰ� �ٷ� �Ű������������ִ� �����ڸ޼ҵ��set���ذ�
				
		System.out.println(gt4.getUsername()); //�޷�����
	}

	public static void main(String[] args) {
		new GenericMain();
	}

}