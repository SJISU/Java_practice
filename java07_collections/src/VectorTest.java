import java.util.Calendar;
import java.util.Vector;

public class VectorTest {

	public VectorTest() {
		
	}
	
	/*
	 List(interface) : index가 존재한다.
	 		저장순서를 유지한다..-중간에서 빠지면 
	 */

	
	public Vector start() { //백터객체를만들고 -> vo객체를 만들고 -> 
		//vector 컬렉션
		Vector v =new Vector();
		
		//4개의 다양한데이터타입 정보들,,,
		String username ="홍길동";
		Integer num = 25010;
		Calendar cal = Calendar.getInstance();		
		MemberVO vo = new MemberVO("세종대왕","기획부","2021-06-10",1000);
		
		//Vector객체에 다른 객체 추가하기
		//add(),addElement()
		v.add(username);
		v.addElement(num);
		v.add(1,cal); //1번째에 있던애가 2번째로 밀려나고 1번째자리에 cal이 들어감
		v.addElement(vo);
							// [username][cal][num][vo]
		
		
		//remove() : index삭제
		//인덱스1번에 담겨있는거 삭제됨, 
		//v.remove(1);
		//v.remove(cal); //객체직접입력가능
		
		return v; //4개의데이터가 저장된 저장소 return
	}
		
	
//	public static void main(String[] args) {
//		new VectorTest().start();
//	}
	
	
}
