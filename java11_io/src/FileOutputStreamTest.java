import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class FileOutputStreamTest {

	public FileOutputStreamTest() {
		
		try {
			
			File f = new File ("D://testFile/OutputTest.txt"); //어디에 저장할지 객체생성
			
			InputStream is = System.in; //여기에서 데이터 작성하여 쓰기할것이다
			FileOutputStream fis = new FileOutputStream(f); //매개변수는 File f
			System.out.print("입력=");
			
			int cnt =0;//몇바퀴 돌았는 지 카운트 하고싶을때
			
			while(true) {
				
				int data = is.read();
				if(data==-1)break;
				fis.write(data); //쓴글자가 f파일안에 들어가서 쓰기가됨
				System.out.println(++cnt+"-->"+(char)data); //몇바퀴 돌았는 지 카운트 하고싶을때 //콘솔에서는 깨져보여도 파일안에서는 문제없다
				
				
				
				
				
				}
			fis.close(); //쓰기가 끝나면 close
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	public static void main(String[] args) {
		new FileOutputStreamTest();

	}

}
