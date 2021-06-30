import test.DefaultData; 
import test.LottoOOP;

public class ModfierTest {

	public ModfierTest() { //현재클래스의 생성자에서 객체만듦
//		LottoOOP lotto =new LottoOOP(); //LottoOOP가 허용해주어야함 - 패키지(폴더)가 다르면 import해줘야 사용가능한,,
//		lotto.lottoStart();
	
		DefaultData dd =new DefaultData();
		//객체명.멤버변수-그 객체안에있는 데이터에 접근가능
		//System.out.println("이름="+dd.name); //멤버변수앞에 public 이 있어야 부를수있다..
		//System.out.println("연락처="+dd.tel); //class DefaultData안의 멤버변수 String앞에 public이없기때문에불가
		
		//허용안한 멤버변수가 필요하면 메소드를 통해서 불러올수있음
		System.out.println("이름="+dd.getName());
		
		DefaultData dd2 =new DefaultData("이순신","010-8888-8888"); 
		
		dd2.sum(); 
				
		
		DefaultData.sum(); //sum앞에 ststic이 붙어있어서 객체안만들고 클래스명.메소드()
		//DefaultData.getName(); -> 불가능
	
	}

	public static void main(String[] args) {
		//접근제한자
		// 클래스 : public ,default(생략)
		//생정사메소드, 메소드 :  public ,protected, default, private
		
		new ModfierTest(); //객체생성 - 생성메소드안의 메소드 호출됨..
		
	} 

}
//33번째 줄에서 만든객체가 생성메소드를 실행시킨다..생성메소드에서 DefaultData 클래스의 객체갸 만들어짐
//16줄에서 DefaultData객체의 메소드를 이용하여 객체의 전역변수 name 출력...
//18번째 줄에서 dd2 객체를 만들어서 DefaultData 클래스의 매개변수가 있는 생성메소드를 받음..
//20번째줄 23번째 줄 모두 실행됨...DefaultData 클래스의sum메소드는 앞에  static이 있어서 클래스명.메소드로도 호출가능