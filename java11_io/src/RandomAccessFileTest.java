import java.io.File;
import java.io.RandomAccessFile;


public class RandomAccessFileTest {

	public RandomAccessFileTest() {
		//원하는 위치의 데이터를 읽고 쓰기가 가능하다.
		File f = new File("D://testFile/access.txt");
		try {
			
			//자바에서는 입력과 출력이 별도로 분리,예외적으로 RandomAccessFile이라는 객체 하나로 쓰기와 읽기 둘 다 가능
			//쓰기전용: w , 읽기전용: r , 읽기쓰기 :rw
			RandomAccessFile  raf = new RandomAccessFile(f,"rw");//쓰기 객체생성
			
			String str = "Java input output test programing";
			raf.writeBytes(str);
			raf.writeInt(12345);
			
			//쓰기할 위치 이동
			raf.seek(10);
			raf.writeBytes("홍길동");
			
			//커서를 마지막옮기기
			raf.seek(raf.length());
			
			byte []data = {65,66,67,68};
			raf.write(data);
			
			
			
			raf.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new RandomAccessFileTest();
	}

}
