import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderTest {

	public InputStreamReaderTest() {
		//문자(char)단위로 입력받는 객체
		InputStreamReader isr = new InputStreamReader(System.in);
		
		try {
			
			System.out.print("입력=");
			while(true) {

//				int code = isr.read(); //한번에 1문자씩 입력받는다.-문자를입력받아서 int를 리턴
//				if(code==-1) break;
//				System.out.println(code+"--->"+(char)code);
				
				//배열을 이용하여 입력받기
				char[]data = new char[5];
				int cnt =isr.read(data); //int는 글자수를 리턴해줌->이걸보고 읽은데이터,문자가 있나없나를 판단
				if(cnt<=0)break;					
												// new String(data)
				System.out.println("cnt:"+cnt+"-->"+String.valueOf(data)+"--->"+data);//char배열인 data를 String으로 형변환하여 출력해준다
				
				
				
			}
		}catch(IOException e) {}
	}

	public static void main(String[] args) {
		
		new InputStreamReaderTest();
	}

}
