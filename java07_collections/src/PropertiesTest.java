import java.util.Enumeration;
import java.util.Properties;

public class PropertiesTest {

	public PropertiesTest() {
		//Properties�÷��� : key , value�� ��� String�� �÷����̴�....
		
		Properties prop = new Properties();
		
		//��ü �߰�
		//��ü��.setPrpperty();
		prop.setProperty("���̹�", "https://www.naver.com");
		prop.setProperty("����Ʈ��", "https://www.nate.com");
		prop.setProperty("����", "https://www.daum.net");
		prop.setProperty("����", "https://www.google.com");
		
		//��ü ���ö�
		//��ü��.getProperty() : Ű�� �̿��Ͽ� ��ü ������		
		System.out.println(prop.getProperty("����"));
		
		//key�� ���ϴ� �޼ҵ�
		//enumeration(�������̽�)(-hasMoreElements(),nextElement())���� return���ִ� �޼ҵ� ����Ͽ� ���key���ϱ�
		Enumeration e = prop.propertyNames(); //����Ŭ���� ���������� ���ʸ��� x
		while(e.hasMoreElements()) {//��ü�� ���� ���� ��� true, ������ false
		
			//Object obj = e.nextElement();
			String str = (String)e.nextElement(); //��������Ʈ�� String�ε� ���ʸ��� �ȵǾ object�� ���������->����ȯ�ʿ�
			System.out.println("key= "+str+", value= "+prop.getProperty(str)); //Ű�� str...getProperty�� Ű���־ value�� ���
			
		}
		
		
	}

	public static void main(String[] args) {
		new PropertiesTest();

	}

}