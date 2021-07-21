import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectInputStreamTest {

	public ObjectInputStreamTest() {
		try {
			
			File f = new File("D://testFile/object.txt");
			FileInputStream fis = new FileInputStream(f); 
			ObjectInputStream ois = new ObjectInputStream(fis); //파일의 내용을 읽어와서 출력함
			
			IoMemo memo = (IoMemo)ois.readObject();//객체를읽어와서 // 원래데이터형이 아닌 object로 가져옴
			
			memo.setVisible(true); // 객체가 파일로들어갔다가 나왔다
		
		}catch(Exception e) {
			
		}
	}

	public static void main(String[] args) {
		new ObjectInputStreamTest();

	}

}

//FileInputStream 의 read() 통해서 읽어 들인 바아트 배열의 Data를 저장한 후 FileOutputStream 의 wtite() 메소드를 이용하여 파일 출력을 한다.