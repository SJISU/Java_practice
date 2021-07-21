import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputOutputTest {

	public DataInputOutputTest() {
		//DataOutPutStream�� ������ FileOutputStream�� ������ �Ѵ�
		try {
			//�⺻���������� ���� ���Ϸ� �����ϱ�
			File file = new File("D://testFile","data.txt"); //���ϰ�ü����
			FileOutputStream fos = new FileOutputStream(file); //����Ʈ ������ �����͸� �о���̴� Ŭ���� ,������ ������ �ۼ���
			DataOutputStream dos =new DataOutputStream(fos);  //�����͸� ��ȯ���־ ������ �а��� Ŭ����
															 // ������ ���ϰ� �����Ҽ� ���� ������ FileOutputStream �� �Ű������� �Ͽ�
			int num =1234;
			double data2= 5628.34;
			boolean boo = true;
			char lastName ='ȫ';
			
			//write() : �����͸� ���Ͽ� �ۼ�..data.txt�� �ۼ���
			dos.writeInt(num); //4byte
			dos.writeDouble(data2); //8byte
			dos.writeBoolean(boo); //1byte
			dos.writeChar(lastName); //2byte
			
			dos.close();
			fos.close();
			
		}catch(FileNotFoundException  fnfe) {
			System.out.println("������ �����....");
		}catch(IOException ie) {
			System.out.println("���Ϸ� ���� ����...");
		}
	}

	public static void main(String[] args) {
	
		new DataInputOutputTest();
	}

}
