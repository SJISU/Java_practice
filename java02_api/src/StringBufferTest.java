
public class StringBufferTest {

	public StringBufferTest() {
		start();
	}
	public void start() {
		StringBuffer sb1 = new StringBuffer(); //기본값은 16개의 문자를 저장할 수 있는 크기
		StringBuffer sb2 = new StringBuffer(100); //객체두개만듬 -객체생성시에 메모리 확보됨
		
		// append() : 문자열추가 - 알아서 공간을 더 확보함...
		sb1.append("Buffer append Test..");
		sb1.append(123456); //정수를 넣어도더해짐..기존의 내용끝에 문자열을 붙여줌...
		
		//insert() : index위치 문자 삽입
		sb1.insert(5, "(스트링버퍼)"); //위치에 문자삽입하고 원래문자는 뒤로 밀려감
		sb1.insert(15, 23234.21342554);
		
		//deleteCharAt() : 
		//0123456 7
		//Buffe(스트링버퍼)r a23234.21342554ppend Test..123456 : 현재데이터..
		sb1.deleteCharAt(6); // '스'삭제됨
		
		sb1.delete(1,4); // index 1부터 4앞까지 지우기
		
		//replace()
		//0123 45 67
		//Be(트링버퍼)r a23234.21342554ppend Test..123456 :현재데이터
		sb1.replace(1, 3, "(자바)"); //index 1부터 3앞까지를 "(자바)"로 치환
		
		//reverse() : 반대방향으로...
		sb1.reverse();

		
		
		//확보된 공간 확인하기
		System.out.println("sb1.capacity="+sb1.capacity()); //16byte -설정안하면
		System.out.println("sb2.capacity="+sb2.capacity()); //100byte
		System.out.println(sb1);
	}
	

	public static void main(String[] args) {
		new StringBufferTest(); //메인메소드에서는 개체만들고 생성자메소드에서 구현
	}

}
