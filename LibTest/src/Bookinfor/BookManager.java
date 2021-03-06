
package Bookinfor;
import Login.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;



public class BookManager {
	Scanner scan = new Scanner(System.in);
	Calendar now = Calendar.getInstance();
	String menuTitle = "[  1.도서전체목록    2.도서검색    3.도서대여    4.도서반납     5.로그아웃     6.종료   7.처음메뉴로 돌아가기 ]";
	String adminTitle = "[  1.도서전체목록  2.도서추가  3.도서삭제  4.회원전체목록  5.회원추가  6.회원삭제  7.종료  8.처음메뉴로 돌아가기 ]";
	
	public BookManager() {
		
	}
	//관리자로그인 or 사용자로그인	
	public void selectUser(){
		try {
			do {
				System.out.print("[1.관리자 2.일반사용자] -> ");
				int num = Integer.parseInt(scan.nextLine());		
				switch(num) {		
				case 1:
					 adminStart();
					 break;
				case 2:
					 bookStart();
					 break;	
				default:
					System.out.println("메뉴를 잘못선택하였습니다. 다시 입력하세요");			
				}	
			}while(true);	
		}catch(NumberFormatException e) {
			System.out.println("다시 메뉴를 선택하세요");
			selectUser();
		}
	}	

	//관리자로그인
	public void adminStart() {
		boolean logResult = false;
		String adminid;
		String adminpw;
		
		do{
			adminid = inData("관리자 id="); 
			adminpw = inData("관리자 pw="); 			
			
			Login log =new Login(); 
			logResult = log.loginCheck(adminid,adminpw);	
		}while(!logResult);
		
		
		BookDataSet.basicBoSet(); 
		Login.basicLoSet();
		adMINProcessStart();		//관리자메뉴
	}		
	
	// 관리자 메뉴
	public void adMINProcessStart() {
		
		do {	
			System.out.println("[ 관리자 메뉴 ]");//7,8수정이나추가---->이중하나 "나가기"로 메뉴이름 바꾸기
			String menu = inData(adminTitle);
			if (menu.equals("1")) {// 전체도서목록
				allBookList(); //

			} else if (menu.equals("2")) {// 도서추가
				bookInsert();
				allBookList();
			} else if (menu.equals("3")) {// 도서삭제
				bookDelete();
				allBookList();
			} else if (menu.equals("4")) {// 전체회원목록
				 allUserPrint();
			} else if (menu.equals("5")) {// 회원추가
				memberInsert();
				allUserPrint();
			}else if (menu.equals("6")) {// 회원삭제
				 memberDelete();
				 allUserPrint();
			} else if (menu.equals("7")) {// 종료
				System.exit(0);
							
			} else if (menu.equals("8")) {//관리자로그아웃-처음으로돌아가기
				
				selectUser();
			
			}else {
				System.out.println("메뉴를 잘못선택하였습니다. 다시 입력하세요");	
			}

		} while (true);
	}
	
	//도서추가
	public void bookInsert() {
		
		BoVO vo = new BoVO();
		
		vo.setName(input("추가할 책이름을 입력하시오="));
		vo.setWriter(input("추가할 책의 저자명을 입력하시오="));
		
		vo.setCheck(inputCheck());//inData 입력받기전에 
		
		
		vo.setCate(input("추가할 책의 청구기호를 입력하시오="));
		vo.setDate(inData("추가할 책의 반납예정일="));
		
		BookDataSet.boList.put(vo.getName(), vo); 
		System.out.println("도서가 도서목록에 추가되었습니다");
	}

	//공백x입력메소드
	public String input(String msg) {
		Boolean flog=false;
		String out;
		
		while(true) {
			out = inData(msg);
			if(out.length()<=0) {
				System.out.println("한글자 이상입력해주세요");
				flog = false;				
			}else {
				flog = true;	
				break;
			}		
		}return out;		
	}	
	//check입력받는 메소드--->대출가능 , 대출불가가 이외는 x
	public String inputCheck(){		
		final String a="대출가능";
		final String b="대출불가";
		String data;
		Boolean flog=false;
		while(true){
			System.out.println("대출이 가능여부를 입력해주세요[대출가능,대출불가]=");
			data=scan.nextLine();
			if(data.equals(a))
			{
				data=a;
				flog = true;
				break;
			}
			else if(data.equals(b))
			{
				data=b;
				flog = true;
				break;
			}
			else
			{
				System.out.println("잘못입력하셨습니다");
				System.out.println("다시 입력부탁드립니다");
				flog = false;
			}
				}
		return data;
	}	
 
	

