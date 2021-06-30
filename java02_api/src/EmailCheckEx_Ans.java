import java.util.Scanner;

public class EmailCheckEx_Ans {
	
		

	public EmailCheckEx_Ans() {		
	}
	
	//메인에서 호출되어서 실행되는 메소드...
	public void start() {
		do {
			String email = inputEmail();
			 if(emailCheck(email)) { //제대로된 이메일
				 //아이디,도메인 분리해서 출력
				 emailPrint(email);
			 }else {//잘못된 메일
				 errorMailMessage(email);
			 }			
		}while(true);		
	}
	
	//이메일 입력
	public String inputEmail() {
		Scanner scan  = new Scanner(System.in);
		System.out.print("이메일 입력=");
		return scan.nextLine();
	}
	
	//이메일이 정상,잘못 확인 
	public boolean emailCheck(String email) {
		//정상 : true , 잘못 : false
		
		//@ : atmark
		//@이가 있어햐함 -@위치 찾아야함...indexOf 또는 laseindexOf
		int atmark = email.indexOf("@");  //없으면 -1이 나온다..
		int point = email.indexOf(".");
		//@이가 . 보다 앞에 와야한다, @이와.사이에 도메인이 있어야하므로 .-@이는 적어도 2보다 커야한다
		if(atmark ==-1 || point==-1 || atmark>point || point-atmark<=2 ) {//잘못된 메일주소일때 
			return false;
		}else {//정상메일 일때
			return true;
		}		
	}
	
	//잘못된 메일 메시지
	public void errorMailMessage(String email) {
		System.out.println(email+" 잘못된 이메일 주소입니다.");
	}
	
	//아이디와 도메인분리하여 출력
	public void emailPrint(String email) {
	   /*
	    split 사용하여 구하는방법
		String emailSplit[] = email.split("@");//0번째는 아이디 1번째는 도메인
	    System.out.println("아이디"+emailSplit[0]);
	    System.out.println("도메인"+emailSplit[1]);	
	   */
	
		//substring 사용하여 구하는방법
		//@이 위치구하여 @위치를 기준으로 아이디와 도메인 구한다...
		int atmark = email.indexOf("@");
		String id = email.substring(0,atmark);
		String domain = email.substring(atmark+1);
		System.out.println("아이디"+id);
	    System.out.println("도메인"+domain);			
	}	
	
	
	public static void main(String[] args) { //메인메소드에는 객체와 시작정도만..
		new EmailCheckEx_Ans().start();
	}

}
/*
 
 실행
 이메일 입력 = goguma@nate
 이메일을 잘못입력하였습니다..
 
 이메일 입력=goguma777.com
 이메일을 잘못입력하였습니다
 
 이메일 입력=goguma.nate@com
 이메일을 잘못입력하였습니다 
 
 이메일입력=goguma@nate.com
 아이디 = goguma777
 도메인 = nate.com
 
 이메일입력=
 
 
  */

// 입력 - 확인 - 정상 또는 오류
//이메일입력(반복) - 입력하고나면 이메일 유효성 확인- 정상이메일인경우에는 아이디와 도메인 분리해서출력
//								    - 오류인경우에는 오류메시지 출력
