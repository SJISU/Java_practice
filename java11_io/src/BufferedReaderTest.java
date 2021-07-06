import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BufferedReaderTest {

	public BufferedReaderTest() {
		try {
			
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);//InputStreamReader을 매개변수로 가진다 ////한글과 ㅇ영어를 길이에 상관없이 한꺼번에 다 읽어온다 enter까지 한번에 다 //임시저장메모리
			
			System.out.println("입력=");
			String txt = br.readLine(); //enter까지의 문자열을 버퍼에 담은후 한줄씩 String변환하여 리턴한다
			System.out.println("txt="+txt); 
		}catch(Exception e) {}
	}

	public static void main(String[] args) {
		
		new BufferedReaderTest();
	}

}
