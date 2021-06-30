import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

//java.text-Class DecimalFormat
// .### .000 
public class DecimalDateFormat {

	public DecimalDateFormat() {
	 try{
		//데이터를 원하는 출력형식으로 만들수 잇는 클래스
		//숫자를 화폐단위로 만들기...그리고 다시 복원..
		int data = 52123542;
		
		DecimalFormat format = new DecimalFormat("#,###원");//세자리 표기하고 원도 붙여서 표시할서다
		
				//패턴화된 데이터
						  //객체명.format()
		String dataFormat= format.format(data); //format api...format클래스의 스트링형format의 api를 사용....//DecimalDateFormat의 api인 메소드 사용한것...
		System.out.println("dataFormat="+dataFormat);
		
		//패턴으로 변환된 데이터를 원래대로 바꾸기 
		//52,123,542원 -> 52123542   //숫자로 바꾸기...
		//NumberFormat의 접근제한자는  이므로 호출못해서 객체생성해주는 메소드 이용하여 호출
		NumberFormat nf = NumberFormat.getInstance(); //객체만들어줌....
	    
		Number num=	nf.parse(dataFormat);//  객체명.parse() 에 스트링을 넣어주면 num에 나오게해줌 //format()과반대기능 //다시 5123542
	    int dataparse = num.intValue(); // int타입으로 형변환..
	    System.out.println("dataparse="+dataparse);
	    
	    
	    //날짜포맷
	    //2021년 6월 4일 (금) 15:21
	    Calendar now = Calendar.getInstance();
	    
	    SimpleDateFormat  dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 (E) hh:mm:ss a");//객체형성 //내가 나타내고싶은 형식으로 만들어줌 yyyy년 yy년..
	    //날짜 셋팅...카렌다를 가지고 잇지만 심플데이터포맷의 api방식으로 날짜 셋팅...
	    String dateStr= dateFormat.format(now.getTime()); //카렌다객채명인 now.gettime
	    									//fotmat 에 데이터를 넣어주면 스트링으로  출려해주는 메소드
	    									//우리는 카렌더를 가지고 있는데 데이트를 넣어줘야하기때문에 카렌다클래스에서 데이터를 리턴해주는 메소드를찾아서 
	    									//format 데이터에 넣는다.....//getTime메소드가 데이터를 리턴해준다....
	    
	    System.out.println("dateStr--->"+dateStr);
		
	 }catch(Exception e) {}
	}

	public static void main(String[] args) {
		new DecimalDateFormat();
	}

}
//메인에서 객체생성함 그리고 생성자로 감