import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapTest {

	public TreeMapTest() {
		
		TreeMap<String, MemberVO> tm = new TreeMap<String, MemberVO>();
		
		//TreeMap은 key,value를 가진다.
		//key를 기준으로 정렬한다
		
		//객체명.put(k,v); : TreeMap객체 tm에 데이터넣기 
		tm.put("홍길동", new MemberVO("홍길동","기획부","2020-10-10",5000)); 
		tm.put("이순신", new MemberVO("이순신","총괄부","2020-01-01",6000));
		tm.put("장영실", new MemberVO("장영실","총무부","2020-07-08",3000));
		tm.put("세종대왕", new MemberVO("세종대왕","인사부","2020-02-01",7000));
		tm.put("유승룡", new MemberVO("유승룡","기획부","2020-03-05",6000));
		tm.put("김삿갓", new MemberVO("김삿갓","영업부","2021-02-10",5000));
		
		//System.out.println(tm.get("김삿갓"));
		
		System.out.println("=======key를 이용한 객체얻어오기=========");
		Set<String> keyList = tm.keySet(); //()keyset을 이용하여 Set이 들어온다
		Iterator<String> ii =keyList.iterator();
		while(ii.hasNext()) {
			//String key = ii.next();
			MemberVO vo = tm.get(ii.next()); //key값 ii.next를 변수설정안해주고 바로get에 넣어서 value값
			System.out.println(vo.toString()); //----->출력된걸보면 key값인 이름으로 정렬된건 확인할수있다..
			
		}
		
		//key값이 아닌 다른데이터로 정렬하고싶다..->입사일순,,,부서순,,,-->ObjectCompareTest에서 다룬다

		System.out.println("=======value를 이용한 객체 얻어오기=====");
		Collection<MemberVO> value = tm.values();
		Iterator<MemberVO> iii = value.iterator();
		while(iii.hasNext()) {
			MemberVO vo = iii.next();
			System.out.println(vo.toString());
		}
		
	}

	public static void main(String[] args) {
		new TreeMapTest();
		
	}

}
