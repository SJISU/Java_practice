import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {

	public HashSetTest() {
		//set인터페이스상속받은 클래스
		// 1. 입력순서를 유지하지 않는다
		// 2. 중복데이터를 허용하지 않는다.
		//TreeSet은 오름차순 정렬기능이 있지만 HashSet은 정렬은X
		
		double[] data = {12.3, 3.4, 5.6, 12.3, 5.2 , 9.1,9.1, 6.7};
		
		HashSet<Double> hs = new HashSet<Double>();
		
		for(double d :data) {
			hs.add(d); // d에 위에서 선언한 객체 넣어주기.....
		}
		
		System.out.println("size="+hs.size()); //중복데이터 없어져서 6이 나옴...
		
		//iterator인터페이스 - hasNext() , next()
		//데이터출력 -> 다른컬렉션에 의존해서 꺼내주는 기능 갖고옴..
		Iterator<Double> ii = hs.iterator();//--->hasNext() , next()
		
		while(ii.hasNext()){//객체가 있으면 true, 없으면 false//객체있을때 값을 가지고 나온다
			Double iiData = ii.next(); //꺼내준다-->순서 없이 나옴 //next()로 꺼낸데이터를 iiData에 넣어 출력한다..
			System.out.println(iiData);
		}
		
	}

	public static void main(String[] args) {
		new HashSetTest();

	}

}
