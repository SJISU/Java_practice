import java.util.Scanner;
public class Lotto {
	public static void main(String[] args) {
		//로또 번호 생성기
		Scanner scan = new Scanner(System.in);
		
		do {			
		    System.out.print("게임수=");
			int data = scan.nextInt();
			
			int[] Lotto = new int[6];
			for(int i =0; i<Lotto.length;i++) {
				int LottoRan = (int)(Math.random()*45)+1;
				Lotto[i]= LottoRan;
				
				/*
				for(int a=0; a<Lotto.length; i++) {
					if(Lotto[a] == Lotto[a+1]){
						Lotto[a] = Lotto[a]+1;					
					}
				}
				*/				
			}
			
			int[] Bonus = new int[1];
			for(int i =0; i<Bonus.length;i++) {
				int BonusRan = (int)(Math.random()*45)+1;
				Bonus[i]= BonusRan;			
			}
			
			for(int a =1; a<=data; a++ ){
				System.out.print(a+"게임=");
					
					for(int i=0; i<Lotto.length; i++) {
						System.out.print(Lotto[i]+",");						
					}   System.out.print("보너스"+Bonus[0]);
						System.out.println();				
			}				 				
			
			System.out.print("계속하시겠습니까(1.예 , 2.아니오)?");
			int status = scan.nextInt();
			if(status==2)
				break;
		
		
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
