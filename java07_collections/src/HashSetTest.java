import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {

	public HashSetTest() {
		//set�������̽���ӹ��� Ŭ����
		// 1. �Է¼����� �������� �ʴ´�
		// 2. �ߺ������͸� ������� �ʴ´�.
		//TreeSet�� �������� ���ı���� ������ HashSet�� ������X
		
		double[] data = {12.3, 3.4, 5.6, 12.3, 5.2 , 9.1,9.1, 6.7};
		
		HashSet<Double> hs = new HashSet<Double>();
		
		for(double d :data) {
			hs.add(d); // d�� ������ ������ ��ü �־��ֱ�.....
		}
		
		System.out.println("size="+hs.size()); //�ߺ������� �������� 6�� ����...
		
		//iterator�������̽� - hasNext() , next()
		//��������� -> �ٸ��÷��ǿ� �����ؼ� �����ִ� ��� �����..
		Iterator<Double> ii = hs.iterator();//--->hasNext() , next()
		
		while(ii.hasNext()){//��ü�� ������ true, ������ false//��ü������ ���� ������ ���´�
			Double iiData = ii.next(); //�����ش�-->���� ���� ���� //next()�� ���������͸� iiData�� �־� ����Ѵ�..
			System.out.println(iiData);
		}
		
	}

	public static void main(String[] args) {
		new HashSetTest();

	}

}
