import java.util.List;

public class ArrayListTest {

	public ArrayListTest() {

		//2.�ݷ���Ŭ������ ��ü�� ����� - �޼ҵ����Ͽ� ������ ����������
		CollectionData data = new CollectionData();
		
		//3.��ü�ȿ��� �޼ҵ� ȣ��		
		//��ȯ�Ǵ� ������Ÿ���� ��ü�� lst�� �־��� = ��ü.�޼ҵ��
		List<MemberVO> lst = data.getMember(); //��ȯ�� : List<MemnerVO> //������ �ȴ����� get����� �ҷ���List �� ������ ������ 
																	   //��ȯ���̶� �����ɷ� ��������������->List<MemberVO>		
		
		MemberVO vo2 = new MemberVO("ZZZ","��ȹ�Ѱ���","2020-01-02",5000); //�Ű������� �������ִ� �����ڸ޼ҵ尡 �����....
																		
		lst.add(2, vo2); //[2]�� vo2�� �ְ� ���ڸ����ִ� �����͵��� �ڷ� �и���...
		
		lst.remove(1); //index ���� --�ε���1���� �ִ� BBB��� ��������...//17�� ��������� ���系��
		lst.remove(vo2); //��ü������ ���� --��ü������ ���� ZZZ��� ��������
		
		//get() : ���� ������ ���� ���ɾ�
		for(int i=0; i<lst.size(); i++) { //lst ������ get()�ؼ� ������� ����Ʈ���ش�...
			MemberVO vo = lst.get(i); //������� lst�������� MemberVO�� �־ ������ش�....?
			vo.memberPrint();
		}
		
		//System.out.println(lst.toString());
	}
	
	public static void main(String[] args) {
		new ArrayListTest(); //1.������ ȣ��...
				

	}

}