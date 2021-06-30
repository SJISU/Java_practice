import java.util.Calendar;
class CalendarTest 
{
	public static void main(String[] args) 
	{
		//컴퓨터의 날짜 시간정보 얻어오기
		// Calender, Date(날짜관련정보만)
		Calendar now = Calendar.getInstance(); //getInstance()--> 객체를 생성해주는 메소드 
		                                       //객체를 형성하면 항상 현재


       //날짜 변경 메소드 : set() /기존의 정보를 변경
	   now.set(2018,6,14);

	   //년도만 변경
	   now.set(Calendar.YEAR,2022);
	   //월만 변경
	   now.set(Calendar.MONTH,10);  //11월이나옴

      
		// 2021년 6월 4일 (금) 15:21
		// now라는 메소드안에 get()----> 날짜, 시간 관련정보를 얻어온다.
		//객체명.get
		int year = now.get(Calendar.YEAR); // 2021 년
		int month = now.get(Calendar.MONTH)+1; // 6월 //month는 0월부터 시작하므로 +1 한다
		int day = now.get(Calendar.DAY_OF_MONTH); //4 날짜
		int week = now.get(Calendar.DAY_OF_WEEK); //6 요일
		int hour  = now.get(Calendar.HOUR_OF_DAY);//10 시간
		int minute = now.get(Calendar.MINUTE); //44 분

        String weekStr = "";
		switch(week){
			   case 1 : weekStr = "일" ; break;
			   case 2 : weekStr = "월" ; break;
			   case 3 : weekStr = "화" ; break;
			   case 4 : weekStr = "수" ; break;
			   case 5 : weekStr = "목" ; break;
			   case 6 : weekStr = "금" ; break;
			   case 7 : weekStr = "토" ; break;
		
		
		}
		System.out.printf("%d년 %d월 %d일 (%s) %d:%d\n",year, month, day, weekStr, hour, minute);
		System.out.println(now);


		// 2022/11/14

		//월의 마지막날
		int lastDay =now.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println("마지막날=>"+lastDay);
		int lastMonth=now.getActualMaximum(Calendar.MONTH);
		System.out.println("월중에 제일큰값=>"+lastMonth);
		int lastYear = now.getActualMaximum(Calendar.YEAR);
		System.out.println("년도중에 제일큰값=>"+lastYear);


	}
}
