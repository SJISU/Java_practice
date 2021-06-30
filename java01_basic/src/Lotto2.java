import java.util.Scanner;
public class Lotto2 {
	public static void main(String[] args) {
			//로또 번호 생성기
			Scanner scan = new Scanner(System.in);
			
			do {
				//게임수입력
			    System.out.print("게임수=");
				int cnt = scan.nextInt();
				
				//입력받은 게임수 만큼 게임만들기/입력받은 수 만큼 돌리기
				for(int game=1; game<=cnt; game++){
					//게임1개 만들기 -배열을 만들어서 -방을 7개 만들어서-1~45까지의 난수를 만들어 방에 입력한다-그런데 중복검사를 해야한다 - 처음방에 숫자넣고 그다음 숫자넣을때 
					//처음 방에 잇는 숫자와 비교하여 중복이 아니면 넣는다 그리고 그다음방에 데이터를 넣을때 0,1번방에 잇는 데이터와 중복되는지 확인하여 데이터 입력
					//로또번호+보너스를 난수로 생성하여 저장할 배열 만들기
						int lotto[]=new int[7];
						for(int i=0; i<lotto.length; i++) { // i =0 처음에 i=0
							lotto[i]= (int)(Math.random()*45)+1;
							
							//중복검사
							for(int c=0; c<i; c++) { //i는 그전에만든거 s는 방금 새로만든거
								if(lotto[i] == lotto[c]) {
									i--;									
								}
							}			
						}
						//정렬
						for(int i=0; i<lotto.length-2; i++){//0,1,2,3,4 //보너스빼고 마지막칸빼고 -2
							
							for(int j =0; j<lotto.length-2-i; j++) { //
								if(lotto[j]>lotto[j+1]) {
									int temp = lotto[j];
									
									lotto[j]=lotto[j+1]; // j와 j+1 비교해서 j가 j+1보다 크면 j를 j+1로 바꾼다
									lotto[j+1]= temp;    // j+1자리에는 lotto[j]자리에 저장해두었던것 temp를 입력
								}
							}							
						}						
						//출력
						System.out.print(game+"게임=");
						for(int i =0; i<lotto.length-1; i++) { //length에서 1을 빼는것은 마지막보너스자리남겨둔것
							System.out.print(lotto[i]+",");							
						}
						System.out.println("bonus="+lotto[6]);					
				}
				System.out.print("계속하시겠습니까(1.예, 2.아니오)?");
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
	 게임수 = 3
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
