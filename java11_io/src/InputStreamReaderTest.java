import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderTest {

	public InputStreamReaderTest() {
		//����(char)������ �Է¹޴� ��ü
		InputStreamReader isr = new InputStreamReader(System.in);
		
		try {
			
			System.out.print("�Է�=");
			while(true) {

//				int code = isr.read(); //�ѹ��� 1���ھ� �Է¹޴´�.-���ڸ��Է¹޾Ƽ� int�� ����
//				if(code==-1) break;
//				System.out.println(code+"--->"+(char)code);
				
				//�迭�� �̿��Ͽ� �Է¹ޱ�
				char[]data = new char[5];
				int cnt =isr.read(data); //int�� ���ڼ��� ��������->�̰ɺ��� ����������,���ڰ� �ֳ������� �Ǵ�
				if(cnt<=0)break;					
												// new String(data)
				System.out.println("cnt:"+cnt+"-->"+String.valueOf(data)+"--->"+data);//char�迭�� data�� String���� ����ȯ�Ͽ� ������ش�
				
				
				
			}
		}catch(IOException e) {}
	}

	public static void main(String[] args) {
		
		new InputStreamReaderTest();
	}

}
