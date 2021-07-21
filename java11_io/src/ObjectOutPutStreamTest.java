import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectOutPutStreamTest {

	public ObjectOutPutStreamTest() {
		try {
			File f = new File("D://testFile/object.txt");
			FileOutputStream fos = new FileOutputStream(f);//바이트 단위로 데이터를 읽어들이는 클래스 ,파일의 내용을 작성함 - 쓰기를 할거니까
			
			ObjectOutputStream  oos = new ObjectOutputStream(fos); // 스스로 File에 접근할수 없기 때문에 FileOutputStream을 매개변수로 가진다
			
			IoMemo memo = new IoMemo();
			oos.writeObject(memo); //f에 IoMemo 객체를 직렬화하여 저장 //클래스를객체화하여 읽어와서 파일에다가 작성함
			
			oos.close();
			fos.close();
			System.out.println("객체 쓰기 완료");
			
		}catch(Exception  e) {
			
		}
	}

	public static void main(String[] args) {
		new ObjectOutPutStreamTest();

	}

}

//FileInputStream 의 read() 통해서 읽어 들인 바아트 배열의 Data를 저장한 후 FileOutputStream 의 wtite() 메소드를 이용하여 파일 출력을 한다.

