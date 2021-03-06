import java.util.Calendar;
import java.util.Vector;

public class VectorMain {

	public VectorMain() {
		//VectorTest클래스의 start()메소드를 호출하면 Vector 리턴된다..
		//네개의 객체가 여기에 리턴되는지 확인,,,,,
		
		VectorTest vt = new VectorTest();
		Vector vvv= vt.start();
		
		//elementAt(),get() : 데이터 꺼내기
		
		String aaa =(String)vvv.elementAt(0); //백터객체점. //0번째 잇는것 겟 했더니 스트링데이터형에 담을수 없으므로 object에 받아줌
		System.out.println("aaa="+aaa);
		
		Calendar ccc = (Calendar)vvv.get(1); //vvv의 인덴스1에 있는거는 오브젝트형식이므로 칼렌더타입에 넣을수없으므로 형변환 해서 넣는다->제너릭안해줘서
		System.out.println("ccc="+ccc);
		
		Integer iii = (Integer)vvv.get(2);
		System.out.println("iii="+iii);
		
		MemberVO vo = (MemberVO)vvv.elementAt(3);
		vo.memberPrint();
		
		//toString() : 문자열로 출력
		System.out.println(vvv.toString());
	}

	public static void main(String[] args) {
		new VectorMain();

	}

}
