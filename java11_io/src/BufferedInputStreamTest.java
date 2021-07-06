import java.io.BufferedInputStream;

public class BufferedInputStreamTest {

	public BufferedInputStreamTest() {
		
		try {
			//BufferedInputStream : 바이트단위로 문자를 읽어 버퍼에 저장후 한줄씩 읽을 수 있는 객체- 숫자를 써도 문자로 읽는다
			BufferedInputStream  bis = new BufferedInputStream(System.in);
			byte[] data = new byte[10]; 			
			System.out.println("입력=");
			int cnt = bis.read(data);
			System.out.println(new String(data));
		}catch(Exception e) {
			
		}
		
		
	}

	public static void main(String[] args) {
		new BufferedInputStreamTest();
	}

}
