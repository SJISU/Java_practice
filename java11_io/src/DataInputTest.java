import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

public class DataInputTest {

	public DataInputTest() { //작성된 파일읜 내용을 읽어와서 출력
		try {
			File f = new File("D://testFile","data.txt"); //아까저장한 데이터를 읽어오겟다
			FileInputStream fis = new FileInputStream(f); //파일의 내용을 읽음
			DataInputStream dis = new DataInputStream(fis); // 스스로 파일과 연결하여 읽어올수없기 때문에 fileinputstream 을 매개변수로 가진다
			
			//int double boolean char 순서대로 
			//read데이터형() : 파일을 읽어온다
			int inData = dis.readInt();
			double douData =dis.readDouble();
			boolean booData = dis.readBoolean();
			char charData = dis.readChar();
			
			System.out.println(inData);
			System.out.println(douData);
			System.out.println(booData);
			System.out.println(charData);
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
	 new DataInputTest();

	}

}
