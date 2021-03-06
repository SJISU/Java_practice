package Login;
import java.util.HashMap;
import java.util.Scanner;
import Bookinfor.*; 

public class Login {

	//관리자 id,pwd
	private final String ADMINID ="admin";
	private final String ADMINPW ="1234";
	
	
	Scanner scan = new Scanner(System.in);
	String menuTitle = "[  1.회원가입	        2.로그인	        3.로그아웃	    4.종료	    5.처음메뉴로 돌아가기 ]";

	boolean flag = false;
	
	// 일반사용자 정보보관
	public static HashMap<String, LogVo> lo = new HashMap<String, LogVo>(); //value값 String을 LogVo로 수정

	public static void basicLoSet() {
		
		lo.put("asd1",new LogVo("asd1","1234","김철수","6786"));
		lo.put("asd2",new LogVo("asd2","1234","김영희","9854"));
		lo.put("asd3",new LogVo("asd3","1234","배수지","1010"));
		lo.put("asd4",new LogVo("asd4","1234","이지은","0516"));
		lo.put("asd5",new LogVo("asd5","1234","한소희","1116"));
		
		
	}	
	
	public Login() {
	}

	//관리자 선택시
	//로그인 체크 구현(true : 로그인성공,false:로그인실패)			
	public boolean loginCheck(String adminid,String adminpwd) {
				
		if(adminid.equals(ADMINID)){
			if(adminpwd.equals(ADMINPW)){
				System.out.println("---관리자 로그인 되었습니다---");
				return true;
			}else if(!adminpwd.equals(ADMINPW)){ 
				System.out.println("등록된 관리자pw가 아닙니다");
				return false;
			}
			else {
				return false;
			}	
		}else if(!adminid.equals(ADMINID)){
			System.out.println("등록된 관리자id가 아닙니다");
			return false;
		}else {
			return false;
		}	
	}
	
	//일반사용자 선택시
	public void logStart() {
		boolean logResult = false;
		do {
			System.out.println("[일반사용자 메뉴]");
			String menu = inData(menuTitle);
			if (menu.equals("1")) {// 회원가입
				join();
			} else if (menu.equals("2")) {// 로그인
				logResult=logIn();
				if(logResult==false)
				{
					logIn();
				}
			} else if (menu.equals("3")) {// 로그아웃
				logout();
			} else if (menu.equals("4")) {// 종료
				System.exit(0); 
				break;//???
			} else if (menu.equals("5")) {//처음으로 돌아가기				
				BookManager bb = new BookManager();
				bb.selectUser();
			} else {
				System.out.println("메뉴를 잘못선택하였습니다. 다시 입력하세요");				
			}
		} while(!logResult);

	}

	//회원가입	
	public void join() {		
		LogVo vo = new LogVo();
		
		String id =inputId();
		vo.setId(id);
		
		vo.setPwd(inputPw());		
		vo.setName(inputName());		
		vo.setTel(inputTel());
		System.out.println("---회원가입이 완료되었습니다---");								
		
		lo.put(id, vo);		
	}	

	// 로그인메소드
		public boolean logIn() {
		
			String id = inData("id를 입력하시오=");
			String pwd = inData("pw를 입력하시오=");
			
			if(id.equals("")|| pwd.equals("")) {
				System.out.println("id와 password를 입력하시오");
				return false;
			}else {
				if(lo.containsKey(id)) { //id가 있는경우에
					
					LogVo vo =Login.lo.get(id); 
					String pass =vo.getPwd(); 
				
				if(!pass.equals(pwd)) {//pwd가 다를때 --오른쪽pwd는 입력된것
					
					System.out.println("틀린비밀번호 다시 로그인해주세요 입니다");
					return true;
				}else {
					System.out.println("---로그인 성공하였습니다---");
					flag = true; //로그아웃메소드에서 사용
					return true;
					
				}				
			}else {//id가 없는경우
			System.out.println("존재하지 않는 아이디 입니다.");
			return false;
			}				
		}
}	

	// 로그아웃 메소드
	public void logout() {
		if (!flag) {
			System.out.println("로그인이 되어 있지 않습니다"); 
			return; 
		}
		flag =false; 
		System.out.println("로그아웃합니다");

	}
	
//===========================================================================================
	//id입력메소드
	public String inputId() {
		String newId;
		Boolean flog=false;
			while(true){	
				newId = inData("일반사용자 id를 입력하시오(5글자 이하)=");			
				if(newId.equals("")){
					System.out.println("한글자 이상입력해주세요");
					flog = false;				
				}
				else if(newId.length()<=5 && lo.containsKey(newId)){				
					System.out.println("중복된 id입니다. 다른id를 입력하세요.");					
					flog = false;				
				}else if(newId.length()>5){						
					System.out.println("입력 가능한 id 글자 수를 초과하였습니다");
					flog = false;
				}
				else{
					flog = true;	
					break;
				}
			}		
			return newId;	
	}
	//pw입력메소드
	public String inputPw() {
		String newPw;
		Boolean flog=false;
		
		while(true) {
			newPw = inData("일반사용자 pw를 입력하시오(5글자이하)=");
			if(newPw.equals("")){
				System.out.println("한글자 이상입력해주세요");
				flog = false;				
						
			}else if(newPw.length()>5){						
				System.out.println("입력 가능한 pw 글자 수를 초과하였습니다");
				flog = false;
			}
			else{
				
				flog = true;	
				break;
			}
		}		
		return newPw;	
			
	}
	//이름입력받는메소드	
	public String inputName() {
		String newName;
		Boolean flog=false;
		
		while(true) {
			newName = inData("일반사용자 이름를 입력하시오(2글자이상)=");
			
			if(newName.length()==0){
				System.out.println("일반사용자 이름를 입력하시오=");
				flog = false;				
			}else if(newName.length()>0 && newName.length()<2){						
				System.out.println("2글자이상 입력해주세요");
				flog = false;
			}else {
			
				flog =true;	
				break;
			}
		}		
		return newName;				
		}
		
	//전화번호 뒷번호 4잘
	public String inputTel() {
		String newTel;
		Boolean flog=false;
		
		while(true) {
			newTel = inData("일반사용자 핸드폰 뒷자리번호 4글자를 입력하시오=");
			if(newTel.length()==0){
				System.out.println("4글자를 입력해주세요");
				flog = false;	
			}else if(newTel.length()<4){						
				System.out.println("4글자를 입력해주세요");
				flog = false;
			}else if(newTel.length()>4){						
				System.out.println("입력 가능한 글자 수를 초과하였습니다");
				flog = false;	
			}else {				
				flog =true;	
				break;
			}
		}		
		return newTel;				
		
	}	

	public String inData(String msg) {
		System.out.print(msg);
		return scan.nextLine();
	}

}
