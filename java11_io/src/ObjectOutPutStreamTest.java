import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectOutPutStreamTest {

	public ObjectOutPutStreamTest() {
		try {
			File f = new File("D://testFile/object.txt");
			FileOutputStream fos = new FileOutputStream(f);//����Ʈ ������ �����͸� �о���̴� Ŭ���� ,������ ������ �ۼ��� - ���⸦ �ҰŴϱ�
			
			ObjectOutputStream  oos = new ObjectOutputStream(fos); // ������ File�� �����Ҽ� ���� ������ FileOutputStream�� �Ű������� ������
			
			IoMemo memo = new IoMemo();
			oos.writeObject(memo); //f�� IoMemo ��ü�� ����ȭ�Ͽ� ���� //Ŭ��������üȭ�Ͽ� �о�ͼ� ���Ͽ��ٰ� �ۼ���
			
			oos.close();
			fos.close();
			System.out.println("��ü ���� �Ϸ�");
			
		}catch(Exception  e) {
			
		}
	}

	public static void main(String[] args) {
		new ObjectOutPutStreamTest();

	}

}

//FileInputStream �� read() ���ؼ� �о� ���� �پ�Ʈ �迭�� Data�� ������ �� FileOutputStream �� wtite() �޼ҵ带 �̿��Ͽ� ���� ����� �Ѵ�.

