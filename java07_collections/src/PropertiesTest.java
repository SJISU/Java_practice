import java.util.Enumeration;
import java.util.Properties;

public class PropertiesTest {

	public PropertiesTest() {
		//Properties컬렉션 : key , value가 모두 String인 컬렉션이다....
		
		Properties prop = new Properties();
		
		//객체 추가
		//객체명.setPrpperty();
		prop.setProperty("네이버", "https://www.naver.com");
		prop.setProperty("네이트온", "https://www.nate.com");
		prop.setProperty("다음", "https://www.daum.net");
		prop.setProperty("구글", "https://www.google.com");
		
		//객체 얻어올때
		//객체명.getProperty() : 키를 이용하여 객체 얻어오기		
		System.out.println(prop.getProperty("다음"));
		
		//key를 구하는 메소드
		//enumeration(인터페이스)(-hasMoreElements(),nextElement())으로 return해주는 메소드 사용하여 모든key구하기
		Enumeration e = prop.propertyNames(); //상위클래스 오브젝쓰고 제너릭은 x
		while(e.hasMoreElements()) {//객체가 남아 있을 경우 true, 없으면 false
		
			//Object obj = e.nextElement();
			String str = (String)e.nextElement(); //원래데이트는 String인데 제너릭아 안되어서 object로 담겨져있음->형변환필요
			System.out.println("key= "+str+", value= "+prop.getProperty(str)); //키값 str...getProperty에 키값넣어서 value값 출력
			
		}
		
		
	}

	public static void main(String[] args) {
		new PropertiesTest();

	}

}
