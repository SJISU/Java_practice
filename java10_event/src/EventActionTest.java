import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

//											1.인터페이스 상속받는다
public class EventActionTest extends JFrame implements ActionListener {
	//		ActionEvent(class), ActionListener(interface) 
	JButton btn = new JButton("클릭하세요");
	JButton btn2 = new JButton("확인");
	
	public EventActionTest() {
		add(BorderLayout.NORTH,btn);
		add(BorderLayout.SOUTH,btn2);
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//이벤트처리
		//1.인터페이스 상속받는다
		//2.이벤트가 발생하는 컴퍼넌트를 등록한다.
		btn.addActionListener(this); //다 this에 들어가 있다 //오버라이딩한 메소드를 넣는다 ->버튼을 클릭하면 actionPerformed을 찾아서 오버라이딩한 메소드를 수행
		btn2.addActionListener(this);//addActionListener -->	actionPerformed 메소드를 실행시킨다
		
	}
	
	
	//3. 추상메소드를 오버라이딩한다		이벤트종류
	public void actionPerformed(ActionEvent ae) {
		
		//getSource -> 이벤트가발생한 object객체를 리턴
		Object obj = ae.getSource(); //1번
		//오브젝트로 나왔을때 각각의 버튼 구별하는방법		
		if(obj == btn) {
			gugudan(7);
			
		}else if(obj == btn2) {
			System.exit(0);
			
		}		
		//JButton eventbtn = (JButton)ae.getSource(); //2번 -원래객체로형변환
	}	
	
	//3. 추상메소드를 오버라이딩한다		이벤트종류
//	public void actionPerformed(ActionEvent ae) { //어떤버튼을 눌러도 여기로 온다...어떤버튼이 눌러지는지 알아야 따로따로 기능구현할수있다
//												  //ae 에서 버튼의 정보를 가져올수있다 //Actionevent클래스에가면 메소드들잉있다->getActionConnend()
//		//getActionConnend(): 이벤트가 발생한 컴퍼넌트의 라벨를 구한다. //이벤트가 발생한 버튼의 라벨을 구해주는 메소드
//		String event = ae.getActionCommand(); //->버튼의 value를 구하는것?
//		
//		if(event.equals("클릭하세요")) {
//			//구구단
//			gugudan(6);		
//		}else if(event.equals("확인")) {
//			//종료
//			System.exit(0);
//		}
//	}
	
	
	public void gugudan(int dan) {
		for(int i=2; i<10; i++) {
			System.out.println(dan+"*"+i+"="+(dan*i));
		}		
	}
		
	
	public static void main(String[] args) {
		new EventActionTest();
	}

}
