import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class EventProcess implements ActionListener{
	
	JLabel lb1;
	
	public EventProcess() {
		
	}
	public EventProcess(JLabel lb1) {
		this.lb1=lb1;
	}
	
	
	//			actionPerformed(ActionEvent)
	public void actionPerformed(ActionEvent ae) {//구현하려면 이벤트처리될라벨을 가져와야한다..?
		lb1.setText("이벤트가 발생함........"); //버튼누르면 라벨이 바뀌어야하니깐 라벨을 만들어서 다시보내준다
		
	}
	
	
	

}
