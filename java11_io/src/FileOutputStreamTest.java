import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class FileOutputStreamTest {

	public FileOutputStreamTest() {
		
		try {
			
			File f = new File ("D://testFile/OutputTest.txt"); //��� �������� ��ü����
			
			InputStream is = System.in; //���⿡�� ������ �ۼ��Ͽ� �����Ұ��̴�
			FileOutputStream fis = new FileOutputStream(f); //�Ű������� File f
			System.out.print("�Է�=");
			
			int cnt =0;//����� ���Ҵ� �� ī��Ʈ �ϰ������
			
			while(true) {
				
				int data = is.read();
				if(data==-1)break;
				fis.write(data); //�����ڰ� f���Ͼȿ� ���� ���Ⱑ��
				System.out.println(++cnt+"-->"+(char)data); //����� ���Ҵ� �� ī��Ʈ �ϰ������ //�ֿܼ����� ���������� ���Ͼȿ����� ��������
				
				
				
				
				
				}
			fis.close(); //���Ⱑ ������ close
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	public static void main(String[] args) {
		new FileOutputStreamTest();

	}

}
