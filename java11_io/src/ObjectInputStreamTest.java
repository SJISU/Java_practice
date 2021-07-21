import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectInputStreamTest {

	public ObjectInputStreamTest() {
		try {
			
			File f = new File("D://testFile/object.txt");
			FileInputStream fis = new FileInputStream(f); 
			ObjectInputStream ois = new ObjectInputStream(fis); //������ ������ �о�ͼ� �����
			
			IoMemo memo = (IoMemo)ois.readObject();//��ü���о�ͼ� // �������������� �ƴ� object�� ������
			
			memo.setVisible(true); // ��ü�� ���Ϸε��ٰ� ���Դ�
		
		}catch(Exception e) {
			
		}
	}

	public static void main(String[] args) {
		new ObjectInputStreamTest();

	}

}

//FileInputStream �� read() ���ؼ� �о� ���� �پ�Ʈ �迭�� Data�� ������ �� FileOutputStream �� wtite() �޼ҵ带 �̿��Ͽ� ���� ����� �Ѵ�.