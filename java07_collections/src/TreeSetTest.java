import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {
	String list[] = {"JAVA", "Spring","������������", "JAVA", "�ڹ�", "ORACLE", "������","ORACLE"};

	public TreeSetTest() {
		start();
	}

	public void start() {
		//TreeSet : �Է¼��� �������� �ʴ´�.
		//			�ߺ������� ������� �ʴ´�.
		//			�����Ѵ�. --->HashSet���� ������.....
		TreeSet<String> ts = new TreeSet<String>(); 
		
		//TreeSet�� ��ü �߰�
		for(String data :list) {
			ts.add(data); //������ ������ ��Ʈ��Ÿ�� data�־���			
			
		}
		//������������ ���ĵǾ� �ִ�.
		System.out.println("size="+ts.size()); //�ߺ��� ���ŵǾ� 6 ���´�..
		
		//6�� �� ������� ����
		//get�̶�¸޼ҵ��� iteractor��� ��ü�� return���ش� 
		Iterator<String> ii = ts.iterator();
		while(ii.hasNext()) { //��ü�ִ��� Ȯ���ϰ� �������
			String d = ii.next(); //�����ش�--> ������������ ���´�...
			System.out.println(d);
		}
		
		//������������ �����Ͽ� ��ü ��������
		//descendingIterator()
		Iterator<String>iii = ts.descendingIterator();
		while(iii.hasNext()) {
			String d = iii.next(); //�Ѱ� ������� ��� ->������ -> �����ִ¾� ������� ���->������ =>�ݺ� 
			System.out.println(d);
		}
		
		
		
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		new TreeSetTest();

	}

}
