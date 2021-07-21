import java.io.File;
import java.io.RandomAccessFile;


public class RandomAccessFileTest {

	public RandomAccessFileTest() {
		//���ϴ� ��ġ�� �����͸� �а� ���Ⱑ �����ϴ�.
		File f = new File("D://testFile/access.txt");
		try {
			
			//�ڹٿ����� �Է°� ����� ������ �и�,���������� RandomAccessFile�̶�� ��ü �ϳ��� ����� �б� �� �� ����
			//��������: w , �б�����: r , �б⾲�� :rw
			RandomAccessFile  raf = new RandomAccessFile(f,"rw");//���� ��ü����
			
			String str = "Java input output test programing";
			raf.writeBytes(str);
			raf.writeInt(12345);
			
			//������ ��ġ �̵�
			raf.seek(10);
			raf.writeBytes("ȫ�浿");
			
			//Ŀ���� �������ű��
			raf.seek(raf.length());
			
			byte []data = {65,66,67,68};
			raf.write(data);
			
			
			
			raf.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new RandomAccessFileTest();
	}

}
