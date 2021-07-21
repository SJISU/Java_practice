import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

public class JSplitPanelTest extends JFrame{

	JSplitPane sp1,sp2;
	CalculatorEx2 cal = new CalculatorEx2();
	SwingCalendar2 calendar = new SwingCalendar2();
	
	JTextArea ta = new JTextArea();
	JScrollPane sp = new JScrollPane(ta);
	
	public JSplitPanelTest() {
		
		//수직나누기
		sp2 =new JSplitPane(JSplitPane.VERTICAL_SPLIT,cal,calendar); // 위아래로 나눈다 
		
		//수평나누기
		sp1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,sp2,sp); //좌우로 나눈다-JSplitPane의 HORIZONTAL_SPLIT사용
																  //좌우로 나눈왼쪽에 위아래로나눈sp2 넣는다
															     // 오른쪽dps JTextArea 
		add(sp1); 		
		 
		//경계선의 위치를 설정할 수 잇다. - 왼쪽의컨텐츠와 오른쪽컨텐츠의 경계선 //좌우-sp1 왼쪽의위아래-sp2
		sp2.setDividerLocation(350); //위쪽에 350px(픽셀)
		sp1.setDividerLocation(800); //왼쪽이 800px
		
		//경계선의 두께 설정 
		sp2.setDividerSize(1); //px단위 -> 선두께를 1 픽셀로 하겟다
		sp1.setDividerSize(20);
		
		//원터치
		sp1.setOneTouchExpandable(true); // 한쪽을 맥스로 확대하는기능
		
		setSize(1000,800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		
		new JSplitPanelTest();
	}

}
