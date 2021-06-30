import java.util.Calendar;
import java.util.Scanner;

public class CalendarEx3 {
	
	int year,month,week,lastDay;
	Scanner scan = new Scanner(System.in);
	public CalendarEx3() {
		
	}
	
	//데이터 입력받때 호출
	void setData(){
		System.out.print("년도=");
		year= scan.nextInt();
		System.out.print("월=");
		month= scan.nextInt();
		}
	//현재 날짜 시간 객체 구하기
	void now (){
		Calendar date = Calendar.getInstance();
		date.set(year,month-1,1);
		week = date.get(Calendar.DAY_OF_WEEK); 
		lastDay =date.getActualMaximum(Calendar.DAY_OF_MONTH);
	}	
	//첫째줄 출력
	void print1 () {
		System.out.println("\t\t"+year+"년"+ month+"월");
		System.out.println("일\t월\t화\t수\t목\t금\t토");

	}
	//일 출력
	void print2 () {
		for(int s=1; s<week; s++){
			System.out.print("\t");			
		}		
		
		for(int d=1; d<=lastDay;d++){
			System.out.print(d+"\t");
			if((d+week-1)%7==0){
				System.out.println();				
			}			
		}		
		
	}
	
	void start() {
		setData();
		now ();
		print1 ();
		print2 ();
	}
	
	public static void main(String[] args) {
		CalendarEx3 sw = new CalendarEx3();
		sw.start();

	}

}
