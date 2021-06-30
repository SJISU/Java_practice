import java.util.Scanner;
public class ArrayEx03_Money {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		do {
				System.out.print("금액=");
				int money =scan.nextInt();			
				
				//화폐단위
				//화폐단위와 갯수를 2차원에 초기화하여 생성한다.
				int[][] result  = {	{50000,0},	{10000,0}, {5000,0}, {1000,0},
									{500,0},{100,0},{50,0},{10,0}, 	 {5,0}, {1,0} };
				//화폐단위계산
				for(int row =0; row<result.length; row++) { //0,1,2,3.....9 //행만큼 돌아라
						result[row][1]= money / result[row][0] ; //화폐갯수 // result배열의 [0][1]자리에 입력받은 money를 result배열의 [0][0]으로 나누어서 넣어라
						money = money-result[row][0]*result[row][1] ;   //현재단위의 화폐금액만큼 차감
				}	
				////출력56000
				for(int row=0; row<result.length; row++ ) {
					if(result[row][1]>0) {
						System.out.print(result[row][0]+"="+result[row][1]);
						if(result[row][0]>=1000){
							System.out.println("장");
						}else{
							System.out.println("개");
						}
					}
				}
				
				//종료확인
					System.out.print("계속하시겠습니까(1.예, 2.아니오)?");		
					if(scan.nextInt()==2) {
						break;	
					}
			}while(true);
	}
}

/*
 배열을 이용하여 만들기 - 1차원,2차원
실행
금액을 입력하세요.? 126300
50000원 = 2장
10000원 = 2장
5000원 = 1장
1000원 = 1장
100원 = 3개
다시하시겠습니다(1.예, 2.아니오)?

금액을 입력하세요.?5435
5000원 = 1 장
100원 = 4개
10원= 3개
1원=5개
다시하시겠습니다(1.예, 2.아니오)?

*/
