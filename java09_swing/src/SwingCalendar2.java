import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SwingCalendar2  extends JPanel implements ActionListener{

	Font ft = new Font("굴림체",Font.BOLD,20);
	Calendar now = Calendar.getInstance();
	
	//Frame-North
	JPanel frmNorth = new JPanel();
		JButton prevMonth = new JButton("◀");
		JButton nextMonth = new JButton("▶");
		JLabel yearLb1 = new JLabel("년");
		JLabel monthLb1 = new JLabel("월");
		
		JComboBox<Integer> yearCombo = new JComboBox<Integer>();		
		DefaultComboBoxModel<Integer> yearModel = new DefaultComboBoxModel<Integer> ();
		
		JComboBox<Integer> monthCombo = new JComboBox<Integer>();
		DefaultComboBoxModel<Integer> monthModel = new DefaultComboBoxModel<Integer> ();
		
	//Frame-Center
	JPanel frmCenter = new JPanel(new BorderLayout());
		JPanel weekTitlePane = new JPanel(new GridLayout (1,7)); //frmCenter의 북쪽
		JPanel dayPane = new JPanel(new GridLayout(0,7)); //frmCenter의 센터
		
	public SwingCalendar2() {
		//super("계산기");
		
		setLayout(new BorderLayout());
		//Frame-North
		prevMonth.setFont(ft);
		nextMonth.setFont(ft);
		yearLb1.setFont(ft);
		monthLb1.setFont(ft);
		yearCombo.setFont(ft);
		monthCombo.setFont(ft);
		
		frmNorth.add(prevMonth);//◀
		
		//년도 리스트
		int nowYear=setNowYear(); //년도메소드호출
		yearCombo.setModel(yearModel); //콤보박스안에 년도셋팅
		yearCombo.setSelectedItem(nowYear);//현재년도셋팅
		frmNorth.add(yearCombo);
		
		frmNorth.add(yearLb1); //"년"
		
		//월리스트
		int nowMonth = setNowMonth();
		monthCombo.setModel(monthModel); //콤보박스안에 월셋팅
		monthCombo.setSelectedItem(nowMonth+1); //현재 월셋팅
		frmNorth.add(monthCombo);
		
		frmNorth.add(monthLb1);//월
		frmNorth.add(nextMonth); //▶
		
		add(BorderLayout.NORTH,frmNorth);
		
		//Frame-Center
		frmCenter.add(BorderLayout.NORTH,weekTitlePane);
		frmCenter.add(dayPane);
		add(frmCenter);
		
		setWeekTitle(); //요일찍기 메소드
		
		//날짜
		//해당월의 1일에 대한 요일
		int week = getOneDayWeek(nowYear,nowMonth);
		//해당월의 마지막날
		int lastDay = now.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		setSpaceLabel(week); //공백		
		setDayLabel(nowYear,nowMonth,lastDay); //날짜처리
		
//		setSize(400,300);
//		setVisible(true);
//		setDefaultCloseOperation(DISPOSE_ON_CLOSE);		
		
		//이벤트등록
		prevMonth.addActionListener(this);	
		nextMonth.addActionListener(this);
		yearCombo.addActionListener(this);
		monthCombo.addActionListener(this);
		
	}
	
	public int setNowYear() { //년도리스트		
		int year = now.get(Calendar.YEAR); //년도	
		for(int y= year+20; y>=year-100; y--) {
			yearModel.addElement(y);
		}
		return year;
	}
	
	public int setNowMonth() {//월리스트
		for(int m =1; m<=12; m++) {
			
			monthModel.addElement(m);
		}
		return now.get(Calendar.MONTH);
	}
	
	public void setWeekTitle() {//요일찍기
		String weekName= "일월화수목금토";
		for(int i=0; i<weekName.length(); i++) { // 0,1,2,3,4,5,6
			JLabel lb1 = new JLabel(weekName.substring(i,i+1),JLabel.CENTER);
			lb1.setFont(ft);
			if(i==0) lb1.setForeground(Color.RED);
			if(i==6) lb1.setForeground(Color.BLUE);
			weekTitlePane.add(lb1);			
		}		
	}
	
	//요일구하기
	public int getOneDayWeek(int y, int m) {
		now.set(y,m,1);
		return now.get(Calendar.DAY_OF_WEEK);
	}
	
	
	//공백을추가하는라벨
	public void setSpaceLabel(int w) {
		for(int i=1; i<w; i++) {
			JLabel lb1 = new JLabel(" ");
			dayPane.add(lb1); //공백라벨찍기
		}
	}	
	//날짜추가하는 레벨
	public void setDayLabel(int year, int month ,int lastDay) {
		for(int day=1; day<=lastDay; day++) {
			JLabel lb1 = new JLabel(String.valueOf(day),JLabel.CENTER); //day는 정수니간 String 으로 형벼환
			lb1.setFont(ft);
			now.set(year,month, day); // 근데 왜 다시 셋팅해주는거?ㅠ--> 요일구하려고? ㅠㅠ
			int week =now.get(Calendar.DAY_OF_WEEK); //위에서 선언한 week는 1일을찍고있으니깐 새로선언
			if(week==1) lb1.setForeground(Color.RED);
			if(week==7) lb1.setForeground(Color.BLUE);
			dayPane.add(lb1);			
		}		
	}
	
	//제이콤보박스 선택시  발생하는 이벤트 메소드
	//패널객채명.removeAll() : 패널안의 컴포넌트지우기... //패널객체명.setVisible()
	public void setNewDate() {
		//콤보박스에서 뭘 선택하던 여기로 온다..select정보를 얻는다
			int year = (Integer)yearCombo.getSelectedItem();
			int month =(int)monthCombo.getSelectedItem();
			now.set(year, month-1,1); //컴퓨터가 알아봐야하니깐....
			//기존의 날자 라벨을 모두 지워야 한다.
			dayPane.removeAll();
			//패널숨기기
			dayPane.setVisible(false);
			setSpaceLabel(now.get(Calendar.DAY_OF_WEEK));
			setDayLabel(year,month-1,now.getActualMaximum(Calendar.DAY_OF_MONTH));	
			//다시패널볼수잇게
			dayPane.setVisible(true);
	}
	
	//왼쪽버튼일때
	public void setPrevMonth() {
		//현재 선택된 콤보박스의 값을 가져온다 
		int y = (int)yearCombo.getSelectedItem();
		int m = (int)monthCombo.getSelectedItem();
		//1월일때 왼쪽버튼을 누르면 연소감소,다른월은 월만감소
		
		if(m==1) { //1월이면 년도를 감소하고 월은 12월로 변경 //1월일때 왼쪽버튼누르면 지금년도-1 년도 12월이출력되거ㅔ
			y--;
			m=12;			
		}else {
			m--; 
		}			
		 setButtonEvent(y,m);//ComboBox의 기존이벤트제거 --> 기존의날짜라벨을 지우고 패널숨기고 날짜셋팅하고 다시 패널보이게	
	}
	//오른쪽버튼일때
	public void setNextMonth() {
		int y = (int)yearCombo.getSelectedItem();
		int m = (int)monthCombo.getSelectedItem();		
		if(m==12) {
			y++;
			m=1;
		}else {
			m++;
		}
		setButtonEvent(y,m);
	}
		
	
	public void setButtonEvent(int y, int m) {
		//ComboBox의 기존이벤트제거 --> 기존의날짜라벨을 지우고 패널숨기고 날짜셋팅하고 다시 패널보이게
				yearCombo.removeActionListener(this);
				monthCombo.removeActionListener(this);
				yearCombo.setSelectedItem(y);
				monthCombo.setSelectedItem(m);
				setNewDate();
				//위에서 지운이벤트 다시등록
				yearCombo.addActionListener(this);
				monthCombo.addActionListener(this);
	}

	//이벤트 추상메소드 오버라이딩
	// instanceof 연산자 : 객체가 어떤 클래스로 생성되었는지 비교하는 연산자
	public void actionPerformed(ActionEvent ae) {
		//콤보박스가 눌러질때 달력이 바뀐다...
		Object obj = ae.getSource(); //JButton,JComboBox 둘다 발생
		
		//객체가 어떤 클래스로 생성되었는지 비교하는 연산자
		if(obj instanceof JButton) { //obj객체가 JButton으로 만든 객체가 맞느냐 
			
		//콤보박스이벤트지우고 날짜셋팅한후 다시 이벤트 등록....
			//왼쪽,오른쪽버튼
			if(obj == prevMonth) {//왼쪽 방향키
				setPrevMonth();
			}else if (obj == nextMonth) {// 오른쪽방향키
				setNextMonth();
			}
			
		}else if(obj instanceof JComboBox) { 
			
			setNewDate(); //제이콤보박스를 선택하면 발생되는 메소드
		}		
	}
	
	

}
