class WhileTest01
{
	public static void main(String[] args) 
	{ 
		//1~5까지 출력
		//초기값, 증가값이 while문에 존재하지 않기 때문에 별도로 식을 표시하여야 한다. -for와 차이점
		
		int i =1;//초기값
		
		while(i<=5){//조건식이 참일때 실행
			System.out.println(i);
			//i의 값을  증가하는 수식  - 안만들어놓으면 i값은 정해져 있기때문에 무한루프에 거린다
			i++; //++i ,i+=1;,i=i+1		

		} //5까지 찍히지만 i의값은 6

		//==================================================
		// 5,4,3,2,1

		int a = 6;
		while(a>1){
			a--; //////////수정불가 -25번째줄에서 숫자바꿈
			System.out.println(a);
			

	/* 
		int a = 5;
		while(a>=1){
			
			System.out.println(a);
			a--;
		}
		
	 */
			}
	   }
	}
/*
	while : 반복문

	while(조건문){
		실행문;
		실행문;
		:
	
	}
*/