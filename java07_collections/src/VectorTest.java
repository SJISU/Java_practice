import java.util.Calendar;
import java.util.Vector;

public class VectorTest {

	public VectorTest() {
		
	}
	
	/*
	 List(interface) : index�� �����Ѵ�.
	 		��������� �����Ѵ�..-�߰����� ������ 
	 */

	
	public Vector start() { //���Ͱ�ü������� -> vo��ü�� ����� -> 
		//vector �÷���
		Vector v =new Vector();
		
		//4���� �پ��ѵ�����Ÿ�� ������,,,
		String username ="ȫ�浿";
		Integer num = 25010;
		Calendar cal = Calendar.getInstance();		
		MemberVO vo = new MemberVO("�������","��ȹ��","2021-06-10",1000);
		
		//Vector��ü�� �ٸ� ��ü �߰��ϱ�
		//add(),addElement()
		v.add(username);
		v.addElement(num);
		v.add(1,cal); //1��°�� �ִ��ְ� 2��°�� �з����� 1��°�ڸ��� cal�� ��
		v.addElement(vo);
							// [username][cal][num][vo]
		
		
		//remove() : index����
		//�ε���1���� ����ִ°� ������, 
		//v.remove(1);
		//v.remove(cal); //��ü�����Է°���
		
		return v; //4���ǵ����Ͱ� ����� ����� return
	}
		
	
//	public static void main(String[] args) {
//		new VectorTest().start();
//	}
	
	
}
