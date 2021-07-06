import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class EventActionTest2 extends JFrame {

	JButton okbtn = new JButton("ok");
	JLabel lb1 = new JLabel("jjjj",JLabel.CENTER); //라벨도 이벤트가 있음 //->라벨버튼누르면 글자바뀌게 ->다른클래스에서 이벤트처리구현
	
	public EventActionTest2() {
		add(BorderLayout.NORTH,okbtn);
		add(lb1);
		
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//이벤트등록->이벤트등록할 객체가 현재클래스에 있으니깐
		okbtn.addActionListener(new EventProcess(lb1)); //이벤트구현한클래스의 메소드가 실행됨
	}
	
	

	public static void main(String[] args) {
		new EventActionTest2();
		
	}

}
