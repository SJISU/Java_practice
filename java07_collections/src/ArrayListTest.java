import java.util.List;

public class ArrayListTest {

	public ArrayListTest() {

		//2.콜렉션클래스를 객체로 만든다 - 메소드사용하여 데이터 가져오려고
		CollectionData data = new CollectionData();
		
		//3.객체안에든 메소드 호출		
		//반환되는 데이터타입의 객체에 lst에 넣어줌 = 객체.메소드명
		List<MemberVO> lst = data.getMember(); //반환형 : List<MemnerVO> //변수에 안담으면 get멤버로 불러온List 의 정보들 없어짐 
																	   //반환형이랑 같은걸로 변수만들어줘야함->List<MemberVO>		
		
		MemberVO vo2 = new MemberVO("ZZZ","기획총괄부","2020-01-02",5000); //매개변수를 가지고있는 생성자메소드가 실행됨....
																		
		lst.add(2, vo2); //[2]에 vo2를 넣고 그자리에있던 데이터들은 뒤로 밀린다...
		
		lst.remove(1); //index 삭제 --인데스1번에 있던 BBB사원 없어진다...//17줄 만들기전에 만든내용
		lst.remove(vo2); //객체명으로 삭제 --겍체명으로 삭제 ZZZ사원 없어진다
		
		//get() : 값을 가지고 오는 명령어
		for(int i=0; i<lst.size(); i++) { //lst 데이터 get()해서 끄집어내서 프린트해준다...
			MemberVO vo = lst.get(i); //순서대로 lst의정보를 MemberVO에 넣어서 출력해준다....?
			vo.memberPrint();
		}
		
		//System.out.println(lst.toString());
	}
	
	public static void main(String[] args) {
		new ArrayListTest(); //1.생성자 호출...
				

	}

}
