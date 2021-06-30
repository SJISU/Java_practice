import java.util.ArrayList;
import java.util.List;

public class CollectionData {

	public CollectionData() {
		
	}
			//반환되는 데이터타입
	public  List<MemberVO> getMember() {  //데이터형에 ArrayList(MemberVO)는 상위클래스에서 하위클래스객체를 쓰지못하기대문에..
		//ArrayList에 사원정보를  담아서 리턴한다...
		//vector에서는 다 object으로 들어가기때문에 형변환 해줬엇음..제너릭을 사용해서 형변환필요x
		//"제너릭" --> < >
		
		//ArrayList<MemberVO> al = new ArrayList<MemberVO>();
		//   제너릭
		List<MemberVO> al2 = new ArrayList<MemberVO>(); //하위클래스를 상위클래스로 넣는것 가능하다,, //ArrayList는 List를 상속받고있다..
														// ArrayList클래스에 객체생성못해서 상위클래스에 객체생성하여넣음
														//al2는 ArrayList컬렉션의 객체...
														//al2라는 객체안에 add하여 데이터 저장...
		al2.add(new MemberVO("AAAA","기획부","2021-05-10",5000));
		al2.add(new MemberVO("BBBB","총무부","2021-01-01",6000));
		al2.add(new MemberVO("CCCC","인사부","2020-10-10",7000));
		al2.add(new MemberVO("DDDD","총무부","2021-02-02",5500));
		al2.add(new MemberVO("EEEE","인사부","2021-03-02",6500));
		
		return al2;
		
	}
}
