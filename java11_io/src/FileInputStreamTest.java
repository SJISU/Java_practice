import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class FileInputStreamTest {

	public FileInputStreamTest() {
			
		try {
			//������ ������ �о ���Ϸ� ����ϱ� // -��ǲ �ƿ�ǲ�� ���� �Ͼ��
			//�о�� ����
			File srcFile = new File("D://javasrc/BasicApi/CalendarTest.java"); //input ->BufferedReader ���
			//����� ����
			File tarFile = new File("D://testFile/CalendarTestEc.java"); // output -> write()�޼ҵ���
			
			FileReader fr= new FileReader(srcFile); //�Ű������� ���ϰ�ü
			BufferedReader br = new BufferedReader(fr);//�Ű�����Ÿ���� FileReader --> ���پ� �о����� ���ٴ�..BufferedReader ��� //Buffer�� ��Ʈ������ �о��
			
			FileWriter fw = new FileWriter(tarFile); //��Ʈ�������ִ� ����� �����Ǵ�...
			
			while(true) {
				String str =br.readLine(); //�����ǵ����� �������->�ݺ������� �������������ְ�
				//���� �����Ͱ� ������ null
				if(str==null) break;
				fw.write(str+"\n"); //���ͼ���������� �ٲ㼭 ���� -> +"\n" �����ָ� ���ٷ� ��µ�
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
