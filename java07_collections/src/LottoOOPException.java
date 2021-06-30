
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

public class LottoOOPException {
	Random random = new Random();
	Scanner scan = new Scanner(System.in);
	TreeSet<Integer> ts = new TreeSet<Integer>();
	
	public LottoOOPException() {
		
	}
	//////// 컬레션 이용해서 수정하기------지수
	
	
	
	
	public int[] lottoCreate() {
		int lotto[] = new int[7]; 										
		for(int i=0; i<lotto.length; i++ ){
			//로또번호생성
			lotto[i]=random.nextInt(45)+1;
			
				
			for(int data : lotto) {
					ts.add(data);
				}
			
				
			
			
			//중복검사 호출
			//i = doubleCheck(lotto,i);
		}
		return lotto;
	}
	
			//중복검사
			public int doubleCheck(int lotto[], int i) { //전달받을 위치 i            
				for(int j=0; j<i; j++) {			
					if(lotto[i]==lotto[j]) {
						i--;
						break;
					}
				}
				return i;
			}
	
	//출력
	public void  lottoPrint(int cnt,int lotto[]) {//매개변수와 정렬된로또번호필요...저 로또안에는 보너스들어가있음
		System.out.print(cnt+"게임");
		
		Iterator<Integer>ii = ts.iterator(); //증복X,오름차순 정렬O ??6개만출력 ㅠ
		
		//6개만출력 어케함.........
			while(ii.hasNext()) {
				
				Integer d = ii.next();
				System.out.print(d+",\t");
			}
		
		
		//System.out.print( Arrays.toString(Arrays.copyOfRange(lotto,0,6)));//번호
		System.out.println(",bonus"+lotto[6]);
	}
	
	//계속여부확인
	public boolean yesNo() {
		do {
			
				System.out.print("계속하시겠습니까(y:예 , n:아니오)?");   //*****y,n이 나오지않으면 while에서 반복되기때문에 굳이 예외처리할필요없음
				String qa =  scan.nextLine();
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
				
				
			
			
			
					System.out.print("게임수=");																			
					int game = Integer.parseInt(scan.nextLine()); //NumerformatException
																  //-------------사용자입력데이터오류발생--콘솔상에서 텍스트입력해야되는자리
					//게임
					for(int i=1; i<=game; i++) {
						int lotto[]=lottoCreate();  
						Arrays.sort(lotto,0,6); //정렬 
						lottoPrint(i,lotto);//출력 
						
					}
					//계속여부
					if(!yesNo()) {  //**yesNo()메소드				
						break;
					}
					
		
			
			
		}while(true);
		}
	
	
	
	public static void main(String[] args) {
		LottoOOPException oop = new LottoOOPException();
		oop.lottoStart();
		
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
