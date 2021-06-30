import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ObjectCompareTest {

	public ObjectCompareTest() {
		
		List<MemberVO> mem = new ArrayList<MemberVO>(); //상위클래스인 List에 객체생성
		mem.add(new MemberVO("홍길동","기획부","2020-10-10",5000));		
		mem.add(new MemberVO("이순신","총괄부","2020-01-01",6000));
		mem.add(new MemberVO("장영실","총무부","2020-07-08",3000));
		mem.add(new MemberVO("세종대왕","인사부","2020-02-01",7000));
		mem.add(new MemberVO("유승룡","기획부","2020-03-05",6000));
		mem.add(new MemberVO("김삿갓","영업부","2021-02-10",5000));
		
		System.out.println("==== 정렬전 ======================"); //ArrayList는 배열로 순서대로 나온당
		//	 제너릭객체   :컬렉션객체
		for(MemberVO vo : mem) {
			System.out.println(vo.toString());
		}
		
		
		System.out.println("====급여를 오름차순으로 정렬====="); //내부클래스를 Collection.sort에 넣어서 정렬
		
		//Collections클래스중에 정렬하는 메소드 -> sort(List,Comparator); 사용
		//상위클래스에 하위클래스객체 생성가능 AscSal를 Comparator에 넣는다
		
		//				객체가 전체있는 컬렉션 ,정렬할 기준이되는 기능이 있는 Comparetor객체
		Collections.sort(mem,new CompareAscSal());
		for(MemberVO vo :mem) {
			System.out.println(vo.toString());
		}
		
		
		System.out.println("====급여를 내림차순으로 정렬====="); //내부클래스를 Collection.sort에 넣어서 정렬
		
		Collections.sort(mem,new CompareDescSal());
		for(MemberVO vo :mem) {
			System.out.println(vo.toString());
		}
		
		System.out.println("====이름을 오름차순으로 정렬====="); 
		
		Collections.sort(mem,new CompareAscName());
		for(MemberVO vo :mem) {
			System.out.println(vo.toString());
		}
		
		System.out.println("====이름을 내림차순으로 정렬====="); 
		Collections.sort(mem,new CompareDescName());
		for(MemberVO vo : mem){
			System.out.println(vo.toString());
		}
		
		System.out.println("----입사일을 오름차순을 정렬----");
		Collections.sort(mem, new CompareAscHire());
		for(MemberVO vo : mem) {
			System.out.println(vo.toString());
		}
		
		System.out.println("----입사일을 내림차순을 정렬----");
		Collections.sort(mem, new CompareDescHire());
		for(MemberVO vo : mem) {
			System.out.println(vo.toString());
		}
	}
	
	//******
	//정렬 -컬렉션안에있는 객체를 담고 그 객체를가지고 정렬하는게아니라 그 객체안에 잇는 특정데이터를 가지고 정렬
	//String 클래스의 메소드-> 객체명.compareTo()
	//숫자로 정렬 오름차순,내림차순-> 내부클래스 -> 인터페이스 comparator상속받아서 만들면된다...
			
	//정렬하는 클래스는 Comparator 인터페이스를 상속받아 만든다...
	
	//숫자를 이용한 오름차순 정렬하는 클래스
	class CompareAscSal implements Comparator<MemberVO>{ //제너릭은 내가 정렬할 데이터가 있는 객체형
		
		public int compare(MemberVO v1, MemberVO v2) { //5000 , 6000 //Comparator인터페이스의 메소드를 오버라이딩하여 사용
			//    조건식 
			//    왼쪽의 객체의값이 작으면  -1, 왼쪽객체의값이 크면 +1 ,같으면 0을 return 해주면 메소드가 알아서 해준다
			return (v1.getSal() < v2.getSal())?  -1 :  (v1.getSal()> v2.getSal()) ? 1: 0 ;
		}		
	}
	
	//숫자를 이용한 내림차순 정렬하는 클래스
	class CompareDescSal implements Comparator<MemberVO>{
		public int compare(MemberVO v1, MemberVO v2) { //5000 , 6000 //Comparator인터페이스의 메소드를 오버라이딩하여 사용
			//    조건식 
			//    왼쪽의 객체의값이 작으면  +1, 왼쪽객체의값이 크면 -1 ,같으면 0을 return 해주면 메소드가 알아서 해준다
			// +1,-1,0
			return (v1.getSal() < v2.getSal())?  1 :  (v1.getSal()> v2.getSal()) ? -1: 0 ;
		}			
	}
	
	  //이름을 오름차순으로 정렬하는 클래스
	   class CompareAscName implements Comparator<MemberVO>{
	      public int compare(MemberVO v1, MemberVO v2) {
	         //왼쪽이 작으면 -1, 왼쪽이 크면 양수, 같으면 0
	         //System.out.println(v1.getName()+", "+v2.getName()+"-->"+v1.getName().compareToIgnoreCase(v2.getName())); //정렬전데이터출력하는것
//							"A"							"a" 	  -> "A"-"a" -> 65-97 = -32
	    	  return v1.getName().compareToIgnoreCase(v2.getName());
	      }
	   }   
	//이름을 내림차순으로 정렬하는 클래스
	   class CompareDescName implements Comparator<MemberVO>{
		      public int compare(MemberVO v1, MemberVO v2) { //compare라는 메소드 오버라이딩
//					"A"										"a"     -> A-a -> 65-97 = -32    -는교환
//		            "a"										"A"     -> a-A -> 97-65 =  32
		         return v2.getName().compareToIgnoreCase(v1.getName()); //===> -가나오면 오른쪽이 더크다 //
		      }
		   }   

	
	//입사일을 기준으로 오름차순으로 정렬하는클래스
	 class CompareAscHire implements Comparator<MemberVO>{
		 public int compare(MemberVO obj1, MemberVO obj2) {			 
			 return obj1.getHire().compareTo(obj2.getHire());
		 }		 
	 }
	 
	//입사일을 기준으로 내림차순으로 정렬하는클래스
		 class CompareDescHire implements Comparator<MemberVO>{
			 public int compare(MemberVO obj1, MemberVO obj2) {				 
				 return obj2.getHire().compareTo(obj1.getHire());
			 }		 
		 }
	
	
	
	public static void main(String[] args) {
		new ObjectCompareTest();
	}

}
