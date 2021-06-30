import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

import Empinfor.EmpDataSet;
import Empinfor.EmpVO;

public class EmpManager { //사원관리하는클래스
	Scanner scan = new Scanner(System.in);
	String menuTitle ="메뉴[1.사원전체목록, 2.사원추가, 3.사원수정, 4.사원삭제, 5.종료]";
	
	public EmpManager() {
		
	}
	
	public void employeeStart() {
		
		boolean logResult = false;
		do{//로그인-실패시 다시실행
			String userid = inData("아이디"); //
			String userpwd = inData("비밀번호"); // 그다음 상수변수들이 가지고있는 데이터와같은지 확인하여 로그인시켜줌
											   //login클래스로 가서 관리자 아이디비번이 맞는지 확인됨
			Login log =new Login(); //메소드 쓰기위해서 객체형성
			logResult = log.loginCheck(userid,userpwd);	
		}while(!logResult);
		
		//로그인 성공하면 오는곳
		//System.out.println("로그인성공");
		//사원의 기본정보 생성
		EmpDataSet.basicEmpSet(); //패캐지가 다를땐 임포트
		
		allEmpList(); //사원전체목록출력	
		EmpProcessStart();//메뉴목록 불러줌....
	}	
	
	//메뉴
	public void EmpProcessStart() {
		do {
			//메뉴입력받음
			String menu= inData(menuTitle); //1~5중에 하나 입력
			if(menu.equals("1")) {//전체사원목록
				allEmpList(); //
				
			}else if (menu.equals("2")){//사원추가->사원정보입력받아야함...->입력받아서 EmpVO에 담는다...->list에추가
				empInsert();
				allEmpList(); //추가됬는지확인
			}else if(menu.equals("3")) {//사원수정
				empUpdate();
				allEmpList(); //수정됬는지확인
			}else if(menu.equals("4")) {//사원삭제
				empDelete();
				allEmpList();
			}else if(menu.equals("5")) {//종료
				System.exit(0); // 이걸 만나면 프로그램 끝남...
			}else {
				System.out.println("메뉴를 잘못선택하였습니다. 다시 입력하세요");
				
			}			
			
		}while(true);
	}
	
	//사원추가->사원등록
	public void empInsert() {
		//1명의 사원정보를 저장할 VO객체 생성하기
		EmpVO vo = new EmpVO();
		
		//사원번호 입력받아서 vo 변수에 넣는다
		vo.setEmpNo(inData("사원번호"));//사원번호 
		vo.setEmpName(inData("사원명"));
		vo.setTel(inData("연락처"));
		
		do {
			boolean falg = true;
			try {
				vo.setSal(Integer.parseInt(inData("급여"))); //-------예외발생가능성
			}catch(NumberFormatException nfe){
				//에러가 발생할때만 오는곳
				falg = false;
				System.out.println("급여는 숫자로 입력하세요..");
			}
			  //발생하든안하든 무조건오는곳
			if(falg) break; 
		}while(true);
		
		vo.setHiredate(inData("입사일"));
		
		EmpDataSet.empList.put(vo.getEmpName(), vo);//empListdp추가
	}
	
	//사원수정-연락처,급여만 수정가능
	public void empUpdate() {
		//변경할 정보를 확인
		String editName = inData("수정할 사원명입력"); //누구정보수정
		
		String editMenu = inData("수정할 피드선택[1.연락처, 2.급여]");
		if(editMenu.equals("1")) {
			telUpdate(editName); //메소드에 수정할사람이름넣어서 호출
		}else if(editMenu.equals("2")) {
			salUpdate(editName);
		}else {
			System.out.println("메뉴를 잘못선택하였습니다.");
		}
		///
	}
	//연락처수정
	public void telUpdate(String username) {
		String tel = inData("수정할 연락처입력"); //데이터는 empList에 들어가있음 거기에입력되어잇는 데이터 수정//이름(key)을 찾아서 value값을 가지고나온다.
		EmpVO vo= EmpDataSet.empList.get(username); //그 사람의 EmpVO를 불러와서 vo에 담아준다
		vo.setTel(tel);//입력받은 tel을 다시 셋팅
	}	
	//급여수정
	public void salUpdate(String username) {
		int sal = Integer.parseInt(inData("수정할 급여 입력"));
		EmpVO vo= EmpDataSet.empList.get(username);
		vo.setSal(sal);
	}
	
	//사원삭제->key를 기준으로 삭제,사원번호로지우기
	public void empDelete() {
		String delName = inData("삭제할 사원명");//삭제할사원명입력
		EmpDataSet.empList.remove(delName);		
	}
		
	//사원전체목록 출력하기
	public void allEmpList() { //위의 메소드에서 이메소드 불러줌
		//제목출력
		EmpVO.titlePrint();//목록찍기
		
		Collection<EmpVO> list =EmpDataSet.empList.values();
		Iterator<EmpVO> ii =list.iterator();
		while(ii.hasNext()) {
			EmpVO vo = ii.next();
			vo.empPrint();
		}
	}
	
	
	//콘솔에서 문자열입력받는 메소드
	public String inData(String msg) {
		System.out.println(msg+"->");
		return scan.nextLine();
	}



}

//콘솔에서입력받는 메소드-> 사원전체목록출력->메뉴목록만들고->사원추가,종료까지 ->
