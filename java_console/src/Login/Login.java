package Login;
import java.util.HashMap;
import java.util.Scanner;

public class Login {

	Scanner scan = new Scanner(System.in);
	String menuTitle = "메뉴[1.회원가입, 2.로그인, 3.로그아웃]";

	boolean flag = false;

	static HashMap<String, LogVo> lo = new HashMap<String, LogVo>();// 회원정보보관

	public Login() {
	}
	public void logStart() {

		do {
			String menu = inData(menuTitle);
			if (menu.equals("1")) {// 회원가입
				// enter();

			} else if (menu.equals("2")) {// 로그인
				// logIn();
			} else if (menu.equals("3")) {// 로그아웃
				// logout();
			} else if (menu.equals("4")) {// 종료 ...음?
				System.exit(0);
			} else {

			}

		} while (true);

	}
	// id입력받음\
//	String io;
//	while(true) { //->break
//	io =inData("id=");
//		boolean a = lo.containsKey(lo.get(io)); //id정보가 같으면 true
//		if(a==true) {
//			System.out.println("중복된 id입니다. 다른id를 입력하세요.");
//		}else  break;
//	}
//	//pwd입력받음
	// 회원가입정보입력하는메소드
//	public void enter() {
//		//이름입력받음
//		String name = inData("이름 입력="); 
//		String pw = inData("password=");
//		
//		
//		lo.put("성지수", new LogSet(,io,pw)); //LogSet클래스에...
//	}
//	
//		//로그인 메소드
//		public void logIn(String id, String pwd) {
//			
//			if(lo.containsKey(id)) {
//				if(!lo.get(id).equals(pwd)) {
//					System.out.println("틀린비밀번호입니다");
//				}else {				
//					System.out.println("로그인 성공");
//					//flag = true; 				
//				}
//			}else {
//				System.out.println("존재하지 않는 아이디 입니다.");
//			}
//		}

	// 로그인메소드
//	public boolean logIn() {
//		if(id==""|| pwd =="") {
//			System.out.println("id와 password를 입력하시오");
//			return false;
//		}else {
//			if(lo.containsKey(id)) { //id가 있는경우에
//				if(!lo.get(id).equals(pwd)) {//pwd가 다를때
//					System.out.println("틀린비밀번호입니다");
//					return true;
//				}else {
//					System.out.println("로그인 성공");
//					return true;			
//				}				
//			}else {
//			System.out.println("존재하지 않는 아이디 입니다.");
//			return false;
//		}	
//		
//		}
//	}	
//	
	// 로그아웃 메소드
//	public void logout() {
//		if (!flag) {
//			System.out.println("로그인이 되어 있지 않습니다"); // ---->
//			return; /// 음.......
//		}
//		// flag =false; //순서 음...
//		System.out.println("로그아웃합니다");
//
//	}

	// 로그인 체크 구현(true:로그인성공 ,false : 로그인실패)

	public String inData(String msg) {
		System.out.println(msg + "->");
		return scan.nextLine();
	}

}
