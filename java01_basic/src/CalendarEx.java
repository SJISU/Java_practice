import java.util.Scanner;
import java.util.Calendar;
class  CalendarEx
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.print("년도=");
		int year = scan.nextInt();
		System.out.print("월=");
		int month = scan.nextInt();


		//제목출력
		System.out.printf("\t\t%d년 %d월\n",year,month);
		System.out.println("일\t월\t화\t수\t목\t금\t토");

		//현재 날짜 시간 객체 구하기
		Calendar date = Calendar.getInstance();
		date.set(year,month-1,1);  // 날짜 변경  1월->0 2월->1.....5월->4,6월->5 
								   //컴퓨터는0월부터 계산하기때문에 입력받은 수에서 1을뺀달을 계산해야 입력한 달이 나온다.
		
		//요일구하기 //공백구할수있게됨-요일시작하는 날전까지 공백이 찍히고 있음
		int week = date.get(Calendar.DAY_OF_WEEK); 

		//달의마지막날
		// 1 , 3 , 5 , 7 , 8 , 1 0 , 12 ->31일
		// 4, 6 , 9 , 11 ->30일
		//2 -> 28,29일
		
		
		/*
		int lastDay = 31 ; //31일 달이 많으니깐 초기값은 31로 설정
		switch (month){
			case 4 : 
			case 6 :
			case 9 :
			case 11 :
				lastDay=30; break;		
			case 2 :
				//년도가 4로 나누어지고 100으로 안나누어지면 28일(운년)
			    //400으로 나누어지면 윤년
				if(year%4==0 && year%100 !=0 || year%400==0 ){
					lastDay = 29;
					}else{
					lastDay=28;
				}
		}
	    */

		//마지막날 //getActualMaximum - ()중에제일큰값을출력해준다 ex)월중에 제일큰값-12
		int lastDay =date.getActualMaximum(Calendar.DAY_OF_MONTH);		
			
		
		//공백출력 공백= 요일-1
		//이제 공백찍고 줄바꿈
		for(int s=1; s<week; s++){
			System.out.print("\t");			
		}		
		//날짜출력 :1에서 lastDay까지 출력
		for(int d=1; d<=lastDay;d++){
			System.out.print(d+"\t");
			if((d+week-1)%7==0){ //출력한문자의 갯수가 7의 배수개이면 줄바꾸기 //week-1 = 공백
				System.out.println();				
			}			
		}		
	}
}


/*
1. 달력: 첫번째줄은 *찍기에활용 -> 요일을 구해서 공백+일수
빈칸(요일-1)
	  빈칸
일-> 1  0
월   2  1
화   3  2
.
.
.
토  7    6

2.한줄의 데이터가 7개가 찍히면 그 다음줄로 넘어가야한다 
데이터는 1씩 증가
---1234 : 총7개
빈칸+숫자 가 7의 배수가 되어야함 //빈칸의 갯수는 요일-1

3.마지막날 -> 월마다 다르다



*/
