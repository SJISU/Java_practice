import java.util.Scanner;
class ForDiamond 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.print("홀수(1~49)입력=");
		int max = scan.nextInt(); //13입력
		
		//짝수일경우 홀수로 변경
		
		if(max%2==0){ 
			max ++;
		
		}
		//출력할 문자 초기값
		char txt = 'A';
    
		
		//삼각형만들기
			for ( int row=1 ; row<=max ; row+=2){//줄 1,3,5,7,9,11......max

				//공백 
				for (int s =1; s<=(max-row)/2 ;s++ ){ //row:한줄에 출력할 문자의수
					System.out.print(" ");
				}

				//문자 row만큼 문자룰력
				//1줄 문자출력
				for (int cnt=1;cnt<=row ;cnt++ ){ // 1~1 
					System.out.print(txt++);
					if(txt>'Z'){//z를 출력하고 나면 A로 되돌리기
						txt = 'A' ;
					}
				}
				//1줄끝나고 다시 FOR로 올라감 그리고 아래식으로 줄바꾸고 다시2번재줄 부터 반복
				System.out.println();
			}
	//===================================================================================
			 for (int row=max-2 ;row>=1 ;row-=2 ){ //13이 들어왓다고 하면 11,9,7,5,3,1로 총6줄 출력
				
				//공백
				for (int s=1;s<=(max-row)/2 ;s++){
					 System.out.print(" ");
				}
				//1줄문자 : row가 가진 갯수만큼 찍으면된다 : 11,9,7,5,3,1 만큼 출력
				for (int cnt=1;cnt<=row ;cnt++ ){
					 System.out.print(txt++);
					if(txt>'Z'){
					   txt = 'A';
					}
				}
				//줄바꿈
				System.out.println();
			}
		
	}
}
