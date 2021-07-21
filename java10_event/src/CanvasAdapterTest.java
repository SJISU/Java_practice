import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CanvasAdapterTest extends MouseAdapter{
	
	MouseAdapterTest2.MyCanvas mc; //내부클래스 선언
	
	public CanvasAdapterTest() {
		
	}
	
	public CanvasAdapterTest( MouseAdapterTest2.MyCanvas mc) {//매개변수를 통해서 mc 넘겨받는다 
															 //내부클래스라서 외부클래스를통해서
		this.mc =mc;
	}
	
	//메소드 재오버라이딩
	public void mouseReleased(MouseEvent me) {
	
		if(me.getButton()==1) {
			// x,y,mc가 없다
			//매개변수를 통해서 mc 넘겨받는다-> 넘겨받아서 x,y 
			mc.x = me.getX();
			mc.y = me.getY();
			mc.repaint(); //페인트메소드호출.....mc로 간다
			
			
		}
		
	}

}
