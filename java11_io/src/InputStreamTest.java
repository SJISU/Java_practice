import java.io.IOException;
import java.io.InputStream;

public class InputStreamTest {

	public InputStreamTest() {
		
		try {
		//InputStream : byte���� ���ڸ� �Է¹޴´�// ����x
		InputStream is = System.in; //InputSream ��ü����
		
		//System.out.print("�Է�=");		
		
		while(true){ //�������� �Է��ϸ� ������ �� �о ��½�Ű�� ���ؼ� �ݺ����ȿ� �ִ´�..
//			
//			
//			//read�� ���� ���� ��� -1�� ���ϵȴ�.			
//			int code =is.read(); //1byte �о�� ->ABCD �Է��ص� A�Ѱ��ǰ� 65 �� ���´�.... 
//								// InputStream�� read �żҵ�
//								//read �����ϸ� int �� ���� -> int�� �־������
//								// ���� 13 10 �� ��µ�
//			
//			if(code==-1) break;
//			System.out.println((char)code); //����Ѱ� �ٲٰ�; ����ȯ (CHAR)
			
			byte data[]=new byte[8];
			// cnt : read�����ͼ� , data�迭�� ���� ���� �ִ�			
			//int cnt = is.read(data);
			int cnt= is.read(data, 2,3);
			System.out.println(cnt+"---->"+new String(data)); //byte�迭�� ���ڷ� �ٲٴ°� ->��ü����
			//�迭�� 8ĭ�� ���� 0 1 2 .... 7 8 ; --> 2,3,4�ε����ڸ��� �迭�� �����ϰ�..�������ε�������NULL �̶� ����Ҷ� �������� ��� 
		}
		
		}catch(IOException e) {}
	}

	public static void main(String[] args) {
		new InputStreamTest();

	}

}