	//도서삭제
	public void bookDelete() {	
		

		while(true) {
			
			String delName = inData("삭제할 책이름을 입력하시오=");	
			
			if(!BookDataSet.boList.containsKey(delName)) {
				System.out.println("---검색 결과 도서가 없습니다---");	
			}else if(delName.length()==0) {			
				System.out.println("한글자 이상입력해주세요");			
			}else {
				BookDataSet.boList.remove(delName);
				System.out.println("도서가 삭제되었습니다");
				break;
			}		
		 }
	}
	
	
	//전체회원목록
	public void allUserPrint(){
		
		Collection<LogVo> values =Login.lo.values();
		Iterator<LogVo> ii =values.iterator();
		
		LogVo.userTitlePrint();
		
		boolean falg = false;
		
		if(ii.hasNext()==falg){			
			System.out.println("등록된 회원정보가 없습니다");		
		}else{	
			while(ii.hasNext()) {
				LogVo vo = ii.next();				
				vo.userPrint();
			}		
		}
	}
	//회원추가
 	public void memberInsert(){
 		LogVo vo = new LogVo();
 		
		String id =inputId2();
		vo.setId(id);
		String pwd =inputPw2();
		vo.setPwd(pwd);
		String name =inputName2();
		vo.setName(name);
		String tel=inputTel2();
		vo.setTel(tel);
		System.out.println("---회원가입이 완료되었습니다---");								
		
		Login.lo.put(id, vo);
 	}
 	
