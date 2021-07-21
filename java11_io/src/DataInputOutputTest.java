import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputOutputTest {

	public DataInputOutputTest() {
		//DataOutPutStream을 가지고 FileOutputStream을 만들어야 한다
		try {
			//기본데이터형의 값을 파일로 저장하기
			File file = new File("D://testFile","data.txt"); //파일객체생성
			FileOutputStream fos = new FileOutputStream(file); //바이트 단위로 데이터를 읽어들이는 클래스 ,파일의 내용을 작성함
			DataOutputStream dos =new DataOutputStream(fos);  //데이터를 변환해주어서 파일을 읽고쓰는 클래스
															 // 스스로 파일과 연동할수 없기 때문에 FileOutputStream 를 매개변수로 하여
			int num =1234;
			double data2= 5628.34;
			boolean boo = true;
			char lastName ='홍';
			
			//write() : 데이터를 파일에 작성..data.txt에 작성됨
			dos.writeInt(num); //4byte
			dos.writeDouble(data2); //8byte
			dos.writeBoolean(boo); //1byte
			dos.writeChar(lastName); //2byte
			
			dos.close();
			fos.close();
			
		}catch(FileNotFoundException  fnfe) {
			System.out.println("파일이 없어요....");
		}catch(IOException ie) {
			System.out.println("파일로 쓰기 에러...");
		}
	}

	public static void main(String[] args) {
	
		new DataInputOutputTest();
	}

}
