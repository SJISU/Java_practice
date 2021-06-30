
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

public class LottoOOP_TreeSet {
	Random random = new Random();
	Scanner scan = new Scanner(System.in);
	
	public LottoOOP_TreeSet() {
		
	}
	//1게임 만들기 + 보너스포함, 중복검사
	public  void lottoCreate(int i ) { //게임수 i받음
		//중복제거 , 정렬
		TreeSet<Integer> lotto = new TreeSet<Integer>();  //--->6개 ---> 데이터 1
		
		int num=0; //--->1개 --->데이터2
		while(lotto.size()<7) {
			//로또번호생성
			num= random.nextInt(45)+1;
			lotto.add(num);
		}	
			//lotto TreeSet번호 7개가 있고 ,num에는 마지막으로 만든번호가 있다
			//포함된 bonus번호는 로또번호에서 지운다. -> TressSet번호 6개가 있다.
			lotto.remove(num); //--->lotto저장소에 있는거 한개 지운다...
			
			lottoPrint(i,lotto.toString(),num); // 배열.toString() : 배열내용 출력			
		
	}
	

	
	//출력
	public void  lottoPrint(int cnt,String lotto, int bonus) {//매개변수와 정렬된로또번호필요...저 로또안에는 보너스들어가있음
		System.out.print(cnt+"게임=");
		System.out.print( lotto);//번호
		System.out.println(", bonus="+bonus);
	}
	
	//계속여부확인
	public boolean yesNo() {
		do {
		
				System.out.print("계속하시겠습니까(y:예 , n:아니오)?");														//************스트링이아니라 다른거데이터형입력오류
				String qa =  scan.nextLine(); // 입력된 y,n을 넣어준다...
				// y:계속하겠다(true) n: 종료하겠다(false),그외 다시--->3가지		
				if(qa.equalsIgnoreCase("y") ){ //qa에 들어있는값이 대소문자구분없이 y이면
					return true;
				}else if (qa.equalsIgnoreCase("n")){//qa에 들어있는값이 대소문자구분없이 n이면
					return false;
				}
			
		}while(true); 
	}
	
	//메인에서 객체생성후 구현시킬 메소드..
	public void lottoStart() {
		do {
			try {	
				System.out.print("게임수=");																			//*****int아니라 다른거 데이터형 입력
				int game = Integer.parseInt(scan.nextLine());//. Integer 객체로 리턴을 받아서 int 변수에 할당하면 자동으로 형변환
				//게임
				for(int i=1; i<=game; i++) {
					lottoCreate(i);  //****입력받음 게임수만큼 로또 생성
					
					
				}
				//계속여부
				if(!yesNo()) {  //**yesNo()메소드
					break;
				}
			}catch(Exception d) {
			System.out.println("Exception~~~>"+d.getMessage());
			}	
		}while(true);
	}
	
	
	
}	

/*
로또	번호 :1~45까지 번호6개
		보너스 1개
		
실행
게임스 = 3
1게임 = 5,13,26,32,33,45,보너스 11
2게임 = 11,23,26,32,35,41, 보너스 9
3게임 = 15,13,26,37,38,42, 보너스23
계속하시겠습니까(1.예 , 2.아니오)? 1
게임수 = 5
1게임 = 5,13,26,32,33,45,보너스 11
2게임 = 11,23,26,32,35,41, 보너스 9
3게임 = 15,13,26,37,38,42, 보너스23
1게임 = 5,13,26,32,33,45,보너스 11
2게임 = 1,23,26,32,35,41, 보너스 27
3게임 = 9,13,26,37,38,42, 보너스45
계속하시겠습니까(1.예 , 2.아니오)?2
*/