 	//===========================================================================================
 		//id입력메소드
 		public String inputId2() {
 			String newId;
 			Boolean flog=false;
 			while(true){
 				
 				newId = inData("추가할 사용자 id를 입력하시오(5글자 이하)=");			
 				if(newId.equals("")){
 					System.out.println("한글자 이상입력해주세요");
 					flog = false;				
 				}
 				else if(newId.length()<=5 && Login.lo.containsKey(newId)){				
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
 		public String inputPw2() {
 			String newPw;
 			Boolean flog=false; 			
 			while(true) {
 				newPw = inData("추가할 사용자 pw를 입력하시오(5글자이하)=");
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
 		public String inputName2() {
 			String newName;
 			Boolean flog=false; 			
 			while(true) {
 				newName = inData("추가할 사용자 이름를 입력하시오(2글자이상)="); 				
 				if(newName.length()==0){
 					System.out.println("2글자이상 입력해주세요");
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
 			
 		//전화번호 뒷번호 4자리
 		public String inputTel2() {
 			String newTel;
 			Boolean flog=false; 			
 			while(true) {
 				newTel = inData("추가할 사용자 핸드폰 뒷자리번호 4글자를 입력하시오=");
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

	//회원삭제
	public void memberDelete() {
		while(true) {
			String memId = inData("삭제할 일반사용자 id를 입력하시오=");
			if(!Login.lo.containsKey(memId)) {
				System.out.println("등록된 id가 없습니다.");
				
			}else if(Login.lo.containsKey(memId)){
				 		
				Login.lo.remove(memId);
				System.out.println("---회원삭제 완료되었습니다.---");
				break;
			}		
		}			
	}

	//일반사용자선택 - 회원가입,로그인
	public void bookStart() {
		Login.basicLoSet(); 
		Login b = new Login();					
		b.logStart(); //로그인메뉴들이실행			
				
		BookDataSet.basicBoSet();
		
		BoProcessStart();//일반사용자 메뉴목록불러줌
	}
	

	//일반사용자 메뉴
	public void BoProcessStart() {  //========5,6,7수정---> 이중하나 "나가기"로 메뉴이름 바꾸기
		
		do {
			System.out.println("[일반사용자 메뉴]");
			String menu = inData(menuTitle);
			if (menu.equals("1")) {// 전체도서목록
				allBookList(); //

			} else if (menu.equals("2")) {// 도서검색
				bookSearch();
			} else if (menu.equals("3")) {// 도서대여
				bookBorrow();
			} else if (menu.equals("4")) {// 도서반납
				bookBack();
			} else if (menu.equals("5")) {//로그아웃
				bookStart();							
			} else if (menu.equals("6")) {//종료
				System.exit(0);			
			}else if (menu.equals("7")) {//처음으로나가기
				selectUser();
			}else {
					System.out.println("메뉴를 잘못선택하였습니다. 다시 입력하세요");	
			}				
		} while (true);
	}
	
	// 도서전체목록 출력
	public void allBookList() {
		
		BoVO.titlePrint();

		Collection<BoVO> list = BookDataSet.boList.values();
		Iterator<BoVO> ii = list.iterator();
		
		while (ii.hasNext()) {
			BoVO vo = ii.next();
			
			BoVO.boVOPrint(vo);
		}
	}
	

	// 도서검색
	public void bookSearch() {
		do {			
			try {
				
				String b1 = inData("검색할 책이름="); 				
				BoVO b2 = BookDataSet.boList.get(b1); 
				System.out.println(b2.toString());
				break; 
			}catch(Exception e) {
				System.out.println("---검색 결과 도서가 없습니다---");
				//break; 
			}			
		}while(true);	
	}

	// 도서대여
	public void bookBorrow() {
		do {				
			try {			
				String b1 = inData("대여할 책 이름=");
				// key값이 b1의데이터check =대출불가이면 책 못빌림-> 불가한다는 메시지 뜨게함
				// 대출가능이면 책 빌릴수있음 -> 대여완료 라는 메시지 뜨게함				
				
				BoVO b2 = BookDataSet.boList.get(b1);
				String b3 = b2.getCheck();
			
				if (b3.equals("대출불가")) {
					System.out.println("대여 불가한 책 입니다");
					//break; 
				} else {
					System.out.println("---대여가 완료되었습니다---");
					checkUpdate(b1); //대여하고 나면 check 값이 대출불가로 바뀐다..
					dateUpdate(b1); //대여하고 나면 대출가능날짜바뀐다...
					break;				
				} 
			}catch(Exception e) {
				System.out.println("---검색 결과 도서가 없습니다---");
				//break;
			}
		}while(true);	
			
	}
	
	//------------> 하나의 메소드로 만들어보기...............
		//check-대출상태수정
		public void checkUpdate(String name) {
			String check = "대출불가";
			
			BoVO vo = BookDataSet.boList.get(name);
			vo.setCheck(check);
		}
		//check-대출상태수정
		public void checkUpdate2(String name) {
			String check = "대출가능";
			
			BoVO vo = BookDataSet.boList.get(name);
			vo.setCheck(check);
		}
		//check-대출후 대여가능날짜변경
		public void dateUpdate(String name){			
			Date date = new Date();
			now.setTime(new Date()); //현재날짜불러옴
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); //날짜형식바꿔줌
			
			now.add(Calendar.DATE, +14); //오늘로부터 14일지난후
			
			String da=df.format(now.getTime());
			
			BoVO vo = BookDataSet.boList.get(name);
						vo.setDate(da);
		}
		//check-반납후 대여가능날짜변경
		public void dateUpdate2(String name) {
			String check = "";
			
			BoVO vo = BookDataSet.boList.get(name);
			vo.setDate(check);
		}
	

	//도서반납
	public void bookBack() {
		do {	
			try {
				String b1 = inData("반납할 책 이름=");
				BoVO b2 = BookDataSet.boList.get(b1); 
				String b3 = b2.getCheck();
				
				if (b3.equals("대출불가")) {
					System.out.println("---반납이 완료되었습니다---");
					checkUpdate2(b1); //반납완료하고나면 check상태 수정되어야함...
					dateUpdate2(b1); //반납완료하면 대여가능날짜변경
					break;		
				} else if(b3.equals("대출가능")){
					System.out.println("반납불가한 책입니다");	
					
					//break;		
				} 
			}catch(Exception e) {
				System.out.println("---검색 결과 도서가 없습니다---");
				//break; 
			}
		}while(true);
	}

	// 콘솔에서 문자열 입력받는 메소드
	public String inData(String msg) {
		System.out.print(msg);
		return scan.nextLine();
	}

}
