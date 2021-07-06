import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalendarEx extends JFrame implements ActionListener ,  ItemListener{
	//달만바뀌는달력만들어야겟다......
	Calendar now = Calendar.getInstance();
	
	JPanel pane = new JPanel();	//년,월
	
	JPanel calpane = new JPanel(new BorderLayout());//달력큰판
	JPanel daypane = new JPanel(new GridLayout(1,7)); //요일판
	JPanel datepane = new JPanel(new GridLayout(6,7)); //날짜판
	
	String dayStr[] = {"일","월","화","수","목","금","토"}; //요일스트링배열
	//String dateStr[] = new String[42];
	
	JComboBox<String> cb1 = new JComboBox<String>();  
	JLabel lb1 = new JLabel("년");
	JComboBox<String> cb2 = new JComboBox<String>();
	JLabel lb2 = new JLabel("월");
	
	JButton leftjbt = new JButton("◀");
	JButton rightjbt = new JButton("▶");
	
	//달력날짜
	int year = now.get(Calendar.YEAR);
	int month = now.get(Calendar.MONTH)+1;
	int date = now.get(Calendar.DAY_OF_MONTH);
	
	
	public CalendarEx() {
		
		
		add(BorderLayout .NORTH,pane);
		pane.add(leftjbt);//왼쪽버튼 --> 이벤트등록 --> 지금월-1 달력판
		pane.add(cb1); //cb1에 년도입력 
		cb1.addItem(String.valueOf(year));		
		//년도
		for(int i=year-10; i<=year+10; i++) {
			if(i==year) {}
			else {cb1.addItem(String.valueOf(i));}		
		}			
		pane.add(lb1); //"년"
		pane.add(cb2); //cb2에 월 입력 //--->이벤트등록 ---> 입력된월바뀜
		cb2.addItem(String.valueOf(month));	
		for(int i=1; i<=12; i++) {
			if(i==month) {}
			else {cb2.addItem(String.valueOf(i));}			
		}		
		pane.add(lb2); //"월"	
		pane.add(rightjbt); //오른쪽버튼 --> 이벤트등록 --.지금월+1 달력판
		pane.setBackground(Color.CYAN);
		
		add(calpane); //달력큰판		
		calpane.add(BorderLayout.NORTH,daypane); //요일판추가
		calpane.add(BorderLayout.CENTER,datepane); //날짜판추가
		
		//요일 제목 셋팅
		for(int i=0; i<dayStr.length; i++) {
			JLabel btn = new JLabel(dayStr[i],JLabel.CENTER);			
			btn.setBackground(Color.GRAY);
			if(i==0) {
				btn.setForeground(Color.red);
			}else if(i==6) {
				btn.setForeground(Color.blue);
			}
			daypane.add(btn); 			
		}
		
		
		//날짜셋팅-날짜판에 제이라벨로 날짜 추가
		now.set(year, month-1,1); //이걸 여기서 하는게맞나? 전역에서인가.......
		cal(year,month); //달력찍는메소드....

		setTitle("카렌다");		
		setSize(300,300);
		setVisible(true);
		

		leftjbt.addActionListener(this);
		rightjbt.addActionListener(this);
		
		cb1.addItemListener(this);
		cb2.addItemListener(this);
	}

	public void actionPerformed(ActionEvent ae) {
		//왼쪽버튼누르면 전달
		//오른쪽버튼 누르면 다음달
		JButton event = (JButton)ae.getSource();
		String btnLb1 = event.getText();
		if(btnLb1.equals("◀")) {
			
		}else if(btnLb1.equals("▶")) {
			
		}
		
	}
	
	public void itemStateChanged(ItemEvent ie) { //제이콤보박스에서 년,월선택하면
		JComboBox event = (JComboBox)ie.getSource();
		if(event.equals(cb1)){ //년도
			String newYear = (String)cb1.getSelectedItem();
			
			//System.out.println(newYear);
			cal(Integer.parseInt(newYear),month);//새로달력찍고 바뀌어야하는데 ......안바뀜 ㅠ
		}else if(event.equals(cb2)) { //월
			
		}
		
		
	}
	//달력찍는메소드
	public void cal(int year, int month) {		
				
		//now.set(year, month-1,1); //?		
		
		int week=now.get(Calendar.DAY_OF_WEEK);
		int lastDay =now.getActualMaximum(Calendar.DAY_OF_MONTH);	
		
		
		for(int space=1; space<week; space++) {
			datepane.add(new JLabel("\t"));			
		}
		//날찌찍기
		for(int day=1; day<=lastDay; day++) {
			JLabel dlb1 = new JLabel(String.valueOf(day),JLabel.CENTER);
			dlb1.setOpaque(true);
			now.set(year,month, day);
			week=now.get(Calendar.DAY_OF_WEEK);
			System.out.println(week);
			if(week==1) {//일요일 글자색 빨강				
				dlb1.setForeground(Color.red);
			}else if((day+week-1)%7==0) { //(week=7)토요일 글자색 파랑
				dlb1.setForeground(Color.blue);
				//System.out.println(week); //확인하려고쓴실행문..지울거임-->왜5로출력 ㅠ
			}
			datepane.add(dlb1);
		}
		for(int space=1; space<=42-(lastDay+week); space++) {
			datepane.add(new JLabel("\t"));	
		}		
	}
	
	
	public static void main(String[] args) {
		
		new CalendarEx();
	}

}
