import java.io.IOException;
import java.io.InputStream;

public class InputStreamTest {

	public InputStreamTest() {
		
		try {
		//InputStream : byte단위 문자를 입력받는다// 숫자x
		InputStream is = System.in; //InputSream 객체형성
		
		//System.out.print("입력=");		
		
		while(true){ //여러글자 입력하면 데이터 다 읽어서 출력시키기 위해서 반복문안에 넣는다..
//			
//			
//			//read한 값이 없을 경우 -1이 리턴된다.			
//			int code =is.read(); //1byte 읽어옴 ->ABCD 입력해도 A한개의값 65 만 나온다.... 
//								// InputStream의 read 매소드
//								//read 실행하면 int 가 나옴 -> int에 넣어줘야함
//								// 엔터 13 10 이 출력됨
//			
//			if(code==-1) break;
//			System.out.println((char)code); //출력한걸 바꾸고싶어서 형변환 (CHAR)
			
			byte data[]=new byte[8];
			// cnt : read데이터수 , data배열에 읽은 값이 있다			
			//int cnt = is.read(data);
			int cnt= is.read(data, 2,3);
			System.out.println(cnt+"---->"+new String(data)); //byte배열을 문자로 바꾸는것 ->객체형성
			//배열을 8칸을 만들어서 0 1 2 .... 7 8 ; --> 2,3,4인덱스자리에 배열을 보관하고..나머지인덱스에는NULL 이라서 출력할때 공백으로 출력 
		}
		
		}catch(IOException e) {}
	}

	public static void main(String[] args) {
		new InputStreamTest();

	}

}
