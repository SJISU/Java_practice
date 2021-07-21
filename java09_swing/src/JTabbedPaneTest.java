import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class JTabbedPaneTest extends JFrame { //JLabel,

	JTabbedPane tp ;
	
	JLabel lb1;
	ImageIcon ii = new ImageIcon("img/flower.jpg");
	
	JButton btn;
	ImageIcon iii = new ImageIcon("img/ha.jpg");
	
	DigitalClock2 dc = new DigitalClock2(0,0);
	
	CalculatorEx2 cal = new CalculatorEx2(); 
	
	SwingCalendar2 calendar = new SwingCalendar2();
	
	PackMan2 pm = new PackMan2();
	
	public JTabbedPaneTest() {
		super("탭메뉴");
		
		tp = new JTabbedPane(JTabbedPane.LEFT);// ()안에서 Jtab을어디에 만들건지 정한다
											  //JTabbedPane.LEFT //JTabbedPane.TOP
		
		lb1 = new JLabel(ii);
		tp.addTab("레이블",lb1);
		
		btn = new JButton(iii);
		tp.addTab("버튼",btn);
		
		tp.addTab("시계",dc);
		
		tp.addTab("계산기",cal);
		
		tp.addTab("달력",null,calendar, "달력");
		
		tp.insertTab("Button",null,new JButton("추가된버튼"),"중간에 탭메뉴 추가",3); //0,1,2,3.. ->3위치에 추가 
		
		tp.addTab("팩맨",pm);
		
		//탭의 활성화 및 비활성화 : setEnabledAt
		// true : 활성화,		false:비활성화
		//				탭index,  true/false
		//tp.setEnabledAt(2,false); // 2번위치에 있는 탭 비활성화시킴
	
		//첫번째 탭을 제외한 나머지 모든 탭을 비활성화 한다. 
		//tp.setEnabled(false);
		
		
		
		add(tp);
		setSize(500,500); //사이즈가 여기서 정해짐...이 이후에 크기가 있다		
		
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//크기설정
		pm.setCanvasSize();
		Thread  t = new Thread(pm); // 이클래스전체를 객체로 넣어줌->run메소드도들어가있음
		t.start();  //----> 이렇게만들면 객체생성만 해주면된다
				
		//탭의 삭제 : removeTabAt
//		try {Thread.sleep(3000);}catch(Exception e) {} //3초후에
//		tp.removeTabAt(3); //3번째 자리에 있는 탭 삭제
		
	}

	public static void main(String[] args) {
		new JTabbedPaneTest();

	}

}
