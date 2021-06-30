package test;

public class DefaultData {
	String name = "홍길동"; //앞에아무것도안붙이면 default 잇음.. staic으로 멤버변수 선언하면 생성된객체들이 name공통으로 가지고있으므로
								 // 어떤객체에서 name을 바꾸면 모든객체의 name이 바뀐다...
	String tel = "010-1234-5678";
	
	public DefaultData() {
	
	}
	
	public DefaultData(String name,String tel ) { //두개의 데이터를 받아 멤버에 옮기는 메소드...
		this.name = name; //현재클래스의 네임이라는 변수 :멤버변수...
		this.tel = tel;
	}
	
	public static void sum() { //메소드 앞에static붙이면 dd2.sum(); 에서 DefaultData.sum(); 으로도 사용할수있다.. 
							  // 객체명.메소드 ---> 클래스명.메소드로 사용 가능...
							  // tot와 i는 지역변수여서 sum이 실행되면 지역변수가 생김 -28번째줄과비교
		int tot=0;
		for(int i=1; i<=100; i++) {
			tot+=i;
		}
		System.out.println("tot="+tot);
	}
	
	
	public String getName() { //여기에는 static 사용불가..name은 멤버변수로서 객체 new 생성해야한다...
							 // 멤버변수가 만들어지기때문에 클래스명.메소드로 사용불가..아니면 멤버변수앞에 static을 써야함
		return name;
	}
}

