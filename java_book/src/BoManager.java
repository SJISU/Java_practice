import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

import Boinfor.BoDataSet;
import Boinfor.BooVO;

public class BoManager {
	Scanner scan = new Scanner(System.in);
	String menuTitle ="메뉴[1.도서전체목록, 2.도서검색, 3.도서대여, 4.도서반납, 5.종료]";
	
	public BoManager() {
		
	}

	public void BoProcessStart() {
		allBooList();
		do {
			//메뉴입력받음
			String menu= inData(menuTitle); //1~5중에 하나 입력
			if(menu.equals("1")) {//전체도서목록
				allBooList(); //
				
			}else if (menu.equals("2")){//도서검색
				allBooList();
			}else if(menu.equals("3")) {//도서대여
				allBooList();
			}else if(menu.equals("4")) {//도서반납
				allBooList();
			}else if(menu.equals("5")) {//종료
				System.exit(0); // 이걸 만나면 프로그램 끝남...
			}else {
				System.out.println("메뉴를 잘못선택하였습니다. 다시 입력하세요");
				
			}			
			
		}while(true);
	}

	
	
	
	
	
	
	
	
	//도서전체목록출력
	public void allBooList() { //위의 메소드에서 이메소드 불러줌
		//제목출력
		BooVO.titlePrint();//목록찍기
		
		Collection<BooVO> list =BoDataSet.booList.values();
		Iterator<BooVO> ii =list.iterator();
		while(ii.hasNext()) {
			BooVO vo = ii.next();
			vo.BooPrint();
		}
	}
	
	
	
	
	
	
	public String inData(String msg) {
		System.out.println(msg+"->");
		return scan.nextLine();
	}	
	
}
