import java.util.Calendar;
import java.util.Scanner; 

public class CalendarOOP {
	
		Scanner scan = new Scanner(System.in);
		Calendar date;
	
	public CalendarOOP() {		//생성자
		calendarStart();
		
	}
	
	public void calendarStart() {
		int year = getDate("년도");
		int month = getDate("월");
		titlePrint(year,month);//제목출력할 메소드 호출
		
			date = Calendar.getInstance();
			//입력받은 년,월 ,1일을 셋팅
			date.set(year, month-1,1);
			//요일 구하기
			int week = date.get(Calendar.DAY_OF_WEEK); //-따로아래에메소드안만들고구함
		
		spacePrint(week-1);//요일 정보를 입력하여 공백출력
		
			//현재년월의 마지막날
			int lastDay =date.getActualMaximum(Calendar.DAY_OF_MONTH); //-따로아래에메소드안만들고구함
		
		//날짜출력
		dayPrint(week-1,lastDay);
	}
	
	//콘솔에서 년도 월을 입력받는 메소드 생성
	public int getDate(String msg) {
			System.out.print(msg+"->");
			return Integer.parseInt(scan.nextLine());
	}
	
	//타이틀 출력
	public void titlePrint(int year, int month) { //메소드가 달라서 변수명 같아도 상관없다.
		System.out.println("\t\t"+year+"년"+month+"월");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
	}
	
	//1일 출력하기전에 공백출력
	public void spacePrint(int cnt) {
		for(int i=1; i<=cnt; i++) {
		System.out.print("\t");
		}
	}
	
	//날짜출력
	public void dayPrint(int space,int lastDay) {
		for(int day =1; day<=lastDay;day++ ) {
			System.out.print(day+"\t");
			if((day+space)%7==0){
				System.out.println();	
			}
		}
	}
		
	
		
	public static void main(String[] args) {
		new CalendarOOP(); //객체생성만으로 구현될수있게 만듬-생성자 메소드가 호출됨
		
	}

}

/*
 년 월을 입력받아 달력출력
 멤버에는 Scanner ,Calendar 존재한다.
 */
 