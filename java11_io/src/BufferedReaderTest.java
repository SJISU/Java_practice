import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BufferedReaderTest {

	public BufferedReaderTest() {
		try {
			
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);//InputStreamReader�� �Ű������� ������ ////�ѱ۰� ����� ���̿� ������� �Ѳ����� �� �о�´� enter���� �ѹ��� �� //�ӽ�����޸�
			
			System.out.println("�Է�=");
			String txt = br.readLine(); //enter������ ���ڿ��� ���ۿ� ������ ���پ� String��ȯ�Ͽ� �����Ѵ�
			System.out.println("txt="+txt); 
		}catch(Exception e) {}
	}

	public static void main(String[] args) {
		
		new BufferedReaderTest();
	}

}
