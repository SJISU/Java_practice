import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class FileInputStreamTest {

	public FileInputStreamTest() {
			
		try {
			//파일의 내용을 읽어서 파일로 출력하기 // -인풋 아웃풋이 같이 일어난다
			//읽어올 파일
			File srcFile = new File("D://javasrc/BasicApi/CalendarTest.java"); //input ->BufferedReader 사용
			//출력할 파일
			File tarFile = new File("D://testFile/CalendarTestEc.java"); // output -> write()메소드사용
			
			FileReader fr= new FileReader(srcFile); //매개변수는 파일객체
			BufferedReader br = new BufferedReader(fr);//매개변수타입은 FileReader --> 한줄씩 읽었으면 좋겟다..BufferedReader 사용 //Buffer는 스트링으로 읽어옴
			
			FileWriter fw = new FileWriter(tarFile); //스트링쓸수있는 기능이 제공되는...
			
			while(true) {
				String str =br.readLine(); //한줄의데이터 읽으면됨->반복돌려서 여러줄읽을수있게
				//읽은 데이터가 없을때 null
				if(str==null) break;
				fw.write(str+"\n"); //엔터설정해줘야지 줄꿔서 나옴 -> +"\n" 안해주면 한줄로 출력됨
				System.out.println(str);
				
			}
			fw.close();
			br.close();
			fr.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new FileInputStreamTest();
	}

}
