import java.util.Calendar;
import java.util.Vector;

public class VectorMain {

	public VectorMain() {
		//VectorTestŬ������ start()�޼ҵ带 ȣ���ϸ� Vector ���ϵȴ�..
		//�װ��� ��ü�� ���⿡ ���ϵǴ��� Ȯ��,,,,,
		
		VectorTest vt = new VectorTest();
		Vector vvv= vt.start();
		
		//elementAt(),get() : ������ ������
		
		String aaa =(String)vvv.elementAt(0); //���Ͱ�ü��. //0��° �մ°� �� �ߴ��� ��Ʈ������������ ������ �����Ƿ� object�� �޾���
		System.out.println("aaa="+aaa);
		
		Calendar ccc = (Calendar)vvv.get(1); //vvv�� �ε���1�� �ִ°Ŵ� ������Ʈ�����̹Ƿ� Į����Ÿ�Կ� �����������Ƿ� ����ȯ �ؼ� �ִ´�->���ʸ������༭
		System.out.println("ccc="+ccc);
		
		Integer iii = (Integer)vvv.get(2);
		System.out.println("iii="+iii);
		
		MemberVO vo = (MemberVO)vvv.elementAt(3);
		vo.memberPrint();
		
		//toString() : ���ڿ��� ���
		System.out.println(vvv.toString());
	}

	public static void main(String[] args) {
		new VectorMain();

	}

}