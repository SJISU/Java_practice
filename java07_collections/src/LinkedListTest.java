import java.util.LinkedList;

public class LinkedListTest {

	public LinkedListTest() {
		start();
	}

	public void start() {
		//LinkedList => List, Deque,Queue 상속받고있음
		//			   Queue일때 입력순서를 유지 출력은 먼저 입력된 객체가 출력된다.
		//			   출력된 객체는 컬렉션에서 지워진다.
		//			   Deque 일때는 양쪽에서 객체를 입력또는 출력할수 있다.
		
		LinkedList<String> ll = new LinkedList<String>();
		
		//객체추가
		// offer() - 데이터넣기
		ll.offer("홍길동");
		ll.offer(new String("세종대왕"));
		ll.offer(String.valueOf(1234)); //1234는 int형이기때문에 문자형으로 형변화 해줘야한다. //String클래스의valueof사용
		ll.offer(5678+""); // "" 을 더하여 문자열로 바꿔줌
		
		System.out.println("size->"+ll.size()); //담겨져있는 객체수 구하기 //4
		
		/*
			//객체 얻어오기
			//pop() - 데이터출력
			
			String data = ll.pop(); // 제일앞에 있는 객체가 얻어지고 컬렉션에서는 지워진다.
			System.out.println("data="+data); //제일앞에있는 홍길동이 끄집어나옴..//세개가 남아있음		
			//남아있는 객체수 구하기
			//size() 이용하여 확인
			System.out.println("size--->"+ll.size()); //3 // 끄집어내고나면 끄집어진 데이터 지워진것 확인할수있다
		*/
		
		
		//객체가 남아있는지 확인해주는
		//isEmpty()->AbstractCollection 클래스에 잇음
		//true : 컬렉션에 객체가 없다. false:컬렉션에 남아있는 객체가 있다.-->객체가 있을때 pop할ㄲㅓ임
		while(!ll.isEmpty()) { //객체가 있을때만 작성할거임 ->
			String data = ll.pop(); //데이터 끄집어내기 //ll의 데이터형:String
			int cnt = ll.size(); //남은겍체수
			System.out.println(data+",남은객체수="+cnt); //끄집어낸데이터,남은데이터수
			
		}
		
		
	}
	
	
	public static void main(String[] args) {
		
		new LinkedListTest();
	}

}
