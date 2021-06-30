import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {
	String list[] = {"JAVA", "Spring","스프링프레임", "JAVA", "자바", "ORACLE", "스프링","ORACLE"};

	public TreeSetTest() {
		start();
	}

	public void start() {
		//TreeSet : 입력순서 유지하지 않는다.
		//			중복데이터 허용하지 않는다.
		//			정렬한다. --->HashSet과의 차이점.....
		TreeSet<String> ts = new TreeSet<String>(); 
		
		//TreeSet에 객체 추가
		for(String data :list) {
			ts.add(data); //위에서 선언한 스트링타입 data넣어줌			
			
		}
		//오름차순으로 정렬되어 있다.
		System.out.println("size="+ts.size()); //중복은 제거되어 6 나온다..
		
		//6개 다 끄집어내서 찍어보기
		//get이라는메소드없어서 iteractor라는 객체로 return해준다 
		Iterator<String> ii = ts.iterator();
		while(ii.hasNext()) { //객체있는지 확인하고 끄집어내기
			String d = ii.next(); //꺼내준다--> 오름차순으로 나온다...
			System.out.println(d);
		}
		
		//내림차순으로 정렬하여 객체 가져오기
		//descendingIterator()
		Iterator<String>iii = ts.descendingIterator();
		while(iii.hasNext()) {
			String d = iii.next(); //한개 끄집어내고 출력 ->지워짐 -> 남아있는애 끄집어내고 출력->지워짐 =>반복 
			System.out.println(d);
		}
		
		
		
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		new TreeSetTest();

	}

}
