import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

public class DataInputTest {

	public DataInputTest() { //�ۼ��� ������ ������ �о�ͼ� ���
		try {
			File f = new File("D://testFile","data.txt"); //�Ʊ������� �����͸� �о���ٴ�
			FileInputStream fis = new FileInputStream(f); //������ ������ ����
			DataInputStream dis = new DataInputStream(fis); // ������ ���ϰ� �����Ͽ� �о�ü����� ������ fileinputstream �� �Ű������� ������
			
			//int double boolean char ������� 
			//read��������() : ������ �о�´�
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
