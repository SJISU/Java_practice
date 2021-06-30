
public class MethodTest2 {
	//4줄에서 11줄까지 전역변수 -static 쓸수있음
	boolean power = false; //true:켜짐 , false :꺼짐
	//채널
	//	 상수화  -한번대입되면 바꿀수 없음
	//			-데이터형 왼쪽에 final키워드를 표시
	//			-상수화된 변수는 모든변수명을 대문자로 표시한다.
	final int CHANNEL_MIN = 1;
	final int CHANNEL_MAX = 20;
	int channelNow = 11;
	
	public MethodTest2() { //생성자메소드 - 클래스명 과 같아야 한다. -객체생성할때 한번필요
		
	}
	//power버튼 누른 경우
	//	   반환형 메소드명(매개변수,매개변수,.......){
	//		실행문; //기능구현 - 기능을 구현해주는 실행문..
	// 		}	
	//소문자로 시작하고 합성어일 경우 두번째 단어부터 대문자로 ()있다.
	void powerStart() {
		power = !power;
		/*
		if(power) {
			power = false;
		}else {
			power = true;
		}
		*/
		System.out.println("power="+power);				
	}
		
	    //단을 입력하면 구구단을 구하여 반환하는 메소드를 생성
		//void : 반환형이 없다.	
		String gugudan(int dan) { //String - 반화되는 데이터타입으로써준다
			//실행문 1개만 내보낸다.
			String result = "";
			for(int i=2; i<10; i++){
				result += dan+"*"+i+"="+dan*i+"\n";
			}
			return result;
		}	
	//채널번호올리기 : 현재채널 +1 
	void channelUp() {
		if(channelNow == CHANNEL_MAX) {
			channelNow = CHANNEL_MIN;
		}else {
			channelNow++;
		}
		
		channelPrint(); //현재클래스의 닥른메소드 호출
		
	}
	//채널번호내리기
	void channelDown() {
		if(channelNow == CHANNEL_MIN) {
			channelNow= CHANNEL_MAX;
		}else {
			channelNow--;
		}
		
		channelPrint();
	}
	//채널번호 출력하는 메소드
	void channelPrint() {
		System.out.println("채널번호="+channelNow);
	}
	
	//static 키워드 -메소드와 변수에 쓴다 ,생성자 메소드에는 안쓴다
	static void sum(int max) {
		int tot=0;
		for(int i=1; i<=max; i++) {
			tot+=i;
		}
		System.out.println("1~"+max+"의 합은="+tot);
	}
	
	
}
