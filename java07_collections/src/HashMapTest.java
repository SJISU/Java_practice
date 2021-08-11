import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapTest {

	public HashMapTest() {
		//Map interface�� ��ӹ��� Ŭ������ key,value �� �����Ѵ�
		//1.HashMap�� key�� value�����͸� �����Ѵ�
		//2.TreeMap�� key�� value�� �����͸� �����ϰ�,key�������� ���ĵȴ�
		
				
		HashMap<Integer, String > hm = new HashMap<Integer, String >();
		
		//��ü��.put(k,y) -> ��ü�߰�
		hm.put(1, "ȫ�浿");
		hm.put(100, "�������");
		hm.put(50, "�̼���");     
		hm.put(25, "�念��");	
		hm.put(33, "���·�"); //HashMap����� ��ü�ȿ� k��v�� ���� ������� �����ؼ� ����,,1�ϸ� ȫ�浿�̳����� 100�ϸ� ��������̳�����...
		
		//��ü��.get(k,y)-> �������°�,���������°�
		String name = hm.get(100); //100�� ������ int���ƴϰ� integer�� ���°�->�ڹٰ���ӽ�������ȯ���ְ�����
		System.out.println("100->"+name); //key�� value�� �˼��ִ� //get()�� �̿��Ͽ� key�� 100�� value���� String������ ����ְ� �װ� ����Ѵ�..
		
		//key������ �˾Ƴ��� value�� ���ϱ� ->key�� ���� ���ϴ� �޼ҵ�
		//Map���� ���Ѱ� Set�� ��Ƽ� �����ش� 		
		//HashMap ���� key����� ���Ͽ� Set�� ����ش�.
		
		// Set< key�������� > ������ü = HashMap��ü��.keySet();
		Set<Integer>keyList = hm.keySet(); //��� key�� �����ֱ�  -> keyList�� �ټ����� ����� ��...
		
		//Set�������̽��� �޼ҵ����ؼ� �����ֱ�:set���� �Ѱ��� ���ϴ� ��ɾ���->iterator��ӹ޾Ƽ� �ϳ��� �����ֱ�
		Iterator<Integer> ii = keyList.iterator(); //iterator ȣ��
		//iterator->��ü��.hasNext()
		while(ii.hasNext()) {//��ü�� ������ true,������ false 
			int k = ii.next(); //������ ������ k�� ���
			System.out.println("key="+k+", value="+hm.get(k)); //value���� hm�������Ƿ� hm.get(key���Է�)�ؼ� value�� ��� 
		}
		
		System.out.println("==================================================");
		
		HashMap<String, MemberVO> hm2 = new HashMap<String, MemberVO>(); //�츮������Ŭ������ value�� �־�����....
																		 //MemberVo�� �ֻ���Ŭ����-> objectŬ����
		//put(k,v);
		hm2.put("ȫ�浿", new MemberVO("ȫ�浿","��ȹ��","2020-10-10",5000)); //MemberVo�� �����ڸ޼ҵ� �̿��Ͽ� HashMap�� �߰� //ȫ�浿�� hashmap�� �־�ȣ���ϸ� MemberVo��ü�� ȣ���
		hm2.put("�̼���", new MemberVO("�̼���","�Ѱ���","2020-01-01",6000));
		hm2.put("�念��", new MemberVO("�念��","�ѹ���","2020-07-08",3000));
		hm2.put("�������", new MemberVO("�������","�λ��","2020-02-01",7000));
		hm2.put("���·�", new MemberVO("���·�","��ȹ��","2020-03-05",6000));
		
		System.out.println("=====key�� �̿��� ���� ������");
		//key��ϰ�������...
		Set<String> memberkey= hm2.keySet();
		//Iterator --set���� return�Ǵϱ� iteratorȣ���Ͽ� hasnext�̿�
		Iterator<String> iii = memberkey.iterator();
		while(iii.hasNext()) {
			
			String key = iii.next();
			MemberVO value = hm2.get(key); //vaule�� ������
			//System.out.println(value.toString()); //value��ü�ȿ� toString()�޼ҵ��ִ�->MemberVo�� �������
			System.out.print(value.getName()); // toString() �޼ҵ� �ȸ���� ���ٸ� ���� ������ �̷��� �����...
			System.out.print(value.getDepart());
			System.out.print(value.getHire());
			System.out.println(value.getSal());
		}
		
		System.out.println("=====key���� value�� �̿��Ͽ� ����������");
		
		// ��ü��.values(); --->HaspMapŬ���� �ȿ��ִ� �޼ҵ���--->�������̽� �ݷ��� ������ ��ȯ��-> �ݷ��ǿ� ��ƾ���
		Collection<MemberVO> values = hm2.values(); //value�� ���������� MemberVO�̱⶧���� �װ� ���ʸ����� �ؼ�...
		
		Iterator<MemberVO> membervalue =values.iterator();
		while(membervalue.hasNext()) {
			MemberVO vo = membervalue.next(); //������Ÿ���� MemberVO
			System.out.println(vo.toString());
		}
		
		
	}

	
	
	
	
	
	public static void main(String[] args) {
		new HashMapTest();

	}

}