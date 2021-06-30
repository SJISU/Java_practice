import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ObjectCompareTest {

	public ObjectCompareTest() {
		
		List<MemberVO> mem = new ArrayList<MemberVO>(); //����Ŭ������ List�� ��ü����
		mem.add(new MemberVO("ȫ�浿","��ȹ��","2020-10-10",5000));		
		mem.add(new MemberVO("�̼���","�Ѱ���","2020-01-01",6000));
		mem.add(new MemberVO("�念��","�ѹ���","2020-07-08",3000));
		mem.add(new MemberVO("�������","�λ��","2020-02-01",7000));
		mem.add(new MemberVO("���·�","��ȹ��","2020-03-05",6000));
		mem.add(new MemberVO("���","������","2021-02-10",5000));
		
		System.out.println("==== ������ ======================"); //ArrayList�� �迭�� ������� ���´�
		//	 ���ʸ���ü   :�÷��ǰ�ü
		for(MemberVO vo : mem) {
			System.out.println(vo.toString());
		}
		
		
		System.out.println("====�޿��� ������������ ����====="); //����Ŭ������ Collection.sort�� �־ ����
		
		//CollectionsŬ�����߿� �����ϴ� �޼ҵ� -> sort(List,Comparator); ���
		//����Ŭ������ ����Ŭ������ü �������� AscSal�� Comparator�� �ִ´�
		
		//				��ü�� ��ü�ִ� �÷��� ,������ �����̵Ǵ� ����� �ִ� Comparetor��ü
		Collections.sort(mem,new CompareAscSal());
		for(MemberVO vo :mem) {
			System.out.println(vo.toString());
		}
		
		
		System.out.println("====�޿��� ������������ ����====="); //����Ŭ������ Collection.sort�� �־ ����
		
		Collections.sort(mem,new CompareDescSal());
		for(MemberVO vo :mem) {
			System.out.println(vo.toString());
		}
		
		System.out.println("====�̸��� ������������ ����====="); 
		
		Collections.sort(mem,new CompareAscName());
		for(MemberVO vo :mem) {
			System.out.println(vo.toString());
		}
		
		System.out.println("====�̸��� ������������ ����====="); 
		Collections.sort(mem,new CompareDescName());
		for(MemberVO vo : mem){
			System.out.println(vo.toString());
		}
		
		System.out.println("----�Ի����� ���������� ����----");
		Collections.sort(mem, new CompareAscHire());
		for(MemberVO vo : mem) {
			System.out.println(vo.toString());
		}
		
		System.out.println("----�Ի����� ���������� ����----");
		Collections.sort(mem, new CompareDescHire());
		for(MemberVO vo : mem) {
			System.out.println(vo.toString());
		}
	}
	
	//******
	//���� -�÷��Ǿȿ��ִ� ��ü�� ��� �� ��ü�������� �����ϴ°Ծƴ϶� �� ��ü�ȿ� �մ� Ư�������͸� ������ ����
	//String Ŭ������ �޼ҵ�-> ��ü��.compareTo()
	//���ڷ� ���� ��������,��������-> ����Ŭ���� -> �������̽� comparator��ӹ޾Ƽ� �����ȴ�...
			
	//�����ϴ� Ŭ������ Comparator �������̽��� ��ӹ޾� �����...
	
	//���ڸ� �̿��� �������� �����ϴ� Ŭ����
	class CompareAscSal implements Comparator<MemberVO>{ //���ʸ��� ���� ������ �����Ͱ� �ִ� ��ü��
		
		public int compare(MemberVO v1, MemberVO v2) { //5000 , 6000 //Comparator�������̽��� �޼ҵ带 �������̵��Ͽ� ���
			//    ���ǽ� 
			//    ������ ��ü�ǰ��� ������  -1, ���ʰ�ü�ǰ��� ũ�� +1 ,������ 0�� return ���ָ� �޼ҵ尡 �˾Ƽ� ���ش�
			return (v1.getSal() < v2.getSal())?  -1 :  (v1.getSal()> v2.getSal()) ? 1: 0 ;
		}		
	}
	
	//���ڸ� �̿��� �������� �����ϴ� Ŭ����
	class CompareDescSal implements Comparator<MemberVO>{
		public int compare(MemberVO v1, MemberVO v2) { //5000 , 6000 //Comparator�������̽��� �޼ҵ带 �������̵��Ͽ� ���
			//    ���ǽ� 
			//    ������ ��ü�ǰ��� ������  +1, ���ʰ�ü�ǰ��� ũ�� -1 ,������ 0�� return ���ָ� �޼ҵ尡 �˾Ƽ� ���ش�
			// +1,-1,0
			return (v1.getSal() < v2.getSal())?  1 :  (v1.getSal()> v2.getSal()) ? -1: 0 ;
		}			
	}
	
	  //�̸��� ������������ �����ϴ� Ŭ����
	   class CompareAscName implements Comparator<MemberVO>{
	      public int compare(MemberVO v1, MemberVO v2) {
	         //������ ������ -1, ������ ũ�� ���, ������ 0
	         //System.out.println(v1.getName()+", "+v2.getName()+"-->"+v1.getName().compareToIgnoreCase(v2.getName())); //����������������ϴ°�
//							"A"							"a" 	  -> "A"-"a" -> 65-97 = -32
	    	  return v1.getName().compareToIgnoreCase(v2.getName());
	      }
	   }   
	//�̸��� ������������ �����ϴ� Ŭ����
	   class CompareDescName implements Comparator<MemberVO>{
		      public int compare(MemberVO v1, MemberVO v2) { //compare��� �޼ҵ� �������̵�
//					"A"										"a"     -> A-a -> 65-97 = -32    -�±�ȯ
//		            "a"										"A"     -> a-A -> 97-65 =  32
		         return v2.getName().compareToIgnoreCase(v1.getName()); //===> -�������� �������� ��ũ�� //
		      }
		   }   

	
	//�Ի����� �������� ������������ �����ϴ�Ŭ����
	 class CompareAscHire implements Comparator<MemberVO>{
		 public int compare(MemberVO obj1, MemberVO obj2) {			 
			 return obj1.getHire().compareTo(obj2.getHire());
		 }		 
	 }
	 
	//�Ի����� �������� ������������ �����ϴ�Ŭ����
		 class CompareDescHire implements Comparator<MemberVO>{
			 public int compare(MemberVO obj1, MemberVO obj2) {				 
				 return obj2.getHire().compareTo(obj1.getHire());
			 }		 
		 }
	
	
	
	public static void main(String[] args) {
		new ObjectCompareTest();
	}

}
