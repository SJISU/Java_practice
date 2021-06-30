import java.util.Scanner;
class ForDiamond2 
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
		int step = 2;    //변수 선언 : 감소하는부분을 나타내기위해
    
		
		//삼각형만들기
			for ( int row=1 ; row>0 ; row+=step){//줄 1,3,5,7,9,11......max // row<=max  ----> row>0

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
				System.out.println();  //13줄 찍고 도달하는 지점 //여기서 확인한다:max값 도달여부
				
				if(row>=max){
					step=-2;
					
				}


			}
	// max 값 도달하면 감소한다 이때 증ㄱ가하는 변수 하나만 만들어주면된다
		
	}
}
