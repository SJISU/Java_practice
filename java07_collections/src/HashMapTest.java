import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapTest {

	public HashMapTest() {
		//Map interface를 상속받은 클래스는 key,value 가 존재한다
		//1.HashMap은 key와 value데이터를 저장한다
		//2.TreeMap은 key와 value로 데이터를 저장하고,key기준으로 정렬된다
		
				
		HashMap<Integer, String > hm = new HashMap<Integer, String >();
		
		//객체명.put(k,y) -> 객체추가
		hm.put(1, "홍길동");
		hm.put(100, "세종대왕");
		hm.put(50, "이순신");     
		hm.put(25, "장영실");	
		hm.put(33, "유승룡"); //HashMap저장소 객체안에 k와v를 각각 순서대로 정렬해서 저장,,1하면 홍길동이나오고 100하면 세종대왕이나오고...
		
		//객체명.get(k,y)-> 값얻어오는것,값가져오는것
		String name = hm.get(100); //100을 썻지만 int가아니고 integer로 보는것->자바가상머신이형변환해주고잇음
		System.out.println("100->"+name); //key로 value값 알수있다 //get()을 이용하여 key가 100인 value값을 String변수로 담아주고 그걸 출력한다..
		
		//key가뭔지 알아내서 value값 구하기 ->key의 정보 구하는 메소드
		//Map에서 구한걸 Set에 담아서 구해준다 		
		//HashMap 에서 key목록을 구하여 Set에 담아준다.
		
		// Set< key데이터형 > 생성객체 = HashMap객체명.keySet();
		Set<Integer>keyList = hm.keySet(); //모든 key값 구해주기  -> keyList의 다섯명의 목록이 들어감...
		
		//Set인터페이스의 메소드사용해서 꺼내주기:set에는 한개씩 구하는 기능없음->iterator상속받아서 하나씩 꺼내주기
		Iterator<Integer> ii = keyList.iterator(); //iterator 호출
		//iterator->객체명.hasNext()
		while(ii.hasNext()) {//객체가 있으면 true,없으면 false 
			int k = ii.next(); //있으면 꺼내서 k에 담기
			System.out.println("key="+k+", value="+hm.get(k)); //value값은 hm에있으므로 hm.get(key값입력)해서 value값 출력 
		}
		
		System.out.println("==================================================");
		
		HashMap<String, MemberVO> hm2 = new HashMap<String, MemberVO>(); //우리가만든클래스를 value로 넣었을때....
																		 //MemberVo의 최상위클래스-> object클래스
		//put(k,v);
		hm2.put("홍길동", new MemberVO("홍길동","기획부","2020-10-10",5000)); //MemberVo의 생성자메소드 이용하여 HashMap에 추가 //홍길동을 hashmap에 넣어호출하면 MemberVo객체가 호출됨
		hm2.put("이순신", new MemberVO("이순신","총괄부","2020-01-01",6000));
		hm2.put("장영실", new MemberVO("장영실","총무부","2020-07-08",3000));
		hm2.put("세종대왕", new MemberVO("세종대왕","인사부","2020-02-01",7000));
		hm2.put("유승룡", new MemberVO("유승룡","기획부","2020-03-05",6000));
		
		System.out.println("=====key를 이용한 정보 얻어오기");
		//key목록가져오기...
		Set<String> memberkey= hm2.keySet();
		//Iterator --set으로 return되니깐 iterator호출하여 hasnext이용
		Iterator<String> iii = memberkey.iterator();
		while(iii.hasNext()) {
			
			String key = iii.next();
			MemberVO value = hm2.get(key); //vaule값 꺼내기
			//System.out.println(value.toString()); //value객체안에 toString()메소드있다->MemberVo에 만들어줌
			System.out.print(value.getName()); // toString() 메소드 안만들어 놨다면 위에 한줄을 이렇게 만든다...
			System.out.print(value.getDepart());
			System.out.print(value.getHire());
			System.out.println(value.getSal());
		}
		
		System.out.println("=====key없이 value를 이용하여 정보얻어오기");
		
		// 객체명.values(); --->HaspMap클래스 안에있는 메소드사용--->인터페이스 콜렉션 형으로 반환됨-> 콜렉션에 담아야함
		Collection<MemberVO> values = hm2.values(); //value의 데이터형은 MemberVO이기때문에 그걸 제너릭으로 해서...
		
		Iterator<MemberVO> membervalue =values.iterator();
		while(membervalue.hasNext()) {
			MemberVO vo = membervalue.next(); //데이터타입은 MemberVO
			System.out.println(vo.toString());
		}
		
		
	}

	
	
	
	
	
	public static void main(String[] args) {
		new HashMapTest();

	}

}
