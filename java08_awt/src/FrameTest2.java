//2.객체형성
import java.awt.Button;
import java.awt.Frame;


public class FrameTest2 {
	
	Frame frm = new Frame("제목");
	Button btn = new Button("객체를 이용한 컨테이너 만들기");

	public FrameTest2() {
		//상속안받아서 frm.객체명
		frm.add(btn); 
		frm.setSize(500,300);
		frm.setVisible(true);
	}
	
	public static void main(String[] args) {
		new FrameTest2();
	}

}