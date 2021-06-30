package test;

public class ProtectedTest2 {
	protected String tel = "010-1234-8959";
	//프로텍디드가 붙어있기때문에 객체생성안됨
	protected ProtectedTest2(){
		System.out.println("다른패키지의 생성자메소드");
	}
	protected void telOutput() {
		System.out.println("전화번호="+tel);
	}
	public String gettel() { //다른패키지,상속이 아니어도 사용가능한메소드인데
			return tel;       
		}
		
	public static ProtectedTest2 getInstance() { //*****
		return new ProtectedTest2();
	} // static을 붙여서 //객체를만드는 메소드를 이용하여 객체생성메소드불른후 -메소드사용
		
	
	
}
